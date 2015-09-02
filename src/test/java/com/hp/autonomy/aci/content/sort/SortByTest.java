/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.sort;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the <TT>SortBy</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class SortByTest {

    @Test
    public void testThen() {
        final Sort sort = SortBy.RELEVANCE
                           .then(SortBy.alphabetical("NS:Field"))
                           .then(SortBy.DATE)
                           .then(SortBy.RELEVANCE)
                           .then(SortBy.alphabetical("NS:FIELD"));
        
        assertEquals("Complex sort not as expected", "relevance+NS%3AField:alphabetical+date+NS%3AFIELD:alphabetical", sort.toString());
    }
}
