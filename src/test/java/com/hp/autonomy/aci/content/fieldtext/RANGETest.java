/*
 * Copyright 2016-2017 Hewlett Packard Enterprise Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import org.junit.Test;

import java.time.ZonedDateTime;
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
        final RANGE range = new RANGE("ns:field", ZonedDateTime.parse("2017-02-15T15:39:00Z"), ZonedDateTime.parse("2017-02-15T15:40:00Z"));
        assertEquals("RANGE{2017-02-15T15:39:00Z,2017-02-15T15:40:00Z}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("2017-02-15T15:39:00Z", "2017-02-15T15:40:00Z"), range.getValues());
        assertEquals(Collections.singletonList("ns:field"), range.getFields());
    }

    @Test
    public void singleFieldDateWideRange() {
        final RANGE range = new RANGE("ns:field", ZonedDateTime.parse("0000-01-01T01:01:00Z"), ZonedDateTime.parse("3000-03-03T03:03:00Z"));
        assertEquals("RANGE{0000-01-01T01:01:00Z,3000-03-03T03:03:00Z}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("0000-01-01T01:01:00Z", "3000-03-03T03:03:00Z"), range.getValues());
        assertEquals(Collections.singletonList("ns:field"), range.getFields());
    }

    @Test
    public void singleFieldDateMillis() {
        final RANGE range = new RANGE("ns:field", ZonedDateTime.parse("0000-01-01T01:01:00.123Z"), ZonedDateTime.parse("3000-03-03T03:03:00.456Z"));
        assertEquals("RANGE{0000-01-01T01:01:00Z,3000-03-03T03:03:00Z}:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("0000-01-01T01:01:00Z", "3000-03-03T03:03:00Z"), range.getValues());
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
        final RANGE range = new RANGE(new String[]{"FIELD1", "FIELD2", "ns:field"}, ZonedDateTime.parse("2017-02-15T15:39:00Z"), ZonedDateTime.parse("2017-02-15T15:40:00Z"));
        assertEquals("RANGE{2017-02-15T15:39:00Z,2017-02-15T15:40:00Z}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("2017-02-15T15:39:00Z", "2017-02-15T15:40:00Z"), range.getValues());
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
        final RANGE range = new RANGE(Arrays.asList("FIELD1", "FIELD2", "ns:field"), ZonedDateTime.parse("2017-02-15T15:39:00Z"), ZonedDateTime.parse("2017-02-15T15:40:00Z"));
        assertEquals("RANGE{2017-02-15T15:39:00Z,2017-02-15T15:40:00Z}:FIELD1:FIELD2:ns%3Afield", range.toString());
        assertEquals(Arrays.asList("2017-02-15T15:39:00Z", "2017-02-15T15:40:00Z"), range.getValues());
        assertEquals(Arrays.asList("FIELD1", "FIELD2", "ns:field"), range.getFields());
    }
}
