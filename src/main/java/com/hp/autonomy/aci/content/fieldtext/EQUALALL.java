/*
 * Copyright 2009-2015 Open Text.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Open Text and its affiliates
 * and licensors ("Open Text") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Open Text shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */
package com.hp.autonomy.aci.content.fieldtext;

import com.hp.autonomy.aci.content.internal.InternalUtils;
import org.apache.commons.lang.Validate;

import java.util.Arrays;
import java.util.Collections;

/**
 * Fieldtext specifier for the EQUALALL operator
 */
public class EQUALALL extends Specifier {

    /**
     * Constructs a new single field EQUALALL fieldtext
     * @param field The field name
     * @param value The first value
     * @param values Any additional values
     * @param <T> The numeric type
     */
    public <T extends Number> EQUALALL(final String field, final T value, final T... values) {
        this(field, InternalUtils.<Number>toList(value, values));
    }

    /**
     * Constructs a new single field EQUALALL fieldtext
     * @param field The field name
     * @param values The field values
     * @param <T> The numeric type
     */
    public <T extends Number> EQUALALL(final String field, final T[] values) {
        this(field, Arrays.asList(values));
    }

    /**
     * Constructs a new single field EQUALALL fieldtext
     * @param field The field name
     * @param values The field values
     */
    public EQUALALL(final String field, final double[] values) {
        this(field, InternalUtils.doublesToIterable(values));
    }

    /**
     * Constructs a new single field EQUALALL fieldtext
     * @param field The field name
     * @param values The field values
     */
    public EQUALALL(final String field, final int[] values) {
        this(field, InternalUtils.intsToIterable(values));
    }

    /**
     * Constructs a new single field EQUALALL fieldtext
     * @param field The field name
     * @param values The field values
     */
    public EQUALALL(final String field, final long[] values) {
        this(field, InternalUtils.longsToIterable(values));
    }

    /**
     * Constructs a new single field EQUALALL fieldtext
     * @param field The field name
     * @param values The field values
     */
    public EQUALALL(final String field, final Iterable<? extends Number> values) {
        this(Collections.singletonList(field), values);
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param value The first field value
     * @param values Any additional field values
     * @param <T> The numeric type
     */
    public <T extends Number> EQUALALL(final String[] fields, final T value, final T... values) {
        this(fields, InternalUtils.<Number>toList(value, values));
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     * @param <T> The numeric type
     */
    public <T extends Number> EQUALALL(final String[] fields, final T[] values) {
        this(fields, Arrays.asList(values));
    }
    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     */
    public EQUALALL(final String[] fields, final double[] values) {
        this(fields, InternalUtils.doublesToIterable(values));
    }
    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     */
    public EQUALALL(final String[] fields, final int[] values) {
        this(fields, InternalUtils.intsToIterable(values));
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     */
    public EQUALALL(final String[] fields, final long[] values) {
        this(fields, InternalUtils.longsToIterable(values));
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     */
    public EQUALALL(final String[] fields, final Iterable<? extends Number> values) {
        this(Arrays.asList(fields), values);
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param value The first field value
     * @param values Any additional field values
     * @param <T> The numeric type
     */
    public <T extends Number> EQUALALL(final Iterable<? extends String> fields, final T value, final T... values) {
        this(fields, InternalUtils.<Number>toList(value, values));
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     * @param <T> The numeric type
     */
    public <T extends Number> EQUALALL(final Iterable<? extends String> fields, final T[] values) {
        this(fields, Arrays.asList(values));
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     */
    public EQUALALL(final Iterable<? extends String> fields, final double[] values) {
        this(fields, InternalUtils.doublesToIterable(values));
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     */
    public EQUALALL(final Iterable<? extends String> fields, final int[] values) {
        this(fields, InternalUtils.intsToIterable(values));
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     */
    public EQUALALL(final Iterable<? extends String> fields, final long[] values) {
        this(fields, InternalUtils.longsToIterable(values));
    }

    /**
     * Constructs a new multiple field EQUALALL fieldtext
     * @param fields The field name
     * @param values The field values
     */
    public EQUALALL(final Iterable<? extends String> fields, final Iterable<? extends Number> values) {
        super("EQUALALL", fields, InternalUtils.numbersToStrings(values));
        Validate.isTrue(!getValues().isEmpty(), "No values specified");
    }

    public final double[] getNumericValues() {
        return InternalUtils.stringsToDoubles(getValues());
    }

    public static <T extends Number> EQUALALL EQUALALL(final String field, final T value, final T... values) {
        return new EQUALALL(field, value, values);
    }

    public static <T extends Number> EQUALALL EQUALALL(final String field, final T[] values) {
        return new EQUALALL(field, values);
    }

    public static EQUALALL EQUALALL(final String field, final double[] values) {
        return new EQUALALL(field, values);
    }

    public static EQUALALL EQUALALL(final String field, final int[] values) {
        return new EQUALALL(field, values);
    }

    public static EQUALALL EQUALALL(final String field, final long[] values) {
        return new EQUALALL(field, values);
    }

    public static EQUALALL EQUALALL(final String field, final Iterable<? extends Number> values) {
        return new EQUALALL(field, values);
    }

    public static <T extends Number> EQUALALL EQUALALL(final String[] fields, final T value, final T... values) {
        return new EQUALALL(fields, value, values);
    }

    public static <T extends Number> EQUALALL EQUALALL(final String[] fields, final T[] values) {
        return new EQUALALL(fields, values);
    }

    public static EQUALALL EQUALALL(final String[] fields, final double[] values) {
        return new EQUALALL(fields, values);
    }

    public static EQUALALL EQUALALL(final String[] fields, final int[] values) {
        return new EQUALALL(fields, values);
    }

    public static EQUALALL EQUALALL(final String[] fields, final long[] values) {
        return new EQUALALL(fields, values);
    }

    public static EQUALALL EQUALALL(final String[] fields, final Iterable<? extends Number> values) {
        return new EQUALALL(fields, values);
    }

    public static <T extends Number> EQUALALL EQUALALL(final Iterable<? extends String> fields, final T value, final T... values) {
        return new EQUALALL(fields, value, values);
    }

    public static <T extends Number> EQUALALL EQUALALL(final Iterable<? extends String> fields, final T[] values) {
        return new EQUALALL(fields, values);
    }

    public static EQUALALL EQUALALL(final Iterable<? extends String> fields, final double[] values) {
        return new EQUALALL(fields, values);
    }

    public static EQUALALL EQUALALL(final Iterable<? extends String> fields, final int[] values) {
        return new EQUALALL(fields, values);
    }

    public static EQUALALL EQUALALL(final Iterable<? extends String> fields, final long[] values) {
        return new EQUALALL(fields, values);
    }

    public static EQUALALL EQUALALL(final Iterable<? extends String> fields, final Iterable<? extends Number> values) {
        return new EQUALALL(fields, values);
    }
}
