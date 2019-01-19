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

import com.arrggh.eve.tools.plugin.character.api.auth.AuthCharacterInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew Norman
 */
public class AuthCharacterInfoTest {

    private static final Integer ID = 1234567890;
    private static final String NAME = "Test Name";
    private static final String TIMESTAMP = "2014-05-23T15:01:15.182864Z";
    private static final String SCOPES = "Scopes";
    private static final String TYPE = "Type";
    private static final String HASH = "Hash Here";
    private static final String PROPERTY = "Property";

    private static final String EXAMPLE = "{\n"
            + "    \"CharacterID\": " + ID + ",\n"
            + "    \"CharacterName\": \"" + NAME + "\",\n"
            + "    \"ExpiresOn\": \"" + TIMESTAMP + "\",\n"
            + "    \"Scopes\": \"" + SCOPES + "\",\n"
            + "    \"TokenType\": \"" + TYPE + "\",\n"
            + "    \"CharacterOwnerHash\": \"" + HASH + "\",\n"
            + "    \"IntellectualProperty\": \"" + PROPERTY + "\"\n"
            + "}";

    @Test
    public void testParse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        AuthCharacterInfo info = mapper.readValue(EXAMPLE, AuthCharacterInfo.class);

        assertEquals(ID, info.getCharacterId());
        assertEquals(NAME, info.getCharacterName());
        assertEquals(TIMESTAMP, info.getExpiresOn());
        assertEquals(SCOPES, info.getScopes());
        assertEquals(TYPE, info.getTokenType());
        assertEquals(HASH, info.getCharacterOwnerHash());
        assertEquals(PROPERTY, info.getIntellectualProperty());
    }

}
