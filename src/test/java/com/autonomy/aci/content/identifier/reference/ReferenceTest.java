/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.content.identifier.reference;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ReferenceTest
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class ReferenceTest {

    @Test
    public void testStringConstructor() {
        final Reference reference = new Reference("http://ref.com/?p=1&q=2");
        
        assertEquals("http://ref.com/?p=1&q=2", reference.getReference());
        assertEquals("http%3A%2F%2Fref.com%2F%3Fp%3D1%26q%3D2", reference.toString());
        assertEquals(1, reference.size());
        assertFalse(reference.isEmpty());
        assertFalse(reference.hasSection());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructorNullException() {
        new Reference(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringConstructorBlankException() {
        new Reference(" ");
    }

    @Test(expected = IllegalStateException.class)
    public void testGetSectionException() {
        new Reference("abc").getSection();
    }
    
    @Test
    public void testStringIntConstructor() {
        final Reference reference = new Reference("http://ref.com/?p=1&q=2", 1);

        assertEquals("http://ref.com/?p=1&q=2", reference.getReference());
        assertEquals(1, reference.getSection());
        assertEquals("http%3A%2F%2Fref.com%2F%3Fp%3D1%26q%3D2$1", reference.toString());
        assertEquals("http%3A%2F%2Fref.com%2F%3Fp%3D1%26q%3D2", reference.toIndexingString());
        assertFalse(reference.isEmpty());
        assertTrue(reference.hasSection());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringIntConstructorNullException() {
        new Reference(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringIntConstructorBlankException() {
        new Reference(" ", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringIntConstructorNegativeNumberException() {
        new Reference("ref", -1);
    }

    @Test
    public void testAppend() {
        final Reference reference = new Reference("ref1");
        
        References references = reference.append("ref2");
        assertEquals("ref1+ref2", references.toString());
        assertEquals("ref1+ref2", references.toIndexingString());
        
        references = reference.append(Arrays.asList("ref3", new Reference("ref4", 0)));
        assertEquals("ref1+ref3+ref4$0", references.toString());
        assertEquals("ref1+ref3+ref4", references.toIndexingString());

        references = reference.append("ref7", "ref8");
        assertEquals("ref1+ref7+ref8", references.toString());
        assertEquals("ref1+ref7+ref8", references.toIndexingString());
    }
    
    @Test
    public void testEquals() {
        final Reference ref1 = new Reference("ref");
        final Reference ref2 = new Reference("ref");
        final Reference ref3 = new Reference("refer");
        final Reference ref4 = new Reference("ref", 0);
        final Reference ref5 = new Reference("ref", 0);
        final Reference ref6 = new Reference("ref", 1);
        final Reference ref7 = new Reference("refer", 0);
        
        assertTrue(ref1.equals(ref1));
        assertTrue(ref1.equals(ref2));
        assertTrue(ref4.equals(ref5));
        
        assertFalse(ref4.equals(ref6));
        assertFalse(ref2.equals(ref3));
        assertFalse(ref4.equals(ref7));
        assertFalse(ref1.equals("ref"));
        assertFalse(ref1.equals(null));
    }
}
