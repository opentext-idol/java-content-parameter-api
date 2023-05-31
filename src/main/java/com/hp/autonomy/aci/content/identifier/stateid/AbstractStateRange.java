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
package com.hp.autonomy.aci.content.identifier.stateid;

/**
 * An abstract base-class that partially implements the {@link StateRange} interface using sensible defaults.
 */
public abstract class AbstractStateRange implements StateRange {
    @Override
    public boolean equals(final Object object) {
        return object == this || object instanceof StateRange && toString().equals(object.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public abstract String toString();

    /**
     * Simple implementation that tests for emptiness using {@code size() == 0}. In most cases this should be
     * overridden with a better implementation.
     *
     * @return {@code true} if and only if size is 0.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
