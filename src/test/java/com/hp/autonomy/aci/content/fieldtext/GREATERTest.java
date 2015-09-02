/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static com.hp.autonomy.aci.content.fieldtext.GREATER.GREATER;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the <TT>GREATER</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class GREATERTest {

    @Test
    public void testStringDouble() {
        GREATER greater = new GREATER("ns:field", (byte)7);
        assertEquals("String, byte constructor", "GREATER{7}:ns%3Afield", greater.toString());
        assertEquals("String, byte - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String, byte - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", (short)7);
        assertEquals("String, short constructor", "GREATER{7}:ns%3Afield", greater.toString());
        assertEquals("String, short - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String, short - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", 7);
        assertEquals("String, int constructor", "GREATER{7}:ns%3Afield", greater.toString());
        assertEquals("String, int - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String, int - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", 7L);
        assertEquals("String, long constructor", "GREATER{7}:ns%3Afield", greater.toString());
        assertEquals("String, long - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String, long - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", 6.3f);
        assertEquals("String, float constructor", "GREATER{6.3}:ns%3Afield", greater.toString());
        assertEquals("String, float - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String, float - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", 6.3);
        assertEquals("String, double constructor", "GREATER{6.3}:ns%3Afield", greater.toString());
        assertEquals("String, double - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String, double - getFields", Collections.singletonList("ns:field"), greater.getFields());
    }

    @Test
    public void testStringNumber() {
        GREATER greater = new GREATER("ns:field", new Byte((byte)7));
        assertEquals("String, Byte constructor", "GREATER{7}:ns%3Afield", greater.toString());
        assertEquals("String, Byte - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String, Byte - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", new Short((short)7));
        assertEquals("String, Short constructor", "GREATER{7}:ns%3Afield", greater.toString());
        assertEquals("String, Short - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String, Short - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", new Integer(7));
        assertEquals("String, Integer constructor", "GREATER{7}:ns%3Afield", greater.toString());
        assertEquals("String, Integer - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String, Integer - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", new Long(7L));
        assertEquals("String, Long constructor", "GREATER{7}:ns%3Afield", greater.toString());
        assertEquals("String, Long - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String, Long - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", new Float(6.3f));
        assertEquals("String, Float constructor", "GREATER{6.3}:ns%3Afield", greater.toString());
        assertEquals("String, Float - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String, Float - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", new Double(6.3));
        assertEquals("String, Double constructor", "GREATER{6.3}:ns%3Afield", greater.toString());
        assertEquals("String, Double - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String, Double - getFields", Collections.singletonList("ns:field"), greater.getFields());

        greater = new GREATER("ns:field", new BigDecimal("6.3"));
        assertEquals("String, BigDecimal constructor", "GREATER{6.3}:ns%3Afield", greater.toString());
        assertEquals("String, BigDecimal - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String, BigDecimal - getFields", Collections.singletonList("ns:field"), greater.getFields());
    }

    @Test
    public void testArrayDouble() {
        GREATER greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, (byte)7);
        assertEquals("String[], byte constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], byte - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String[], byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, (short)7);
        assertEquals("String[], short constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], short - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String[], short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, 7);
        assertEquals("String[], int constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], int - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String[], int - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, 7L);
        assertEquals("String[], long constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], long - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String[], long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, 6.3f);
        assertEquals("String[], float constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], float - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String[], float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, 6.3);
        assertEquals("String[], double constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], double - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String[], double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());
    }

    @Test
    public void testArrayNumber() {
        GREATER greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Byte((byte)7));
        assertEquals("String[], Byte constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], Byte - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String[], Byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Short((short)7));
        assertEquals("String[], Short constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], Short - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String[], Short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Integer(7));
        assertEquals("String[], Integer constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], Integer - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String[], Integer - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Long(7L));
        assertEquals("String[], Long constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], Long - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("String[], Long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Float(6.3f));
        assertEquals("String[], Float constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], Float - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String[], Float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Double(6.3));
        assertEquals("String[], Double constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], Double - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String[], Double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(new String[]{"FIELD1", "FIELD2", "ns:field"}, new BigDecimal("6.3"));
        assertEquals("String[], BigDecimal constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("String[], BigDecimal - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("String[], BigDecimal - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());
    }

    @Test
    public void testIterableDouble() {
        GREATER greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), (byte)7);
        assertEquals("Iterable<String>, byte constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, byte - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), (short)7);
        assertEquals("Iterable<String>, short constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, short - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 7);
        assertEquals("Iterable<String>, int constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, int - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, int - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 7L);
        assertEquals("Iterable<String>, long constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, long - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 6.3f);
        assertEquals("Iterable<String>, float constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, float - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 6.3);
        assertEquals("Iterable<String>, double constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, double - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());
    }

    @Test
    public void testIterableNumber() {
        GREATER greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Byte((byte)7));
        assertEquals("Iterable<String>, Byte constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, Byte - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, Byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Short((short)7));
        assertEquals("Iterable<String>, Short constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, Short - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, Short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Integer(7));
        assertEquals("Iterable<String>, Integer constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, Integer - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, Integer - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Long(7L));
        assertEquals("Iterable<String>, Long constructor", "GREATER{7}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, Long - getValues", 7.0, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, Long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Float(6.3f));
        assertEquals("Iterable<String>, Float constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, Float - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, Float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Double(6.3));
        assertEquals("Iterable<String>, Double constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, Double - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, Double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());

        greater = new GREATER(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new BigDecimal("6.3"));
        assertEquals("Iterable<String>, BigDecimal constructor", "GREATER{6.3}:FIELD1:FIELD2:ns%3Afield", greater.toString());
        assertEquals("Iterable<String>, BigDecimal - getValues", 6.3, greater.getNumericValue(), 0);
        assertEquals("Iterable<String>, BigDecimal - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), greater.getFields());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("GREATER{6}:field", GREATER.GREATER("field", 6).toString());
        assertEquals("GREATER{6}:field:title", GREATER.GREATER(new String[]{"field", "title"}, 6).toString());
        assertEquals("GREATER{6}:field:title", GREATER.GREATER(Arrays.asList("field", "title"), 6).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException1() {
        new GREATER((String)null, 7);
    }

    @Test(expected = RuntimeException.class)
    public void testNullException2() {
        new GREATER((String[])null, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException3() {
        new GREATER(new String[]{null}, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException4() {
        new GREATER((Iterable<String>)null, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException5() {
        new GREATER(Arrays.asList("title", null), 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException6() {
        new GREATER("title", null);
    }
}
