/*
 * Copyright 2009-2015 Open Text.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Open Text and its affiliates
 * and licensors ("Open Text") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Open Text shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.hp.autonomy.aci.content.fieldtext;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

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
        assertEquals("String, String... - getFields", Collections.singletonList("ns:field"), match.getFields());
    }

    @Test
    public void testStringArray() {
        final NOTMATCH match = new NOTMATCH("ns:field", new String[]{"20%", "10%", "1,2"});
        assertEquals("String, String[] constructor", "NOTMATCH{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, String[] - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, String[] - getFields", Collections.singletonList("ns:field"), match.getFields());
    }

    @Test
    public void testStringIterable() {
        final NOTMATCH match = new NOTMATCH("ns:field", Arrays.asList("20%", "10%", "1,2"));
        assertEquals("String, Iterable<String> constructor", "NOTMATCH{20%25,10%25,1%2C2}:ns%3Afield", match.toString());
        assertEquals("String, Iterable<String> - getValues", Arrays.asList("20%", "10%", "1,2"), match.getValues());
        assertEquals("String, Iterable<String> - getFields", Collections.singletonList("ns:field"), match.getFields());
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
        assertEquals("NOTMATCH{val1,val2}:field", NOTMATCH.NOTMATCH("field", "val1", "val2").toString());
        assertEquals("NOTMATCH{val1,val2}:field", NOTMATCH.NOTMATCH("field", new String[]{"val1", "val2"}).toString());
        assertEquals("NOTMATCH{val1,val2}:field", NOTMATCH.NOTMATCH("field", Arrays.asList("val1", "val2")).toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH.NOTMATCH(new String[]{"field", "title"}, "val1", "val2").toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH.NOTMATCH(new String[]{"field", "title"}, new String[]{"val1", "val2"}).toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH.NOTMATCH(new String[]{"field", "title"}, Arrays.asList("val1", "val2")).toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH.NOTMATCH(Arrays.asList("field", "title"), "val1", "val2").toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH.NOTMATCH(Arrays.asList("field", "title"), new String[]{"val1", "val2"}).toString());
        assertEquals("NOTMATCH{val1,val2}:field:title", NOTMATCH.NOTMATCH(Arrays.asList("field", "title"), Arrays.asList("val1", "val2")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues1() {
        new NOTMATCH("FIELD", new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues2() {
        new NOTMATCH("FIELD", Collections.<String>emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues3() {
        new NOTMATCH(new String[]{"FIELD"}, new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues4() {
        new NOTMATCH(new String[]{"FIELD"}, Collections.<String>emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues5() {
        new NOTMATCH(Collections.singletonList("FIELD"), new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValues6() {
        new NOTMATCH(Collections.singletonList("FIELD"), Collections.<String>emptyList());
    }
}
