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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static com.hp.autonomy.aci.content.fieldtext.EQUAL.EQUAL;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the <tt>EQUAL</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class EQUALTest {
    @Test
    public void testStringFieldName() {
        assertEquals("EQUAL{1}:field", new EQUAL("field", 1).toString());
        assertEquals("EQUAL{1.2}:field", new EQUAL("field", 1.2).toString());
        assertEquals("EQUAL{1}:field", new EQUAL("field", 1L).toString());
        assertEquals("EQUAL{1.3}:field", new EQUAL("field", 1.3f).toString());
        assertEquals("EQUAL{1}:field", new EQUAL("field", (byte)1).toString());
        assertEquals("EQUAL{1}:field", new EQUAL("field", (short)1).toString());
        assertEquals("EQUAL{1.3}:field", new EQUAL("field", new BigDecimal("1.3")).toString());

        assertEquals("EQUAL{1,2}:field", new EQUAL("field", 1, 2).toString());
        assertEquals("EQUAL{1.3,2}:field", new EQUAL("field", 1.3, 2).toString());
        assertEquals("EQUAL{1,2.3}:field", new EQUAL("field", 1, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field", new EQUAL("field", 1L, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field", new EQUAL("field", 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUAL{1,2}:field", new EQUAL("field", new int[]{1, 2}).toString());
        assertEquals("EQUAL{1.3,2.4}:field", new EQUAL("field", new double[]{1.3, 2.4}).toString());
        assertEquals("EQUAL{1,2}:field", new EQUAL("field", new long[]{1L, 2L}).toString());

        assertEquals("EQUAL{1,2}:field", new EQUAL("field", new Integer[]{1, 2}).toString());

        assertEquals("EQUAL{1,2.3}:field", new EQUAL("field", Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticStringFieldName() {
        assertEquals("EQUAL{1}:field", EQUAL.EQUAL("field", 1).toString());
        assertEquals("EQUAL{1.2}:field", EQUAL.EQUAL("field", 1.2).toString());
        assertEquals("EQUAL{1}:field", EQUAL.EQUAL("field", 1L).toString());
        assertEquals("EQUAL{1.3}:field", EQUAL.EQUAL("field", 1.3f).toString());
        assertEquals("EQUAL{1}:field", EQUAL.EQUAL("field", (byte) 1).toString());
        assertEquals("EQUAL{1}:field", EQUAL.EQUAL("field", (short) 1).toString());
        assertEquals("EQUAL{1.3}:field", EQUAL.EQUAL("field", new BigDecimal("1.3")).toString());

        assertEquals("EQUAL{1,2}:field", EQUAL.EQUAL("field", 1, 2).toString());
        assertEquals("EQUAL{1.3,2}:field", EQUAL.EQUAL("field", 1.3, 2).toString());
        assertEquals("EQUAL{1,2.3}:field", EQUAL.EQUAL("field", 1, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field", EQUAL.EQUAL("field", 1L, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field", EQUAL.EQUAL("field", 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUAL{1,2}:field", EQUAL.EQUAL("field", new int[]{1, 2}).toString());
        assertEquals("EQUAL{1.3,2.4}:field", EQUAL.EQUAL("field", new double[]{1.3, 2.4}).toString());
        assertEquals("EQUAL{1,2}:field", EQUAL.EQUAL("field", new long[]{1L, 2L}).toString());

        assertEquals("EQUAL{1,2}:field", EQUAL.EQUAL("field", new Integer[]{1, 2}).toString());

        assertEquals("EQUAL{1,2.3}:field", EQUAL.EQUAL("field", Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testArrayFieldNames() {
        final String[] fields = {"field", "title"};

        assertEquals("EQUAL{1}:field:title", new EQUAL(fields, 1).toString());
        assertEquals("EQUAL{1.2}:field:title", new EQUAL(fields, 1.2).toString());
        assertEquals("EQUAL{1}:field:title", new EQUAL(fields, 1L).toString());
        assertEquals("EQUAL{1.3}:field:title", new EQUAL(fields, 1.3f).toString());
        assertEquals("EQUAL{1}:field:title", new EQUAL(fields, (byte)1).toString());
        assertEquals("EQUAL{1}:field:title", new EQUAL(fields, (short)1).toString());
        assertEquals("EQUAL{1.3}:field:title", new EQUAL(fields, new BigDecimal("1.3")).toString());

        assertEquals("EQUAL{1,2}:field:title", new EQUAL(fields, 1, 2).toString());
        assertEquals("EQUAL{1.3,2}:field:title", new EQUAL(fields, 1.3, 2).toString());
        assertEquals("EQUAL{1,2.3}:field:title", new EQUAL(fields, 1, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field:title", new EQUAL(fields, 1L, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field:title", new EQUAL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUAL{1,2}:field:title", new EQUAL(fields, new int[]{1, 2}).toString());
        assertEquals("EQUAL{1.3,2.4}:field:title", new EQUAL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("EQUAL{1,2}:field:title", new EQUAL(fields, new long[]{1L, 2L}).toString());

        assertEquals("EQUAL{1,2}:field:title", new EQUAL(fields, new Integer[]{1, 2}).toString());

        assertEquals("EQUAL{1,2.3}:field:title", new EQUAL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticArrayFieldNames() {
        final String[] fields = {"field", "title"};

        assertEquals("EQUAL{1}:field:title", EQUAL.EQUAL(fields, 1).toString());
        assertEquals("EQUAL{1.2}:field:title", EQUAL.EQUAL(fields, 1.2).toString());
        assertEquals("EQUAL{1}:field:title", EQUAL.EQUAL(fields, 1L).toString());
        assertEquals("EQUAL{1.3}:field:title", EQUAL.EQUAL(fields, 1.3f).toString());
        assertEquals("EQUAL{1}:field:title", EQUAL.EQUAL(fields, (byte) 1).toString());
        assertEquals("EQUAL{1}:field:title", EQUAL.EQUAL(fields, (short) 1).toString());
        assertEquals("EQUAL{1.3}:field:title", EQUAL.EQUAL(fields, new BigDecimal("1.3")).toString());

        assertEquals("EQUAL{1,2}:field:title", EQUAL.EQUAL(fields, 1, 2).toString());
        assertEquals("EQUAL{1.3,2}:field:title", EQUAL.EQUAL(fields, 1.3, 2).toString());
        assertEquals("EQUAL{1,2.3}:field:title", EQUAL.EQUAL(fields, 1, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field:title", EQUAL.EQUAL(fields, 1L, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field:title", EQUAL.EQUAL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUAL{1,2}:field:title", EQUAL.EQUAL(fields, new int[]{1, 2}).toString());
        assertEquals("EQUAL{1.3,2.4}:field:title", EQUAL.EQUAL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("EQUAL{1,2}:field:title", EQUAL.EQUAL(fields, new long[]{1L, 2L}).toString());

        assertEquals("EQUAL{1,2}:field:title", EQUAL.EQUAL(fields, new Integer[]{1, 2}).toString());

        assertEquals("EQUAL{1,2.3}:field:title", EQUAL.EQUAL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testIterableFieldNames() {
        final Iterable<? extends String> fields = Arrays.asList("field", "title");

        assertEquals("EQUAL{1}:field:title", new EQUAL(fields, 1).toString());
        assertEquals("EQUAL{1.2}:field:title", new EQUAL(fields, 1.2).toString());
        assertEquals("EQUAL{1}:field:title", new EQUAL(fields, 1L).toString());
        assertEquals("EQUAL{1.3}:field:title", new EQUAL(fields, 1.3f).toString());
        assertEquals("EQUAL{1}:field:title", new EQUAL(fields, (byte)1).toString());
        assertEquals("EQUAL{1}:field:title", new EQUAL(fields, (short)1).toString());
        assertEquals("EQUAL{1.3}:field:title", new EQUAL(fields, new BigDecimal("1.3")).toString());

        assertEquals("EQUAL{1,2}:field:title", new EQUAL(fields, 1, 2).toString());
        assertEquals("EQUAL{1.3,2}:field:title", new EQUAL(fields, 1.3, 2).toString());
        assertEquals("EQUAL{1,2.3}:field:title", new EQUAL(fields, 1, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field:title", new EQUAL(fields, 1L, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field:title", new EQUAL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUAL{1,2}:field:title", new EQUAL(fields, new int[]{1, 2}).toString());
        assertEquals("EQUAL{1.3,2.4}:field:title", new EQUAL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("EQUAL{1,2}:field:title", new EQUAL(fields, new long[]{1L, 2L}).toString());

        assertEquals("EQUAL{1,2}:field:title", new EQUAL(fields, new Integer[]{1, 2}).toString());

        assertEquals("EQUAL{1,2.3}:field:title", new EQUAL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testStaticIterableFieldNames() {
        final Iterable<? extends String> fields = Arrays.asList("field", "title");

        assertEquals("EQUAL{1}:field:title", EQUAL.EQUAL(fields, 1).toString());
        assertEquals("EQUAL{1.2}:field:title", EQUAL.EQUAL(fields, 1.2).toString());
        assertEquals("EQUAL{1}:field:title", EQUAL.EQUAL(fields, 1L).toString());
        assertEquals("EQUAL{1.3}:field:title", EQUAL.EQUAL(fields, 1.3f).toString());
        assertEquals("EQUAL{1}:field:title", EQUAL.EQUAL(fields, (byte) 1).toString());
        assertEquals("EQUAL{1}:field:title", EQUAL.EQUAL(fields, (short) 1).toString());
        assertEquals("EQUAL{1.3}:field:title", EQUAL.EQUAL(fields, new BigDecimal("1.3")).toString());

        assertEquals("EQUAL{1,2}:field:title", EQUAL.EQUAL(fields, 1, 2).toString());
        assertEquals("EQUAL{1.3,2}:field:title", EQUAL.EQUAL(fields, 1.3, 2).toString());
        assertEquals("EQUAL{1,2.3}:field:title", EQUAL.EQUAL(fields, 1, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field:title", EQUAL.EQUAL(fields, 1L, 2.3).toString());
        assertEquals("EQUAL{1,2.3}:field:title", EQUAL.EQUAL(fields, 1L, new BigDecimal("2.3")).toString());

        assertEquals("EQUAL{1,2}:field:title", EQUAL.EQUAL(fields, new int[]{1, 2}).toString());
        assertEquals("EQUAL{1.3,2.4}:field:title", EQUAL.EQUAL(fields, new double[]{1.3, 2.4}).toString());
        assertEquals("EQUAL{1,2}:field:title", EQUAL.EQUAL(fields, new long[]{1L, 2L}).toString());

        assertEquals("EQUAL{1,2}:field:title", EQUAL.EQUAL(fields, new Integer[]{1, 2}).toString());

        assertEquals("EQUAL{1,2.3}:field:title", EQUAL.EQUAL(fields, Arrays.asList(1L, 2.3)).toString());
    }

    @Test
    public void testBasicFunctionality() {
        final EQUAL equal = new EQUAL("field", 1, 2, 3);

        assertEquals("EQUAL{1,2,3}:field", equal.toString());
        assertEquals(Arrays.asList("1", "2", "3"), equal.getValues());
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, equal.getNumericValues(), 0);
        assertEquals(Collections.singletonList("field"), equal.getFields());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException1() {
        new EQUAL((String)null, 1);
    }

    @Test(expected = RuntimeException.class)
    public void testNullException2() {
        new EQUAL((String[])null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException3() {
        new EQUAL(new String[]{null}, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException4() {
        new EQUAL((Iterable<String>)null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException5() {
        new EQUAL(Arrays.asList("field", null), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException6() {
        new EQUAL("field", (Integer)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException7() {
        new EQUAL("field", 7, (Integer)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException8() {
        new EQUAL("field", (int[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException9() {
        new EQUAL("field", (Iterable<Number>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException10() {
        new EQUAL("field", Arrays.asList(1, null));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException1() {
        new EQUAL("field", new Integer[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException2() {
        new EQUAL("field", new int[0]);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyException3() {
        new EQUAL("field", Collections.<Long>emptyList());
    }
}
