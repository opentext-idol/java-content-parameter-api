/*
 * $Id$
 *
 * Copyright (c) 2008-2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */

package com.autonomy.aci.content.fieldtext;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;

import static com.autonomy.aci.content.fieldtext.LESS.*;

import static org.junit.Assert.*;

/**
 * Tests for the <tt>LESS</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class LESSTest {

    @Test
    public void testStringDouble() {
        LESS less = new LESS("ns:field", (byte)7);
        assertEquals("String, byte constructor", "LESS{7}:ns%3Afield", less.toString());
        assertEquals("String, byte - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String, byte - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", (short)7);
        assertEquals("String, short constructor", "LESS{7}:ns%3Afield", less.toString());
        assertEquals("String, short - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String, short - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", 7);
        assertEquals("String, int constructor", "LESS{7}:ns%3Afield", less.toString());
        assertEquals("String, int - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String, int - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", 7L);
        assertEquals("String, long constructor", "LESS{7}:ns%3Afield", less.toString());
        assertEquals("String, long - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String, long - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", 6.3f);
        assertEquals("String, float constructor", "LESS{6.3}:ns%3Afield", less.toString());
        assertEquals("String, float - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String, float - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", 6.3);
        assertEquals("String, double constructor", "LESS{6.3}:ns%3Afield", less.toString());
        assertEquals("String, double - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String, double - getFields", Arrays.asList("ns:field"), less.getFields());
    }

    @Test
    public void testStringNumber() {
        LESS less = new LESS("ns:field", new Byte((byte)7));
        assertEquals("String, Byte constructor", "LESS{7}:ns%3Afield", less.toString());
        assertEquals("String, Byte - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String, Byte - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", new Short((short)7));
        assertEquals("String, Short constructor", "LESS{7}:ns%3Afield", less.toString());
        assertEquals("String, Short - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String, Short - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", new Integer(7));
        assertEquals("String, Integer constructor", "LESS{7}:ns%3Afield", less.toString());
        assertEquals("String, Integer - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String, Integer - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", new Long(7L));
        assertEquals("String, Long constructor", "LESS{7}:ns%3Afield", less.toString());
        assertEquals("String, Long - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String, Long - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", new Float(6.3f));
        assertEquals("String, Float constructor", "LESS{6.3}:ns%3Afield", less.toString());
        assertEquals("String, Float - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String, Float - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", new Double(6.3));
        assertEquals("String, Double constructor", "LESS{6.3}:ns%3Afield", less.toString());
        assertEquals("String, Double - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String, Double - getFields", Arrays.asList("ns:field"), less.getFields());

        less = new LESS("ns:field", new BigDecimal("6.3"));
        assertEquals("String, BigDecimal constructor", "LESS{6.3}:ns%3Afield", less.toString());
        assertEquals("String, BigDecimal - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String, BigDecimal - getFields", Arrays.asList("ns:field"), less.getFields());
    }

    @Test
    public void testArrayDouble() {
        LESS less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, (byte)7);
        assertEquals("String[], byte constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], byte - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String[], byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, (short)7);
        assertEquals("String[], short constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], short - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String[], short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, 7);
        assertEquals("String[], int constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], int - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String[], int - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, 7L);
        assertEquals("String[], long constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], long - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String[], long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, 6.3f);
        assertEquals("String[], float constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], float - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String[], float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, 6.3);
        assertEquals("String[], double constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], double - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String[], double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());
    }

    @Test
    public void testArrayNumber() {
        LESS less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Byte((byte)7));
        assertEquals("String[], Byte constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], Byte - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String[], Byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Short((short)7));
        assertEquals("String[], Short constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], Short - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String[], Short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Integer(7));
        assertEquals("String[], Integer constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], Integer - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String[], Integer - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Long(7L));
        assertEquals("String[], Long constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], Long - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("String[], Long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Float(6.3f));
        assertEquals("String[], Float constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], Float - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String[], Float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, new Double(6.3));
        assertEquals("String[], Double constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], Double - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String[], Double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(new String[]{"FIELD1", "FIELD2", "ns:field"}, new BigDecimal("6.3"));
        assertEquals("String[], BigDecimal constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("String[], BigDecimal - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("String[], BigDecimal - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());
    }

    @Test
    public void testIterableDouble() {
        LESS less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), (byte)7);
        assertEquals("Iterable<String>, byte constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, byte - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), (short)7);
        assertEquals("Iterable<String>, short constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, short - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 7);
        assertEquals("Iterable<String>, int constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, int - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, int - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 7L);
        assertEquals("Iterable<String>, long constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, long - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 6.3f);
        assertEquals("Iterable<String>, float constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, float - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 6.3);
        assertEquals("Iterable<String>, double constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, double - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());
    }

    @Test
    public void testIterableNumber() {
        LESS less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Byte((byte)7));
        assertEquals("Iterable<String>, Byte constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, Byte - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, Byte - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Short((short)7));
        assertEquals("Iterable<String>, Short constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, Short - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, Short - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Integer(7));
        assertEquals("Iterable<String>, Integer constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, Integer - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, Integer - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Long(7L));
        assertEquals("Iterable<String>, Long constructor", "LESS{7}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, Long - getValues", 7.0, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, Long - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Float(6.3f));
        assertEquals("Iterable<String>, Float constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, Float - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, Float - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new Double(6.3));
        assertEquals("Iterable<String>, Double constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, Double - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, Double - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());

        less = new LESS(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new BigDecimal("6.3"));
        assertEquals("Iterable<String>, BigDecimal constructor", "LESS{6.3}:FIELD1:FIELD2:ns%3Afield", less.toString());
        assertEquals("Iterable<String>, BigDecimal - getValues", 6.3, less.getNumericValue(), 0);
        assertEquals("Iterable<String>, BigDecimal - getFields", Arrays.asList("FIELD1", "FIELD2", "ns:field"), less.getFields());
    }

    @Test
    public void testFactoryMethods() {
        assertEquals("LESS{6}:field", LESS("field", 6).toString());
        assertEquals("LESS{6}:field:title", LESS(new String[]{"field", "title"}, 6).toString());
        assertEquals("LESS{6}:field:title", LESS(Arrays.asList("field", "title"), 6).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException1() {
        new LESS((String)null, 7);
    }

    @Test(expected = RuntimeException.class)
    public void testNullException2() {
        new LESS((String[])null, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException3() {
        new LESS(new String[]{null}, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException4() {
        new LESS((Iterable<String>)null, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException5() {
        new LESS(Arrays.asList("title", null), 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullException6() {
        new LESS("title", null);
    }
}
