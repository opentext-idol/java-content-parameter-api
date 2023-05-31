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
package com.hp.autonomy.aci.content.identifier.id;

import com.hp.autonomy.aci.content.identifier.DocumentIdentifiers;

/**
 * A representation of a set of document ids.
 */
public interface Ids extends DocumentIdentifiers, Iterable<Id> {

    /**
     * Combines the ids in {@code this} with the specified ids.
     * <p>
     * It is implementation specific whether or not {@code this} is modified or whether a new object is returned
     * instead. If {@code this} is modified it should also be returned.
     *
     * @param ids The ids to append
     * @return The combined ids object
     */
    Ids append(int... ids);

    /**
     * Combines the ids in {@code this} with the specified ids.
     * <p>
     * It is implementation specific whether or not {@code this} is modified or whether a new object is returned
     * instead. If {@code this} is modified it should also be returned.
     *
     * @param ids The ids to append
     * @return The combined ids object
     */
    Ids append(Iterable<?>... ids);

    /**
     * The number of ids.
     *
     * @return The number of ids.
     */
    int size();

    /**
     * {@code Ids} objects are considered equal if their {@code String} representations are equal.
     *
     * @param obj An object to test for equality
     * @return {@code true} if and only if {@code obj} is an {@code Ids} object with the same {@code toString()} value
     *         as this object.
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
}
