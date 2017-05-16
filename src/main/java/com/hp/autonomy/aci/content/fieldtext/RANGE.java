package com.hp.autonomy.aci.content.fieldtext;

import org.apache.commons.lang.StringUtils;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@SuppressWarnings({"WeakerAccess", "ClassWithTooManyConstructors"})
public class RANGE extends Specifier {
    private static final ZonedDateTime oneAD = ZonedDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);

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

    private static String formatDate(final ZonedDateTime maybeParam) {
        // IDOL ISO date time does not have a year 0 whereas Java ISO date time does
        return Optional.ofNullable(maybeParam)
                .map(param -> DateTimeFormatter.ISO_INSTANT.format((param.isBefore(oneAD) ? param.minusYears(1) : param).truncatedTo(ChronoUnit.SECONDS)))
                .orElse(null);
    }

    @Override
    protected String getValuesString() {
        return StringUtils.join(getValues(), ',');
    }

    @SuppressWarnings("InnerClassTooDeeplyNested")
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
