/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the <tt>EQUALALL</tt> class.
 *
 * @author darrelln
 * @version $Revision:$ $Date:$
 */
public class EQUALALLTest {
    @Test
    public void testStringFieldName() {
        assertEquals("EQUALALL{1}:field", new EQUALALL("field", 1).toString());
        assertEquals("EQUALALL{1.2}:field", new EQUALALL("field", 1.2).toString());
        assertEquals("EQUALALL{1}:field", new EQUALALL("field", 1L).toString());
        assertEquals("EQUALALL{1.3}:field", new EQUALALL("field", 1.3f).toString());
        assertEquals("EQUALALL{1}:field", new EQUALALL("field", (byte)1).toString());
        assertEquals("EQUALALL{1}:field", new EQUALALL("field", (short)1).toString());
        assertEquals("EQUALALL{1.3}:field", new EQUALALL("field", new BigDecimal("1.3")).toString());

        assertEquals("EQUALALL{1,2}:field", new EQUALALL("field", 1, 2).toString());
        assertEquals("EQUALALL{1.3,2}:field", new EQUALALL("field", 1.3, 2).toString());
        assertEquals("EQUALALL{1,2.3}:field", new EQUALALL("field", 1, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field", new EQUALALL("field", 1L, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field", new EQUALALL("field", 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUALALL{1,2}:field", new EQUALALL("field", new int[]{1, 2}).toString());
        assertEquals("EQUALALL{1.3,2.4}:field", new EQUALALL("field", new double[]{1.3, 2.4}).toString());
        assertEquals("EQUALALL{1,2}:field", new EQUALALL("field", new long[]{1L, 2L}).toString());

        assertEquals("EQUALALL{1,2}:field", new EQUALALL("field", new Integer[]{1, 2}).toString());

        assertEquals("EQUALALL{1,2.3}:field", new EQUALALL("field", Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticStringFieldName() {
        assertEquals("EQUALALL{1}:field", EQUALALL.EQUALALL("field", 1).toString());
        assertEquals("EQUALALL{1.2}:field", EQUALALL.EQUALALL("field", 1.2).toString());
        assertEquals("EQUALALL{1}:field", EQUALALL.EQUALALL("field", 1L).toString());
        assertEquals("EQUALALL{1.3}:field", EQUALALL.EQUALALL("field", 1.3f).toString());
        assertEquals("EQUALALL{1}:field", EQUALALL.EQUALALL("field", (byte) 1).toString());
        assertEquals("EQUALALL{1}:field", EQUALALL.EQUALALL("field", (short) 1).toString());
        assertEquals("EQUALALL{1.3}:field", EQUALALL.EQUALALL("field", new BigDecimal("1.3")).toString());

        assertEquals("EQUALALL{1,2}:field", EQUALALL.EQUALALL("field", 1, 2).toString());
        assertEquals("EQUALALL{1.3,2}:field", EQUALALL.EQUALALL("field", 1.3, 2).toString());
        assertEquals("EQUALALL{1,2.3}:field", EQUALALL.EQUALALL("field", 1, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field", EQUALALL.EQUALALL("field", 1L, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field", EQUALALL.EQUALALL("field", 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUALALL{1,2}:field", EQUALALL.EQUALALL("field", new int[]{1, 2}).toString());
        assertEquals("EQUALALL{1.3,2.4}:field", EQUALALL.EQUALALL("field", new double[]{1.3, 2.4}).toString());
        assertEquals("EQUALALL{1,2}:field", EQUALALL.EQUALALL("field", new long[]{1L, 2L}).toString());

        assertEquals("EQUALALL{1,2}:field", EQUALALL.EQUALALL("field", new Integer[]{1, 2}).toString());

        assertEquals("EQUALALL{1,2.3}:field", EQUALALL.EQUALALL("field", Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testArrayFieldNames() {
        final String[] fields = {"field", "title"};

        assertEquals("EQUALALL{1}:field:title", new EQUALALL(fields, 1).toString());
        assertEquals("EQUALALL{1.2}:field:title", new EQUALALL(fields, 1.2).toString());
        assertEquals("EQUALALL{1}:field:title", new EQUALALL(fields, 1L).toString());
        assertEquals("EQUALALL{1.3}:field:title", new EQUALALL(fields, 1.3f).toString());
        assertEquals("EQUALALL{1}:field:title", new EQUALALL(fields, (byte)1).toString());
        assertEquals("EQUALALL{1}:field:title", new EQUALALL(fields, (short)1).toString());
        assertEquals("EQUALALL{1.3}:field:title", new EQUALALL(fields, new BigDecimal("1.3")).toString());

        assertEquals("EQUALALL{1,2}:field:title", new EQUALALL(fields, 1, 2).toString());
        assertEquals("EQUALALL{1.3,2}:field:title", new EQUALALL(fields, 1.3, 2).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", new EQUALALL(fields, 1, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", new EQUALALL(fields, 1L, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", new EQUALALL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUALALL{1,2}:field:title", new EQUALALL(fields, new int[]{1, 2}).toString());
        assertEquals("EQUALALL{1.3,2.4}:field:title", new EQUALALL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("EQUALALL{1,2}:field:title", new EQUALALL(fields, new long[]{1L, 2L}).toString());

        assertEquals("EQUALALL{1,2}:field:title", new EQUALALL(fields, new Integer[]{1, 2}).toString());

        assertEquals("EQUALALL{1,2.3}:field:title", new EQUALALL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticArrayFieldNames() {
        final String[] fields = {"field", "title"};

        assertEquals("EQUALALL{1}:field:title", EQUALALL.EQUALALL(fields, 1).toString());
        assertEquals("EQUALALL{1.2}:field:title", EQUALALL.EQUALALL(fields, 1.2).toString());
        assertEquals("EQUALALL{1}:field:title", EQUALALL.EQUALALL(fields, 1L).toString());
        assertEquals("EQUALALL{1.3}:field:title", EQUALALL.EQUALALL(fields, 1.3f).toString());
        assertEquals("EQUALALL{1}:field:title", EQUALALL.EQUALALL(fields, (byte) 1).toString());
        assertEquals("EQUALALL{1}:field:title", EQUALALL.EQUALALL(fields, (short) 1).toString());
        assertEquals("EQUALALL{1.3}:field:title", EQUALALL.EQUALALL(fields, new BigDecimal("1.3")).toString());

        assertEquals("EQUALALL{1,2}:field:title", EQUALALL.EQUALALL(fields, 1, 2).toString());
        assertEquals("EQUALALL{1.3,2}:field:title", EQUALALL.EQUALALL(fields, 1.3, 2).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", EQUALALL.EQUALALL(fields, 1, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", EQUALALL.EQUALALL(fields, 1L, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", EQUALALL.EQUALALL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUALALL{1,2}:field:title", EQUALALL.EQUALALL(fields, new int[]{1, 2}).toString());
        assertEquals("EQUALALL{1.3,2.4}:field:title", EQUALALL.EQUALALL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("EQUALALL{1,2}:field:title", EQUALALL.EQUALALL(fields, new long[]{1L, 2L}).toString());

        assertEquals("EQUALALL{1,2}:field:title", EQUALALL.EQUALALL(fields, new Integer[]{1, 2}).toString());

        assertEquals("EQUALALL{1,2.3}:field:title", EQUALALL.EQUALALL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testIterableFieldNames() {
        final Iterable<? extends String> fields = Arrays.asList("field", "title");

        assertEquals("EQUALALL{1}:field:title", new EQUALALL(fields, 1).toString());
        assertEquals("EQUALALL{1.2}:field:title", new EQUALALL(fields, 1.2).toString());
        assertEquals("EQUALALL{1}:field:title", new EQUALALL(fields, 1L).toString());
        assertEquals("EQUALALL{1.3}:field:title", new EQUALALL(fields, 1.3f).toString());
        assertEquals("EQUALALL{1}:field:title", new EQUALALL(fields, (byte)1).toString());
        assertEquals("EQUALALL{1}:field:title", new EQUALALL(fields, (short)1).toString());
        assertEquals("EQUALALL{1.3}:field:title", new EQUALALL(fields, new BigDecimal("1.3")).toString());

        assertEquals("EQUALALL{1,2}:field:title", new EQUALALL(fields, 1, 2).toString());
        assertEquals("EQUALALL{1.3,2}:field:title", new EQUALALL(fields, 1.3, 2).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", new EQUALALL(fields, 1, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", new EQUALALL(fields, 1L, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", new EQUALALL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUALALL{1,2}:field:title", new EQUALALL(fields, new int[]{1, 2}).toString());
        assertEquals("EQUALALL{1.3,2.4}:field:title", new EQUALALL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("EQUALALL{1,2}:field:title", new EQUALALL(fields, new long[]{1L, 2L}).toString());

        assertEquals("EQUALALL{1,2}:field:title", new EQUALALL(fields, new Integer[]{1, 2}).toString());

        assertEquals("EQUALALL{1,2.3}:field:title", new EQUALALL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticIterableFieldNames() {
        final Iterable<? extends String> fields = Arrays.asList("field", "title");

        assertEquals("EQUALALL{1}:field:title", EQUALALL.EQUALALL(fields, 1).toString());
        assertEquals("EQUALALL{1.2}:field:title", EQUALALL.EQUALALL(fields, 1.2).toString());
        assertEquals("EQUALALL{1}:field:title", EQUALALL.EQUALALL(fields, 1L).toString());
        assertEquals("EQUALALL{1.3}:field:title", EQUALALL.EQUALALL(fields, 1.3f).toString());
        assertEquals("EQUALALL{1}:field:title", EQUALALL.EQUALALL(fields, (byte) 1).toString());
        assertEquals("EQUALALL{1}:field:title", EQUALALL.EQUALALL(fields, (short) 1).toString());
        assertEquals("EQUALALL{1.3}:field:title", EQUALALL.EQUALALL(fields, new BigDecimal("1.3")).toString());

        assertEquals("EQUALALL{1,2}:field:title", EQUALALL.EQUALALL(fields, 1, 2).toString());
        assertEquals("EQUALALL{1.3,2}:field:title", EQUALALL.EQUALALL(fields, 1.3, 2).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", EQUALALL.EQUALALL(fields, 1, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", EQUALALL.EQUALALL(fields, 1L, 2.3).toString());
        assertEquals("EQUALALL{1,2.3}:field:title", EQUALALL.EQUALALL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUALALL{1,2}:field:title", EQUALALL.EQUALALL(fields, new int[]{1, 2}).toString());
        assertEquals("EQUALALL{1.3,2.4}:field:title", EQUALALL.EQUALALL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("EQUALALL{1,2}:field:title", EQUALALL.EQUALALL(fields, new long[]{1L, 2L}).toString());

        assertEquals("EQUALALL{1,2}:field:title", EQUALALL.EQUALALL(fields, new Integer[]{1, 2}).toString());

        assertEquals("EQUALALL{1,2.3}:field:title", EQUALALL.EQUALALL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testBasicFunctionality() {
        final EQUALALL EQUALALL = new EQUALALL("field", 1, 2, 3);

        assertEquals("EQUALALL{1,2,3}:field", EQUALALL.toString());
        assertEquals(Arrays.asList("1", "2", "3"), EQUALALL.getValues());
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, EQUALALL.getNumericValues(), 0);
        assertEquals(Collections.singletonList("field"), EQUALALL.getFields());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException1() {
        new EQUALALL((String)null, 1);
    }

    @Test(expected = RuntimeException.class)
    public void testNullException2() {
        new EQUALALL((String[])null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException3() {
        new EQUALALL(new String[]{null}, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException4() {
        new EQUALALL((Iterable<String>)null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException5() {
        new EQUALALL(Arrays.asList("field", null), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException6() {
        new EQUALALL("field", (Integer)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException7() {
        new EQUALALL("field", 7, (Integer)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException8() {
        new EQUALALL("field", (int[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException9() {
        new EQUALALL("field", (Iterable<Number>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException10() {
        new EQUALALL("field", Arrays.asList(1, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException1() {
        new EQUALALL("field", new Integer[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException2() {
        new EQUALALL("field", new int[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException3() {
        new EQUALALL("field", Collections.<Long>emptyList());
    }

}
