package com.hp.autonomy.aci.content.ranges;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RangesTest {
    @Test
    public void noRanges() {
        assertEquals("", new Ranges(null).toString());
    }

    @Test
    public void ranges() {
        final List<Range> ranges = Arrays.asList(
                new NumericRange("A_FIELD", Arrays.asList(1D, 2D, 3D)),
                new NumericRange("ANOTHER_FIELD", Arrays.asList(1.1, 2.2), true, true)
                //TODO: add date with FIND-1352
        );
        assertEquals("FIXED{1.0,2.0,3.0}:A_FIELD+FIXED{.,1.1,2.2,.}:ANOTHER_FIELD", new Ranges(ranges).toString());
    }
}
