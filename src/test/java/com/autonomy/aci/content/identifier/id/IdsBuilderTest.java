/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.autonomy.aci.content.identifier.id;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IdsBuilderTest
 */
public class IdsBuilderTest {
    final Id id1 = new Id(1);
    final Id id2 = new Id(2);
    final Id id4 = new Id(4);

    final Id id2b = new Id(2);

    @Test
    public void testEmptyConstructor() {
        final IdsBuilder builder = new IdsBuilder();

        assertEquals("0", builder.toString());
        assertEquals(0, builder.size());
        assertTrue(builder.isEmpty());
        assertFalse(builder.iterator().hasNext());
    }

    @Test
    public void testIntVarArgsConstructor() {
        final IdsBuilder builder = new IdsBuilder(7, 2, 4);

        assertEquals("2+4+7", builder.toString());
        assertEquals(3, builder.size());
        assertFalse(builder.isEmpty());

        final Iterator<Id> it = builder.iterator();

        assertTrue(it.hasNext());
        assertEquals(2, it.next().getId());
        assertEquals(4, it.next().getId());
        assertEquals(7, it.next().getId());
        assertFalse(it.hasNext());
    }

    @Test
    public void testIterableConstructor() {
        final IdsBuilder builder = new IdsBuilder(Arrays.asList(id4, 8, id2));

        assertEquals("2+4+8", builder.toString());
        assertEquals(3, builder.size());
        assertFalse(builder.isEmpty());

        final Iterator<Id> it = builder.iterator();

        assertTrue(it.hasNext());
        assertEquals(id2, it.next());
        assertEquals(id4, it.next());
        assertEquals(8, it.next().getId());
        assertFalse(it.hasNext());
    }
    
    @Test
    public void testIdsConstructor() {
        // This is actually using Iterable<?>... but is worthy of a test because it is a common use case
        final IdsBuilder builder = new IdsBuilder(new Id(7), new Id(3).append(8), new Id(4));

        assertEquals("3+4+7+8", builder.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testIntVarArgsConstructorException1() {
        new IdsBuilder((int[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntVarArgsConstructorException2() {
        new IdsBuilder(1, 2, 0, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableConstructorException1() {
        new IdsBuilder((Iterable<?>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableConstructorException2() {
        new IdsBuilder(Arrays.asList(id1, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableConstructorException3() {
        new IdsBuilder(Arrays.asList(id1, "4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableConstructorException4() {
        new IdsBuilder(Arrays.asList(id1, 0));
    }

    @Test
    public void testAppendIntVarArgs() {
        final IdsBuilder builder = new IdsBuilder();

        builder.append(9, 6, 5);

        assertEquals("5+6+9", builder.toString());
        assertEquals(3, builder.size());
        assertFalse(builder.isEmpty());

        builder.append(7);

        assertEquals("5+6+7+9", builder.toString());
        assertEquals(4, builder.size());

        builder.append(7);

        assertEquals("5+6+7+9", builder.toString());
        assertEquals(4, builder.size());

        builder.append(6, 7, 8, 6, 7, 8);

        assertEquals("5+6+7+8+9", builder.toString());
        assertEquals(5, builder.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIntVarArgsException1() {
        new IdsBuilder().append(1, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testAppendIntVarArgsException2() {
        new IdsBuilder().append((int[])null);
    }
    
    @Test
    public void testAppendIterable() {
        final IdsBuilder builder = new IdsBuilder();

        builder.append(id4);

        assertEquals("4", builder.toString());
        assertEquals(1, builder.size());
        assertFalse(builder.isEmpty());

        builder.append(Arrays.asList(id2, 7));

        assertEquals("2+4+7", builder.toString());
        assertEquals(3, builder.size());
        assertFalse(builder.isEmpty());

        builder.append(id2b);

        assertEquals("2+4+7", builder.toString());
        assertEquals(3, builder.size());
        assertFalse(builder.isEmpty());

        builder.append(id1, Arrays.asList(id4, 5, 5));

        assertEquals("1+2+4+5+7", builder.toString());
        assertEquals(5, builder.size());
        assertFalse(builder.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableException1() {
        new IdsBuilder().append((Iterable<?>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableException2() {
        new IdsBuilder().append(Arrays.asList(id1, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableException3() {
        new IdsBuilder().append(Arrays.asList(id1, "2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableException4() {
        new IdsBuilder().append(Arrays.asList(id1, 0));
    }
    
    @Test
    public void testSelfAppend() {
        final IdsBuilder builder = new IdsBuilder(1, 2, 3);

        builder.append(builder);

        assertEquals("1+2+3", builder.toString());
        assertEquals(3, builder.size());
    }

    @Test
    public void testFromId() {
        final IdsBuilder builder = IdsBuilder.from(new Id(4));

        assertEquals("4", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test
    public void testFromIdsBuilder() {
        final IdsBuilder original = new IdsBuilder(new Id(4));
        final IdsBuilder builder = IdsBuilder.from(original);

        assertSame(original, builder);
        assertEquals("4", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromNullException() {
        IdsBuilder.from(null);
    }
}
