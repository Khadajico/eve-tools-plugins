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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Andrew Norman
 */
public abstract class AbstractLoader<T> implements ILoader {

    private final Class<T> rootClass;
    private final String resource;
    private T cache;

    protected AbstractLoader(Class<T> rootClass, String resource) {
        this.rootClass = rootClass;
        this.resource = resource;
    }

    public void initialise() {
        cache = load(resource);
    }

    private T load(String resource) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try (InputStream is = AbstractLoader.class.getResourceAsStream(resource)) {
            try (GZIPInputStream gzip = new GZIPInputStream(is)) {
                return mapper.readValue(gzip, rootClass);
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // TODO notify user of error here
            throw new RuntimeException("Cannot load " + resource + " file", ex);
        }
    }
    
    protected T getCached() {
        return cache;
    }
}
