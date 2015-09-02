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
 * Fieldtext specifier for the NOTWILD operator
 */
public class NOTWILD extends Specifier {

    /**
     * Constructs a new single field NOTWILD fieldtext
     * @param field The field name
     * @param value The first field value
     * @param values Any additional field values
     */
    public NOTWILD(final String field, final String value, final String... values) {
        this(Collections.singletonList(field), value, values);
    }

    /**
     * Constructs a new single field NOTWILD fieldtext
     * @param field The field name
     * @param values The field values
     */
    public NOTWILD(final String field, final String[] values) {
        this(Collections.singletonList(field), values);
    }

    /**
     * Constructs a new single field NOTWILD fieldtext
     * @param field The field name
     * @param values The field values
     */
    public NOTWILD(final String field, final Iterable<String> values) {
        this(Collections.singletonList(field), values);
    }

    /**
     * Constructs a new multiple field NOTWILD fieldtext
     * @param fields The field names
     * @param value The first field value
     * @param values Any additional field values
     */
    public NOTWILD(final String[] fields, final String value, final String... values) {
        this(Arrays.asList(fields), value, values);
    }

    /**
     * Constructs a new multiple field NOTWILD fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTWILD(final String[] fields, final String[] values) {
        this(Arrays.asList(fields), values);
    }

    /**
     * Constructs a new multiple field NOTWILD fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTWILD(final String[] fields, final Iterable<String> values) {
        this(Arrays.asList(fields), values);
    }

    /**
     * Constructs a new multiple field NOTWILD fieldtext
     * @param fields The field names
     * @param value The first field value
     * @param values Any additional field values
     */
    public NOTWILD(final Iterable<String> fields, final String value, final String... values) {
        this(fields, InternalUtils.toList(value, values));
    }

    /**
     * Constructs a new multiple field NOTWILD fieldtext
     * @param fields The field names
     * @param values The field values
     */
    public NOTWILD(final Iterable<String> fields, final String[] values) {
        this(fields, Arrays.asList(values));
    }

    public NOTWILD(final Iterable<String> fields, final Iterable<String> values) {
        super("NOTWILD", fields, values);
        Validate.isTrue(!getValues().isEmpty(), "No values specified");
    }

    public static NOTWILD NOTWILD(final String field, final String value, final String... values) {
        return new NOTWILD(field, value, values);
    }

    public static NOTWILD NOTWILD(final String field, final String[] values) {
        return new NOTWILD(field, values);
    }

    public static NOTWILD NOTWILD(final String field, final Iterable<String> values) {
        return new NOTWILD(field, values);
    }

    public static NOTWILD NOTWILD(final String[] fields, final String value, final String... values) {
        return new NOTWILD(fields, value, values);
    }

    public static NOTWILD NOTWILD(final String[] fields, final String[] values) {
        return new NOTWILD(fields, values);
    }

    public static NOTWILD NOTWILD(final String[] fields, final Iterable<String> values) {
        return new NOTWILD(fields, values);
    }

    public static NOTWILD NOTWILD(final Iterable<String> fields, final String value, final String... values) {
        return new NOTWILD(fields, value, values);
    }

    public static NOTWILD NOTWILD(final Iterable<String> fields, final String[] values) {
        return new NOTWILD(fields, values);
    }

    public static NOTWILD NOTWILD(final Iterable<String> fields, final Iterable<String> values) {
        return new NOTWILD(fields, values);
    }
}
