/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.ranges;

import org.apache.commons.collections4.CollectionUtils;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public class DateRange implements Range {
    private static final long serialVersionUID = -5755223676715240483L;

    private static final ZonedDateTime oneAD = ZonedDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);

    private static final Pattern FIELD_SEPARATOR = Pattern.compile(":", Pattern.LITERAL);
    private final String field;
    private final List<ZonedDateTime> ranges;
    private final boolean noMin;
    private final boolean noMax;

    public DateRange(final String field, final List<ZonedDateTime> ranges) {
        this(field, ranges, false);
    }

    public DateRange(final String field, final List<ZonedDateTime> ranges, final boolean noMax) {
        this(field, ranges, false, noMax);
    }

    public DateRange(final String field, final List<ZonedDateTime> ranges, final boolean noMin, final boolean noMax) {
        this.field = field;
        this.ranges = new ArrayList<>(ranges);
        this.noMin = noMin;
        this.noMax = noMax;
    }

    @Override
    public String toString() {
        if (CollectionUtils.isNotEmpty(ranges)) {
            final StringBuilder stringBuilder = new StringBuilder("FIXEDDATE{");
            if (noMin) {
                stringBuilder.append(".,");
            }
            ranges.forEach(range -> stringBuilder.append(formatDate(range)).append(','));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            if (noMax) {
                stringBuilder.append(",.");
            }
            stringBuilder.append("}:").append(FIELD_SEPARATOR.matcher(field).replaceAll(Matcher.quoteReplacement("%3A")));
            return stringBuilder.toString();
        } else {
            return "";
        }
    }

    private String formatDate(final ZonedDateTime range) {
        // IDOL ISO date time does not have a year 0 whereas Java ISO date time does
        return DateTimeFormatter.ISO_INSTANT.format(range.isBefore(oneAD) ? range.minusYears(1) : range);
    }
}
