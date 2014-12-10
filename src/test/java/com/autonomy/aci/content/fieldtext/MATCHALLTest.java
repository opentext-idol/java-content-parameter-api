/*
 * $Id:$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author:$ on $Date:$
 */

package com.autonomy.aci.content.fieldtext;

import java.util.Arrays;

import org.junit.Test;

import static com.autonomy.aci.content.fieldtext.MATCHALL.*;

import static org.junit.Assert.*;

/**
 * Tests for the <tt>MATCHALL</tt> class.
 *
 * @author darrelln
 * @version $Revision: #1 $ $Date: 2010/04/14 $
 */
public class MATCHALLTest {

    @Test
    public void testStringStrings() {
        final MATCHALL match = new MATCHALL("ns:field", "20%", "10%", "1,2");
        assertEquals("String, String... constructor", "MATCHALL{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String... - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testStringArray() {
        final MATCHALL match = new MATCHALL("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "MATCHALL{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String[] - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testStringIterable() {
        final MATCHALL match = new MATCHALL("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "MATCHALL{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, Iterable<String> - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testArrayStrings() {
        final MATCHALL match = new MATCHALL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "20%", "10%", "1,2");
        assertEquals("String[], String... constructor", "MATCHALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testArrayArray() {
        final MATCHALL match = new MATCHALL(new String[]{"FIELD1", "FIELD2", "ns:field"}, new String[]{"20%", "10%", "1,2"});
        assertEquals("String[], String[] constructor", "MATCHALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testArrayIterable() {
        final MATCHALL match = new MATCHALL(new String[]{"FIELD1", "FIELD2", "ns:field"}, Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String[], Iterable<String> constructor", "MATCHALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableStrings() {
        final MATCHALL match = new MATCHALL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "20%", "10%", "1,2");
        assertEquals("Iterable<String>, String... constructor", "MATCHALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableArray() {
        final MATCHALL match = new MATCHALL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new String[]{"20%", "10%", "1,2"});
        assertEquals("Iterable<String>, String[] constructor", "MATCHALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableIterable() {
        final MATCHALL match = new MATCHALL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), Arrays.asList("20%", "10%", "1,2"));
        assertEquals("Iterable<String>, Iterable<String> constructor", "MATCHALL{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("MATCHALL{val1,val2}:field", MATCHALL("field", "val1", "val2").toString());
        assertEquals("MATCHALL{val1,val2}:field", MATCHALL("field", new String[]{"val1", "val2"}).toString());
        assertEquals("MATCHALL{val1,val2}:field", MATCHALL("field", Arrays.asList("val1", "val2")).toString());
        assertEquals("MATCHALL{val1,val2}:field:title", MATCHALL(new String[]{"field", "title"}, "val1", "val2").toString());
        assertEquals("MATCHALL{val1,val2}:field:title", MATCHALL(new String[]{"field", "title"}, new String[]{"val1", "val2"}).toString());
        assertEquals("MATCHALL{val1,val2}:field:title", MATCHALL(new String[]{"field", "title"}, Arrays.asList("val1", "val2")).toString());
        assertEquals("MATCHALL{val1,val2}:field:title", MATCHALL(Arrays.asList("field", "title"), "val1", "val2").toString());
        assertEquals("MATCHALL{val1,val2}:field:title", MATCHALL(Arrays.asList("field", "title"), new String[]{"val1", "val2"}).toString());
        assertEquals("MATCHALL{val1,val2}:field:title", MATCHALL(Arrays.asList("field", "title"), Arrays.asList("val1", "val2")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new MATCHALL("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new MATCHALL("FIELD", Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new MATCHALL(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new MATCHALL(new String[]{"FIELD"}, Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues8() {
        new MATCHALL(Arrays.asList("FIELD"), new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues9() {
        new MATCHALL(Arrays.asList("FIELD"), Arrays.<String>asList());
    }
}
