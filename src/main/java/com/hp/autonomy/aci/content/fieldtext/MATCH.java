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
 * Fieldtext specifier for the MATCH operator
 */
public class MATCH extends Specifier {

    /**
     * Creates a new single field MATCH fieldtext
     * @param field The name of the field
     * @param value The first field value
     * @param values Any additional field values
     */
    public MATCH(final String field, final String value, final String... values) {
        this(Collections.singletonList(field), value, values);
    }

    /**
     * Creates a new single field MATCH fieldtext
     * @param field The name of the field
     * @param values The field values
     */
    public MATCH(final String field, final String[] values) {
        this(Collections.singletonList(field), values);
    }

    /**
     * Creates a new single field MATCH fieldtext
     * @param field The name of the field
     * @param values The field values
     */
    public MATCH(final String field, final Iterable<String> values) {
        this(Collections.singletonList(field), values);
    }

    /**
     * Creates a new multiple field MATCH fieldtext
     * @param fields The names of the fields
     * @param value The first field value
     * @param values Any additional field values
     */
    public MATCH(final String[] fields, final String value, final String... values) {
        this(Arrays.asList(fields), value, values);
    }

    /**
     * Creates a new multiple field MATCH fieldtext
     * @param fields The names of the fields
     * @param values The field values
     */
    public MATCH(final String[] fields, final String[] values) {
        this(Arrays.asList(fields), values);
    }

    /**
     * Creates a new multiple field MATCH fieldtext
     * @param fields The names of the fields
     * @param values The field values
     */
    public MATCH(final String[] fields, final Iterable<String> values) {
        this(Arrays.asList(fields), values);
    }

    /**
     * Creates a new multiple field MATCH fieldtext
     * @param fields The names of the fields
     * @param value The first field value
     * @param values Any additional field values
     */
    public MATCH(final Iterable<String> fields, final String value, final String... values) {
        this(fields, InternalUtils.toList(value, values));
    }

    /**
     * Creates a new multiple field MATCH fieldtext
     * @param fields The names of the fields
     * @param values The field values
     */
    public MATCH(final Iterable<String> fields, final String[] values) {
        this(fields, Arrays.asList(values));
    }

    /**
     * Creates a new multiple field MATCH fieldtext
     * @param fields The names of the fields
     * @param values The field values
     */
    public MATCH(final Iterable<String> fields, final Iterable<String> values) {
        super("MATCH", fields, values);
        Validate.isTrue(!getValues().isEmpty(), "No values specified");
    }

    public static MATCH MATCH(final String field, final String value, final String... values) {
        return new MATCH(field, value, values);
    }

    public static MATCH MATCH(final String field, final String[] values) {
        return new MATCH(field, values);
    }

    public static MATCH MATCH(final String field, final Iterable<String> values) {
        return new MATCH(field, values);
    }

    public static MATCH MATCH(final String[] fields, final String value, final String... values) {
        return new MATCH(fields, value, values);
    }

    public static MATCH MATCH(final String[] fields, final String[] values) {
        return new MATCH(fields, values);
    }

    public static MATCH MATCH(final String[] fields, final Iterable<String> values) {
        return new MATCH(fields, values);
    }

    public static MATCH MATCH(final Iterable<String> fields, final String value, final String... values) {
        return new MATCH(fields, value, values);
    }

    public static MATCH MATCH(final Iterable<String> fields, final String[] values) {
        return new MATCH(fields, values);
    }

    public static MATCH MATCH(final Iterable<String> fields, final Iterable<String> values) {
        return new MATCH(fields, values);
    }
}
