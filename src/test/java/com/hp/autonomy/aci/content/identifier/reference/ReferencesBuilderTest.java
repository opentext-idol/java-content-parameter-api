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
package com.hp.autonomy.aci.content.identifier.reference;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ReferenceBuilderTest
 */
public class ReferencesBuilderTest {
    @Test
    public void testEmptyConstructor() {
        final References builder = new ReferencesBuilder();

        assertFalse(builder.toString().isEmpty());
        assertFalse(builder.toIndexingString().isEmpty());
        assertTrue(builder.isEmpty());
        assertEquals(0, builder.size());
    }
    
    @Test
    public void testStringIntConstructor() {
        final References builder = new ReferencesBuilder("ref", 2);

        assertEquals("ref$2", builder.toString());
        Assert.assertEquals("ref", builder.toIndexingString());
        assertFalse(builder.isEmpty());
        assertEquals(1, builder.size());

        final Reference reference = builder.iterator().next();

        assertEquals("ref", reference.getReference());
        assertEquals(2, reference.getSection());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringIntConstructorNullStringException() {
        new ReferencesBuilder(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringIntConstructorBlankStringException() {
        new ReferencesBuilder(" ", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringIntConstructorNegativeIntException() {
        new ReferencesBuilder("ref", -1);
    }
    
    @Test
    public void testStringVarargsConstructor() {
        final References builder = new ReferencesBuilder("ref1", "ref1", "ref2", "ref3");

        assertEquals("ref1+ref2+ref3", builder.toString());
        Assert.assertEquals("ref1+ref2+ref3", builder.toIndexingString());
        assertFalse(builder.isEmpty());
        assertEquals(3, builder.size());

        final Iterator<Reference> iterator = builder.iterator();

        assertEquals("ref1", iterator.next().toString());
        assertEquals("ref2", iterator.next().toString());
        assertEquals("ref3", iterator.next().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringVarargsConstructorNullStringException() {
        new ReferencesBuilder("ref1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringVarargsConstructorBlankStringException() {
        new ReferencesBuilder("ref1", " ");
    }

    @Test(expected = RuntimeException.class)
    public void testStringVarargsConstructorNullArrayException() {
        new ReferencesBuilder((String[])null);
    }
    
    @Test
    public void testAppend() {
        final References builder = new ReferencesBuilder();
        builder.append("ref1", "ref2").append("ref3", 1).append(new Reference("ref4"), new Reference("ref5", 2));

        assertEquals("ref1+ref2+ref3$1+ref4+ref5$2", builder.toString());
        Assert.assertEquals("ref1+ref2+ref3+ref4+ref5", builder.toIndexingString());
        assertFalse(builder.isEmpty());
        assertEquals(5, builder.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendException1() {
        new ReferencesBuilder().append("ref1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendException2() {
        new ReferencesBuilder().append("ref1", " ");
    }

    @Test(expected = RuntimeException.class)
    public void testAppendException3() {
        new ReferencesBuilder().append((String[])null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendException4() {
        new ReferencesBuilder().append("ref1", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendException5() {
        new ReferencesBuilder().append(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendException6() {
        new ReferencesBuilder().append(" ", 0);
    }

    @Test
    public void testFromReference() {
        final ReferencesBuilder builder = ReferencesBuilder.from(new Reference("ref"));

        assertEquals("ref", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test
    public void testFromReferencesBuilder() {
        final ReferencesBuilder original = new ReferencesBuilder(new Reference("ref"));
        final ReferencesBuilder builder = ReferencesBuilder.from(original);

        assertSame(original, builder);
        assertEquals("ref", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromNullException() {
        ReferencesBuilder.from(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFromIntegerIteratorException() {
        ReferencesBuilder.from(Arrays.asList(1, 2, 3));
    }
}
