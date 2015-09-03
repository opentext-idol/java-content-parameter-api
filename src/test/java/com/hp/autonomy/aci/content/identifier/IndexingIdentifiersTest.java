/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.hp.autonomy.aci.content.identifier;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IndexingIdentifiersTest
 */
public class IndexingIdentifiersTest {
    @Test
    public void testAll() {
        assertFalse(IndexingIdentifiers.ALL.isEmpty());
    }
}
