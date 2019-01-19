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
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.ContextAwareAction;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;

@ActionID(
        category = "Window",
        id = "com.arrggh.eve.tools.plugin.character.impl.editor.information.ShowCharacterInformationToolbarAction"
)
@ActionRegistration(
        iconBase = "com/arrggh/eve/tools/plugin/character/impl/editor/information/biography.png",
        displayName = "Show Character Information",
        lazy = true
)
@ActionReference(path = "Toolbars/Character", position = 0)
@Messages("CTL_ShowCharacterInformationToolbarAction=Show Character Information")
/**
 *
 * @author Andrew Norman
 */
public final class ShowCharacterInformationToolbarAction extends AbstractAction implements LookupListener, ContextAwareAction {

    private Lookup context;
    private Lookup.Result<IEveCharacter> lkpInfo;

    public ShowCharacterInformationToolbarAction() {
        this(Utilities.actionsGlobalContext());
    }

    private ShowCharacterInformationToolbarAction(Lookup context) {
        putValue(Action.NAME, "Show Character Information");
        this.context = context;
    }

    void init() {
        if (lkpInfo != null) {
            return;
        }

        lkpInfo = context.lookupResult(IEveCharacter.class);
        lkpInfo.addLookupListener(this);
        resultChanged(null);
    }

    @Override
    public boolean isEnabled() {
        init();
        return super.isEnabled();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        init();
        for (IEveCharacter instance : lkpInfo.allInstances()) {
            System.err.println("Showing the information for " + instance.getName());
        }
    }

    public void resultChanged(LookupEvent ev) {
        setEnabled(!lkpInfo.allInstances().isEmpty());
    }

    public Action createContextAwareInstance(Lookup context) {
        return new ShowCharacterInformationToolbarAction(context);
    }
}
