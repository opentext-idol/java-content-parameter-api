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

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static com.hp.autonomy.aci.content.fieldtext.NOTEQUAL.NOTEQUAL;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the <tt>NOTEQUAL</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class NOTEQUALTest {
    @Test
    public void testStringFieldName() {
        assertEquals("NOTEQUAL{1}:field", new NOTEQUAL("field", 1).toString());
        assertEquals("NOTEQUAL{1.2}:field", new NOTEQUAL("field", 1.2).toString());
        assertEquals("NOTEQUAL{1}:field", new NOTEQUAL("field", 1L).toString());
        assertEquals("NOTEQUAL{1.3}:field", new NOTEQUAL("field", 1.3f).toString());
        assertEquals("NOTEQUAL{1}:field", new NOTEQUAL("field", (byte)1).toString());
        assertEquals("NOTEQUAL{1}:field", new NOTEQUAL("field", (short)1).toString());
        assertEquals("NOTEQUAL{1.3}:field", new NOTEQUAL("field", new BigDecimal("1.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field", new NOTEQUAL("field", 1, 2).toString());
        assertEquals("NOTEQUAL{1.3,2}:field", new NOTEQUAL("field", 1.3, 2).toString());
        assertEquals("NOTEQUAL{1,2.3}:field", new NOTEQUAL("field", 1, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field", new NOTEQUAL("field", 1L, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field", new NOTEQUAL("field", 1L, new BigDecimal("2.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field", new NOTEQUAL("field", new int[]{1, 2}).toString());
        assertEquals("NOTEQUAL{1.3,2.4}:field", new NOTEQUAL("field", new double[]{1.3, 2.4}).toString());
        assertEquals("NOTEQUAL{1,2}:field", new NOTEQUAL("field", new long[]{1L, 2L}).toString());

        assertEquals("NOTEQUAL{1,2}:field", new NOTEQUAL("field", new Integer[]{1, 2}).toString());

        assertEquals("NOTEQUAL{1,2.3}:field", new NOTEQUAL("field", Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticStringFieldName() {
        assertEquals("NOTEQUAL{1}:field", NOTEQUAL.NOTEQUAL("field", 1).toString());
        assertEquals("NOTEQUAL{1.2}:field", NOTEQUAL.NOTEQUAL("field", 1.2).toString());
        assertEquals("NOTEQUAL{1}:field", NOTEQUAL.NOTEQUAL("field", 1L).toString());
        assertEquals("NOTEQUAL{1.3}:field", NOTEQUAL.NOTEQUAL("field", 1.3f).toString());
        assertEquals("NOTEQUAL{1}:field", NOTEQUAL.NOTEQUAL("field", (byte) 1).toString());
        assertEquals("NOTEQUAL{1}:field", NOTEQUAL.NOTEQUAL("field", (short) 1).toString());
        assertEquals("NOTEQUAL{1.3}:field", NOTEQUAL.NOTEQUAL("field", new BigDecimal("1.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field", NOTEQUAL.NOTEQUAL("field", 1, 2).toString());
        assertEquals("NOTEQUAL{1.3,2}:field", NOTEQUAL.NOTEQUAL("field", 1.3, 2).toString());
        assertEquals("NOTEQUAL{1,2.3}:field", NOTEQUAL.NOTEQUAL("field", 1, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field", NOTEQUAL.NOTEQUAL("field", 1L, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field", NOTEQUAL.NOTEQUAL("field", 1L, new BigDecimal("2.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field", NOTEQUAL.NOTEQUAL("field", new int[]{1, 2}).toString());
        assertEquals("NOTEQUAL{1.3,2.4}:field", NOTEQUAL.NOTEQUAL("field", new double[]{1.3, 2.4}).toString());
        assertEquals("NOTEQUAL{1,2}:field", NOTEQUAL.NOTEQUAL("field", new long[]{1L, 2L}).toString());

        assertEquals("NOTEQUAL{1,2}:field", NOTEQUAL.NOTEQUAL("field", new Integer[]{1, 2}).toString());

        assertEquals("NOTEQUAL{1,2.3}:field", NOTEQUAL.NOTEQUAL("field", Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testArrayFieldNames() {
        final String[] fields = {"field", "title"};

        assertEquals("NOTEQUAL{1}:field:title", new NOTEQUAL(fields, 1).toString());
        assertEquals("NOTEQUAL{1.2}:field:title", new NOTEQUAL(fields, 1.2).toString());
        assertEquals("NOTEQUAL{1}:field:title", new NOTEQUAL(fields, 1L).toString());
        assertEquals("NOTEQUAL{1.3}:field:title", new NOTEQUAL(fields, 1.3f).toString());
        assertEquals("NOTEQUAL{1}:field:title", new NOTEQUAL(fields, (byte)1).toString());
        assertEquals("NOTEQUAL{1}:field:title", new NOTEQUAL(fields, (short)1).toString());
        assertEquals("NOTEQUAL{1.3}:field:title", new NOTEQUAL(fields, new BigDecimal("1.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", new NOTEQUAL(fields, 1, 2).toString());
        assertEquals("NOTEQUAL{1.3,2}:field:title", new NOTEQUAL(fields, 1.3, 2).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", new NOTEQUAL(fields, 1, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", new NOTEQUAL(fields, 1L, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", new NOTEQUAL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", new NOTEQUAL(fields, new int[]{1, 2}).toString());
        assertEquals("NOTEQUAL{1.3,2.4}:field:title", new NOTEQUAL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("NOTEQUAL{1,2}:field:title", new NOTEQUAL(fields, new long[]{1L, 2L}).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", new NOTEQUAL(fields, new Integer[]{1, 2}).toString());

        assertEquals("NOTEQUAL{1,2.3}:field:title", new NOTEQUAL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticArrayFieldNames() {
        final String[] fields = {"field", "title"};

        assertEquals("NOTEQUAL{1}:field:title", NOTEQUAL.NOTEQUAL(fields, 1).toString());
        assertEquals("NOTEQUAL{1.2}:field:title", NOTEQUAL.NOTEQUAL(fields, 1.2).toString());
        assertEquals("NOTEQUAL{1}:field:title", NOTEQUAL.NOTEQUAL(fields, 1L).toString());
        assertEquals("NOTEQUAL{1.3}:field:title", NOTEQUAL.NOTEQUAL(fields, 1.3f).toString());
        assertEquals("NOTEQUAL{1}:field:title", NOTEQUAL.NOTEQUAL(fields, (byte) 1).toString());
        assertEquals("NOTEQUAL{1}:field:title", NOTEQUAL.NOTEQUAL(fields, (short) 1).toString());
        assertEquals("NOTEQUAL{1.3}:field:title", NOTEQUAL.NOTEQUAL(fields, new BigDecimal("1.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", NOTEQUAL.NOTEQUAL(fields, 1, 2).toString());
        assertEquals("NOTEQUAL{1.3,2}:field:title", NOTEQUAL.NOTEQUAL(fields, 1.3, 2).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", NOTEQUAL.NOTEQUAL(fields, 1, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", NOTEQUAL.NOTEQUAL(fields, 1L, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", NOTEQUAL.NOTEQUAL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", NOTEQUAL.NOTEQUAL(fields, new int[]{1, 2}).toString());
        assertEquals("NOTEQUAL{1.3,2.4}:field:title", NOTEQUAL.NOTEQUAL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("NOTEQUAL{1,2}:field:title", NOTEQUAL.NOTEQUAL(fields, new long[]{1L, 2L}).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", NOTEQUAL.NOTEQUAL(fields, new Integer[]{1, 2}).toString());

        assertEquals("NOTEQUAL{1,2.3}:field:title", NOTEQUAL.NOTEQUAL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testIterableFieldNames() {
        final Iterable<? extends String> fields = Arrays.asList("field", "title");

        assertEquals("NOTEQUAL{1}:field:title", new NOTEQUAL(fields, 1).toString());
        assertEquals("NOTEQUAL{1.2}:field:title", new NOTEQUAL(fields, 1.2).toString());
        assertEquals("NOTEQUAL{1}:field:title", new NOTEQUAL(fields, 1L).toString());
        assertEquals("NOTEQUAL{1.3}:field:title", new NOTEQUAL(fields, 1.3f).toString());
        assertEquals("NOTEQUAL{1}:field:title", new NOTEQUAL(fields, (byte)1).toString());
        assertEquals("NOTEQUAL{1}:field:title", new NOTEQUAL(fields, (short)1).toString());
        assertEquals("NOTEQUAL{1.3}:field:title", new NOTEQUAL(fields, new BigDecimal("1.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", new NOTEQUAL(fields, 1, 2).toString());
        assertEquals("NOTEQUAL{1.3,2}:field:title", new NOTEQUAL(fields, 1.3, 2).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", new NOTEQUAL(fields, 1, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", new NOTEQUAL(fields, 1L, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", new NOTEQUAL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", new NOTEQUAL(fields, new int[]{1, 2}).toString());
        assertEquals("NOTEQUAL{1.3,2.4}:field:title", new NOTEQUAL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("NOTEQUAL{1,2}:field:title", new NOTEQUAL(fields, new long[]{1L, 2L}).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", new NOTEQUAL(fields, new Integer[]{1, 2}).toString());

        assertEquals("NOTEQUAL{1,2.3}:field:title", new NOTEQUAL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticIterableFieldNames() {
        final Iterable<? extends String> fields = Arrays.asList("field", "title");

        assertEquals("NOTEQUAL{1}:field:title", NOTEQUAL.NOTEQUAL(fields, 1).toString());
        assertEquals("NOTEQUAL{1.2}:field:title", NOTEQUAL.NOTEQUAL(fields, 1.2).toString());
        assertEquals("NOTEQUAL{1}:field:title", NOTEQUAL.NOTEQUAL(fields, 1L).toString());
        assertEquals("NOTEQUAL{1.3}:field:title", NOTEQUAL.NOTEQUAL(fields, 1.3f).toString());
        assertEquals("NOTEQUAL{1}:field:title", NOTEQUAL.NOTEQUAL(fields, (byte) 1).toString());
        assertEquals("NOTEQUAL{1}:field:title", NOTEQUAL.NOTEQUAL(fields, (short) 1).toString());
        assertEquals("NOTEQUAL{1.3}:field:title", NOTEQUAL.NOTEQUAL(fields, new BigDecimal("1.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", NOTEQUAL.NOTEQUAL(fields, 1, 2).toString());
        assertEquals("NOTEQUAL{1.3,2}:field:title", NOTEQUAL.NOTEQUAL(fields, 1.3, 2).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", NOTEQUAL.NOTEQUAL(fields, 1, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", NOTEQUAL.NOTEQUAL(fields, 1L, 2.3).toString());
        assertEquals("NOTEQUAL{1,2.3}:field:title", NOTEQUAL.NOTEQUAL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", NOTEQUAL.NOTEQUAL(fields, new int[]{1, 2}).toString());
        assertEquals("NOTEQUAL{1.3,2.4}:field:title", NOTEQUAL.NOTEQUAL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("NOTEQUAL{1,2}:field:title", NOTEQUAL.NOTEQUAL(fields, new long[]{1L, 2L}).toString());

        assertEquals("NOTEQUAL{1,2}:field:title", NOTEQUAL.NOTEQUAL(fields, new Integer[]{1, 2}).toString());

        assertEquals("NOTEQUAL{1,2.3}:field:title", NOTEQUAL.NOTEQUAL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testBasicFunctionality() {
        final NOTEQUAL equal = new NOTEQUAL("field", 1, 2, 3);

        assertEquals("NOTEQUAL{1,2,3}:field", equal.toString());
        assertEquals(Arrays.asList("1", "2", "3"), equal.getValues());
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, equal.getNumericValues(), 0);
        assertEquals(Collections.singletonList("field"), equal.getFields());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException1() {
        new NOTEQUAL((String)null, 1);
    }

    @Test(expected = RuntimeException.class)
    public void testNullException2() {
        new NOTEQUAL((String[])null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException3() {
        new NOTEQUAL(new String[]{null}, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException4() {
        new NOTEQUAL((Iterable<String>)null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException5() {
        new NOTEQUAL(Arrays.asList("field", null), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException6() {
        new NOTEQUAL("field", (Integer)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException7() {
        new NOTEQUAL("field", 7, (Integer)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException8() {
        new NOTEQUAL("field", (int[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException9() {
        new NOTEQUAL("field", (Iterable<Number>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException10() {
        new NOTEQUAL("field", Arrays.asList(1, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException1() {
        new NOTEQUAL("field", new Integer[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException2() {
        new NOTEQUAL("field", new int[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException3() {
        new NOTEQUAL("field", Collections.<Long>emptyList());
    }
}
