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
package com.arrggh.eve.tools.plugin.character.impl;

import com.arrggh.eve.esi.ApiException;
import com.arrggh.eve.esi.api.CharacterApi;
import com.arrggh.eve.esi.model.GetCharactersCharacterIdPortraitOk;
import com.arrggh.eve.tools.plugin.character.api.auth.AuthCharacterInfo;
import com.arrggh.eve.tools.plugin.character.api.auth.AuthToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Andrew Norman
 */
public class CharacterUtilities {

    private static final Logger LOG = Logger.getLogger(CharacterUtilities.class.getName());

    public static AuthCharacterInfo verifyToken(AuthToken token) {
        LOG.log(Level.INFO, "Verifying a character token {0}", token.getAccessToken());
        ObjectMapper mapper = new ObjectMapper();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet("https://esi.tech.ccp.is/verify/");
            get.addHeader("Authorization", "Bearer " + token.getAccessToken());

            try (CloseableHttpResponse response = client.execute(get)) {
                LOG.log(Level.INFO, "ESI Response Status Line {0}", response.getStatusLine());
                String json = EntityUtils.toString(response.getEntity());
                return mapper.readValue(json, AuthCharacterInfo.class);
            }
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "Cannot retrieve verify character token", ex);
        }
        return null;
    }

    public static BufferedImage retrieveCharacterPortrait(int characterId) {
        CharacterApi api = new CharacterApi();

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            GetCharactersCharacterIdPortraitOk request = api.getCharactersCharacterIdPortrait(characterId, "tranquility", "");
            HttpGet get = new HttpGet(request.getPx64x64());

            try (CloseableHttpResponse response = client.execute(get)) {
                InputStream data = response.getEntity().getContent();
                return ImageIO.read(data);
            }
        } catch (ApiException | IOException ex) {
            LOG.log(Level.WARNING, "Cannot retrieve character portrait", ex);
        }
        return new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
    }
}
