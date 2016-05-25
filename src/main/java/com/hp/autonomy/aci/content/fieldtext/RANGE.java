package com.hp.autonomy.aci.content.fieldtext;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings({"WeakerAccess", "ClassWithTooManyConstructors"})
public class RANGE extends Specifier {
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

    public RANGE(final String field, final Long min, final Long max, final Type type) {
        this(Collections.singletonList(field), min, max, type);
    }

    public RANGE(final String field, final DateTime min, final DateTime max) {
        this(Collections.singletonList(field), min, max);
    }

    public RANGE(final String[] fields, final Long min, final Long max, final Type type) {
        this(Arrays.asList(fields), min, max, type);
    }

    public RANGE(final String[] fields, final DateTime min, final DateTime max) {
        this(Arrays.asList(fields), min, max);
    }

    public RANGE(final Iterable<? extends String> fields, final Long min, final Long max, final Type type) {
        super("RANGE", fields, constructRangeParam(min, type), constructRangeParam(max, type));
    }

    public RANGE(final Iterable<? extends String> fields, final DateTime min, final DateTime max) {
        this(fields, min != null ? min.getMillis() : null, max != null ? max.getMillis() : null, Type.EPOCH);
    }

    @Override
    protected String getValuesString() {
        return StringUtils.join(getValues(), ',');
    }

    private static String constructRangeParam(final Long param, final Type type) {
        return param != null ? type.getParam(param) : ".";
    }
}
