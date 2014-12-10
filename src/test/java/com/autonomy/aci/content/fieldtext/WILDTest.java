/*
 * $Id$
 *
 * Copyright (c) 2008-2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */

package com.autonomy.aci.content.fieldtext;

import java.util.Arrays;

import org.junit.Test;

import static com.autonomy.aci.content.fieldtext.WILD.*;

import static org.junit.Assert.*;

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
        assertEquals("String, String... - getFields", Arrays.asList("ns:field"), wild.getFields());
    }

    @Test
    public void testStringArray() {
        final WILD wild = new WILD("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "WILD{20%25,10%25,1%2C2}:ns%3Afield", wild.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("String, String[] - getFields", Arrays.asList("ns:field"), wild.getFields());
    }

    @Test
    public void testStringIterable() {
        final WILD wild = new WILD("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "WILD{20%25,10%25,1%2C2}:ns%3Afield", wild.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), wild.getValues());
        assertEquals("String, Iterable<String> - getFields", Arrays.asList("ns:field"), wild.getFields());
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
        assertEquals("WILD{dog}:field", WILD("field", "dog").toString());
        assertEquals("WILD{dog,cat}:field", WILD("field", "dog", "cat").toString());
        assertEquals("WILD{dog,cat}:field", WILD("field", new String[]{"dog", "cat"}).toString());
        assertEquals("WILD{dog,cat}:field", WILD("field", Arrays.asList("dog", "cat")).toString());
        assertEquals("WILD{dog}:field:title", WILD(new String[]{"field", "title"}, "dog").toString());
        assertEquals("WILD{dog,cat}:field:title", WILD(new String[]{"field", "title"}, "dog", "cat").toString());
        assertEquals("WILD{dog,cat}:field:title", WILD(new String[]{"field", "title"}, new String[]{"dog", "cat"}).toString());
        assertEquals("WILD{dog,cat}:field:title", WILD(new String[]{"field", "title"}, Arrays.asList("dog", "cat")).toString());
        assertEquals("WILD{dog}:field:title", WILD(Arrays.asList("field", "title"), "dog").toString());
        assertEquals("WILD{dog,cat}:field:title", WILD(Arrays.asList("field", "title"), "dog", "cat").toString());
        assertEquals("WILD{dog,cat}:field:title", WILD(Arrays.asList("field", "title"), new String[]{"dog", "cat"}).toString());
        assertEquals("WILD{dog,cat}:field:title", WILD(Arrays.asList("field", "title"), Arrays.asList("dog", "cat")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues1() {
        new WILD("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new WILD("FIELD", Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new WILD(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues4() {
        new WILD(new String[]{"FIELD"}, Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new WILD(Arrays.asList("FIELD"), new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new WILD(Arrays.asList("FIELD"), Arrays.<String>asList());
    }
}
