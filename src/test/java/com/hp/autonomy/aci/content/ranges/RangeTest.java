package com.hp.autonomy.aci.content.ranges;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangeTest {
    @Test
    public void range() {
        assertEquals("FIXED{1.1,2.2}:A_FIELD", new Range("A_FIELD", new double[]{1.1, 2.2}).toString());
    }

    @Test
    public void fieldWithColon() {
        assertEquals("FIXED{1.1,2.2}:A_FI%3AELD", new Range("A_FI:ELD", new double[]{1.1, 2.2}).toString());
    }

    @Test
    public void scientificNotation() {
        assertEquals("FIXED{1.234567890001234E11,2.2}:A_FIELD", new Range("A_FIELD", new double[]{123456789000.1234, 2.2}).toString());
    }

    @Test
    public void rangeNoMax() {
        assertEquals("FIXED{1.1,2.2,.}:A_FIELD", new Range("A_FIELD", new double[]{1.1, 2.2}, true).toString());
    }

    @Test
    public void rangeNoMin() {
        assertEquals("FIXED{.,1.1,2.2}:A_FIELD", new Range("A_FIELD", new double[]{1.1, 2.2}, true, false).toString());
    }

    @Test
    public void rangeNoMaxNoMin() {
        assertEquals("FIXED{.,1.1,2.2,.}:A_FIELD", new Range("A_FIELD", new double[]{1.1, 2.2}, true, true).toString());
    }
}
