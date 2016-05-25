package com.hp.autonomy.aci.content.fieldtext;

import com.hp.autonomy.aci.content.internal.InternalUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings({"WeakerAccess", "ClassWithTooManyConstructors"})
public class NRANGE extends Specifier {
    public NRANGE(final String field, final Number min, final Number max) {
        this(field, min, max, true, true);
    }

    public NRANGE(final String field, final Number min, final Number max, final boolean minInclusive, final boolean maxInclusive) {
        this(Collections.singletonList(field), min, max, minInclusive, maxInclusive);
    }

    public NRANGE(final String[] fields, final Number min, final Number max) {
        this(fields, min, max, true, true);
    }

    public NRANGE(final String[] fields, final Number min, final Number max, final boolean minInclusive, final boolean maxInclusive) {
        this(Arrays.asList(fields), min, max, minInclusive, maxInclusive);
    }

    public NRANGE(final Iterable<? extends String> fields, final Number min, final Number max) {
        this(fields, min, max, true, true);
    }

    public NRANGE(final Iterable<? extends String> fields, final Number min, final Number max, final boolean minInclusive, final boolean maxInclusive) {
        super("NRANGE", fields, constructRangeParam(min, minInclusive, '>'), constructRangeParam(max, maxInclusive, '<'));
    }

    @Override
    protected String getValuesString() {
        return StringUtils.join(getValues(), ',');
    }

    private static String constructRangeParam(final Number param, final boolean inclusive, final char symbol) {
        return inclusive ? InternalUtils.numberToString(param) : symbol + InternalUtils.numberToString(param);
    }
}
