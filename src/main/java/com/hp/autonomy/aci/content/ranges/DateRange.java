/*
 * Copyright 2017 Hewlett Packard Enterprise Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.ranges;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class DateRange extends ParametricFieldRange<ZonedDateTime> {
    private static final long serialVersionUID = -5755223676715240483L;

    public DateRange(final String field, final List<ZonedDateTime> ranges) {
        super(field, ranges);
    }

    public DateRange(final String field, final List<ZonedDateTime> ranges, final boolean noMax) {
        super(field, ranges, noMax);
    }

    public DateRange(final String field, final List<ZonedDateTime> ranges, final boolean noMin, final boolean noMax) {
        super(field, ranges, noMin, noMax);
    }

    protected String getFieldTextName() {
        return "FIXEDDATE";
    }

    protected String formatElement(final ZonedDateTime range) {
        // IDOL ISO date time does not have a year 0 whereas Java ISO date time does
        return DateTimeFormatter.ISO_INSTANT
            .format(range.truncatedTo(ChronoUnit.SECONDS));
    }
}
