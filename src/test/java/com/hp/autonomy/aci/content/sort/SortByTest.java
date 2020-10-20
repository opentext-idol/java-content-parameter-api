/*
 * (c) Copyright 2009-2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
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
