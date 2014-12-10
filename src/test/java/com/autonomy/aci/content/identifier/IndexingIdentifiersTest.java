/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.aci.content.identifier;

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
