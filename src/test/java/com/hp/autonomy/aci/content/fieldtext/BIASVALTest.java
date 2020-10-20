/*
 * (c) Copyright 2009-2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.hp.autonomy.aci.content.fieldtext;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static com.hp.autonomy.aci.content.fieldtext.BIASVAL.BIASVAL;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the <TT>BIASVAL</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class BIASVALTest {

    @Test
    public void testStringStringNumber() {
        BIASVAL biasVal = new BIASVAL("ns:field", "VALUE", (byte)11);
        assertEquals("String, String, byte constructor", "BIASVAL{VALUE,11}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, byte - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String, String, byte - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, byte - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", (short)11);
        assertEquals("String, String, short constructor", "BIASVAL{VALUE,11}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, short - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String, String, short - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, short - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", 11);
        assertEquals("String, String, int constructor", "BIASVAL{VALUE,11}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, int - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String, String, int - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, int - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", 11L);
        assertEquals("String, String, long constructor", "BIASVAL{VALUE,11}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, long - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String, String, long - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, long - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", -12.1f);
        assertEquals("String, String, float constructor", "BIASVAL{VALUE,-12.1}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, float - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String, String, float - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, float - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", -12.1);
        assertEquals("String, String, double constructor", "BIASVAL{VALUE,-12.1}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, double - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String, String, double - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, double - getFields", Collections.singletonList("ns:field"), biasVal.getFields());
        
        biasVal = new BIASVAL("ns:field", "VALUE", new Byte((byte)11));
        assertEquals("String, String, Byte constructor", "BIASVAL{VALUE,11}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, Byte - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String, String, Byte - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, Byte - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", new Short((short)11));
        assertEquals("String, String, Short constructor", "BIASVAL{VALUE,11}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, Short - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String, String, Short - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, Short - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", new Integer(11));
        assertEquals("String, String, Integer constructor", "BIASVAL{VALUE,11}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, Integer - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String, String, Integer - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, Integer - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", new Long(11L));
        assertEquals("String, String, Long constructor", "BIASVAL{VALUE,11}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, Long - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String, String, Long - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, Long - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", new Float(-12.1f));
        assertEquals("String, String, Float constructor", "BIASVAL{VALUE,-12.1}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, Float - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String, String, Float - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, Float - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", new Double(-12.1));
        assertEquals("String, String, Double constructor", "BIASVAL{VALUE,-12.1}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, Double - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String, String, Double - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, Double - getFields", Collections.singletonList("ns:field"), biasVal.getFields());

        biasVal = new BIASVAL("ns:field", "VALUE", new BigDecimal("-12.1"));
        assertEquals("String, String, BigDecimal constructor", "BIASVAL{VALUE,-12.1}:ns%3Afield", biasVal.toString());
        assertEquals("String, String, BigDecimal - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String, String, BigDecimal - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String, String, BigDecimal - getFields", Collections.singletonList("ns:field"), biasVal.getFields());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringNumberNullFieldsException() {
        new BIASVAL((String)null, "VALUE", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringNumberNullValueException() {
        new BIASVAL("ns:field", null, (byte)11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringNumberNullBiasException() {
        new BIASVAL("ns:field", "VALUE", null);
    }

    @Test
    public void testArrayStringNumber() {
        BIASVAL biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", (byte)11);
        assertEquals("String[], String, byte constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, byte - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String[], String, byte - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", (short)11);
        assertEquals("String[], String, short constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, short - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String[], String, short - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", 11);
        assertEquals("String[], String, int constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, int - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String[], String, int - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, int - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", 11L);
        assertEquals("String[], String, long constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, long - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String[], String, long - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", -12.1f);
        assertEquals("String[], String, float constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, float - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String[], String, float - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", -12.1);
        assertEquals("String[], String, double constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, double - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String[], String, double - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());
        
        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Byte((byte)11));
        assertEquals("String[], String, Byte constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, Byte - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String[], String, Byte - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, Byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Short((short)11));
        assertEquals("String[], String, Short constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, Short - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String[], String, Short - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, Short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Integer(11));
        assertEquals("String[], String, Integer constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, Integer - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String[], String, Integer - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, Integer - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Long(11L));
        assertEquals("String[], String, Long constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, Long - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("String[], String, Long - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, Long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Float(-12.1f));
        assertEquals("String[], String, Float constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, Float - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String[], String, Float - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, Float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new Double(-12.1));
        assertEquals("String[], String, Double constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, Double - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String[], String, Double - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, Double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", new BigDecimal("-12.1"));
        assertEquals("String[], String, BigDecimal constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("String[], String, BigDecimal - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("String[], String, BigDecimal - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("String[], String, BigDecimal - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());
    }

    @Test(expected = RuntimeException.class)
    public void testArrayStringNumberNullFieldsException() {
        new BIASVAL((String[])null, "VALUE", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayStringNumberNullValueException() {
        new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, null, (byte)11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayStringNumberNullBiasExceptionException() {
        new BIASVAL(new String[]{"FIELD1", "FIELD2", "ns:field"}, "VALUE", null);
    }

    @Test
    public void testIterableStringNumber() {
        BIASVAL biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", (byte)11);
        assertEquals("Iterable<String>, String, byte constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, byte - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, byte - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", (short)11);
        assertEquals("Iterable<String>, String, short constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, short - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, short - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", 11);
        assertEquals("Iterable<String>, String, int constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, int - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, int - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, int - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", 11L);
        assertEquals("Iterable<String>, String, long constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, long - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, long - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", -12.1f);
        assertEquals("Iterable<String>, String, float constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, float - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, float - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", -12.1);
        assertEquals("Iterable<String>, String, double constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, double - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, double - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());
        
        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", new Byte((byte)11));
        assertEquals("Iterable<String>, String, Byte constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, Byte - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, Byte - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, Byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", new Short((short)11));
        assertEquals("Iterable<String>, String, Short constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, Short - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, Short - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, Short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", new Integer(11));
        assertEquals("Iterable<String>, String, Integer constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, Integer - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, Integer - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, Integer - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", new Long(11L));
        assertEquals("Iterable<String>, String, Long constructor", "BIASVAL{VALUE,11}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, Long - getBias", 11.0, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, Long - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, Long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", new Float(-12.1f));
        assertEquals("Iterable<String>, String, Float constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, Float - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, Float - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, Float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", new Double(-12.1));
        assertEquals("Iterable<String>, String, Double constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, Double - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, Double - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, Double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());

        biasVal = new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", new BigDecimal("-12.1"));
        assertEquals("Iterable<String>, String, BigDecimal constructor", "BIASVAL{VALUE,-12.1}:FIELD1:FIELD2:ns%3Afield", biasVal.toString());
        assertEquals("Iterable<String>, String, BigDecimal - getBias", -12.1, biasVal.getBias(), 0);
        assertEquals("Iterable<String>, String, BigDecimal - getMatchValue", "VALUE", biasVal.getMatchValue());
        assertEquals("Iterable<String>, String, BigDecimal - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), biasVal.getFields());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableStringNumberNullFieldsException() {
        new BIASVAL((Iterable<String>)null, "VALUE", 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableStringNumberNullValueException() {
        new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), null, (byte)11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterableStringNumberNullBiasException() {
        new BIASVAL(Arrays.asList("FIELD1", "FIELD2", "ns:field"), "VALUE", null);
    }
    
    @Test
    public void testFactoryMethods() {
        assertEquals("BIASVAL{VALUE,2}:field", BIASVAL("field", "VALUE", 2).toString());
        assertEquals("BIASVAL{VALUE,2}:field:title", BIASVAL(new String[]{"field", "title"}, "VALUE", 2).toString());
        assertEquals("BIASVAL{VALUE,2}:field:title", BIASVAL(Arrays.asList("field", "title"), "VALUE", 2).toString());
    }
}
