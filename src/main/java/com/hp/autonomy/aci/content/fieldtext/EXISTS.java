/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import com.hp.autonomy.aci.content.internal.InternalUtils;

import java.util.Arrays;

/**
 * Fieldtext specifier for the EXISTS operator
 */
public class EXISTS extends Specifier {

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param fields The field names
     */
    public EXISTS(final String[] fields) {
        this(Arrays.asList(fields));
    }

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param field The field names
     * @param fields Any additional field names
     */
    public EXISTS(final String field, final String... fields) {
        this(InternalUtils.toList(field, fields));
    }

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param fields The field names
     */
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
