package com.hp.autonomy.aci.content.fieldtext;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class NRANGETest {
    @Test
    public void singleField() {
        final NRANGE range = new NRANGE("ns:field", 123456789, 123456791);
        assertEquals("NRANGE{123456789,123456791}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789", "123456791"), range.getValues());
        assertEquals(Collections.singletonList("ns:field"), range.getFields());
    }

    @Test
    public void singleFieldExclusive() {
        final NRANGE range = new NRANGE("ns:field", 123456789, 123456791, false, false);
        assertEquals("NRANGE{>123456789,<123456791}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList(">123456789", "<123456791"), range.getValues());
        assertEquals(Collections.singletonList("ns:field"), range.getFields());
    }

    @Test
    public void fieldArray() {
        final NRANGE range = new NRANGE(new String[]{"FIELD1", "FIELD2", "ns:field"}, 123456789, 123456791);
        assertEquals("NRANGE{123456789,123456791}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789", "123456791"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }

    @Test
    public void fieldArrayExclusive() {
        final NRANGE range = new NRANGE(new String[]{"FIELD1", "FIELD2", "ns:field"}, 123456789, 123456791, false, false);
        assertEquals("NRANGE{>123456789,<123456791}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList(">123456789", "<123456791"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }

    @Test
    public void fieldCollection() {
        final NRANGE range = new NRANGE(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 123456789, 123456791);
        assertEquals("NRANGE{123456789,123456791}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789", "123456791"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }

    @Test
    public void fieldCollectionExclusive() {
        final NRANGE range = new NRANGE(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 123456789, 123456791, false, false);
        assertEquals("NRANGE{>123456789,<123456791}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList(">123456789", "<123456791"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }
}
