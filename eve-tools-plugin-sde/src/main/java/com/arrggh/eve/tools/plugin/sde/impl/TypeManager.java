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

import com.arrggh.eve.tools.plugin.sde.api.IType;
import com.arrggh.eve.tools.plugin.sde.api.ITypeManager;
import com.arrggh.eve.tools.plugin.sde.impl.loader.ITypeLoader;
import com.arrggh.eve.tools.plugin.sde.impl.loader.model.SdeType;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Andrew Norman
 */
@ServiceProvider(service = ITypeManager.class)
public class TypeManager implements ITypeManager {

    private final ITypeLoader typeLoader;
    private final LoadingCache<Integer, Type> cache;

    public TypeManager() {
        this.typeLoader = Lookup.getDefault().lookup(ITypeLoader.class);
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .build(new CacheLoader<Integer, Type>() {
                    @Override
                    public Type load(Integer id) {
                        SdeType sdeType = typeLoader.get(id);

                        return Type.builder().id(id).name(sdeType.getName().getEn()).build();
                    }
                });
    }

    @Override
    public Optional<IType> findType(int id) {
        try {
            return Optional.of(cache.get(id));
        } catch (ExecutionException ex) {
            Exceptions.printStackTrace(ex);
            return Optional.empty();
        }
    }
}
