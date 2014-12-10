/*
 * $Id$
 *
 * Copyright (c) 2008-2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
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
