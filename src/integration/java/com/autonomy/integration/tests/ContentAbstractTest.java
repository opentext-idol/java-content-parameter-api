/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests;

import com.autonomy.nonaci.indexing.impl.DreAddCommand;
import com.autonomy.test.integration.Config;
import com.autonomy.test.integration.ConfigFile;
import com.autonomy.test.integration.Content;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * BaseContentTest
 */
public abstract class ContentAbstractTest {
    protected static Content content;

    private static final String configPath = System.getProperties().getProperty("user.dir") + "/src/integration/config/";

    protected ContentAbstractTest() {
        
    }

    @BeforeClass
    public static void beforeClass() {
        final Config config = new ConfigFile(configPath + "standard.content.cfg");

        // Create the content server and start it running...
        content = new Content(config);
        content.start();
    }

    @Before
    public void setUp() {
        // Reindex before each test to ensure the engine is in a known good state
        final String idxPath = configPath + "small-utf8.idx";

        final DreAddCommand dreAdd = new DreAddCommand();
        dreAdd.setIndexFile(idxPath);

        content.initialAndBlock();
        content.index(dreAdd);
        content.syncAndBlock();
    }

    @AfterClass
    public static void afterClass() {
        // There may have been an error during setup, this is so we don't throw a NullPointerException...
        if(content != null) {
            // Stop the content server and clean up...
            content.stop();
        }
    }
}
