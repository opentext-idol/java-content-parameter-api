/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.content.fieldtext;

import com.autonomy.aci.content.internal.InternalUtils;
import org.apache.commons.lang.Validate;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 */
public class EQUAL extends Specifier {
    public <T extends Number> EQUAL(final String field, final T value, final T... values) {
        this(field, InternalUtils.<Number>toList(value, values));
    }

    public <T extends Number> EQUAL(final String field, final T[] values) {
        this(field, Arrays.asList(values));
    }

    public EQUAL(final String field, final double[] values) {
        this(field, InternalUtils.doublesToIterable(values));
    }

    public EQUAL(final String field, final int[] values) {
        this(field, InternalUtils.intsToIterable(values));
    }

    public EQUAL(final String field, final long[] values) {
        this(field, InternalUtils.longsToIterable(values));
    }

    public EQUAL(final String field, final Iterable<? extends Number> values) {
        this(Collections.singletonList(field), values);
    }

    public <T extends Number> EQUAL(final String[] fields, final T value, final T... values) {
        this(fields, InternalUtils.<Number>toList(value, values));
    }

    public <T extends Number> EQUAL(final String[] fields, final T[] values) {
        this(fields, Arrays.asList(values));
    }

    public EQUAL(final String[] fields, final double[] values) {
        this(fields, InternalUtils.doublesToIterable(values));
    }

    public EQUAL(final String[] fields, final int[] values) {
        this(fields, InternalUtils.intsToIterable(values));
    }

    public EQUAL(final String[] fields, final long[] values) {
        this(fields, InternalUtils.longsToIterable(values));
    }

    public EQUAL(final String[] fields, final Iterable<? extends Number> values) {
        this(Arrays.asList(fields), values);
    }

    public <T extends Number> EQUAL(final Iterable<? extends String> fields, final T value, final T... values) {
        this(fields, InternalUtils.<Number>toList(value, values));
    }

    public <T extends Number> EQUAL(final Iterable<? extends String> fields, final T[] values) {
        this(fields, Arrays.asList(values));
    }

    public EQUAL(final Iterable<? extends String> fields, final double[] values) {
        this(fields, InternalUtils.doublesToIterable(values));
    }

    public EQUAL(final Iterable<? extends String> fields, final int[] values) {
        this(fields, InternalUtils.intsToIterable(values));
    }

    public EQUAL(final Iterable<? extends String> fields, final long[] values) {
        this(fields, InternalUtils.longsToIterable(values));
    }

    public EQUAL(final Iterable<? extends String> fields, final Iterable<? extends Number> values) {
        super("EQUAL", fields, InternalUtils.numbersToStrings(values));
        Validate.isTrue(!getValues().isEmpty(), "No values specified");
    }

    public final double[] getNumericValues() {
        return InternalUtils.stringsToDoubles(getValues());
    }

    public static <T extends Number> EQUAL EQUAL(final String field, final T value, final T... values) {
        return new EQUAL(field, value, values);
    }

    public static <T extends Number> EQUAL EQUAL(final String field, final T[] values) {
        return new EQUAL(field, values);
    }

    public static EQUAL EQUAL(final String field, final double[] values) {
        return new EQUAL(field, values);
    }

    public static EQUAL EQUAL(final String field, final int[] values) {
        return new EQUAL(field, values);
    }

    public static EQUAL EQUAL(final String field, final long[] values) {
        return new EQUAL(field, values);
    }

    public static EQUAL EQUAL(final String field, final Iterable<? extends Number> values) {
        return new EQUAL(field, values);
    }

    public static <T extends Number> EQUAL EQUAL(final String[] fields, final T value, final T... values) {
        return new EQUAL(fields, value, values);
    }

    public static <T extends Number> EQUAL EQUAL(final String[] fields, final T[] values) {
        return new EQUAL(fields, values);
    }

    public static EQUAL EQUAL(final String[] fields, final double[] values) {
        return new EQUAL(fields, values);
    }

    public static EQUAL EQUAL(final String[] fields, final int[] values) {
        return new EQUAL(fields, values);
    }

    public static EQUAL EQUAL(final String[] fields, final long[] values) {
        return new EQUAL(fields, values);
    }

    public static EQUAL EQUAL(final String[] fields, final Iterable<? extends Number> values) {
        return new EQUAL(fields, values);
    }

    public static <T extends Number> EQUAL EQUAL(final Iterable<? extends String> fields, final T value, final T... values) {
        return new EQUAL(fields, value, values);
    }

    public static <T extends Number> EQUAL EQUAL(final Iterable<? extends String> fields, final T[] values) {
        return new EQUAL(fields, values);
    }

    public static EQUAL EQUAL(final Iterable<? extends String> fields, final double[] values) {
        return new EQUAL(fields, values);
    }

    public static EQUAL EQUAL(final Iterable<? extends String> fields, final int[] values) {
        return new EQUAL(fields, values);
    }

    public static EQUAL EQUAL(final Iterable<? extends String> fields, final long[] values) {
        return new EQUAL(fields, values);
    }

    public static EQUAL EQUAL(final Iterable<? extends String> fields, final Iterable<? extends Number> values) {
        return new EQUAL(fields, values);
    }
}