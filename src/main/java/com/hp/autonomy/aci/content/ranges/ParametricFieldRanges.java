/*
 * (c) Copyright 2016-2017 Micro Focus or one of its affiliates.
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

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class ParametricFieldRanges {
    private final ArrayList<ParametricFieldRange> ranges;

    public ParametricFieldRanges(final List<? extends ParametricFieldRange> ranges) {
        this.ranges = new ArrayList<ParametricFieldRange>(ListUtils.emptyIfNull(ranges));
    }

    @Override
    public String toString() {
        return ranges.isEmpty()
            ? ""
            : StringUtils.join(ranges, '+');
    }
}
