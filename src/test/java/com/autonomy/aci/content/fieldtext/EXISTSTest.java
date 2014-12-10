/*
 * $Id$
 *
 * Copyright (c) 2008-2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */

package com.autonomy.aci.content.fieldtext;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import static com.autonomy.aci.content.fieldtext.EXISTS.*;

import static org.junit.Assert.*;

/**
 * Tests for the <TT>EXISTS</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class EXISTSTest {
    @Test
    public void testString() {
        final EXISTS exists = new EXISTS("ns:field");
        assertEquals("String constructor", "EXISTS{}:ns%3Afield", exists.toString());
        assertEquals("String - getFields", Arrays.asList("ns:field"), exists.getFields());
        assertTrue("String - getValues", exists.getValues().isEmpty());
    }

    @Test
    public void testArray() {
        final EXISTS exists = new EXISTS(new String[]{"FIELD1", "FIELD2", "ns:field"});
        assertEquals("String[] constructor", "EXISTS{}:FIELD1:FIELD2:ns%3Afield", exists.toString());
        assertEquals("String[] - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), exists.getFields());
        assertTrue("String[] - getValues", exists.getValues().isEmpty());
    }

    @Test
    public void testIterable() {
        final EXISTS exists = new EXISTS(Arrays.asList("FIELD1", "FIELD2", "ns:field"));
        assertEquals("Iterable<String> constructor", "EXISTS{}:FIELD1:FIELD2:ns%3Afield", exists.toString());
        assertEquals("Iterable<String> - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), exists.getFields());
        assertTrue("Iterable<String> - getValues", exists.getValues().isEmpty());
    }
    
    @Test
    public void testFactoryMethods() {
        assertEquals("EXISTS{}:field", EXISTS("field").toString());
        assertEquals("EXISTS{}:field:title", EXISTS("field", "title").toString());
        assertEquals("EXISTS{}:field:title", EXISTS(new String[]{"field", "title"}).toString());
        assertEquals("EXISTS{}:field:title", EXISTS(Arrays.asList("field", "title")).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException1() {
        new EXISTS((String)null);
    }

    @Test(expected = RuntimeException.class)
    public void testNullException2() {
        new EXISTS((String[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException3() {
        new EXISTS(new String[]{null});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException4() {
        new EXISTS((Iterable<String>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException5() {
        new EXISTS(Arrays.asList("title", null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoFieldsArray() {
        new EXISTS(new String[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoFieldsIterable() {
        new EXISTS(Collections.<String>emptyList());
    }
}
