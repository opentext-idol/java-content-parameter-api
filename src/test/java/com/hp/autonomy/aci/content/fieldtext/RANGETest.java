package com.hp.autonomy.aci.content.fieldtext;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class RANGETest {
    @Test
    public void singleFieldEpoch() {
        final RANGE range = new RANGE("ns:field", 123456789000L, 123456791000L, RANGE.Type.EPOCH);
        assertEquals("RANGE{123456789e,123456791e}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789e", "123456791e"), range.getValues());
        assertEquals(Collections.singletonList("ns:field"), range.getFields());
    }

    @Test
    public void singleFieldDays() {
        final RANGE range = new RANGE("ns:field", 123456789L, 123456791L, RANGE.Type.DAYS);
        assertEquals("RANGE{123456789,123456791}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789", "123456791"), range.getValues());
        assertEquals(Collections.singletonList("ns:field"), range.getFields());
    }

    @Test
    public void singleFieldSeconds() {
        final RANGE range = new RANGE("ns:field", 123456789L, 123456791L, RANGE.Type.SECONDS);
        assertEquals("RANGE{123456789s,123456791s}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789s", "123456791s"), range.getValues());
        assertEquals(Collections.singletonList("ns:field"), range.getFields());
    }

    @Test
    public void singleFieldDate() {
        final RANGE range = new RANGE("ns:field", new DateTime(123456789000L), new DateTime(123456791000L));
        assertEquals("RANGE{123456789e,123456791e}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789e", "123456791e"), range.getValues());
        assertEquals(Collections.singletonList("ns:field"), range.getFields());
    }

    @Test
    public void fieldArrayEpoch() {
        final RANGE range = new RANGE(new String[]{"FIELD1", "FIELD2", "ns:field"}, 123456789000L, 123456791000L, RANGE.Type.EPOCH);
        assertEquals("RANGE{123456789e,123456791e}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789e", "123456791e"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }

    @Test
    public void fieldArrayDate() {
        final RANGE range = new RANGE(new String[]{"FIELD1", "FIELD2", "ns:field"}, new DateTime(123456789000L), new DateTime(123456791000L));
        assertEquals("RANGE{123456789e,123456791e}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789e", "123456791e"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }

    @Test
    public void fieldCollectionEpoch() {
        final RANGE range = new RANGE(Arrays.asList("FIELD1", "FIELD2", "ns:field"), 123456789000L, 123456791000L, RANGE.Type.EPOCH);
        assertEquals("RANGE{123456789e,123456791e}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789e", "123456791e"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }

    @Test
    public void fieldCollectionDate() {
        final RANGE range = new RANGE(Arrays.asList("FIELD1", "FIELD2", "ns:field"), new DateTime(123456789000L), new DateTime(123456791000L));
        assertEquals("RANGE{123456789e,123456791e}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("123456789e", "123456791e"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }
}
