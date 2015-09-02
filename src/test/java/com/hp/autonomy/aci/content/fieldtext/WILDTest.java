/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.hp.autonomy.aci.content.fieldtext.WILD.WILD;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the <tt>WILD</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class WILDTest {

    @Test
    public void testStringString() {
        final WILD wild = new WILD("ns:field", "20%", "10%", "1,2");
        assertEquals("String, String... constructor", "WILD{20%25,10%25,1%2C2}:ns%3Afield", wild.toString());
        assertEquals("String, String... - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("String, String... - getFields", Collections.singletonList("ns:field"), wild.getFields());
    }

    @Test
    public void testStringArray() {
        final WILD wild = new WILD("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "WILD{20%25,10%25,1%2C2}:ns%3Afield", wild.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("String, String[] - getFields", Collections.singletonList("ns:field"), wild.getFields());
    }

    @Test
    public void testStringIterable() {
        final WILD wild = new WILD("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "WILD{20%25,10%25,1%2C2}:ns%3Afield", wild.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("String, Iterable<String> - getFields", Collections.singletonList("ns:field"), wild.getFields());
    }

    @Test
    public void testArrayStrings() {
        final WILD wild = new WILD(new String[]{"FIELD1", "FIELD2", "ns:field"}, "20%", "10%", "1,2");
        assertEquals("String[], String... constructor", "WILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", wild.toString());
        assertEquals("String[], String... - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("String[], String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), wild.getFields());
    }

    @Test
    public void testArrayArray() {
        final WILD wild = new WILD(new String[]{"FIELD1", "FIELD2", "ns:field"}, new String[]{"20%", "10%", "1,2"});
        assertEquals("String[], String[] constructor", "WILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", wild.toString());
        assertEquals("String[], String[] - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("String[], String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), wild.getFields());
    }

    @Test
    public void testArrayIterable() {
        final WILD wild = new WILD(new String[]{"FIELD1", "FIELD2", "ns:field"}, Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String[], Iterable<String> constructor", "WILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", wild.toString());
        assertEquals("String[], Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("String[], Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), wild.getFields());
    }

    @Test
    public void testIterableStrings() {
        final WILD wild = new WILD(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "20%", "10%", "1,2");
        assertEquals("Iterable<String>, String... constructor", "WILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", wild.toString());
        assertEquals("Iterable<String>, String... - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("Iterable<String>, String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), wild.getFields());
    }

    @Test
    public void testIterableArray() {
        final WILD wild = new WILD(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new String[]{"20%", "10%", "1,2"});
        assertEquals("Iterable<String>, String[] constructor", "WILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", wild.toString());
        assertEquals("Iterable<String>, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("Iterable<String>, String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), wild.getFields());
    }

    @Test
    public void testIterableIterable() {
        final WILD wild = new WILD(Arrays.asList("FIELD1", "FIELD2", "ns:field"), Arrays.asList("20%", "10%", "1,2"));
        assertEquals("Iterable<String>, Iterable<String> constructor", "WILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", wild.toString());
        assertEquals("Iterable<String>, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("Iterable<String>, Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), wild.getFields());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("WILD{dog}:field", WILD.WILD("field", "dog").toString());
        assertEquals("WILD{dog,cat}:field", WILD.WILD("field", "dog", "cat").toString());
        assertEquals("WILD{dog,cat}:field", WILD.WILD("field", new String[]{"dog", "cat"}).toString());
        assertEquals("WILD{dog,cat}:field", WILD.WILD("field", Arrays.asList("dog", "cat")).toString());
        assertEquals("WILD{dog}:field:title", WILD.WILD(new String[]{"field", "title"}, "dog").toString());
        assertEquals("WILD{dog,cat}:field:title", WILD.WILD(new String[]{"field", "title"}, "dog", "cat").toString());
        assertEquals("WILD{dog,cat}:field:title", WILD.WILD(new String[]{"field", "title"}, new String[]{"dog", "cat"}).toString());
        assertEquals("WILD{dog,cat}:field:title", WILD.WILD(new String[]{"field", "title"}, Arrays.asList("dog", "cat")).toString());
        assertEquals("WILD{dog}:field:title", WILD.WILD(Arrays.asList("field", "title"), "dog").toString());
        assertEquals("WILD{dog,cat}:field:title", WILD.WILD(Arrays.asList("field", "title"), "dog", "cat").toString());
        assertEquals("WILD{dog,cat}:field:title", WILD.WILD(Arrays.asList("field", "title"), new String[]{"dog", "cat"}).toString());
        assertEquals("WILD{dog,cat}:field:title", WILD.WILD(Arrays.asList("field", "title"), Arrays.asList("dog", "cat")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues1() {
        new WILD("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new WILD("FIELD", Collections.<String>emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new WILD(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues4() {
        new WILD(new String[]{"FIELD"}, Collections.<String>emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new WILD(Collections.singletonList("FIELD"), new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new WILD(Collections.singletonList("FIELD"), Collections.<String>emptyList());
    }
}
