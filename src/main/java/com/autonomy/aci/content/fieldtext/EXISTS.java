/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.content.fieldtext;

import com.autonomy.aci.content.internal.InternalUtils;

import java.util.Arrays;

/**
 *
 */
public class EXISTS extends Specifier {

    public EXISTS(final String[] fields) {
        this(Arrays.asList(fields));
    }

    public EXISTS(final String field, final String... fields) {
        this(InternalUtils.toList(field, fields));
    }

    public EXISTS(final Iterable<String> fields) {
        super("EXISTS", fields);
    }

    public static EXISTS EXISTS(final String[] fields) {
        return new EXISTS(fields);
    }

    public static EXISTS EXISTS(final String field, final String... fields) {
        return new EXISTS(field, fields);
    }

    public static EXISTS EXISTS(final Iterable<String> fields) {
        return new EXISTS(fields);
    }
}
