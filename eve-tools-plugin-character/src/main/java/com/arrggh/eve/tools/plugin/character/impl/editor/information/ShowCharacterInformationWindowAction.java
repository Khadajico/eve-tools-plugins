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
package com.arrggh.eve.tools.plugin.character.impl.editor.information;

import com.arrggh.eve.tools.plugin.character.api.IEveCharacter;
import com.arrggh.eve.tools.plugin.character.api.actions.IEveCharacterMouseMenuAction;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Andrew Norman
 */
@ServiceProvider(service=IEveCharacterMouseMenuAction.class)
public class ShowCharacterInformationWindowAction implements IEveCharacterMouseMenuAction {

    @Override
    public String getText() {
        return "Information";
    }

    @Override
    public void performAction(IEveCharacter character) {
        System.err.println("Showing information for " + character.getName());
    }
}
