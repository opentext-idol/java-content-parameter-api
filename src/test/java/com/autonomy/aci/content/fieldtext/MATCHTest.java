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

import static com.autonomy.aci.content.fieldtext.MATCH.*;

import static org.junit.Assert.*;

/**
 * Tests for the <tt>MATCH</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class MATCHTest {

    @Test
    public void testStringStrings() {
        final MATCH match = new MATCH("ns:field", "20%", "10%", "1,2");
        assertEquals("String, String... constructor", "MATCH{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String... - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testStringArray() {
        final MATCH match = new MATCH("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "MATCH{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String[] - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testStringIterable() {
        final MATCH match = new MATCH("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "MATCH{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, Iterable<String> - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testArrayStrings() {
        final MATCH match = new MATCH(new String[]{"FIELD1", "FIELD2", "ns:field"}, "20%", "10%", "1,2");
        assertEquals("String[], String... constructor", "MATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testArrayArray() {
        final MATCH match = new MATCH(new String[]{"FIELD1", "FIELD2", "ns:field"}, new String[]{"20%", "10%", "1,2"});
        assertEquals("String[], String[] constructor", "MATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testArrayIterable() {
        final MATCH match = new MATCH(new String[]{"FIELD1", "FIELD2", "ns:field"}, Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String[], Iterable<String> constructor", "MATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableStrings() {
        final MATCH match = new MATCH(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "20%", "10%", "1,2");
        assertEquals("Iterable<String>, String... constructor", "MATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableArray() {
        final MATCH match = new MATCH(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new String[]{"20%", "10%", "1,2"});
        assertEquals("Iterable<String>, String[] constructor", "MATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableIterable() {
        final MATCH match = new MATCH(Arrays.asList("FIELD1", "FIELD2", "ns:field"), Arrays.asList("20%", "10%", "1,2"));
        assertEquals("Iterable<String>, Iterable<String> constructor", "MATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("MATCH{val1,val2}:field", MATCH("field", "val1", "val2").toString());
        assertEquals("MATCH{val1,val2}:field", MATCH("field", new String[]{"val1", "val2"}).toString());
        assertEquals("MATCH{val1,val2}:field", MATCH("field", Arrays.asList("val1", "val2")).toString());
        assertEquals("MATCH{val1,val2}:field:title", MATCH(new String[]{"field", "title"}, "val1", "val2").toString());
        assertEquals("MATCH{val1,val2}:field:title", MATCH(new String[]{"field", "title"}, new String[]{"val1", "val2"}).toString());
        assertEquals("MATCH{val1,val2}:field:title", MATCH(new String[]{"field", "title"}, Arrays.asList("val1", "val2")).toString());
        assertEquals("MATCH{val1,val2}:field:title", MATCH(Arrays.asList("field", "title"), "val1", "val2").toString());
        assertEquals("MATCH{val1,val2}:field:title", MATCH(Arrays.asList("field", "title"), new String[]{"val1", "val2"}).toString());
        assertEquals("MATCH{val1,val2}:field:title", MATCH(Arrays.asList("field", "title"), Arrays.asList("val1", "val2")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new MATCH("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new MATCH("FIELD", Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new MATCH(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new MATCH(new String[]{"FIELD"}, Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues8() {
        new MATCH(Arrays.asList("FIELD"), new String[0]);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNoValues9() {
        new MATCH(Arrays.asList("FIELD"), Arrays.<String>asList());
    }
}
