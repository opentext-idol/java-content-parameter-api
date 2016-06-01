package com.hp.autonomy.aci.content.ranges;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RangesTest {
    @Test
    public void noRanges() {
        assertEquals("", new Ranges(null).toString());
    }

    @Test
    public void ranges() {
        assertEquals("FIXED{1,2,3}:A_FIELD+FIXED{.,1.1,2.2,.}:ANOTHER_FIELD", new Ranges(Arrays.asList(new Range("A_FIELD", new double[]{1, 2, 3}), new Range("ANOTHER_FIELD", new double[]{1.1, 2.2}, true, true))).toString());
    }
}
