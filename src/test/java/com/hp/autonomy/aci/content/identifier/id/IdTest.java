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
package com.hp.autonomy.aci.content.identifier.id;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IdTest
 */
public class IdTest {
    final Id id1 = new Id(1);
    final Id id2 = new Id(2);
    final Id id4 = new Id(4);

    final Id id2b = new Id(2);

    @Test
    public void testIdConstructor() {
        final Id id = new Id(1);

        assertEquals("1", id.toString());
        assertEquals(1, id.getId());
        assertEquals(1, id.size());
        assertFalse(id.isEmpty());

        final Iterator<Id> it = id.iterator();

        assertTrue(it.hasNext());

        final Id itId = it.next();

        assertSame(id, itId);

        assertFalse(it.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException() {
        new Id(0);
    }

    @Test
    public void testCompare() {
        assertEquals(0, id1.compareTo(id1));
        assertEquals(0, id2.compareTo(id2));
        assertEquals(0, id4.compareTo(id4));

        assertEquals(0, id2.compareTo(id2b));
        assertEquals(0, id2b.compareTo(id2));

        assertEquals(-1, id1.compareTo(id2));
        assertEquals(1, id2.compareTo(id1));

        assertEquals(-1, id1.compareTo(id4));
        assertEquals(1, id4.compareTo(id1));

        assertEquals(-1, id2.compareTo(id4));
        assertEquals(1, id4.compareTo(id2));
    }

    @Test
    public void testEquals() {
        assertTrue(id1.equals(id1));
        assertTrue(id2.equals(id2));
        assertTrue(id4.equals(id4));

        assertTrue(id2.equals(id2b));
        assertTrue(id2b.equals(id2));

        assertFalse(id1.equals(id2));
        assertFalse(id2.equals(id1));

        assertFalse(id1.equals(id4));
        assertFalse(id4.equals(id1));

        assertFalse(id2.equals(id4));
        assertFalse(id4.equals(id2));

        assertFalse(id1.equals(null));

        assertFalse(id1.equals("1"));
    }
    
    @Test
    public void testHashCode() {
        assertEquals(id1.hashCode(), id1.hashCode());

        assertEquals(id2.hashCode(), id2b.hashCode());

        assertFalse(id1.hashCode() == id2.hashCode());
    }

    @Test
    public void testAppendIntVarArgs() {
        final Ids ids1 = new Id(3).append(2, 4);

        assertEquals("2+3+4", ids1.toString());
        assertEquals(3, ids1.size());
        assertFalse(ids1.isEmpty());

        final Ids ids2 = new Id(3).append(3, 2, 4, 2, 4, 2, 4, 3);

        assertEquals("2+3+4", ids2.toString());
        assertEquals(3, ids2.size());
        assertFalse(ids2.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIntVarArgsException1() {
        new Id(3).append(2, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testAppendIntVarArgsException2() {
        new Id(3).append((int[])null);
    }

    @Test
    public void testAppendIterable() {
        final Ids ids1 = new Id(3).append(id1, Arrays.asList(id4, 6));

        assertEquals("1+3+4+6", ids1.toString());
        assertEquals(4, ids1.size());
        assertFalse(ids1.isEmpty());

        final Ids ids2 = new Id(3).append(id1, Arrays.asList(6, id4, 6), id1, id4, id1);

        assertEquals("1+3+4+6", ids2.toString());
        assertEquals(4, ids2.size());
        assertFalse(ids2.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableException1() {
        new Id(3).append(Arrays.asList(id1, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableException2() {
        new Id(3).append((Iterable<?>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableException3() {
        new Id(3).append(Arrays.asList(id1, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableException4() {
        new Id(3).append(Arrays.asList(id1, "3"));
    }
}
