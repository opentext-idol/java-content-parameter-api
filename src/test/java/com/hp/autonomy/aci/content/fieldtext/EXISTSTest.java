/*
 * (c) Copyright 2009-2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.hp.autonomy.aci.content.fieldtext;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.hp.autonomy.aci.content.fieldtext.EXISTS.EXISTS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals("String - getFields", Collections.singletonList("ns:field"), exists.getFields());
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
        assertEquals("EXISTS{}:field", EXISTS.EXISTS("field").toString());
        assertEquals("EXISTS{}:field:title", EXISTS.EXISTS("field", "title").toString());
        assertEquals("EXISTS{}:field:title", EXISTS.EXISTS(new String[]{"field", "title"}).toString());
        assertEquals("EXISTS{}:field:title", EXISTS.EXISTS(Arrays.asList("field", "title")).toString());
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
