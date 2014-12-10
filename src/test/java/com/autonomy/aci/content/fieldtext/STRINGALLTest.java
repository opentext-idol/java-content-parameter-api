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

import static com.autonomy.aci.content.fieldtext.STRINGALL.*;

import static org.junit.Assert.*;

/**
 * Tests for the <TT>STRINGALL</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class STRINGALLTest {

    @Test
    public void testStringString() {
        final STRINGALL stringall = new STRINGALL("ns:field", "20%", "10%", "1,2");
        assertEquals("String, String... constructor", "STRINGALL{20%25,10%25,1%2C2}:ns%3Afield", stringall.toString());
        assertEquals("String, String... - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("String, String... - getFields", Arrays.asList("ns:field"), stringall.getFields());
    }

    @Test
    public void testStringArray() {
        final STRINGALL stringall = new STRINGALL("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "STRINGALL{20%25,10%25,1%2C2}:ns%3Afield", stringall.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("String, String[] - getFields", Arrays.asList("ns:field"), stringall.getFields());
    }

    @Test
    public void testStringIterable() {
        final STRINGALL stringall = new STRINGALL("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "STRINGALL{20%25,10%25,1%2C2}:ns%3Afield", stringall.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("String, Iterable<String> - getFields", Arrays.asList("ns:field"), stringall.getFields());
    }

    @Test
    public void testArrayStrings() {
        final STRINGALL stringall = new STRINGALL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "20%", "10%", "1,2");
        assertEquals("String[], String... constructor", "STRINGALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", stringall.toString());
        assertEquals("String[], String... - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("String[], String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), stringall.getFields());
    }

    @Test
    public void testArrayArray() {
        final STRINGALL stringall = new STRINGALL(new String[]{"FIELD1", "FIELD2", "ns:field"}, new String[]{"20%", "10%", "1,2"});
        assertEquals("String[], String[] constructor", "STRINGALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", stringall.toString());
        assertEquals("String[], String[] - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("String[], String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), stringall.getFields());
    }

    @Test
    public void testArrayIterable() {
        final STRINGALL stringall = new STRINGALL(new String[]{"FIELD1", "FIELD2", "ns:field"}, Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String[], Iterable<String> constructor", "STRINGALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", stringall.toString());
        assertEquals("String[], Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("String[], Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), stringall.getFields());
    }

    @Test
    public void testIterableStrings() {
        final STRINGALL stringall = new STRINGALL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "20%", "10%", "1,2");
        assertEquals("Iterable<String>, String... constructor", "STRINGALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", stringall.toString());
        assertEquals("Iterable<String>, String... - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("Iterable<String>, String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), stringall.getFields());
    }

    @Test
    public void testIterableArray() {
        final STRINGALL stringall = new STRINGALL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new String[]{"20%", "10%", "1,2"});
        assertEquals("Iterable<String>, String[] constructor", "STRINGALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", stringall.toString());
        assertEquals("Iterable<String>, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("Iterable<String>, String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), stringall.getFields());
    }

    @Test
    public void testIterableIterable() {
        final STRINGALL stringall = new STRINGALL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), Arrays.asList("20%", "10%", "1,2"));
        assertEquals("Iterable<String>, Iterable<String> constructor", "STRINGALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", stringall.toString());
        assertEquals("Iterable<String>, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), stringall.getValues());
        assertEquals("Iterable<String>, Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), stringall.getFields());
    }
    
    @Test
    public void testFactoryMethods() {
        assertEquals("STRINGALL{dog}:field", STRINGALL("field", "dog").toString());
        assertEquals("STRINGALL{dog,cat}:field", STRINGALL("field", "dog", "cat").toString());
        assertEquals("STRINGALL{dog,cat}:field", STRINGALL("field", new String[]{"dog", "cat"}).toString());
        assertEquals("STRINGALL{dog,cat}:field", STRINGALL("field", Arrays.asList("dog", "cat")).toString());
        assertEquals("STRINGALL{dog}:field:title", STRINGALL(new String[]{"field", "title"}, "dog").toString());
        assertEquals("STRINGALL{dog,cat}:field:title", STRINGALL(new String[]{"field", "title"}, "dog", "cat").toString());
        assertEquals("STRINGALL{dog,cat}:field:title", STRINGALL(new String[]{"field", "title"}, new String[]{"dog", "cat"}).toString());
        assertEquals("STRINGALL{dog,cat}:field:title", STRINGALL(new String[]{"field", "title"}, Arrays.asList("dog", "cat")).toString());
        assertEquals("STRINGALL{dog}:field:title", STRINGALL(Arrays.asList("field", "title"), "dog").toString());
        assertEquals("STRINGALL{dog,cat}:field:title", STRINGALL(Arrays.asList("field", "title"), "dog", "cat").toString());
        assertEquals("STRINGALL{dog,cat}:field:title", STRINGALL(Arrays.asList("field", "title"), new String[]{"dog", "cat"}).toString());
        assertEquals("STRINGALL{dog,cat}:field:title", STRINGALL(Arrays.asList("field", "title"), Arrays.asList("dog", "cat")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues1() {
        new STRINGALL("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new STRINGALL("FIELD", Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new STRINGALL(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues4() {
        new STRINGALL(new String[]{"FIELD"}, Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new STRINGALL(Arrays.asList("FIELD"), new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new STRINGALL(Arrays.asList("FIELD"), Arrays.<String>asList());
    }
}
