/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import com.hp.autonomy.aci.content.internal.InternalUtils;

import java.util.Arrays;

/**
 * Fieldtext specifier for the EMPTY operator
 */
public class EMPTY extends Specifier {

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param field The first field name
     * @param fields Any additional field names
     */
    public EMPTY(final String field, final String... fields) {
        this(InternalUtils.toList(field, fields));
    }

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param fields The field names
     */
    public EMPTY(final String[] fields) {
        this(Arrays.asList(fields));
    }

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param fields The field names
     */
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
