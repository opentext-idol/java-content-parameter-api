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
public class EMPTY extends Specifier {

    public EMPTY(final String field, final String... fields) {
        this(InternalUtils.toList(field, fields));
    }

    public EMPTY(final String[] fields) {
        this(Arrays.asList(fields));
    }

    public EMPTY(final Iterable<String> fields) {
        super("EMPTY", fields);
    }

    public static EMPTY EMPTY(final String field, final String... fields) {
        return new EMPTY(field, fields);
    }

    public static EMPTY EMPTY(final String[] fields) {
        return new EMPTY(fields);
    }

    public static EMPTY EMPTY(final Iterable<String> fields) {
        return new EMPTY(fields);
    }
}
