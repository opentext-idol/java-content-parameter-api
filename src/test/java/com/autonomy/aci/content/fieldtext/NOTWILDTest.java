/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.aci.content.fieldtext;

import java.util.Arrays;

import org.junit.Test;

import static com.autonomy.aci.content.fieldtext.NOTWILD.*;

import static org.junit.Assert.*;

/**
 * Tests for the <tt>NOTWILD</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class NOTWILDTest {

    @Test
    public void testStringStrings() {
        final NOTWILD match = new NOTWILD("ns:field", "20%", "10%", "1,2");
        assertEquals("String, String... constructor", "NOTWILD{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String... - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testStringArray() {
        final NOTWILD match = new NOTWILD("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "NOTWILD{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String[] - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testStringIterable() {
        final NOTWILD match = new NOTWILD("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "NOTWILD{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, Iterable<String> - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testArrayStrings() {
        final NOTWILD match = new NOTWILD(new String[]{"FIELD1", "FIELD2", "ns:field"}, "20%", "10%", "1,2");
        assertEquals("String[], String... constructor", "NOTWILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testArrayArray() {
        final NOTWILD match = new NOTWILD(new String[]{"FIELD1", "FIELD2", "ns:field"}, new String[]{"20%", "10%", "1,2"});
        assertEquals("String[], String[] constructor", "NOTWILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testArrayIterable() {
        final NOTWILD match = new NOTWILD(new String[]{"FIELD1", "FIELD2", "ns:field"}, Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String[], Iterable<String> constructor", "NOTWILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableStrings() {
        final NOTWILD match = new NOTWILD(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "20%", "10%", "1,2");
        assertEquals("Iterable<String>, String... constructor", "NOTWILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableArray() {
        final NOTWILD match = new NOTWILD(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new String[]{"20%", "10%", "1,2"});
        assertEquals("Iterable<String>, String[] constructor", "NOTWILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableIterable() {
        final NOTWILD match = new NOTWILD(Arrays.asList("FIELD1", "FIELD2", "ns:field"), Arrays.asList("20%", "10%", "1,2"));
        assertEquals("Iterable<String>, Iterable<String> constructor", "NOTWILD{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("NOTWILD{val1,val2}:field", NOTWILD("field", "val1", "val2").toString());
        assertEquals("NOTWILD{val1,val2}:field", NOTWILD("field", new String[]{"val1", "val2"}).toString());
        assertEquals("NOTWILD{val1,val2}:field", NOTWILD("field", Arrays.asList("val1", "val2")).toString());
        assertEquals("NOTWILD{val1,val2}:field:title", NOTWILD(new String[]{"field", "title"}, "val1", "val2").toString());
        assertEquals("NOTWILD{val1,val2}:field:title", NOTWILD(new String[]{"field", "title"}, new String[]{"val1", "val2"}).toString());
        assertEquals("NOTWILD{val1,val2}:field:title", NOTWILD(new String[]{"field", "title"}, Arrays.asList("val1", "val2")).toString());
        assertEquals("NOTWILD{val1,val2}:field:title", NOTWILD(Arrays.asList("field", "title"), "val1", "val2").toString());
        assertEquals("NOTWILD{val1,val2}:field:title", NOTWILD(Arrays.asList("field", "title"), new String[]{"val1", "val2"}).toString());
        assertEquals("NOTWILD{val1,val2}:field:title", NOTWILD(Arrays.asList("field", "title"), Arrays.asList("val1", "val2")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues1() {
        new NOTWILD("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new NOTWILD("FIELD", Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new NOTWILD(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues4() {
        new NOTWILD(new String[]{"FIELD"}, Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new NOTWILD(Arrays.asList("FIELD"), new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new NOTWILD(Arrays.asList("FIELD"), Arrays.<String>asList());
    }
}
