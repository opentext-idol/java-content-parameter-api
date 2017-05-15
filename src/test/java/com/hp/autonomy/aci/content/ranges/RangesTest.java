package com.hp.autonomy.aci.content.ranges;

import org.junit.Test;

import java.time.ZonedDateTime;
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
        final String dateMinString = "2017-05-12T12:58:00Z";
        final ZonedDateTime dateMin = ZonedDateTime.parse(dateMinString);
        final String dateMaxString = "2017-05-12T12:58:01Z";
        final ZonedDateTime dateMax = ZonedDateTime.parse(dateMaxString);

        final List<Range> ranges = Arrays.asList(
                new NumericRange("A_FIELD", Arrays.asList(1D, 2D, 3D)),
                new NumericRange("ANOTHER_FIELD", Arrays.asList(1.1, 2.2), true, true),
                new DateRange("A_DATE_FIELD", Arrays.asList(dateMin, dateMax))
        );
        assertEquals(
                "FIXED{1.0,2.0,3.0}:A_FIELD" +
                "+FIXED{.,1.1,2.2,.}:ANOTHER_FIELD" +
                "+FIXEDDATE{" + dateMinString + ',' + dateMaxString + "}:A_DATE_FIELD",
                new Ranges(ranges).toString()
        );
    }
}
