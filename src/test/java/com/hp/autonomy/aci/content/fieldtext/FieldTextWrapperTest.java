/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.hp.autonomy.aci.content.fieldtext;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * FieldTextWrapperTest
 */
public class FieldTextWrapperTest {
    @Test
    public void testCopyConstructor() {
        final FieldTextWrapper wrapper = new FieldTextWrapper(new EQUAL("field", 7));

        assertEquals(1, wrapper.size());
        assertEquals("EQUAL{7}:field", wrapper.toString());
    }

    @Test
    public void testObjectConstructor() {
        final FieldTextWrapper wrapper = new FieldTextWrapper((Object)new EQUAL("field", 7));

        assertEquals(2, wrapper.size());
        assertEquals("EQUAL{7}:field", wrapper.toString());
    }

    @Test
    public void testStringWrapping() {
        final FieldTextWrapper wrapper = new FieldTextWrapper(" EQUAL{7}:field+AND+MATCH{A}:UUID ");

        assertEquals(2, wrapper.size());
        assertEquals("EQUAL{7}:field+AND+MATCH{A}:UUID", wrapper.toString());
    }

    @Test
    public void testBlankStringWrapping() {
        final FieldTextWrapper wrapper = new FieldTextWrapper("  ");

        assertEquals("", wrapper.toString());
        assertEquals(0, wrapper.size());
        assertTrue(wrapper.isEmpty());

        // Now test the use cases that make treating blank strings differently necessary
        final FieldText emptyAndEmpty = wrapper.AND(wrapper);

        assertEquals(0, emptyAndEmpty.size());
        assertEquals("", emptyAndEmpty.toString());

        final FieldText emptyAndEqual = wrapper.AND(new EQUAL("FIELD", 8));

        assertEquals(1, emptyAndEqual.size());
        assertEquals("EQUAL{8}:FIELD", emptyAndEqual.toString());

        final FieldText matchAndEmpty = new MATCH("FIELD", "Value").AND(wrapper);

        assertEquals(1, matchAndEmpty.size());
        assertEquals("MATCH{Value}:FIELD", matchAndEmpty.toString());
    }
            
    @Test(expected = IllegalArgumentException.class)
    public void testNullFieldTextException() {
        new FieldTextWrapper(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullObjectException() {
        new FieldTextWrapper((Object)null);
    }

    @Test(expected = RuntimeException.class)
    public void testNullToStringConstruction() {
        new FieldTextWrapper(new Object() {
            @Override
            public String toString() {
                return null;
            }
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullToStringCopyConstruction() {
        new FieldTextWrapper(new AbstractFieldText() {
            @Override
            public int size() {
                return 2;
            }

            @Override
            public String toString() {
                return null;
            }
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSizeCopyConstruction() {
        new FieldTextWrapper(new AbstractFieldText() {
            @Override
            public int size() {
                return -1;
            }

            @Override
            public String toString() {
                return "EQUAL{7}:field";
            }
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSizeConstruction() {
        new FieldTextWrapper("EQUAL{7}:field", -1);
    }
}
