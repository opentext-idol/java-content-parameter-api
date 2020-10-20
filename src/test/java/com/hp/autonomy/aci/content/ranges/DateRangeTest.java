/*
 * (c) Copyright 2017 Micro Focus or one of its affiliates.
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

package com.hp.autonomy.aci.content.ranges;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DateRangeTest {
    @Test
    public void range() {
        final String minString = "2017-05-12T12:58:00Z";
        final ZonedDateTime min = ZonedDateTime.parse(minString);
        final String maxString = "2017-05-12T12:58:01Z";
        final ZonedDateTime max = ZonedDateTime.parse(maxString);
        assertEquals(
            "FIXEDDATE{" + minString + ',' + maxString + "}:A_FIELD",
            new DateRange("A_FIELD", Arrays.asList(min, max)).toString()
        );
    }

    @Test
    public void rangeWithMillis() {
        final String minString = "2017-05-12T12:58:00.123Z";
        final ZonedDateTime min = ZonedDateTime.parse(minString);
        final String maxString = "2017-05-12T12:58:01.456Z";
        final ZonedDateTime max = ZonedDateTime.parse(maxString);
        assertEquals(
            "FIXEDDATE{2017-05-12T12:58:00Z,2017-05-12T12:58:01Z}:A_FIELD",
            new DateRange("A_FIELD", Arrays.asList(min, max)).toString()
        );
    }

    @Test
    public void wideRange() {
        final String minString = "0000-01-01T01:01:00Z";
        final ZonedDateTime min = ZonedDateTime.parse(minString);
        final String maxString = "3000-03-03T03:03:00Z";
        final ZonedDateTime max = ZonedDateTime.parse(maxString);
        assertEquals(
            "FIXEDDATE{0000-01-01T01:01:00Z," + maxString + "}:A_FIELD",
            new DateRange("A_FIELD", Arrays.asList(min, max)).toString()
        );
    }

    @Test
    public void fieldWithColon() {
        final String minString = "2017-05-12T12:58:00Z";
        final ZonedDateTime min = ZonedDateTime.parse(minString);
        final String maxString = "2017-05-12T12:58:01Z";
        final ZonedDateTime max = ZonedDateTime.parse(maxString);
        assertEquals(
            "FIXEDDATE{" + minString + ',' + maxString + "}:A_FI%3AELD",
            new DateRange("A_FI%3AELD", Arrays.asList(min, max)).toString()
        );
    }

    @Test
    public void rangeNoMax() {
        final String minString = "2017-05-12T12:58:00Z";
        final ZonedDateTime min = ZonedDateTime.parse(minString);
        final String middleString = "2017-05-12T12:58:01Z";
        final ZonedDateTime middle = ZonedDateTime.parse(middleString);
        assertEquals(
            "FIXEDDATE{" + minString + ',' + middleString + ",.}:A_FIELD",
            new DateRange("A_FIELD", Arrays.asList(min, middle), true).toString()
        );
    }

    @Test
    public void rangeNoMin() {
        final String middleString = "2017-05-12T12:58:00Z";
        final ZonedDateTime middle = ZonedDateTime.parse(middleString);
        final String maxString = "2017-05-12T12:58:01Z";
        final ZonedDateTime max = ZonedDateTime.parse(maxString);
        assertEquals(
            "FIXEDDATE{.," + middleString + ',' + maxString + "}:A_FIELD",
            new DateRange("A_FIELD", Arrays.asList(middle, max), true, false).toString()
        );
    }

    @Test
    public void rangeNoMaxNoMin() {
        final String middle1String = "2017-05-12T12:58:00Z";
        final ZonedDateTime middle1 = ZonedDateTime.parse(middle1String);
        final String middle2String = "2017-05-12T12:58:01Z";
        final ZonedDateTime middle2 = ZonedDateTime.parse(middle2String);
        assertEquals(
            "FIXEDDATE{.," + middle1String + ',' + middle2String + ",.}:A_FIELD",
            new DateRange("A_FIELD", Arrays.asList(middle1, middle2), true, true).toString()
        );
    }
}
