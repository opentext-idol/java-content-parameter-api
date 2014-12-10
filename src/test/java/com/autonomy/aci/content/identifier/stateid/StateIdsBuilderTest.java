/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.aci.content.identifier.stateid;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * StateIdsBuilderTest
 */
public class StateIdsBuilderTest {
    @Test
    public void testEmptyConstructor() {
        final StateIds stateIds = new StateIdsBuilder();

        assertFalse("".equals(stateIds.toString()));
        assertEquals(0, stateIds.size());
        assertTrue(stateIds.isEmpty());
        assertFalse(stateIds.iterator().hasNext());
    }

    @Test
    public void testStringIntConstructor() {
        final StateIds stateIds = new StateIdsBuilder("ABC-12", 7);

        assertEquals("ABC-12[7]", stateIds.toString());
    }

    @Test
    public void testStringIntIntConstructor() {
        final StateIds stateIds = new StateIdsBuilder("ABC-12", 7, 9);

        assertEquals("ABC-12[7-9]", stateIds.toString());
    }

    @Test
    public void testStringRangeConstructor() {
        final StateIds stateIds = new StateIdsBuilder("ABC-12", Range.first(4));

        assertEquals("ABC-12[0-3]", stateIds.toString());
    }

    @Test
    public void testStringVarArgsConstructor() {
        final StateIds stateIds = new StateIdsBuilder("ABC-12", "DEF-4", "GHI-78");

        assertEquals("ABC-12,DEF-4,GHI-78", stateIds.toString());
    }

    @Test
    public void testIterableConstructor() {
        final StateIds stateIds = new StateIdsBuilder(Arrays.asList("ABC", new StateId("DEF")), Arrays.asList("GHI", new StateId("JKL", 4)));

        assertEquals("ABC,DEF,GHI,JKL[4]", stateIds.toString());
        assertEquals(4, stateIds.size());
    }

    @Test
    public void testFromStateId() {
        final StateIdsBuilder builder = StateIdsBuilder.from(new StateId("ABC-12"));

        assertEquals("ABC-12", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test
    public void testFromStateIdsBuilder() {
        final StateIdsBuilder original = new StateIdsBuilder(new StateId("ABC-12"));
        final StateIdsBuilder builder = StateIdsBuilder.from(original);

        assertSame(original, builder);
        assertEquals("ABC-12", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromNullException() {
        StateIdsBuilder.from(null);
    }
}
