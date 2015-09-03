/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.hp.autonomy.aci.content.sort;

import java.util.Iterator;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SortBuilderTest
 */
public class SortBuilderTest {
    @Test
    public void testEmptySortBuilder() {
        final SortBuilder builder = new SortBuilder();

        assertEquals("", builder.toString());
        assertEquals(0, builder.size());
        assertTrue(builder.isEmpty());
        assertFalse(builder.iterator().hasNext());
    }

    @Test
    public void testSingleEntrySortBuilder() {
        final SortBuilder builder = new SortBuilder(SortBy.DATABASE);

        assertEquals("database", builder.toString());
        assertEquals(1, builder.size());
        assertFalse(builder.isEmpty());

        final Iterator<SortBy> iterator = builder.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(SortBy.DATABASE, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTwoEntriesSortBuilder() {
        final SortBuilder builder = new SortBuilder(SortBy.DATABASE, SortBy.DOC_ID_DECREASING);

        assertEquals("database+dociddecreasing", builder.toString());
        assertEquals(2, builder.size());
        assertFalse(builder.isEmpty());

        final Iterator<SortBy> iterator = builder.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(SortBy.DATABASE, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(SortBy.DOC_ID_DECREASING, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testMixedEntries() {
        final SortBuilder builder = new SortBuilder(
                SortBy.DATABASE,
                SortBy.DOC_ID_DECREASING,
                new SortBuilder(),
                new SortBuilder(
                        SortBy.DATABASE,
                        SortBy.AUTN_RANK,
                        new SortBuilder(
                                SortBy.DOC_ID_INCREASING, SortBy.DATABASE, SortBy.DATE
                        ),
                        SortBy.DATABASE
                )
        );

        assertEquals("database+dociddecreasing+autnrank+docidincreasing+date", builder.toString());
        assertEquals(5, builder.size());
        assertFalse(builder.isEmpty());

        final Iterator<SortBy> iterator = builder.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(SortBy.DATABASE, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(SortBy.DOC_ID_DECREASING, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(SortBy.AUTN_RANK, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(SortBy.DOC_ID_INCREASING, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(SortBy.DATE, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullIterableException() {
        new SortBuilder((Iterable<SortBy>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullArrayException() {
        new SortBuilder((Iterable<SortBy>[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullElementException() {
        new SortBuilder(SortBy.DATABASE, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullInIterableException() {
        new SortBuilder(Arrays.asList(SortBy.DATABASE, null));
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Test
    public void testEqualsHashCode() {
        final SortBuilder builder = new SortBuilder(SortBy.DATABASE);

        //noinspection EqualsWithItself
        assertTrue(builder.equals(builder));
        //noinspection EqualsBetweenInconvertibleTypes
        assertTrue(builder.equals(SortBy.DATABASE));
        //noinspection EqualsBetweenInconvertibleTypes
        assertFalse(builder.equals(SortBy.DATE));

        //noinspection EqualsBetweenInconvertibleTypes
        assertFalse(builder.equals("database"));
        //noinspection ObjectEqualsNull
        assertFalse(builder.equals(null));

        assertEquals(builder.hashCode(), SortBy.DATABASE.hashCode());

        builder.then(SortBy.DATE);

        //noinspection EqualsWithItself
        assertTrue(builder.equals(builder));
        assertTrue(builder.equals(new SortBuilder(builder)));
        //noinspection EqualsBetweenInconvertibleTypes
        assertFalse(builder.equals(SortBy.DATABASE));
        //noinspection EqualsBetweenInconvertibleTypes
        assertFalse(builder.equals(SortBy.DATE));

        assertEquals(builder.hashCode(), new SortBuilder(builder).hashCode());
    }


    @Test
    public void testFromSortBy() {
        final SortBuilder builder = SortBuilder.from(SortBy.CLUSTER);

        assertEquals("cluster", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test
    public void testFromBuilder() {
        final SortBuilder original = new SortBuilder(SortBy.REVERSE_DATE);
        final SortBuilder builder = SortBuilder.from(original);

        assertSame(original, builder);
        assertEquals("reversedate", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromNullException() {
        SortBuilder.from(null);
    }
}
