package com.hp.autonomy.aci.content.ranges;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Ranges {
    private final List<Range> ranges;

    public Ranges(final List<Range> ranges) {
        this.ranges = new ArrayList<Range>(ListUtils.emptyIfNull(ranges));
    }

    @Override
    public String toString() {
        return ranges.isEmpty() ? "" : StringUtils.join(ranges, '+');
    }
}
