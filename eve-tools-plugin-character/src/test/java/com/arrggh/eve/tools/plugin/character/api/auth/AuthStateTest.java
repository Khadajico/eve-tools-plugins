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
package com.arrggh.eve.tools.plugin.character.api.auth;

import com.arrggh.eve.tools.plugin.character.api.auth.AuthState;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew Norman
 */
public class AuthStateTest {
    
    private static final String UUID = "e1472a10-7b19-11e8-bb43-3b9be8bcdd73";
    private static Integer PORT = 1234;
    
    private static final String EXAMPLE = "{\n"
            + "    \"uuid\":\"" + UUID + "\",\n"
            + "    \"port\":" + PORT+ "\n"
            + "}";
    
    @Test
    public void testParse() throws IOException {
         ObjectMapper mapper = new ObjectMapper();

        AuthState state = mapper.readValue(EXAMPLE, AuthState.class);

        assertEquals(UUID, state.getUuid());
        assertEquals(PORT, state.getPort());
    }
    
}
