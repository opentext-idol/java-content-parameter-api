/*
 * (c) Copyright 2009-2015 Micro Focus or one of its affiliates.
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

import com.hp.autonomy.aci.content.internal.InternalUtils;
import org.apache.commons.lang.Validate;

import java.util.Arrays;
import java.util.Collections;

/**
 * Fieldtext specifier for the NOTEQUAL operator
 */
public class NOTEQUAL extends Specifier {

    /**
     * Constructs a new single field NOTEQUAL fieldtext
     * @param field The field name
     * @param value The first field value
     * @param values Any additional field values
     * @param <T> The numeric type
     */
    public <T extends Number> NOTEQUAL(final String field, final T value, final T... values) {
        this(field, InternalUtils.<Number>toList(value, values));
    }

    /**
     * Constructs a new single field NOTEQUAL fieldtext
     * @param field The field name
     * @param values The field values
     * @param <T> The numeric type
     */
    public <T extends Number> NOTEQUAL(final String field, final T[] values) {
        this(field, Arrays.asList(values));
    }

    /**
     * Constructs a new single field NOTEQUAL fieldtext
     * @param field The field name
     * @param values The field values
     */
    public NOTEQUAL(final String field, final double[] values) {
        this(field, InternalUtils.doublesToIterable(values));
    }

    /**
     * Constructs a new single field NOTEQUAL fieldtext
     * @param field The field name
     * @param values The field values
     */
    public NOTEQUAL(final String field, final int[] values) {
        this(field, InternalUtils.intsToIterable(values));
    }

    /**
     * Constructs a new single field NOTEQUAL fieldtext
     * @param field The field name
     * @param values The field values
     */
    public NOTEQUAL(final String field, final long[] values) {
        this(field, InternalUtils.longsToIterable(values));
    }

    /**
     * Constructs a new single field NOTEQUAL fieldtext
     * @param field The field name
     * @param values The field values
     */
    public NOTEQUAL(final String field, final Iterable<? extends Number> values) {
        this(Collections.singletonList(field), values);
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param value The first field value
     * @param values Any additional field values
     * @param <T> The numeric type
     */
    public <T extends Number> NOTEQUAL(final String[] fields, final T value, final T... values) {
        this(fields, InternalUtils.<Number>toList(value, values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     * @param <T> The numeric type
     */
    public <T extends Number> NOTEQUAL(final String[] fields, final T[] values) {
        this(fields, Arrays.asList(values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTEQUAL(final String[] fields, final double[] values) {
        this(fields, InternalUtils.doublesToIterable(values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTEQUAL(final String[] fields, final int[] values) {
        this(fields, InternalUtils.intsToIterable(values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTEQUAL(final String[] fields, final long[] values) {
        this(fields, InternalUtils.longsToIterable(values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTEQUAL(final String[] fields, final Iterable<? extends Number> values) {
        this(Arrays.asList(fields), values);
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param value The first field value
     * @param values Any additional field values
     * @param <T> The numeric type
     */
    public <T extends Number> NOTEQUAL(final Iterable<? extends String> fields, final T value, final T... values) {
        this(fields, InternalUtils.<Number>toList(value, values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     * @param <T> The numeric type
     */
    public <T extends Number> NOTEQUAL(final Iterable<? extends String> fields, final T[] values) {
        this(fields, Arrays.asList(values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTEQUAL(final Iterable<? extends String> fields, final double[] values) {
        this(fields, InternalUtils.doublesToIterable(values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTEQUAL(final Iterable<? extends String> fields, final int[] values) {
        this(fields, InternalUtils.intsToIterable(values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTEQUAL(final Iterable<? extends String> fields, final long[] values) {
        this(fields, InternalUtils.longsToIterable(values));
    }

    /**
     * Constructs a new multiple field NOTEQUAL fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTEQUAL(final Iterable<? extends String> fields, final Iterable<? extends Number> values) {
        super("NOTEQUAL", fields, InternalUtils.numbersToStrings(values));
        Validate.isTrue(!getValues().isEmpty(), "No values specified");
    }

    public final double[] getNumericValues() {
        return InternalUtils.stringsToDoubles(getValues());
    }

    public static <T extends Number> NOTEQUAL NOTEQUAL(final String field, final T value, final T... values) {
        return new NOTEQUAL(field, value, values);
    }

    public static <T extends Number> NOTEQUAL NOTEQUAL(final String field, final T[] values) {
        return new NOTEQUAL(field, values);
    }

    public static NOTEQUAL NOTEQUAL(final String field, final double[] values) {
        return new NOTEQUAL(field, values);
    }

    public static NOTEQUAL NOTEQUAL(final String field, final int[] values) {
        return new NOTEQUAL(field, values);
    }

    public static NOTEQUAL NOTEQUAL(final String field, final long[] values) {
        return new NOTEQUAL(field, values);
    }

    public static NOTEQUAL NOTEQUAL(final String field, final Iterable<? extends Number> values) {
        return new NOTEQUAL(field, values);
    }

    public static <T extends Number> NOTEQUAL NOTEQUAL(final String[] fields, final T value, final T... values) {
        return new NOTEQUAL(fields, value, values);
    }

    public static <T extends Number> NOTEQUAL NOTEQUAL(final String[] fields, final T[] values) {
        return new NOTEQUAL(fields, values);
    }

    public static NOTEQUAL NOTEQUAL(final String[] fields, final double[] values) {
        return new NOTEQUAL(fields, values);
    }

    public static NOTEQUAL NOTEQUAL(final String[] fields, final int[] values) {
        return new NOTEQUAL(fields, values);
    }

    public static NOTEQUAL NOTEQUAL(final String[] fields, final long[] values) {
        return new NOTEQUAL(fields, values);
    }

    public static NOTEQUAL NOTEQUAL(final String[] fields, final Iterable<? extends Number> values) {
        return new NOTEQUAL(fields, values);
    }

    public static <T extends Number> NOTEQUAL NOTEQUAL(final Iterable<? extends String> fields, final T value, final T... values) {
        return new NOTEQUAL(fields, value, values);
    }

    public static <T extends Number> NOTEQUAL NOTEQUAL(final Iterable<? extends String> fields, final T[] values) {
        return new NOTEQUAL(fields, values);
    }

    public static NOTEQUAL NOTEQUAL(final Iterable<? extends String> fields, final double[] values) {
        return new NOTEQUAL(fields, values);
    }

    public static NOTEQUAL NOTEQUAL(final Iterable<? extends String> fields, final int[] values) {
        return new NOTEQUAL(fields, values);
    }

    public static NOTEQUAL NOTEQUAL(final Iterable<? extends String> fields, final long[] values) {
        return new NOTEQUAL(fields, values);
    }

    public static NOTEQUAL NOTEQUAL(final Iterable<? extends String> fields, final Iterable<? extends Number> values) {
        return new NOTEQUAL(fields, values);
    }
}
