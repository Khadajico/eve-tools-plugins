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
package com.arrggh.eve.tools.plugin.sde.api;

import com.arrggh.eve.tools.plugin.sde.impl.loader.IBlueprintLoader;
import com.arrggh.eve.tools.plugin.sde.impl.loader.IMarketGroupLoader;
import com.arrggh.eve.tools.plugin.sde.impl.loader.ITypeLoader;
import com.arrggh.eve.tools.plugin.sde.impl.loader.InitialiseLoaderRunnable;
import java.util.logging.Logger;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;
import org.openide.util.RequestProcessor;

/**
 *
 * @author Andrew Norman
 */
public class Installer extends ModuleInstall {

    private static final Logger LOG = Logger.getLogger(Installer.class.getName());
    private static final RequestProcessor PROCESSOR = new RequestProcessor(Installer.class.getName(), 5);

    @Override
    public void restored() {
        LOG.info("Starting to restore Static Data Module");
        final IBlueprintLoader bpLoader = Lookup.getDefault().lookup(IBlueprintLoader.class);
        final IMarketGroupLoader groupLoader = Lookup.getDefault().lookup(IMarketGroupLoader.class);
        final ITypeLoader typeLoader = Lookup.getDefault().lookup(ITypeLoader.class);

        LOG.info("Scheduling Static Data (Blueprint) Loading");
        PROCESSOR.post(new InitialiseLoaderRunnable(bpLoader, "Blueprints"));
        LOG.info("Scheduling Static Data (Market Group) Loading");
        PROCESSOR.post(new InitialiseLoaderRunnable(groupLoader, "Market Groups"));
        LOG.info("Scheduling Static Data (Type) Loading");
        PROCESSOR.post(new InitialiseLoaderRunnable(typeLoader, "Types"));
        LOG.info("Finished to restore Static Data Module");
    }
}
