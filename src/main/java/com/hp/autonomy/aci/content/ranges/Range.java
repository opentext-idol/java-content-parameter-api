/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.ranges;

import org.apache.commons.lang3.ArrayUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public class Range implements Serializable {
    private static final long serialVersionUID = -5755223676715240483L;

    private static final Pattern FIELD_SEPARATOR = Pattern.compile(":", Pattern.LITERAL);
    private final String field;
    private final double[] ranges;
    private final boolean noMin;
    private final boolean noMax;

    public Range(final String field, final double[] ranges) {
        this(field, ranges, false);
    }

    public Range(final String field, final double[] ranges, final boolean noMax) {
        this(field, ranges, false, noMax);
    }

    public Range(final String field, final double[] ranges, final boolean noMin, final boolean noMax) {
        this.field = field;
        this.ranges = Arrays.copyOf(ranges, ranges.length);
        this.noMin = noMin;
        this.noMax = noMax;
    }

    @Override
    public String toString() {
        if (ArrayUtils.isNotEmpty(ranges)) {
            final StringBuilder stringBuilder = new StringBuilder("FIXED{");
            if (noMin) {
                stringBuilder.append(".,");
            }
            for (final double range : ranges) {
                stringBuilder.append(range).append(',');
            }
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
}
