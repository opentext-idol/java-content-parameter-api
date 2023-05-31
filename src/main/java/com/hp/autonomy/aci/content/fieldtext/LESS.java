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

import java.util.Arrays;
import java.util.Collections;

/**
 * Fieldtext specifier for the LESS operator
 */
public class LESS extends Specifier {

    /**
     * Constructs a new single field LESS fieldtext
     * @param field The field name
     * @param value The field value
     */
    public LESS(final String field, final Number value) {
        this(Collections.singletonList(field), value);
    }

    /**
     * Constructs a new multiple field LESS fieldtext
     * @param fields The field names
     * @param value The field value
     */
    public LESS(final String[] fields, final Number value) {
        this(Arrays.asList(fields), value);
    }

    /**
     * Constructs a new multiple field LESS fieldtext
     * @param fields The field names
     * @param value The field value
     */
    public LESS(final Iterable<String> fields, final Number value) {
        super("LESS", fields, InternalUtils.numberToString(value));
    }

    public final double getNumericValue() {
        return Double.parseDouble(getValues().get(0));
    }

    public static LESS LESS(final String field, final Number value) {
        return new LESS(field, value);
    }

    public static LESS LESS(final String[] fields, final Number value) {
        return new LESS(fields, value);
    }

    public static LESS LESS(final Iterable<String> fields, final Number value) {
        return new LESS(fields, value);
    }
}
