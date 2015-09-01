/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.content.fieldtext;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.autonomy.aci.content.fieldtext.EMPTY.EMPTY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the <TT>EMPTY</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class EMPTYTest {

    @Test
    public void testString() {
        final EMPTY empty = new EMPTY("ns:field");
        assertEquals("String constructor", "EMPTY{}:ns%3Afield", empty.toString());
        assertEquals("String - getFields", Collections.singletonList("ns:field"), empty.getFields());
        assertTrue("String - getValues", empty.getValues().isEmpty());
    }

    @Test
    public void testArray() {
        final EMPTY empty = new EMPTY(new String[]{"FIELD1", "FIELD2", "ns:field"});
        assertEquals("String[] constructor", "EMPTY{}:FIELD1:FIELD2:ns%3Afield", empty.toString());
        assertEquals("String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), empty.getFields());
        assertTrue("String[] - getValues", empty.getValues().isEmpty());
    }

    @Test
    public void testIterable() {
        final EMPTY empty = new EMPTY(Arrays.asList(new String[]{"FIELD1", "FIELD2", "ns:field"}));
        assertEquals("Iterable<String> constructor", "EMPTY{}:FIELD1:FIELD2:ns%3Afield", empty.toString());
        assertEquals("Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), empty.getFields());
        assertTrue("Iterable<String> - getValues", empty.getValues().isEmpty());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("EMPTY{}:field", EMPTY("field").toString());
        assertEquals("EMPTY{}:field:title", EMPTY("field", "title").toString());
        assertEquals("EMPTY{}:field:title", EMPTY(new String[]{"field", "title"}).toString());
        assertEquals("EMPTY{}:field:title", EMPTY(Arrays.asList("field", "title")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException1() {
        new EMPTY((String)null);
    }

    @Test(expected = RuntimeException.class)
    public void testNullException2() {
        new EMPTY((String[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException3() {
        new EMPTY(new String[]{null});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException4() {
        new EMPTY((Iterable<String>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException5() {
        new EMPTY(Arrays.asList("title", null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoFieldsArray() {
        new EMPTY(new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoFieldsIterable() {
        new EMPTY(Collections.<String>emptyList());
    }
}
