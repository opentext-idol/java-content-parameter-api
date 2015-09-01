/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.content.fieldtext;

import com.autonomy.aci.content.internal.InternalUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 */
public class BIASVAL extends Specifier {

    public BIASVAL(final String field, final String value, final Number bias) {
        this(Collections.singletonList(field), value, bias);
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
