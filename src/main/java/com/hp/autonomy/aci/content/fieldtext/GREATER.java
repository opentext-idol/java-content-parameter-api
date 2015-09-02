/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.fieldtext;

import com.hp.autonomy.aci.content.internal.InternalUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * Fieldtext specifier for the GREATER operator
 */
public class GREATER extends Specifier {

    /**
     * Constructs a new single field GREATER fieldtext
     * @param field The field name
     * @param value The field value
     */
    public GREATER(final String field, final Number value) {
        this(Collections.singletonList(field), value);
    }

    /**
     * Constructs a new multiple field GREATER fieldtext
     * @param fields The field names
     * @param value The field value
     */
    public GREATER(final String[] fields, final Number value) {
        this(Arrays.asList(fields), value);
    }

    /**
     * Constructs a new multiple field GREATER fieldtext
     * @param fields The field names
     * @param value The field value
     */
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
