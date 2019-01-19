/*
 * The MIT License
 *
 * Copyright 2018 Andrew Norman.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.arrggh.eve.tools.plugin.character.impl.explorer;

import com.arrggh.eve.tools.plugin.character.api.IEveCharacterManager;
import com.arrggh.eve.tools.plugin.character.api.auth.AuthState;
import com.arrggh.eve.tools.plugin.character.api.auth.AuthToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author Andrew Norman
 */
class AuthHandler implements HttpHandler {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String CHARACTER_REGISTERED = "Character Registered ... you can close browser window";
    private static final String PROBLEM = "Something went wrong ... please look at the messages in the dialog window";

    private final Logger LOG = Logger.getLogger(AuthHandler.class.getName());
    private final AuthState expectedState;

    private final IMessageWriter writer;

    public AuthHandler(AuthState expectedState, IMessageWriter writer) {
        this.expectedState = expectedState;
        this.writer = writer;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String queryString = uri.getQuery();
        QueryParameters parameters = getQueryParameters(queryString);
        if (expectedState.equals(parameters.getState()) && parameters.getToken() != null) {
            writer.write("Registering character ");
            IEveCharacterManager manager = Lookup.getDefault().lookup(IEveCharacterManager.class);
            manager.registerNewToken(parameters.getToken());
            writer.write("Character registered ... you can close this dialog now");
            sendResponse(exchange, CHARACTER_REGISTERED);
        } else {
            sendResponse(exchange, PROBLEM);
        }
    }

    private void sendResponse(HttpExchange exchange, String message) throws IOException {
        exchange.sendResponseHeaders(200, message.length());
        OutputStream os = exchange.getResponseBody();
        os.write(message.getBytes());
        os.close();
        LOG.log(Level.INFO, "Response sent \"{0}\"", message);
    }

    private QueryParameters getQueryParameters(String query) {
        AuthState state = null;
        AuthToken token = null;
        for (String chunk : query.split("&")) {
            String[] bits = chunk.split("=");
            if (bits[0].equals("state")) {
                String decodedString = new String(Base64.getDecoder().decode(bits[1]));
                LOG.log(Level.INFO, "Received state: {0}", decodedString);
                try {
                    state = mapper.readValue(decodedString, AuthState.class);
                } catch (IOException ex) {
                    writer.write("Cannot decode AuthState: " + ex.getMessage());
                    LOG.log(Level.SEVERE, "Cannot decode AuthState", ex);
                    Exceptions.printStackTrace(ex);
                }
            }
            if (bits[0].equals("token")) {
                String decodedString = new String(Base64.getDecoder().decode(bits[1]));
                LOG.log(Level.INFO, "Received token: {0}", decodedString);
                try {
                    token = mapper.readValue(decodedString, AuthToken.class);
                } catch (IOException ex) {
                    writer.write("Cannot decode AuthToken: " + ex.getMessage());
                    LOG.log(Level.SEVERE, "Cannot decode AuthToken", ex);
                    Exceptions.printStackTrace(ex);
                }
            }
        }
        return new QueryParameters(token, state);
    }

}
