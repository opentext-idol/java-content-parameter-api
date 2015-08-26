/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.aci.content.identifier.stateid;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * RangeTest
 */
public class RangeTest {
    @Test
    public void testIntConstructor() {
        final Range range = new Range(0);

        assertEquals(0, range.getStart());
        assertEquals(0, range.getEnd());
        assertEquals("0", range.toString());
        assertEquals(1, range.size());
        assertFalse(range.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntConstructorNegativeNumberException() {
        new Range(-1);
    }

    @Test
    public void testIntIntConstructor() {
        final Range range = new Range(0, 7);

        assertEquals(0, range.getStart());
        assertEquals(7, range.getEnd());
        assertEquals("0-7", range.toString());
        assertEquals(8, range.size());
        assertFalse(range.isEmpty());
    }

    @Test
    public void testIntIntConstructorBorderline() {
        final Range range = new Range(7, 7);

        assertEquals(7, range.getStart());
        assertEquals(7, range.getEnd());
        assertEquals("7", range.toString());
        assertEquals(1, range.size());
        assertFalse(range.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntIntConstructorOrderException() {
        new Range(8, 7);
    }

    @Test
    public void testNext() {
        final Range range = new Range(7, 9).next();

        assertEquals(10, range.getStart());
        assertEquals(12, range.getEnd());
        assertEquals("10-12", range.toString());
        assertEquals(3, range.size());
        assertFalse(range.isEmpty());
    }

    @Test
    public void testNextInt() {
        final Range range = new Range(7, 9).next(4);

        assertEquals(10, range.getStart());
        assertEquals(13, range.getEnd());
        assertEquals("10-13", range.toString());
        assertEquals(4, range.size());
        assertFalse(range.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextIntZeroException() {
        new Range(7, 9).next(0);
    }

    @Test
    public void testPageInt() {
        final Range range = Range.first(12).page(2);

        assertEquals(12, range.getStart());
        assertEquals(23, range.getEnd());
        assertEquals("12-23", range.toString());
        assertEquals(12, range.size());
        assertFalse(range.isEmpty());
    }

    @Test
    public void testEqualsHashCode() {
        final StateRange range1 = new Range(3);
        final StateRange range2 = new Range(3, 3);
        final StateRange range3 = new Range(1, 3);
        final StateRange range4 = new Range(1, 3);
        final StateRange range5 = new Range(3, 5);

        // Identical
        assertTrue(range1.equals(range1));
        assertTrue(range2.equals(range2));
        assertTrue(range3.equals(range3));
        assertTrue(range5.equals(range5));

        // Equal
        assertTrue(range1.equals(range2));
        assertTrue(range2.equals(range1));

        assertTrue(range3.equals(range4));
        assertTrue(range4.equals(range3));

        // Not equal
        assertFalse(range1.equals(range3));
        assertFalse(range1.equals(range4));
        assertFalse(range1.equals(range5));

        assertFalse(range2.equals(range3));
        assertFalse(range2.equals(range4));
        assertFalse(range2.equals(range5));

        assertFalse(range3.equals(range1));
        assertFalse(range3.equals(range2));
        assertFalse(range3.equals(range5));

        assertFalse(range5.equals(range1));
        assertFalse(range5.equals(range2));
        assertFalse(range5.equals(range3));

        // Not a Range
        assertFalse(range1.equals("3"));
        assertFalse(range1.equals(null));

        // Hashcode
        assertEquals(range1.hashCode(), range2.hashCode());
        assertEquals(range3.hashCode(), range4.hashCode());
    }
}
