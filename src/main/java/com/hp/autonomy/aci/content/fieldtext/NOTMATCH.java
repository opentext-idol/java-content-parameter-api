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
 * Fieldtext specifier for the NOTMATCH operator
 */
public class NOTMATCH extends Specifier {

    public NOTMATCH(final String field, final String value, final String... values) {
        this(Collections.singletonList(field), value, values);
    }

    public NOTMATCH(final String field, final String[] values) {
        this(Collections.singletonList(field), values);
    }

    public NOTMATCH(final String field, final Iterable<String> values) {
        this(Collections.singletonList(field), values);
    }

    public NOTMATCH(final String[] fields, final String value, final String... values) {
        this(Arrays.asList(fields), value, values);
    }

    public NOTMATCH(final String[] fields, final String[] values) {
        this(Arrays.asList(fields), values);
    }

    public NOTMATCH(final String[] fields, final Iterable<String> values) {
        this(Arrays.asList(fields), values);
    }

    public NOTMATCH(final Iterable<String> fields, final String value, final String... values) {
        this(fields, InternalUtils.toList(value, values));
    }

    public NOTMATCH(final Iterable<String> fields, final String[] values) {
        this(fields, Arrays.asList(values));
    }

    public NOTMATCH(final Iterable<String> fields, final Iterable<String> values) {
        super("NOTMATCH", fields, values);
        Validate.isTrue(!getValues().isEmpty(), "No values specified");
    }

    public static NOTMATCH NOTMATCH(final String field, final String value, final String... values) {
        return new NOTMATCH(field, value, values);
    }

    public static NOTMATCH NOTMATCH(final String field, final String[] values) {
        return new NOTMATCH(field, values);
    }

    public static NOTMATCH NOTMATCH(final String field, final Iterable<String> values) {
        return new NOTMATCH(field, values);
    }

    public static NOTMATCH NOTMATCH(final String[] fields, final String value, final String... values) {
        return new NOTMATCH(fields, value, values);
    }

    public static NOTMATCH NOTMATCH(final String[] fields, final String[] values) {
        return new NOTMATCH(fields, values);
    }

    public static NOTMATCH NOTMATCH(final String[] fields, final Iterable<String> values) {
        return new NOTMATCH(fields, values);
    }

    public static NOTMATCH NOTMATCH(final Iterable<String> fields, final String value, final String... values) {
        return new NOTMATCH(fields, value, values);
    }

    public static NOTMATCH NOTMATCH(final Iterable<String> fields, final String[] values) {
        return new NOTMATCH(fields, values);
    }

    public static NOTMATCH NOTMATCH(final Iterable<String> fields, final Iterable<String> values) {
        return new NOTMATCH(fields, values);
    }
}
