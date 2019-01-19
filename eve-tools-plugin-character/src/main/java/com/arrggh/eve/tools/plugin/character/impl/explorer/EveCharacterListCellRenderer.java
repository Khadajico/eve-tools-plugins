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
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Andrew Norman
 */
public class EveCharacterListCellRenderer implements ListCellRenderer<IEveCharacter> {

    private final Logger LOG = Logger.getLogger(EveCharacterListCellRenderer.class.getName());

    private final JPanel panel;
    private final JLabel lblName;
    private final JLabel lblIcon;
    private final JLabel lblUpdated;

    public EveCharacterListCellRenderer() {
        panel = new JPanel();

        lblName = new JLabel("");
        lblIcon = new JLabel("");
        lblUpdated = new JLabel("");

        lblName.setFont(lblName.getFont().deriveFont(16.0f));
        lblUpdated.setFont(lblUpdated.getFont().deriveFont(10.0f));
        
        panel.setLayout(new GridBagLayout());

        panel.add(lblIcon, new GridBagConstraints(0, 0, 1, 3, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(4, 4, 4, 2), 0, 0));
        panel.add(new JLabel(), new GridBagConstraints(1, 0, 1, 3, 1.0f, 1.0f, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(4, 2, 4, 2), 0, 0));
        panel.add(lblName, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(4, 2, 2, 4), 0, 0));
        panel.add(lblUpdated, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(2, 2, 4, 4), 0, 0));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends IEveCharacter> list, IEveCharacter value, int index, boolean isSelected, boolean cellHasFocus) {
        lblName.setText("Name:" + value.getName());
        lblIcon.setIcon(new ImageIcon(value.getImage()));
        lblUpdated.setText("Last Authorised: " + createTimeString(value.getLastUpdated(), Instant.now()) + " ago");

        panel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());

        return panel;
    }

    protected static String createTimeString(Instant ago, Instant now) {
        long seconds = ChronoUnit.SECONDS.between(ago, now);
        if (seconds < 60) {
            return String.format("%d second%s", seconds, seconds == 1 ? "" : "s");
        }
        long minutes = ChronoUnit.MINUTES.between(ago, now);
        if (minutes < 60) {
            return String.format("%d minute%s", minutes, minutes == 1 ? "" : "s");
        }
        long hours = ChronoUnit.HOURS.between(ago, now);
        if (hours < 24) {
            return String.format("%d hour%s", hours, hours == 1 ? "" : "s");
        }
        long days = ChronoUnit.DAYS.between(ago, now);
        return String.format("%d day%s", days, days == 1 ? "" : "s");
    }
}
