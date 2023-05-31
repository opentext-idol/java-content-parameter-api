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
 * A representation of the state range for a state id. The state range is the optional section in square brackets after
 * the state token.
 *
 * <p>This interface provides relatively few methods for manipulating a state range. This is intentional. Though the
 * majority of ranges are continuous it is possible to have discontinuous ranges and these must also be supported.
 */
public interface StateRange {
    /**
     * The string representation of the range, as used to query IDOL. Note that this should not include the square
     * brackets. An empty range should have an empty string representation.
     *
     * @return The range as a string
     */
    @Override
    String toString();

    /**
     * {@code StateRange} objects are considered equal if their {@code String} representations are equal.
     *
     * @param obj An object to test for equality
     * @return {@code true} if and only if {@code obj} is a {@code StateRange} object with the same {@code toString()}
     *         value as this object.
     */
    @Override
    boolean equals(Object obj);

    /**
     * The hashcode should be that of the {@code String} representation.
     *
     * @return The hashcode of the {@code String} representation.
     */
    @Override
    int hashCode();

    /**
     * Whether or not the range is empty. An empty range will have a size of 0 and an empty string representation.
     *
     * <p>In general, implementations should be wary of allowing empty ranges to be created as they can cause confusion.
     * Despite having a size of 0, an empty range will actually match all documents in a stored state, rather than none
     * of them.
     *
     * @return {@code true} if the range is empty
     */
    boolean isEmpty();

    /**
     * The size of the range. For example, the range <tt>[5-7,12]</tt> has a size of {@code 4}. Note that a size of 0
     * signifies a range that will match all the documents in a stored state rather than one that will match no
     * documents.
     *
     * @return The size of the range
     */
    int size();
}
