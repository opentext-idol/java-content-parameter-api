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
public class GREATER extends Specifier {

    public GREATER(final String field, final Number value) {
        this(Arrays.asList(field), value);
    }

    public GREATER(final String[] fields, final Number value) {
        this(Arrays.asList(fields), value);
    }

    public GREATER(final Iterable<String> fields, final Number value) {
        super("GREATER", fields, InternalUtils.numberToString(value));
    }

    public final double getNumericValue() {
        return Double.parseDouble(getValues().get(0));
    }

    public static GREATER GREATER(final String field, final Number value) {
        return new GREATER(field, value);
    }

    public static GREATER GREATER(final String[] fields, final Number value) {
        return new GREATER(fields, value);
    }

    public static GREATER GREATER(final Iterable<String> fields, final Number value) {
        return new GREATER(fields, value);
    }
}
