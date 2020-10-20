/*
 * (c) Copyright 2016-2017 Micro Focus or one of its affiliates.
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

package com.hp.autonomy.aci.content.fieldtext;

import org.apache.commons.lang.StringUtils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@SuppressWarnings({"WeakerAccess", "ClassWithTooManyConstructors"})
public class RANGE extends Specifier {
    public RANGE(final String field, final Long min, final Long max, final Type type) {
        this(Collections.singletonList(field), min, max, type);
    }

    public RANGE(final String field, final ZonedDateTime min, final ZonedDateTime max) {
        this(Collections.singletonList(field), min, max);
    }

    public RANGE(final String[] fields, final Long min, final Long max, final Type type) {
        this(Arrays.asList(fields), min, max, type);
    }

    public RANGE(final String[] fields, final ZonedDateTime min, final ZonedDateTime max) {
        this(Arrays.asList(fields), min, max);
    }

    public RANGE(final Iterable<? extends String> fields, final Long min, final Long max, final Type type) {
        super("RANGE", fields, constructRangeParam(min, type), constructRangeParam(max, type));
    }

    public RANGE(final Iterable<? extends String> fields, final ZonedDateTime min, final ZonedDateTime max) {
        super("RANGE", fields, formatDate(min), formatDate(max));
    }

    private static String constructRangeParam(final Long param, final Type type) {
        return Optional.ofNullable(param).map(type::getParam).orElse(".");
    }

    private static String formatDate(final ZonedDateTime param) {
        // IDOL ISO date time does not have a year 0 whereas Java ISO date time does
        return DateTimeFormatter.ISO_INSTANT
            .format(param.truncatedTo(ChronoUnit.SECONDS));
    }

    @Override
    protected String getValuesString() {
        return StringUtils.join(getValues(), ',');
    }

    public enum Type {
        DAYS {
            @Override
            protected String getParam(final Long param) {
                return String.valueOf(param);
            }
        },
        SECONDS {
            @Override
            protected String getParam(final Long param) {
                return param + "s";
            }
        },
        EPOCH {
            @Override
            protected String getParam(final Long param) {
                return param / 1000 + "e";
            }
        };

        protected abstract String getParam(final Long value);
    }
}
