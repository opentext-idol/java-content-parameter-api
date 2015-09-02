/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.aci.content.sort;

import com.autonomy.aci.client.util.AciURLCodec;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.util.Collections;
import java.util.Iterator;

/**
 * Class to represent the various sort specifiers. e.g.
 *
 * <pre> 
 * String sort = SortBy.RELEVANCE
 *               .then(SortBy.alphabetical("VIRTUALPATHNAME"))
 *               .then(SortBy.AUTN_RANK)
 *               .toString();
 * </pre>
 *
 * Instances are accessed via static fields or methods. All instances of {@code SortBy} should be immutable, though this
 * class is not {@code final} to allow extensions for sort specifiers that do not currently exist.
 */
public class SortBy extends AbstractSort {
    private final String sort;
    
    public static final SortBy AUTN_RANK = new SortBy("autnrank");
    public static final SortBy CLUSTER = new SortBy("cluster");
    public static final SortBy DATABASE = new SortBy("database");
    public static final SortBy DATE = new SortBy("date");
    public static final SortBy DOC_ID_DECREASING = new SortBy("dociddecreasing");
    public static final SortBy DOC_ID_INCREASING = new SortBy("docidincreasing");
    public static final SortBy OFF = new SortBy("off");
    public static final SortBy RANDOM = new SortBy("random");
    public static final SortBy RELEVANCE = new SortBy("relevance");
    public static final SortBy REVERSE_DATE = new SortBy("reversedate");
    public static final SortBy REVERSE_RELEVANCE = new SortBy("reverserelevance");

    /**
     * Constructor for creating a {@code SortBy} that only requires a specifier name.
     * <p/>
     * This constructor is {@code protected} to discourage its use, not because a subclass is strictly required. All of
     * the current sort specifiers of this form exist as immutable, static fields of this class.
     *
     * @param sort The specifier name
     */
    protected SortBy(final String sort) {
        Validate.isTrue(StringUtils.isNotBlank(sort), "Sort must not be blank");
        this.sort = sort;
    }

    /**
     * Constructor for creating a {@code SortBy} that requires both a specifier name and a field name.
     * <p/>
     * This constructor is {@code protected} to discourage its use, not because a subclass is strictly required. All of
     * the current sort specifiers of this form can be created via static methods of this class.
     *
     * @param sort The specifier name
     * @param fieldname The field name
     */
    protected SortBy(final String sort, final String fieldname) {
        Validate.isTrue(StringUtils.isNotBlank(sort), "Sort must not be blank");
        Validate.isTrue(StringUtils.isNotBlank(fieldname), "Fieldname must not be blank");

        this.sort = AciURLCodec.getInstance().encode(fieldname) + ':' + sort;
    }

    /**
     * Creates an <tt>alphabetical</tt> sort specifier for the given field name.
     *
     * @param fieldname The field name
     * @return A new specifier
     */
    public static SortBy alphabetical(final String fieldname) {
        return new SortBy("alphabetical", fieldname);
    }

    /**
     * Creates a <tt>decreasing</tt> sort specifier for the given field name.
     *
     * @param fieldname The field name
     * @return A new specifier
     */
    public static SortBy decreasing(final String fieldname) {
        return new SortBy("decreasing", fieldname);
    }

    /**
     * Creates an <tt>increasing</tt> sort specifier for the given field name.
     *
     * @param fieldname The field name
     * @return A new specifier
     */
    public static SortBy increasing(final String fieldname) {
        return new SortBy("increasing", fieldname);
    }

    /**
     * Creates a <tt>numberdecreasing</tt> sort specifier for the given field name.
     *
     * @param fieldname The field name
     * @return A new specifier
     */
    public static SortBy numberDecreasing(final String fieldname) {
        return new SortBy("numberdecreasing", fieldname);
    }

    /**
     * Creates a <tt>numberincreasing</tt> sort specifier for the given field name.
     *
     * @param fieldname The field name
     * @return A new specifier
     */
    public static SortBy numberIncreasing(final String fieldname) {
        return new SortBy("numberincreasing", fieldname);
    }
    
    /**
     * Creates a <tt>reversealphabetical</tt> sort specifier for the given field name.
     *
     * @param fieldname The field name
     * @return A new specifier
     */
    public static SortBy reverseAlphabetical(final String fieldname) {
        return new SortBy("reversealphabetical", fieldname);
    }

    /**
     * An iterator that just contains {@code this}. Elements cannot be removed.
     *
     * @return An iterator
     */
    @Override
    public Iterator<SortBy> iterator() {
        // Should probably rewrite this to use a custom iterator
        return Collections.singletonList(this).iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return sort;
    }
}
