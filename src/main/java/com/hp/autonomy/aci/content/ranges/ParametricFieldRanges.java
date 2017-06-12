/*
 * Copyright 2016-2017 Hewlett Packard Enterprise Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
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
        this.ranges = new ArrayList<>(ListUtils.emptyIfNull(ranges));
    }

    @Override
    public String toString() {
        return ranges.isEmpty()
            ? ""
            : StringUtils.join(ranges, '+');
    }
}
