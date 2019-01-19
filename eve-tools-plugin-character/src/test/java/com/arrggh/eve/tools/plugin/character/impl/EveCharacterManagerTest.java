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

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Instant;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author Andrew Norman
 */
public class EveCharacterManagerTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    
    private static final Integer ID = 123456;
    private static final String NAME = "Name";
    private static final String HASH = "Hash";
    private static final String ACCESS = "Access";
    private static final String REFRESH = "Refresh";
    private static final Instant EXPIRES = Instant.now();
    private static final BufferedImage IMAGE = new BufferedImage(64, 64, BufferedImage.TYPE_3BYTE_BGR);
    
    @Test
    public void testLoadSaveCharacters() {
        EveCharacterManager manager = new EveCharacterManager();
        
        EveCharacter newCharacter= EveCharacter.builder().id(ID).name(NAME).hash(HASH).accessToken(ACCESS).refreshToken(REFRESH).expiresAt(EXPIRES).image(IMAGE).build();
        
        manager.saveCharacter(folder.getRoot(), newCharacter);
        
        File expectedFile = new File(folder.getRoot(), ID + ".json");
        EveCharacter diskCharacter = manager.loadCharacter(expectedFile);
        
        assertEquals(newCharacter, diskCharacter);
    }    
}
