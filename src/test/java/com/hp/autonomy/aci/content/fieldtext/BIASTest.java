/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the <TT>BIAS</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class BIASTest {

    @Test
    public void testStringNumberNumberNumber() {
        final BIAS bias = new BIAS("autn_date", 12.0f, (byte)1, 10.3);

        assertEquals("toString", "BIAS{12,1,10.3}:autn_date", bias.toString());
        assertEquals("getOptimum", 12.0, bias.getOptimum(), 0);
        assertEquals("getRange", 1.0, bias.getRange(), 0);
        assertEquals("getBias", 10.3, bias.getBias(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringNumberNumberNumberNullStringException() {
        new BIAS((String)null, 12.0f, (byte)1, 10.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringNumberNumberNumberNullOptimumException() {
        new BIAS("field1", null, (byte)1, 10.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringNumberNumberNumberNullRangeException() {
        new BIAS("field1", 12.0f, null, 10.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringNumberNumberNumberNullBiasException() {
        new BIAS("field1", 12.0f, (byte)1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringNumberNumberNumberNegativeRangeException() {
        new BIAS("field1", 12.0f, -1, 10.3);
    }
    
    @Test
    public void testArrayNumberNumberNumber() {
        final BIAS bias = new BIAS(new String[]{"ns:field", "FIELD1"}, new Integer(12), new BigDecimal("1"), new Float(10.3));

        assertEquals("toString", "BIAS{12,1,10.3}:ns%3Afield:FIELD1", bias.toString());
        assertEquals("getOptimum", 12.0, bias.getOptimum(), 0);
        assertEquals("getRange", 1.0, bias.getRange(), 0);
        assertEquals("getBias", 10.3, bias.getBias(), 0);
    }

    @Test(expected = RuntimeException.class)
    public void testArrayNumberNumberNumberNullArrayException() {
        new BIAS((String[])null, new Integer(12), new BigDecimal("1"), new Float(10.3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayNumberNumberNumberNullOptimumException() {
        new BIAS(new String[]{"ns:field", "FIELD1"}, null, new BigDecimal("1"), new Float(10.3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayNumberNumberNumberNullRangeException() {
        new BIAS(new String[]{"ns:field", "FIELD1"}, new Integer(12), null, new Float(10.3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayNumberNumberNumberNullBiasException() {
        new BIAS(new String[]{"ns:field", "FIELD1"}, new Integer(12), new BigDecimal("1"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayNumberNumberNumberNegativeRangeException() {
        new BIAS(new String[]{"ns:field", "FIELD1"}, new Integer(12), new BigDecimal("-1"), new Float(10.3));
    }
    
    @Test
    public void testIterableNumberNumberNumber() {
        final BIAS bias = new BIAS(Arrays.asList("ns:field", "FIELD1"), new Long(12), 1.0, new Double(10.3));

        assertEquals("toString", "BIAS{12,1,10.3}:ns%3Afield:FIELD1", bias.toString());
        assertEquals("getOptimum", 12.0, bias.getOptimum(), 0);
        assertEquals("getRange", 1.0, bias.getRange(), 0);
        assertEquals("getBias", 10.3, bias.getBias(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableNumberNumberNumberNullIterableException() {
        new BIAS((Iterable<String>)null, new Long(12), 1.0, new Double(10.3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableNumberNumberNumberNullOptimumException() {
        new BIAS(Arrays.asList("ns:field", "FIELD1"), null, 1.0, new Double(10.3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableNumberNumberNumberNullRangeException() {
        new BIAS(Arrays.asList("ns:field", "FIELD1"), new Long(12), null, new Double(10.3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableNumberNumberNumberNullBiasException() {
        new BIAS(Arrays.asList("ns:field", "FIELD1"), new Long(12), 1.0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableNumberNumberNumberNegativeRangeException() {
        new BIAS(Arrays.asList("ns:field", "FIELD1"), new Long(12), -1.0, new Double(10.3));
    }
    
    @Test
    public void testBigDate() {
        final BIAS bias = new BIAS("autn_date", 1103918400, 259200, 25);

        assertEquals("toString", "BIAS{1103918400,259200,25}:autn_date", bias.toString());
        assertEquals("getOptimum", 1103918400.0, bias.getOptimum(), 0);
        assertEquals("getRange", 259200.0, bias.getRange(), 0);
        assertEquals("getBias", 25.0, bias.getBias(), 0);
    }
    
    @Test
    public void testFactoryMethods() {
        Assert.assertEquals("BIAS{1,2,3}:field", BIAS.BIAS("field", 1, 2, 3).toString());
        Assert.assertEquals("BIAS{1,2,3}:field:title", BIAS.BIAS(new String[]{"field", "title"}, 1, 2, 3).toString());
        Assert.assertEquals("BIAS{1,2,3}:field:title", BIAS.BIAS(Arrays.asList("field", "title"), 1, 2, 3).toString());
    }
}
