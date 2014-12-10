/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;

import org.apache.commons.lang.Validate;

/**
 * A simple representation of a 'flat' &lt;autn:hit&gt; document. Documents indexed using IDX are 'flat'.
 */
public class FlatDocument {
    private final Map<String, String> autnFields = new HashMap<String, String>();
    private final Map<String, List<String>> contentFields = new HashMap<String, List<String>>();

    void setAutnFieldValue(final String name, final String value) {
        Validate.notEmpty(name);
        Validate.isTrue(!autnFields.containsKey(autnize(name)), "Value already set: " + name);

        autnFields.put(autnize(name), value);
    }

    void addContentFieldValue(final String name, final String value) {
        List<String> values = contentFields.get(name);

        if (values == null) {
            values = new ArrayList<String>();
            contentFields.put(name, values);
        }

        values.add(value);
    }

    int getId() {
        return Integer.parseInt(getAutnFieldValue("id"));
    }

    private String getAutnFieldValue(final String name) {
        return autnFields.get(autnize(name));
    }

    public String getFirstContentFieldValue(final String name) {
        final List<String> values = getContentFieldValues(name);

        if (values.isEmpty()) {
            return null;
        }
        
        return values.get(0);
    }

    private List<String> getContentFieldValues(final String name) {
        final List<String> values = contentFields.get(name);

        if (values == null) {
            return Collections.emptyList();
        }

        return Collections.unmodifiableList(values);
    }

    private static String autnize(final String field) {
        if (field.startsWith("autn:")) {
            return field;
        }

        return "autn:" + field;
    }
}
