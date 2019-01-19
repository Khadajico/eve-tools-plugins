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

import com.arrggh.eve.tools.plugin.character.api.IEveCharacter;
import com.arrggh.eve.tools.plugin.character.api.IEveCharacterManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import org.openide.util.lookup.InstanceContent;

/**
 *
 * @author Andrew Norman
 */
public class EveCharacterListModel extends AbstractListModel<IEveCharacter> implements PropertyChangeListener {

    private final Logger LOG = Logger.getLogger(EveCharacterListModel.class.getName());

    private final List<IEveCharacter> data;
    private final IEveCharacterManager manager;

    public EveCharacterListModel(IEveCharacterManager manager) {
        this.data = new LinkedList<>();
        this.manager = manager;
        manager.addPropertyChangerListener(this);
        updateDataList();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public IEveCharacter getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        updateDataList();
        fireContentsChanged(evt, 0, getSize());
    }

    private static final Comparator<IEveCharacter> NAME = (IEveCharacter lhs, IEveCharacter rhs) -> lhs.getName().compareTo(rhs.getName());

    private void updateDataList() {
        data.clear();

        Set<Integer> ids = manager.getCharacterIds();
        ids.forEach((id) -> {
            data.add(manager.getCharacter(id));
        });

        Collections.sort(data, NAME);
        LOG.log(Level.INFO, "Updated character list model ... {0} characters", getSize());
    }
}
