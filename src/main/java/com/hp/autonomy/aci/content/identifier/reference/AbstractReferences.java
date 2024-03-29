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
package com.hp.autonomy.aci.content.identifier.reference;

import com.hp.autonomy.aci.content.identifier.DocumentIdentifiers;
import com.hp.autonomy.aci.content.identifier.IndexingIdentifiers;
import com.hp.autonomy.aci.content.identifier.QueryIdentifiers;

import java.util.UUID;

/**
 * An abstract base-class that partially implements the {@link References} interface using sensible defaults.
 */
public abstract class AbstractReferences implements References {

    // Stringifier just converts a Reference to a String. This is needed because we need subtly different string
    // representations for queries and indexing.
    private interface Stringifier {
        String toString(Reference reference);
    }

    private static final Stringifier ACI_STRINGIFIER = new Stringifier() {
        @Override
        public String toString(final Reference reference) {
            return reference.toString();
        }
    };

    private static final Stringifier INDEXING_STRINGIFIER = new Stringifier() {
        @Override
        public String toString(final Reference reference) {
            return reference.toIndexingString();
        }
    };

    private static final String MATCH_NOTHING = "MATCH_NOTHING_" + UUID.randomUUID().toString();

    /**
     *
     * @return {@code "matchreference"} or equivalent
     */
    @Override
    public String getMatchParameterName() {
        return QueryIdentifiers.MATCH_REFERENCE;
    }

    /**
     *
     * @return {@code "DREDOCREF"} or equivalent
     */
    @Override
    public String getIndexingIdentifierName() {
        return IndexingIdentifiers.DREDOCREF;
    }

    /**
     *
     * @return {@code "dontmatchreference"} or equivalent
     */
    @Override
    public String getDontMatchParameterName() {
        return DocumentIdentifiers.DONT_MATCH_REFERENCE;
    }

    /**
     *
     * @return {@code "reference"} or equivalent
     */
    @Override
    public String getGetContentParameterName() {
        return DocumentIdentifiers.REFERENCE;
    }

    @Override
    public String toIndexingString() {
        return toString(INDEXING_STRINGIFIER);
    }

    @Override
    public References append(final String reference, final int section) {
        return new ReferencesBuilder(this).append(reference, section);
    }

    @Override
    public References append(final String... references) {
        return new ReferencesBuilder(this).append(references);
    }

    @Override
    public References append(final Iterable<?>... references) {
        return new ReferencesBuilder(this).append(references);
    }

    /**
     * Simple implementation that tests for emptiness using <tt>size() == 0</tt>. In most cases this should be
     * overridden with a better implementation.
     *
     * @return <tt>true</tt> if and only if size is 0.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Simple implementation that calculates the size by counting the number of elements in the iterator. In most cases
     * this should be overridden with a better implementation.
     *
     * @return {@inheritDoc}
     */
    @Override
    public int size() {
        int size = 0;

        for (final Reference ref : this) {
            ++size;
        }

        return size;
    }

    @Override
    public boolean equals(final Object obj) {
        return obj == this || obj instanceof References && toString().equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return toString(ACI_STRINGIFIER);
    }

    private String toString(final Stringifier stringifier) {
        if (isEmpty()) {
            return MATCH_NOTHING;
        }

        final StringBuilder builder = new StringBuilder();

        for (final Reference reference : this) {
            if (reference == null) {
                throw new IllegalStateException("Unexpected null reference in iterator");
            }

            builder.append(stringifier.toString(reference)).append('+');
        }

        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }
}
