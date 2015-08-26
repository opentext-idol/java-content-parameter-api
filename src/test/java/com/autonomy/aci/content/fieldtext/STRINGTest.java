/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.content.fieldtext;

import java.util.Arrays;

import org.junit.Test;

import static com.autonomy.aci.content.fieldtext.STRING.*;

import static org.junit.Assert.*;

/**
 * Tests for the <TT>STRING</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class STRINGTest {

    @Test
    public void testStringString() {
        final STRING string = new STRING("ns:field", "20%", "10%", "1,2");
        assertEquals("String, String... constructor", "STRING{20%25,10%25,1%2C2}:ns%3Afield", string.toString());
        assertEquals("String, String... - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("String, String... - getFields", Arrays.asList("ns:field"), string.getFields());
    }

    @Test
    public void testStringArray() {
        final STRING string = new STRING("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "STRING{20%25,10%25,1%2C2}:ns%3Afield", string.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("String, String[] - getFields", Arrays.asList("ns:field"), string.getFields());
    }

    @Test
    public void testStringIterable() {
        final STRING string = new STRING("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "STRING{20%25,10%25,1%2C2}:ns%3Afield", string.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("String, Iterable<String> - getFields", Arrays.asList("ns:field"), string.getFields());
    }

    @Test
    public void testArrayStrings() {
        final STRING string = new STRING(new String[]{"FIELD1", "FIELD2", "ns:field"}, "20%", "10%", "1,2");
        assertEquals("String[], String... constructor", "STRING{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", string.toString());
        assertEquals("String[], String... - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("String[], String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), string.getFields());
    }

    @Test
    public void testArrayArray() {
        final STRING string = new STRING(new String[]{"FIELD1", "FIELD2", "ns:field"}, new String[]{"20%", "10%", "1,2"});
        assertEquals("String[], String[] constructor", "STRING{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", string.toString());
        assertEquals("String[], String[] - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("String[], String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), string.getFields());
    }

    @Test
    public void testArrayIterable() {
        final STRING string = new STRING(new String[]{"FIELD1", "FIELD2", "ns:field"}, Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String[], Iterable<String> constructor", "STRING{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", string.toString());
        assertEquals("String[], Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("String[], Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), string.getFields());
    }

    @Test
    public void testIterableStrings() {
        final STRING string = new STRING(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "20%", "10%", "1,2");
        assertEquals("Iterable<String>, String... constructor", "STRING{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", string.toString());
        assertEquals("Iterable<String>, String... - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("Iterable<String>, String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), string.getFields());
    }

    @Test
    public void testIterableArray() {
        final STRING string = new STRING(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new String[]{"20%", "10%", "1,2"});
        assertEquals("Iterable<String>, String[] constructor", "STRING{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", string.toString());
        assertEquals("Iterable<String>, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("Iterable<String>, String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), string.getFields());
    }

    @Test
    public void testIterableIterable() {
        final STRING string = new STRING(Arrays.asList("FIELD1", "FIELD2", "ns:field"), Arrays.asList("20%", "10%", "1,2"));
        assertEquals("Iterable<String>, Iterable<String> constructor", "STRING{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", string.toString());
        assertEquals("Iterable<String>, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), string.getValues());
        assertEquals("Iterable<String>, Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), string.getFields());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("STRING{dog}:field", STRING("field", "dog").toString());
        assertEquals("STRING{dog,cat}:field", STRING("field", "dog", "cat").toString());
        assertEquals("STRING{dog,cat}:field", STRING("field", new String[]{"dog", "cat"}).toString());
        assertEquals("STRING{dog,cat}:field", STRING("field", Arrays.asList("dog", "cat")).toString());
        assertEquals("STRING{dog}:field:title", STRING(new String[]{"field", "title"}, "dog").toString());
        assertEquals("STRING{dog,cat}:field:title", STRING(new String[]{"field", "title"}, "dog", "cat").toString());
        assertEquals("STRING{dog,cat}:field:title", STRING(new String[]{"field", "title"}, new String[]{"dog", "cat"}).toString());
        assertEquals("STRING{dog,cat}:field:title", STRING(new String[]{"field", "title"}, Arrays.asList("dog", "cat")).toString());
        assertEquals("STRING{dog}:field:title", STRING(Arrays.asList("field", "title"), "dog").toString());
        assertEquals("STRING{dog,cat}:field:title", STRING(Arrays.asList("field", "title"), "dog", "cat").toString());
        assertEquals("STRING{dog,cat}:field:title", STRING(Arrays.asList("field", "title"), new String[]{"dog", "cat"}).toString());
        assertEquals("STRING{dog,cat}:field:title", STRING(Arrays.asList("field", "title"), Arrays.asList("dog", "cat")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues1() {
        new STRING("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new STRING("FIELD", Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new STRING(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues4() {
        new STRING(new String[]{"FIELD"}, Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new STRING(Arrays.asList("FIELD"), new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new STRING(Arrays.asList("FIELD"), Arrays.<String>asList());
    }
}
