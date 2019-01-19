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
package com.arrggh.eve.tools.plugin.character.impl;

import com.arrggh.eve.tools.plugin.character.api.*;
import com.arrggh.eve.tools.plugin.character.api.auth.AuthCharacterInfo;
import com.arrggh.eve.tools.plugin.character.api.auth.AuthToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Andrew Norman
 */
@ServiceProvider(service = IEveCharacterManager.class)
public class EveCharacterManager implements IEveCharacterManager {

    private final ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());

    private final Logger LOG = Logger.getLogger(EveCharacterManager.class.getName());
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final Map<Integer, EveCharacter> characters = new HashMap<>();

    public EveCharacterManager() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(BufferedImage.class, new ImageDeserializer());
        mapper.registerModule(module);
    }

    @Override
    public void addPropertyChangerListener(PropertyChangeListener listener) {
        LOG.log(Level.INFO, "Adding the PropertyChangeListener {0}", listener);
        support.addPropertyChangeListener(listener);
    }

    @Override
    public Set<Integer> getCharacterIds() {
        return Collections.unmodifiableSet(characters.keySet());
    }

    @Override
    public void removePropertyChangerListener(PropertyChangeListener listener) {
        LOG.log(Level.INFO, "Removing the PropertyChangeListener {0}", listener);
        support.removePropertyChangeListener(listener);
    }

    @Override
    public Integer registerNewToken(AuthToken token) {
        LOG.log(Level.INFO, "Registering a new character token {0}", token.getAccessToken());
        AuthCharacterInfo authInfo = CharacterUtilities.verifyToken(token);
        BufferedImage image = CharacterUtilities.retrieveCharacterPortrait(authInfo.getCharacterId());

        Instant expires = Instant.ofEpochMilli(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(token.getExpiresIn()));
        String accessToken = token.getAccessToken();
        String refreshToken = token.getRefreshToken();

        EveCharacter newCharacter = EveCharacter.builder().id(authInfo.getCharacterId()).name(authInfo.getCharacterName()).hash(authInfo.getCharacterOwnerHash()).accessToken(accessToken).expiresAt(expires).lastUpdated(Instant.now()).refreshToken(refreshToken).image(image).build();
        Integer id = saveCharacter(getCacheDirectory("characters"), newCharacter);
        characters.put(id, newCharacter);
        support.firePropertyChange("character", null, newCharacter);
        return id;       
    }

    public void loadCharacters() {
        File directory = getCacheDirectory("characters");
        LOG.log(Level.INFO, "Looking for characters in {0}", directory);
        for (File file : directory.listFiles()) {
            EveCharacter character = loadCharacter(file);
            if (character != null) {
                characters.put(character.getId(), character);
            }
        }
        LOG.log(Level.INFO, "{0} characters loaded", characters.size());
    }
    
    protected EveCharacter loadCharacter(File characterFile) {
        try {
            LOG.log(Level.INFO, "Loading character from file {0}.", characterFile);
            return mapper.readValue(characterFile, EveCharacter.class);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Problem loading character from disk", ex);
            return null;
        }
    }

    protected Integer saveCharacter(File directory, EveCharacter newCharacter) {
        characters.put(newCharacter.getId(), newCharacter);
        support.firePropertyChange("New Character", false, newCharacter);

        File characterFile = new File(directory, newCharacter.getId() + ".json");

        try {
            mapper.writeValue(characterFile, newCharacter);
            return newCharacter.getId();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Problem saving character to disk", ex);
            return null;
        }
    }

    private static File getCacheDirectory(String type) {
        String user_dir = System.getProperty("netbeans.user");
        File baseDir = new File(user_dir);
        baseDir.mkdir();
        File cacheDir = new File(baseDir, "cache");
        cacheDir.mkdir();
        File typeCacheDir = new File(cacheDir, type);
        typeCacheDir.mkdir();
        return typeCacheDir;
    }

    @Override
    public IEveCharacter getCharacter(Integer id) {
        return characters.get(id);
    }
}
