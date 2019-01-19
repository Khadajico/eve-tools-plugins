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
package com.arrggh.eve.tools.plugin.sde.impl.loader;

import com.arrggh.eve.tools.plugin.sde.api.Installer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.api.progress.ProgressHandle;

/**
 *
 * @author Andrew Norman
 */
public class InitialiseLoaderRunnable implements Runnable {

    private static final Logger LOG = Logger.getLogger(Installer.class.getName());

    private final ILoader loader;
    private final String name;

    public InitialiseLoaderRunnable(ILoader loader, String name) {
        this.loader = loader;
        this.name = name;
    }

    @Override
    public void run() {
        LOG.log(Level.INFO, "Starting to load {0} data", name);
        ProgressHandle ph = ProgressHandle.createHandle("Loading " + name + " data");
        ph.start();
        loader.initialise();
        ph.finish();
        LOG.log(Level.INFO, "Finished loading {0} data", name);
    }
}
