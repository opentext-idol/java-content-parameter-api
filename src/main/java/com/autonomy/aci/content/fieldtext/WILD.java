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
public class WILD extends Specifier {

    public WILD(final String field, final String value, final String... values) {
        this(Collections.singletonList(field), value, values);
    }

    public WILD(final String field, final String[] values) {
        this(Collections.singletonList(field), values);
    }

    public WILD(final String field, final Iterable<String> values) {
        this(Collections.singletonList(field), values);
    }

    public WILD(final String[] fields, final String value, final String... values) {
        this(Arrays.asList(fields), value, values);
    }

    public WILD(final String[] fields, final String[] values) {
        this(Arrays.asList(fields), values);
    }

    public WILD(final String[] fields, final Iterable<String> values) {
        this(Arrays.asList(fields), values);
    }

    public WILD(final Iterable<String> fields, final String value, final String... values) {
        this(fields, InternalUtils.toList(value, values));
    }

    public WILD(final Iterable<String> fields, final String[] values) {
        this(fields, Arrays.asList(values));
    }

    public WILD(final Iterable<String> fields, final Iterable<String> values) {
        super("WILD", fields, values);
        Validate.isTrue(!getValues().isEmpty(), "No values specified");
    }

    public static WILD WILD(final String field, final String value, final String... values) {
        return new WILD(field, value, values);
    }

    public static WILD WILD(final String field, final String[] values) {
        return new WILD(field, values);
    }

    public static WILD WILD(final String field, final Iterable<String> values) {
        return new WILD(field, values);
    }

    public static WILD WILD(final String[] fields, final String value, final String... values) {
        return new WILD(fields, value, values);
    }

    public static WILD WILD(final String[] fields, final String[] values) {
        return new WILD(fields, values);
    }

    public static WILD WILD(final String[] fields, final Iterable<String> values) {
        return new WILD(fields, values);
    }

    public static WILD WILD(final Iterable<String> fields, final String value, final String... values) {
        return new WILD(fields, value, values);
    }

    public static WILD WILD(final Iterable<String> fields, final String[] values) {
        return new WILD(fields, values);
    }

    public static WILD WILD(final Iterable<String> fields, final Iterable<String> values) {
        return new WILD(fields, values);
    }
}
