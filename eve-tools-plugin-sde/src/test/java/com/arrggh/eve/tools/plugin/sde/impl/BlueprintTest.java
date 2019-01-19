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
package com.arrggh.eve.tools.plugin.sde.impl;

import com.arrggh.eve.tools.plugin.sde.api.IBlueprint;
import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.Assert.*;
import org.junit.Test;

public class BlueprintTest {

    private static final int TEST_ID = 12345;
    private static final String TEST_NAME = "Test Blueprint";

    @Test
    public void testBuilder() {
        IBlueprint bp = Blueprint.builder().id(TEST_ID).name(TEST_NAME).build();

        assertEquals(TEST_ID, bp.getId());
        assertEquals(TEST_NAME, bp.getName());
    }

    @Test
    public void testEquality() {
        EqualsVerifier.forClass(Blueprint.class).verify();
    }
}
