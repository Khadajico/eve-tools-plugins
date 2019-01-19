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

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew Norman
 */
public class EveCharacterListCellRendererTest {

    private static final Instant START = Instant.now();

    @Test
    public void testTimeStringCreation() {
        assertEquals("1 second", EveCharacterListCellRenderer.createTimeString(START, START.plus(1, ChronoUnit.SECONDS)));
        assertEquals("10 seconds", EveCharacterListCellRenderer.createTimeString(START, START.plus(10, ChronoUnit.SECONDS)));
        assertEquals("59 seconds", EveCharacterListCellRenderer.createTimeString(START, START.plus(59, ChronoUnit.SECONDS)));
        assertEquals("1 minute", EveCharacterListCellRenderer.createTimeString(START, START.plus(60, ChronoUnit.SECONDS)));
        assertEquals("1 minute", EveCharacterListCellRenderer.createTimeString(START, START.plus(61, ChronoUnit.SECONDS)));
        assertEquals("5 minutes", EveCharacterListCellRenderer.createTimeString(START, START.plus(5, ChronoUnit.MINUTES)));
        assertEquals("59 minutes", EveCharacterListCellRenderer.createTimeString(START, START.plus(59, ChronoUnit.MINUTES).plus(59, ChronoUnit.SECONDS)));
        assertEquals("1 hour", EveCharacterListCellRenderer.createTimeString(START, START.plus(1, ChronoUnit.HOURS)));
        assertEquals("5 hours", EveCharacterListCellRenderer.createTimeString(START, START.plus(5, ChronoUnit.HOURS)));
        assertEquals("23 hours", EveCharacterListCellRenderer.createTimeString(START, START.plus(23, ChronoUnit.HOURS).plus(59, ChronoUnit.MINUTES)));
        assertEquals("1 day", EveCharacterListCellRenderer.createTimeString(START, START.plus(1, ChronoUnit.DAYS)));
        assertEquals("5 days", EveCharacterListCellRenderer.createTimeString(START, START.plus(5, ChronoUnit.DAYS)));
    }
}
