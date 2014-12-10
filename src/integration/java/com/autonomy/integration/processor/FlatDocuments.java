/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;

/**
 * FlatDocuments represents a list of results, all of which are 'flat' documents.
 */
public class FlatDocuments {
    private final List<FlatDocument> documents = new ArrayList<FlatDocument>();
    private final List<String> warnings = new ArrayList<String>();
    private String stateToken;

    void add(final FlatDocument document) {
        documents.add(document);
    }

    void addWarning(final String warning) {
        warnings.add(warning);
    }

    public FlatDocument get(final int index) {
        return documents.get(index);
    }

    public String getWarning(final int index) {
        return warnings.get(index);
    }

    public int size() {
        return documents.size();
    }

    public int warningsSize() {
        return warnings.size();
    }

    public boolean isWarningsEmpty() {
        return warningsSize() == 0;
    }
    
    public String getStateToken() {
        return stateToken;
    }

    void setStateToken(final String stateToken) {
        Validate.notNull(stateToken);

        if (this.stateToken != null) {
            throw new IllegalStateException("Can only set the state token once");
        }

        this.stateToken = stateToken;
    }

    public int getId(final int index) {
        return get(index).getId();
    }

    public List<Integer> getIds() {
        final List<Integer> ids = new ArrayList<Integer>(size());

        for (final FlatDocument document : documents) {
            ids.add(document.getId());
        }
        
        return ids;
    }
}
