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
 * Fieldtext specifier for the BIAS operator
 */
public class BIAS extends Specifier {

    /**
     * Constructs a new single field BIAS fieldtext
     * @param field The field name
     * @param optimum The field value that receives maximum bias
     * @param range The range of values either side of optimum which receive bias
     * @param bias The bias value at the optimum
     */
    public BIAS(final String field, final Number optimum, final Number range, final Number bias) {
        this(Collections.singletonList(field), optimum, range, bias);
    }

    /**
     * Constructs a new multiple field BIAS fieldtext
     * @param fields The field name
     * @param optimum The field value that receives maximum bias
     * @param range The range of values either side of optimum which receive bias
     * @param bias The bias value at the optimum
     */
    public BIAS(final String[] fields, final Number optimum, final Number range, final Number bias) {
        this(Arrays.asList(fields), optimum, range, bias);
    }

    /**
     * Constructs a new multiple field BIAS fieldtext
     * @param fields The field name
     * @param optimum The field value that receives maximum bias
     * @param range The range of values either side of optimum which receive bias
     * @param bias The bias value at the optimum
     */
    public BIAS(final Iterable<String> fields, final Number optimum, final Number range, final Number bias) {
        super("BIAS", fields, InternalUtils.numberToString(optimum), InternalUtils.numberToString(range), InternalUtils.numberToString(bias));

        if(range.doubleValue() < 0) {
            throw new IllegalArgumentException("Range must not be negative");
        }
    }

    public final double getOptimum() {
        return Double.parseDouble(getValues().get(0));
    }
    
    public final double getRange() {
        return Double.parseDouble(getValues().get(1));
    }
    
    public final double getBias() {
        return Double.parseDouble(getValues().get(2));
    }
    
    public static BIAS BIAS(final String field, final Number optimum, final Number range, final Number bias) {
        return new BIAS(field, optimum, range, bias);
    }

    public static BIAS BIAS(final String[] fields, final Number optimum, final Number range, final Number bias) {
        return new BIAS(fields, optimum, range, bias);
    }

    public static BIAS BIAS(final Iterable<String> fields, final Number optimum, final Number range, final Number bias) {
        return new BIAS(fields, optimum, range, bias);
    }
}
