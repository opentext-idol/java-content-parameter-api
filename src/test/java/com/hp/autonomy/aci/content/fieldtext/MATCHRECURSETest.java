/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.hp.autonomy.aci.content.fieldtext.MATCHRECURSE.*;

/**
 * Tests for the <tt>MATCHRECURSE</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class MATCHRECURSETest {

    private final Iterable<String> fieldsIterable = Arrays.asList("FIELD1", "FIELD2", "ns:field");

    @Test
    public void testStringStringNumber() {
        MATCHRECURSE matchRecurse = new MATCHRECURSE("ns:field", "VALUE", (byte)11);
        assertEquals("String, String, byte constructor", "MATCHRECURSE{VALUE,11}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, byte - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String, String, byte - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, byte - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", (short)11);
        assertEquals("String, String, short constructor", "MATCHRECURSE{VALUE,11}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, short - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String, String, short - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, short - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", 11);
        assertEquals("String, String, int constructor", "MATCHRECURSE{VALUE,11}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, int - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String, String, int - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, int - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", 11L);
        assertEquals("String, String, long constructor", "MATCHRECURSE{VALUE,11}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, long - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String, String, long - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, long - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", 12.1f);
        assertEquals("String, String, float constructor", "MATCHRECURSE{VALUE,12}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, float - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String, String, float - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, float - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", 12.1);
        assertEquals("String, String, double constructor", "MATCHRECURSE{VALUE,12}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, double - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String, String, double - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, double - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());
        
        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", new Byte((byte)11));
        assertEquals("String, String, Byte constructor", "MATCHRECURSE{VALUE,11}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, Byte - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String, String, Byte - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, Byte - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", new Short((short)11));
        assertEquals("String, String, Short constructor", "MATCHRECURSE{VALUE,11}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, Short - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String, String, Short - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, Short - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", new Integer(11));
        assertEquals("String, String, Integer constructor", "MATCHRECURSE{VALUE,11}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, Integer - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String, String, Integer - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, Integer - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", new Long(11L));
        assertEquals("String, String, Long constructor", "MATCHRECURSE{VALUE,11}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, Long - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String, String, Long - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, Long - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", new Float(12.1f));
        assertEquals("String, String, Float constructor", "MATCHRECURSE{VALUE,12}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, Float - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String, String, Float - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, Float - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", new Double(12.1));
        assertEquals("String, String, Double constructor", "MATCHRECURSE{VALUE,12}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, Double - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String, String, Double - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, Double - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE("ns:field", "VALUE", new BigDecimal("12.1"));
        assertEquals("String, String, BigDecimal constructor", "MATCHRECURSE{VALUE,12}:ns%3Afield", matchRecurse.toString());
        assertEquals("String, String, BigDecimal - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String, String, BigDecimal - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String, String, BigDecimal - getFields", Collections.singletonList("ns:field"), matchRecurse.getFields());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringNumberNullFieldException() {
        new MATCHRECURSE((String)null, "VALUE", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringNumberNullValueException() {
        new MATCHRECURSE("ns:field", null, 11);
    }

    @Test(expected = RuntimeException.class)
    public void testStringStringNumberNullDepthException() {
        new MATCHRECURSE("ns:field", "VALUE", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringNumberNegativeDepthException() {
        new MATCHRECURSE("ns:field", "VALUE", -1);
    }
    
    @Test
    public void testArrayStringNumber() {
        MATCHRECURSE matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", (byte)11);
        assertEquals("String[], String, byte constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, byte - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String[], String, byte - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", (short)11);
        assertEquals("String[], String, short constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, short - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String[], String, short - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", 11);
        assertEquals("String[], String, int constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, int - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String[], String, int - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, int - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", 11L);
        assertEquals("String[], String, long constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, long - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String[], String, long - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", 12.1f);
        assertEquals("String[], String, float constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, float - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String[], String, float - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", 12.1);
        assertEquals("String[], String, double constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, double - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String[], String, double - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());
        
        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Byte((byte)11));
        assertEquals("String[], String, Byte constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, Byte - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String[], String, Byte - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, Byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Short((short)11));
        assertEquals("String[], String, Short constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, Short - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String[], String, Short - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, Short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Integer(11));
        assertEquals("String[], String, Integer constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, Integer - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String[], String, Integer - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, Integer - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Long(11L));
        assertEquals("String[], String, Long constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, Long - getDepth", 11, matchRecurse.getDepth());
        assertEquals("String[], String, Long - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, Long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Float(12.1f));
        assertEquals("String[], String, Float constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, Float - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String[], String, Float - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, Float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Double(12.1));
        assertEquals("String[], String, Double constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, Double - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String[], String, Double - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, Double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new BigDecimal("12.1"));
        assertEquals("String[], String, BigDecimal constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("String[], String, BigDecimal - getDepth", 12, matchRecurse.getDepth());
        assertEquals("String[], String, BigDecimal - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("String[], String, BigDecimal - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());
    }

    @Test(expected = RuntimeException.class)
    public void testArrayStringNumberNullFieldsException() {
        new MATCHRECURSE((String[])null, "VALUE", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayStringNumberNullValueException() {
        new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, null, 11);
    }

    @Test(expected = RuntimeException.class)
    public void testArrayStringNumberNullDepthException() {
        new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayStringNumberNegativeDepthException() {
        new MATCHRECURSE(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", -1);
    }

    @Test
    public void testIterableStringNumber() {
        MATCHRECURSE matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", (byte)11);
        assertEquals("Iterable<String>, String, byte constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, byte - getDepth", 11, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, byte - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", (short)11);
        assertEquals("Iterable<String>, String, short constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, short - getDepth", 11, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, short - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", 11);
        assertEquals("Iterable<String>, String, int constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, int - getDepth", 11, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, int - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, int - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", 11L);
        assertEquals("Iterable<String>, String, long constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, long - getDepth", 11, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, long - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", 12.1f);
        assertEquals("Iterable<String>, String, float constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, float - getDepth", 12, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, float - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", 12.1);
        assertEquals("Iterable<String>, String, double constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, double - getDepth", 12, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, double - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());
        
        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", new Byte((byte)11));
        assertEquals("Iterable<String>, String, Byte constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, Byte - getDepth", 11, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, Byte - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, Byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", new Short((short)11));
        assertEquals("Iterable<String>, String, Short constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, Short - getDepth", 11, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, Short - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, Short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", new Integer(11));
        assertEquals("Iterable<String>, String, Integer constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, Integer - getDepth", 11, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, Integer - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, Integer - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", new Long(11L));
        assertEquals("Iterable<String>, String, Long constructor", "MATCHRECURSE{VALUE,11}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, Long - getDepth", 11, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, Long - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, Long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", new Float(12.1f));
        assertEquals("Iterable<String>, String, Float constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, Float - getDepth", 12, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, Float - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, Float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", new Double(12.1));
        assertEquals("Iterable<String>, String, Double constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, Double - getDepth", 12, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, Double - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, Double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());

        matchRecurse = new MATCHRECURSE(fieldsIterable, "VALUE", new BigDecimal("12.1"));
        assertEquals("Iterable<String>, String, BigDecimal constructor", "MATCHRECURSE{VALUE,12}:FIELD1:FIELD2:ns%3Afield", matchRecurse.toString());
        assertEquals("Iterable<String>, String, BigDecimal - getDepth", 12, matchRecurse.getDepth());
        assertEquals("Iterable<String>, String, BigDecimal - getMatchValue", "VALUE", matchRecurse.getMatchValue());
        assertEquals("Iterable<String>, String, BigDecimal - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), matchRecurse.getFields());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIterableStringNumberNullFieldsException() {
        new MATCHRECURSE((Iterable<String>)null, "VALUE", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableStringNumberNullValueException() {
        new MATCHRECURSE(fieldsIterable, null, 11);
    }

    @Test(expected = RuntimeException.class)
    public void testIterableStringNumberNullDepthException() {
        new MATCHRECURSE(fieldsIterable, "VALUE", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableStringNumberNegativeNumberException() {
        new MATCHRECURSE(fieldsIterable, "VALUE", new Integer(-2));
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("MATCHRECURSE{value,3}:field", MATCHRECURSE("field", "value", 3).toString());
        assertEquals("MATCHRECURSE{value,3}:field:title", MATCHRECURSE(new String[]{"field", "title"}, "value", 3).toString());
        assertEquals("MATCHRECURSE{value,3}:field:title", MATCHRECURSE(Arrays.asList("field", "title"), "value", 3).toString());
    }
}
