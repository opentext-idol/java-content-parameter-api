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
 * Fieldtext specifier for the MATCHALL operator
 */
public class MATCHALL extends Specifier {

    public MATCHALL(final String field, final String value, final String... values) {
        this(Collections.singletonList(field), value, values);
    }

    public MATCHALL(final String field, final String[] values) {
        this(Collections.singletonList(field), values);
    }

    public MATCHALL(final String field, final Iterable<String> values) {
        this(Collections.singletonList(field), values);
    }

    public MATCHALL(final String[] fields, final String value, final String... values) {
        this(Arrays.asList(fields), value, values);
    }

    public MATCHALL(final String[] fields, final String[] values) {
        this(Arrays.asList(fields), values);
    }

    public MATCHALL(final String[] fields, final Iterable<String> values) {
        this(Arrays.asList(fields), values);
    }

    public MATCHALL(final Iterable<String> fields, final String value, final String... values) {
        this(fields, InternalUtils.toList(value, values));
    }

    public MATCHALL(final Iterable<String> fields, final String[] values) {
        this(fields, Arrays.asList(values));
    }

    public MATCHALL(final Iterable<String> fields, final Iterable<String> values) {
        super("MATCHALL", fields, values);
        Validate.isTrue(!getValues().isEmpty(), "No values specified");
    }

    public static MATCHALL MATCHALL(final String field, final String value, final String... values) {
        return new MATCHALL(field, value, values);
    }

    public static MATCHALL MATCHALL(final String field, final String[] values) {
        return new MATCHALL(field, values);
    }

    public static MATCHALL MATCHALL(final String field, final Iterable<String> values) {
        return new MATCHALL(field, values);
    }

    public static MATCHALL MATCHALL(final String[] fields, final String value, final String... values) {
        return new MATCHALL(fields, value, values);
    }

    public static MATCHALL MATCHALL(final String[] fields, final String[] values) {
        return new MATCHALL(fields, values);
    }

    public static MATCHALL MATCHALL(final String[] fields, final Iterable<String> values) {
        return new MATCHALL(fields, values);
    }

    public static MATCHALL MATCHALL(final Iterable<String> fields, final String value, final String... values) {
        return new MATCHALL(fields, value, values);
    }

    public static MATCHALL MATCHALL(final Iterable<String> fields, final String[] values) {
        return new MATCHALL(fields, values);
    }

    public static MATCHALL MATCHALL(final Iterable<String> fields, final Iterable<String> values) {
        return new MATCHALL(fields, values);
    }
}
