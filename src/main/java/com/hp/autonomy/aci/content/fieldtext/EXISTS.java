/*
 * (c) Copyright 2009-2015 Micro Focus or one of its affiliates.
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

package com.hp.autonomy.aci.content.fieldtext;

import com.hp.autonomy.aci.content.internal.InternalUtils;

import java.util.Arrays;

/**
 * Fieldtext specifier for the EXISTS operator
 */
public class EXISTS extends Specifier {

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param fields The field names
     */
    public EXISTS(final String[] fields) {
        this(Arrays.asList(fields));
    }

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param field The field names
     * @param fields Any additional field names
     */
    public EXISTS(final String field, final String... fields) {
        this(InternalUtils.toList(field, fields));
    }

    /**
     * Constructs a new multiple field EMPTY fieldtext
     * @param fields The field names
     */
    public EXISTS(final Iterable<String> fields) {
        super("EXISTS", fields);
    }

    public static EXISTS EXISTS(final String[] fields) {
        return new EXISTS(fields);
    }

    public static EXISTS EXISTS(final String field, final String... fields) {
        return new EXISTS(field, fields);
    }

    public static EXISTS EXISTS(final Iterable<String> fields) {
        return new EXISTS(fields);
    }
}
