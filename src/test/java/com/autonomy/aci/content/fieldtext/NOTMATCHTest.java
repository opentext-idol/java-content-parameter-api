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

import static com.autonomy.aci.content.fieldtext.NOTMATCH.*;

import static org.junit.Assert.*;

/**
 * Tests for the <tt>NOTMATCH</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class NOTMATCHTest {

    @Test
    public void testStringStrings() {
        final NOTMATCH match = new NOTMATCH("ns:field", "20%", "10%", "1,2");
        assertEquals("String, String... constructor", "NOTMATCH{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String... - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testStringArray() {
        final NOTMATCH match = new NOTMATCH("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "NOTMATCH{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String[] - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testStringIterable() {
        final NOTMATCH match = new NOTMATCH("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "NOTMATCH{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, Iterable<String> - getFields", Arrays.asList("ns:field"), match.getFields());
    }

    @Test
    public void testArrayStrings() {
        final NOTMATCH match = new NOTMATCH(new String[]{"FIELD1", "FIELD2", "ns:field"}, "20%", "10%", "1,2");
        assertEquals("String[], String... constructor", "NOTMATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testArrayArray() {
        final NOTMATCH match = new NOTMATCH(new String[]{"FIELD1", "FIELD2", "ns:field"}, new String[]{"20%", "10%", "1,2"});
        assertEquals("String[], String[] constructor", "NOTMATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testArrayIterable() {
        final NOTMATCH match = new NOTMATCH(new String[]{"FIELD1", "FIELD2", "ns:field"}, Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String[], Iterable<String> constructor", "NOTMATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("String[], Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String[], Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableStrings() {
        final NOTMATCH match = new NOTMATCH(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "20%", "10%", "1,2");
        assertEquals("Iterable<String>, String... constructor", "NOTMATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, String... - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, String... - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableArray() {
        final NOTMATCH match = new NOTMATCH(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new String[]{"20%", "10%", "1,2"});
        assertEquals("Iterable<String>, String[] constructor", "NOTMATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testIterableIterable() {
        final NOTMATCH match = new NOTMATCH(Arrays.asList("FIELD1", "FIELD2", "ns:field"), Arrays.asList("20%", "10%", "1,2"));
        assertEquals("Iterable<String>, Iterable<String> constructor", "NOTMATCH{20%25,10%25,1%2C2}:FIELD1:FIELD2:ns%3Afield", match.toString());
        assertEquals("Iterable<String>, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("Iterable<String>, Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), match.getFields());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("NOTMATCH{val1,val2}:field", NOTMATCH("field", "val1", "val2").toString());
        assertEquals("NOTMATCH{val1,val2}:field", NOTMATCH("field", new String[]{"val1", "val2"}).toString());
        assertEquals("NOTMATCH{val1,val2}:field", NOTMATCH("field", Arrays.asList("val1", "val2")).toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH(new String[]{"field", "title"}, "val1", "val2").toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH(new String[]{"field", "title"}, new String[]{"val1", "val2"}).toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH(new String[]{"field", "title"}, Arrays.asList("val1", "val2")).toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH(Arrays.asList("field", "title"), "val1", "val2").toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH(Arrays.asList("field", "title"), new String[]{"val1", "val2"}).toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH(Arrays.asList("field", "title"), Arrays.asList("val1", "val2")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues1() {
        new NOTMATCH("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new NOTMATCH("FIELD", Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new NOTMATCH(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues4() {
        new NOTMATCH(new String[]{"FIELD"}, Arrays.<String>asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new NOTMATCH(Arrays.asList("FIELD"), new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new NOTMATCH(Arrays.asList("FIELD"), Arrays.<String>asList());
    }
}
