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
public class BIASVAL extends Specifier {

    public BIASVAL(final String field, final String value, final Number bias) {
        this(Arrays.asList(field), value, bias);
    }

    public BIASVAL(final String[] fields, final String value, final Number bias) {
        this(Arrays.asList(fields), value, bias);
    }

    public BIASVAL(final Iterable<String> fields, final String value, final Number bias) {
        super("BIASVAL", fields, value, InternalUtils.numberToString(bias));
    }
    
    public final String getMatchValue() {
        return getValues().get(0);
    }
    
    public final double getBias() {
        return Double.parseDouble(getValues().get(1));
    }

    public static BIASVAL BIASVAL(final String field, final String value, final Number bias) {
        return new BIASVAL(field, value, bias);
    }

    public static BIASVAL BIASVAL(final String[] fields, final String value, final Number bias) {
        return new BIASVAL(fields, value, bias);
    }

    public static BIASVAL BIASVAL(final Iterable<String> fields, final String value, final Number bias) {
        return new BIASVAL(fields, value, bias);
    }
}
