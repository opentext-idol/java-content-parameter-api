/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.hp.autonomy.aci.content.identifier.stateid;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * StateIdTest
 */
public class StateIdTest {
    @Test
    public void testStringConstructor() {
        final StateId stateId = new StateId("ABC-12");

        assertEquals("ABC-12", stateId.toString());
        assertEquals(1, stateId.size());
        assertFalse(stateId.isEmpty());
        assertEquals("ABC-12", stateId.getStateToken());

        final StateRange range = stateId.getRange();

        assertEquals("", range.toString());
        assertEquals(0, range.size());
        assertTrue(range.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructorBlankException() {
        new StateId("   ");
    }

    @Test
    public void testStringIntConstructor() {
        final StateId stateId = new StateId("ABC-12", 7);

        assertEquals("ABC-12[7]", stateId.toString());
        assertEquals(1, stateId.size());
        assertFalse(stateId.isEmpty());
        assertEquals("ABC-12", stateId.getStateToken());

        final StateRange range = stateId.getRange();

        assertEquals("7", range.toString());
        assertEquals(1, range.size());
        assertFalse(range.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringIntConstructorNegativeNumberException() {
        new StateId("ABC-12", -1);
    }

    @Test
    public void testStringIntIntConstructor() {
        final StateId stateId = new StateId("ABC-12", 7, 19);

        assertEquals("ABC-12[7-19]", stateId.toString());
        assertEquals(1, stateId.size());
        assertFalse(stateId.isEmpty());
        assertEquals("ABC-12", stateId.getStateToken());

        final StateRange range = stateId.getRange();

        assertEquals("7-19", range.toString());
        assertEquals(13, range.size());
        assertFalse(range.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringIntIntConstructorOrderException() {
        new StateId("ABC-12", 7, 6);
    }

    @Test
    public void testStringRangeConstructor() {
        final StateId stateId = new StateId("ABC-12", new Range(0, 3));

        assertEquals("ABC-12[0-3]", stateId.toString());
        assertEquals(1, stateId.size());
        assertFalse(stateId.isEmpty());
        assertEquals("ABC-12", stateId.getStateToken());

        final StateRange range = stateId.getRange();

        assertEquals("0-3", range.toString());
        assertEquals(4, range.size());
        assertFalse(range.isEmpty());
    }

    @Test
    public void testStringRangeConstructorEmptyRange() {
        final StateId stateId = new StateId("ABC-12", new AbstractStateRange() {
            @Override
            public String toString() {
                return "";
            }

            @Override
            public int size() {
                return 0;
            }
        });

        assertEquals("ABC-12", stateId.toString());
        assertEquals(1, stateId.size());
        assertFalse(stateId.isEmpty());
        assertEquals("ABC-12", stateId.getStateToken());

        final StateRange range = stateId.getRange();

        assertEquals("", range.toString());
        assertEquals(0, range.size());
        assertTrue(range.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringRangeConstructorNullException() {
        new StateId("ABC-12", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringRangeConstructorInvalidRangeException1() {
        // This implementation of StateRange violates the contract of size()
        new StateId("ABC-12", new AbstractStateRange() {
            @Override
            public String toString() {
                return "1-2";
            }

            @Override
            public int size() {
                return 0;
            }
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringRangeConstructorInvalidRangeException2() {
        // This implementation of StateRange violates the contract of size()
        new StateId("ABC-12", new AbstractStateRange() {
            @Override
            public String toString() {
                return " ";
            }

            @Override
            public int size() {
                return 1;
            }
        });
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testStringRangeConstructorInvalidRangeException3() {
        // This implementation of StateRange violates the contract of toString()
        new StateId("ABC-12", new AbstractStateRange() {
            @Override
            public String toString() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        });
    }

    @Test
    public void testPagesNormal() {
        final List<StateId> pages = new StateId("TOKEN-1234").pages(100, 234);

        assertEquals(3, pages.size());
        assertEquals("TOKEN-1234[0-99]", pages.get(0).toString());
        assertEquals("TOKEN-1234[100-199]", pages.get(1).toString());
        assertEquals("TOKEN-1234[200-233]", pages.get(2).toString());
    }

    @Test
    public void testPagesBelowBorderline() {
        final List<StateId> pages = new StateId("TOKEN-1234").pages(100, 300);

        assertEquals(3, pages.size());
        assertEquals("TOKEN-1234[0-99]", pages.get(0).toString());
        assertEquals("TOKEN-1234[100-199]", pages.get(1).toString());
        assertEquals("TOKEN-1234[200-299]", pages.get(2).toString());
    }

    @Test
    public void testPagesAboveBorderline() {
        final List<StateId> pages = new StateId("TOKEN-1234").pages(100, 201);

        assertEquals(3, pages.size());
        assertEquals("TOKEN-1234[0-99]", pages.get(0).toString());
        assertEquals("TOKEN-1234[100-199]", pages.get(1).toString());
        assertEquals("TOKEN-1234[200]", pages.get(2).toString());
    }

    @Test
    public void testPagesSinglePage() {
        final List<StateId> pages = new StateId("TOKEN-1234").pages(100, 32);

        assertEquals(1, pages.size());
        assertEquals("TOKEN-1234[0-31]", pages.get(0).toString());
    }

    @Test
    public void testPagesSmallestCase() {
        final List<StateId> pages = new StateId("TOKEN-1234").pages(1, 1);

        assertEquals(1, pages.size());
        assertEquals("TOKEN-1234[0]", pages.get(0).toString());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPagesZeroPageSizeException() {
        new StateId("TOKEN-1234").pages(0, 32);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPagesZeroTotalResultsException() {
        new StateId("TOKEN-1234").pages(100, 0);
    }

    @Test
    public void testWithoutRange() {
        final StateId stateId = new StateId("ABC-12", 7, 9).withoutRange();

        assertEquals("ABC-12", stateId.toString());
        assertEquals(1, stateId.size());
        assertFalse(stateId.isEmpty());

        final StateRange range = stateId.getRange();

        assertEquals("", range.toString());
        assertEquals(0, range.size());
        assertTrue(range.isEmpty());
    }

    @Test
    public void testForDocument() {
        final StateId stateId = new StateId("ABC-12", 7, 9).forDocument(0);

        assertEquals("ABC-12[0]", stateId.toString());
        assertEquals(1, stateId.size());
        assertFalse(stateId.isEmpty());

        final StateRange range = stateId.getRange();

        assertEquals("0", range.toString());
        assertEquals(1, range.size());
        assertFalse(range.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForDocumentNegativeNumberException() {
        new StateId("ABC-12", 7, 9).forDocument(-1);
    }

    @Test
    public void testIterator() {
        final StateId stateId = new StateId("ABC-12");

        final Iterator<StateId> iterator = stateId.iterator();

        assertTrue(iterator.hasNext());
        assertSame(stateId, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorCantRemove() {
        final Iterator<StateId> iterator = new StateId("ABC-12").iterator();
        iterator.next();
        iterator.remove();
    }

    @Test
    public void testEqualsHashCode() {
        final StateIds stateId1 = new StateId("ABC-12");
        final StateIds stateId2 = new StateId("ABC-12");
        final StateIds stateId3 = new StateId("ABC-12", 7);
        final StateIds stateId4 = new StateId("ABC-12", 7, 7);

        final StateIds stateIdsBuilder1 = new StateIdsBuilder("ABC-12");
        final StateIds stateIdsBuilder2 = new StateIdsBuilder("ABC-12", 7);

        // Identical
        assertTrue(stateId1.equals(stateId1));
        assertTrue(stateId3.equals(stateId3));
        assertTrue(stateId4.equals(stateId4));

        // Equal
        assertTrue(stateId1.equals(stateId2));
        assertTrue(stateId2.equals(stateId1));

        // Equal with range
        assertTrue(stateId3.equals(stateId4));
        assertTrue(stateId4.equals(stateId3));

        // Not equal
        assertFalse(stateId1.equals(stateId3));
        assertFalse(stateId1.equals(stateId4));
        assertFalse(stateId3.equals(stateId1));
        assertFalse(stateId4.equals(stateId1));

        // Not a StateId but still an equal StateIds
        assertTrue(stateId1.equals(stateIdsBuilder1));
        assertTrue(stateId3.equals(stateIdsBuilder2));

        // Not a StateIds
        assertFalse(stateId1.equals("ABC-12"));
        assertFalse(stateId1.equals(null));

        // Hashcode
        assertEquals(stateId1.hashCode(), stateId2.hashCode());
        assertEquals(stateId3.hashCode(), stateId4.hashCode());
        assertEquals(stateId1.hashCode(), stateIdsBuilder1.hashCode());
        assertEquals(stateId3.hashCode(), stateIdsBuilder2.hashCode());
    }

    @Test
    public void testAppendStringVarArgs() {
        final StateIds stateIds = new StateId("XYZ-12", 7).append("ABC-34", "DEF-56");

        assertEquals("XYZ-12[7],ABC-34,DEF-56", stateIds.toString());
        assertEquals(3, stateIds.size());
    }

    @Test(expected = RuntimeException.class)
    public void testAppendStringVarArgsNullArrayException() {
        new StateId("XYZ-12").append((String[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendStringVarArgsBlankStringException() {
        new StateId("XYZ-12").append("  ");
    }
    
    @Test
    public void testAppendStringInt() {
        final StateIds stateIds = new StateId("XYZ-12").append("ABC-34", 0);

        assertEquals("XYZ-12,ABC-34[0]", stateIds.toString());
        assertEquals(2, stateIds.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendStringIntBlankStringException() {
        new StateId("XYZ-12").append(" ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendStringIntNegativeNumberException() {
        new StateId("XYZ-12").append(" ", -1);
    }

    @Test
    public void testAppendStringIntInt() {
        final StateIds stateIds = new StateId("XYZ-12", 4).append("ABC-34", 0, 2);

        assertEquals("XYZ-12[4],ABC-34[0-2]", stateIds.toString());
        assertEquals(2, stateIds.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendStringIntIntBlankStringException() {
        new StateId("XYZ-12").append(" ", 1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendStringIntIntNegativeNumberException() {
        new StateId("XYZ-12").append("ABC-34", -1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendStringIntIntOrderingException() {
        new StateId("XYZ-12").append("ABC-34", 4, 3);
    }

    @Test
    public void testAppendStringRange() {
        final StateIds stateIds = new StateId("XYZ-12", 5).append("ABC-34", Range.first(17));

        assertEquals("XYZ-12[5],ABC-34[0-16]", stateIds.toString());
        assertEquals(2, stateIds.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendStringRangeBlankStringException() {
        new StateId("XYZ-12", 5).append(" ", Range.first(17));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendStringRangeNullRangeException() {
        new StateId("XYZ-12", 5).append("ABC-34", null);
    }

    @Test
    public void testAppendIterable() {
        final StateIds stateIds = new StateId("XYZ-12", 5).append(Arrays.asList("ABC", "DEF", new StateId("GHI", 1, 4)));

        assertEquals("XYZ-12[5],ABC,DEF,GHI[1-4]", stateIds.toString());
        assertEquals(4, stateIds.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableNullIterable() {
        new StateId("XYZ-12", 5).append((Iterable<?>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableNullEntry() {
        new StateId("XYZ-12", 5).append(Arrays.asList("ABC-5", null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendIterableUnknownEntry() {
        new StateId("XYZ-12", 5).append(Arrays.asList(1));
    }

    @Test
    public void testAppendStateIds() {
        // This is actually using Iterable<?>... but is worthy of a test because it is a common use case
        final StateIds stateIds = new StateId("ABC").append(new StateId("DEF").append("GHI", 7), new StateId("JKL", 4));

        assertEquals("ABC,DEF,GHI[7],JKL[4]", stateIds.toString());
        assertEquals(4, stateIds.size());
    }
}
