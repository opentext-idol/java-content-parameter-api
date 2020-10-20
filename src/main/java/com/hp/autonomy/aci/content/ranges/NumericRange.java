/*
 * (c) Copyright 2017 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
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
