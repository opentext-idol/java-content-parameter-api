/*
 * $Id:$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author:$ on $Date:$
 */
package com.autonomy.integration.tests.sort;

import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.aci.content.sort.Sort;
import com.autonomy.aci.content.sort.SortBy;
import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.tests.ContentAbstractTest;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SortIntegrationTest
 */
public class SortIntegrationTest extends ContentAbstractTest {
    @Test
    public void testSortBy() {
        // Fields
        testSort(SortBy.AUTN_RANK, 5, 4, 3, 2, 1);
        testSort(SortBy.CLUSTER, 1, 3, 2, 4, 5);
        testSort(SortBy.DATABASE, 5, 4, 2, 1, 3);
        testSort(SortBy.DATE, 3, 1, 2, 5, 4);
        testSort(SortBy.DOC_ID_DECREASING, 5, 4, 3, 2, 1);
        testSort(SortBy.DOC_ID_INCREASING, 1, 2, 3, 4, 5);
        testSort(SortBy.OFF, 5, 4, 3, 2, 1);
        testSort(SortBy.RELEVANCE, 1, 3, 2, 4, 5);
        testSort(SortBy.REVERSE_DATE, 5, 4, 2, 1, 3);
        testSort(SortBy.REVERSE_RELEVANCE, 5, 4, 2, 3, 1);

        // Methods - the use of */ shouldn't affect the order but does test escaping
        testSort(SortBy.alphabetical("*/COLOR"), 2, 3, 1, 5, 4);
        testSort(SortBy.alphabetical("NUMERIC_FIELD"), 3, 1, 5, 4, 2);
        testSort(SortBy.decreasing("COLOR"), 5, 4, 1, 3, 2);
        testSort(SortBy.decreasing("*/NUMERIC_FIELD"), 3, 1, 2, 5, 4);
        testSort(SortBy.increasing("COLOR"), 2, 3, 1, 5, 4);
        testSort(SortBy.increasing("NUMERIC_FIELD"), 5, 4, 2, 3, 1);
        testSort(SortBy.numberDecreasing("*/NUMERIC_FIELD"), 3, 1, 2, 5, 4);
        testSort(SortBy.numberIncreasing("NUMERIC_FIELD"), 5, 4, 2, 3, 1);
        testSort(SortBy.reverseAlphabetical("COLOR"), 5, 4, 1, 3, 2);
        testSort(SortBy.reverseAlphabetical("NUMERIC_FIELD"), 2, 5, 4, 1, 3);

        // Combination of sorts - the ids are in a different order to all of the sorts above
        testSort(SortBy.decreasing("NUMERIC_FIELD").then(SortBy.REVERSE_DATE), 1, 3, 2, 5, 4);
    }

    @Test
    public void testSortByRandom() {
        // Here we test that the 'random' sort doesn't keep returning results in the same order

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "run, jump and see if you can spot a balloon");
        parameters.put("sort", SortBy.RANDOM);

        // Grab a reference document list against which to compare our subsequent queries
        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        if (!documents.isWarningsEmpty()) {
            fail(documents.warningsSize() + " warnings: " + documents.getWarning(0));
        }

        final List<Integer> ids = documents.getIds();
        boolean success = false;

        // If we get the same ids 25 times in a row, it isn't very random
        for (int index = 0 ; index < 25 ; ++index) {
            if (!ids.equals(content.executeAction(parameters, new FlatDocumentsProcessor()).getIds())) {
                success = true;
                break;
            }
        }

        if (!success) {
            fail("Ids were in the same order every time: " + StringUtils.join(ids, ","));
        }
    }

    private void testSort(final Sort sort, final Integer... ids) {
        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "run, jump and see if you can spot a balloon");
        parameters.put("sort", sort);

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        if (!documents.isWarningsEmpty()) {
            fail(documents.warningsSize() + " warnings: " + documents.getWarning(0));
        }

        assertEquals(Arrays.asList(ids), documents.getIds());
    }
}
