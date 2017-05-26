/*
 * Copyright 2017 Hewlett Packard Enterprise Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.ranges;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class NumericRange extends ParametricFieldRange<Double> {
    private static final long serialVersionUID = -5755223676715240483L;

    public NumericRange(final String field, final List<Double> ranges) {
        super(field, ranges);
    }

    public NumericRange(final String field, final List<Double> ranges, final boolean noMax) {
        super(field, ranges, noMax);
    }

    public NumericRange(final String field, final List<Double> ranges, final boolean noMin, final boolean noMax) {
        super(field, ranges, noMin, noMax);
    }

    protected String getFieldTextName() {
        return "FIXED";
    }

    protected String formatElement(final Double range) {
        return range.toString();
    }
}
