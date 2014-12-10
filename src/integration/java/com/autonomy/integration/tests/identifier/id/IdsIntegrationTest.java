/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests.identifier.id;

import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.aci.content.identifier.id.Id;
import com.autonomy.aci.content.identifier.id.Ids;
import com.autonomy.aci.content.identifier.id.IdsBuilder;
import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.tests.ContentAbstractTest;
import com.autonomy.nonaci.indexing.impl.DreReplaceCommand;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IdsIntegrationTest
 */
public class IdsIntegrationTest extends ContentAbstractTest {

    @Test
    public void testNoIds() throws InterruptedException {
        // An empty builder shouldn't match any documents
        final Ids id = new IdsBuilder();

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(id.getMatchParameterName(), id);

        assertEquals(0, content.executeAction(parameters, new FlatDocumentsProcessor()).size());
    }

    @Test
    public void testSingleId() throws InterruptedException {
        final Ids id = new Id(1);

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(id.getMatchParameterName(), id);

        assertEquals(Arrays.asList(1), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testMultipleIds() throws InterruptedException {
        final Ids id = new Id(1).append(3);

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(id.getMatchParameterName(), id);

        assertEquals(Arrays.asList(3, 1), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testMatchAndDontMatchIds() throws InterruptedException {
        final Ids matchIds = new Id(1).append(3);
        final Ids dontMatchIds = new Id(1);

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(matchIds.getMatchParameterName(), matchIds);
        parameters.add(dontMatchIds.getDontMatchParameterName(), dontMatchIds);

        assertEquals(Arrays.asList(3), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testGetContent() throws InterruptedException {
        final Ids id = new Id(2).append(3);

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add(id.getGetContentParameterName(), id);

        assertEquals(Arrays.asList(2, 3), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testReplaceWithId() {
        final Ids id = new Id(2);

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + id.getIndexingIdentifierName() + " " + id.toIndexingString() + "\n" +
                "#DREFIELDNAME REPLACEFIELD\n" +
                "#DREFIELDVALUE cats and dogs\n" +
                "#DREENDDATANOOP\n\n"
        );

        content.index(replace).blockUntilComplete();

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add("id", new IdsBuilder(1, 2, 3));

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(1, 2, 3), documents.getIds());

        assertNull(documents.get(0).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(1).getFirstContentFieldValue("REPLACEFIELD"));
        assertNull(documents.get(2).getFirstContentFieldValue("REPLACEFIELD"));
    }

    @Test
    public void testReplaceWithIdsBuilder() {
        final Ids id = new IdsBuilder(1, 3);

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + id.getIndexingIdentifierName() + " " + id.toIndexingString() + "\n" +
                "#DREFIELDNAME REPLACEFIELD\n" +
                "#DREFIELDVALUE cats and dogs\n" +
                "#DREENDDATANOOP\n\n"
        );

        content.index(replace).blockUntilComplete();

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add("id", new IdsBuilder(1, 2, 3));

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(1, 2, 3), documents.getIds());

        assertEquals("cats and dogs", documents.get(0).getFirstContentFieldValue("REPLACEFIELD"));
        assertNull(documents.get(1).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(2).getFirstContentFieldValue("REPLACEFIELD"));
    }
}
