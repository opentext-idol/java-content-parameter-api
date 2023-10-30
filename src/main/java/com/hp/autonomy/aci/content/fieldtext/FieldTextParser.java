/*
 * Copyright 2023 Open Text.
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

import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for IDOL fieldtext strings.
 */
public class FieldTextParser {
    // operator{value1,value2}:field1:field2
    private static final Pattern specifierPattern = Pattern.compile(
            "\\s*(?<operator>[^\\s{]+)\\s*\\{(?<values>[^}]*)\\}(?<fields>:\\S+)\\s*$");

    /**
     * Parse a fieldtext specifier - that is, a single 'OPERATOR{values}:fields' term, without any further operators.
     *
     * @param specifierString Fieldtext specifier string
     * @return Parsed specifier.  The operator is always upper-case, and the field names are always lower-case.
     * @throws IllegalArgumentException
     */
    public static Specifier parseSpecifier(final String specifierString) throws IllegalArgumentException {
        final Matcher matcher = specifierPattern.matcher(specifierString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Unexpected fieldtext specifier format: " + specifierString);
        }

        final String operator = matcher.group("operator"); // gets upper-cased by Specifier
        final List<String> fields = Arrays.stream(matcher.group("fields").split(":"))
                .skip(1)
                .map(field -> field.replace("%3A", ":").toLowerCase()).toList();
        final List<String> values = Arrays.stream(matcher.group("values").split(","))
                .map(value -> URLDecoder.decode(value.strip())).toList();

        return new Specifier(operator, fields, values);
    }

}
