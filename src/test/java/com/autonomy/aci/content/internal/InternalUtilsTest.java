/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.content.internal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the <tt>SpecifierUtils</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class InternalUtilsTest {

    @Test
    public void testDoubleToString() {
        assertEquals("1", InternalUtils.doubleToString(1));
        assertEquals("10", InternalUtils.doubleToString(10));
        assertEquals("100", InternalUtils.doubleToString(100));
        assertEquals("1000", InternalUtils.doubleToString(1000));
        assertEquals("10000", InternalUtils.doubleToString(10000));
        assertEquals("100000", InternalUtils.doubleToString(100000));
        assertEquals("1000000", InternalUtils.doubleToString(1000000));
        assertEquals("10000000", InternalUtils.doubleToString(10000000));

        assertEquals("-3.14159", InternalUtils.doubleToString(-3.141592654f));
        assertEquals("-31.41593", InternalUtils.doubleToString(-31.41592654f));
        assertEquals("-314.1593", InternalUtils.doubleToString(-314.1592654f));
        assertEquals("-3141.593", InternalUtils.doubleToString(-3141.592654f));
        assertEquals("-23141.59", InternalUtils.doubleToString(-23141.592654f));
        assertEquals("-31415.9", InternalUtils.doubleToString(-31415.92654f));
        assertEquals("-314159", InternalUtils.doubleToString(-314159.2654f));
        assertEquals("-3141593", InternalUtils.doubleToString(-3141592.654));
        assertEquals("-31415927", InternalUtils.doubleToString(-31415926.54));
    }

    @Test
    public void testDoublesToStrings() {
        assertNull(InternalUtils.doublesToStrings((double[])null));
        assertTrue(Arrays.equals(InternalUtils.doublesToStrings(10000000, 3.141592654), new String[]{"10000000", "3.14159"}));
    }

    @Test
    public void testNumbersToStrings() {
        final List<Float> numbers = Arrays.asList(new Float[]{new Float(3.141592654f), new Float(3141592.65f)});
        final List<String> strings = Arrays.asList(new String[]{"3.14159", "3141593"});

        assertNull(InternalUtils.numbersToStrings((Iterable<Float>)null));
        assertEquals(strings, InternalUtils.numbersToStrings(numbers));
    }

    @Test
    public void testNumberToString() {
        assertNull(InternalUtils.numberToString((Integer)null));

        assertEquals("1", InternalUtils.numberToString(new Byte((byte)1)));
        assertEquals("10", InternalUtils.numberToString(new Short((short)10)));
        assertEquals("100", InternalUtils.numberToString(new Integer(100)));
        assertEquals("1000", InternalUtils.numberToString(new Integer(1000)));
        assertEquals("10000", InternalUtils.numberToString(new Long(10000)));
        assertEquals("100000", InternalUtils.numberToString(new Double(100000)));
        assertEquals("1000000", InternalUtils.numberToString(new Long(1000000)));
        assertEquals("10000000", InternalUtils.numberToString(new Long(10000000L)));

        assertEquals("3.14159", InternalUtils.numberToString(new Float(3.141592654f)));
        assertEquals("31.41593", InternalUtils.numberToString(new Float(31.41592654)));
        assertEquals("314.1593", InternalUtils.numberToString(new Float(314.1592654f)));
        assertEquals("3141.593", InternalUtils.numberToString(new Float(3141.592654)));
        assertEquals("23141.59", InternalUtils.numberToString(new Float(23141.592654f)));
        assertEquals("31415.9", InternalUtils.numberToString(new Float(31415.92654f)));
        assertEquals("314159", InternalUtils.numberToString(new Float(314159.2654)));
        assertEquals("3141593", InternalUtils.numberToString(new Double(3141592.654)));
        assertEquals("31415927", InternalUtils.numberToString(new BigDecimal(31415926.54)));
    }
}
