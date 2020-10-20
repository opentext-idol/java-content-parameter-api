/*
 * (c) Copyright 2015-2017 Micro Focus or one of its affiliates.
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

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ParametricFieldRange<T> {
    private static final Pattern FIELD_SEPARATOR = Pattern.compile(":", Pattern.LITERAL);
    private final String field;
    private final List<T> ranges;
    private final boolean noMin;
    private final boolean noMax;

    ParametricFieldRange(final String field, final List<T> ranges) {
        this(field, ranges, false);
    }

    ParametricFieldRange(final String field, final List<T> ranges, final boolean noMax) {
        this(field, ranges, false, noMax);
    }

    ParametricFieldRange(final String field, final List<T> ranges, final boolean noMin, final boolean noMax) {
        this.field = field;
        this.ranges = new ArrayList<>(ranges);
        this.noMin = noMin;
        this.noMax = noMax;
    }

    protected abstract String getFieldTextName();

    protected abstract String formatElement(final T range);

    @Override
    public String toString() {
        if(CollectionUtils.isNotEmpty(ranges)) {
            final StringBuilder stringBuilder = (new StringBuilder(getFieldTextName())).append("{");
            if(noMin) {
                stringBuilder.append(".,");
            }
            ranges.forEach(range -> stringBuilder.append(formatElement(range)).append(','));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            if(noMax) {
                stringBuilder.append(",.");
            }
            stringBuilder.append("}:").append(FIELD_SEPARATOR.matcher(field).replaceAll(Matcher.quoteReplacement("%3A")));
            return stringBuilder.toString();
        } else {
            return "";
        }
    }
}
