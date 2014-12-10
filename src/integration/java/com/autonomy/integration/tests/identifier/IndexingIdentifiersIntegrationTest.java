/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests.identifier;

import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.tests.ContentAbstractTest;
import com.autonomy.aci.content.identifier.IndexingIdentifiers;
import com.autonomy.aci.content.identifier.id.IdsBuilder;
import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.nonaci.indexing.impl.DreReplaceCommand;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * IndexingIdentifiersIntegrationTest
 */
public class IndexingIdentifiersIntegrationTest extends ContentAbstractTest {
    @Test
    public void testReplaceAll() {
        final IndexingIdentifiers all = IndexingIdentifiers.ALL;

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + all.getIndexingIdentifierName() + " " + all.toIndexingString() + "\n" +
                "#DREFIELDNAME REPLACEFIELD\n" +
                "#DREFIELDVALUE cats and dogs\n" +
                "#DREENDDATANOOP\n\n"
        );

        content.index(replace).blockUntilComplete();

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add("id", new IdsBuilder(1, 2, 3, 4, 5));

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(1, 2, 3, 4, 5), documents.getIds());

        assertEquals("cats and dogs", documents.get(0).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(1).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(2).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(3).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(4).getFirstContentFieldValue("REPLACEFIELD"));
    }
}
