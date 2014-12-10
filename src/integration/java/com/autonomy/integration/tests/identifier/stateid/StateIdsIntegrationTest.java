/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests.identifier.stateid;

import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.aci.content.identifier.id.Id;
import com.autonomy.aci.content.identifier.id.Ids;
import com.autonomy.aci.content.identifier.id.IdsBuilder;
import com.autonomy.aci.content.identifier.stateid.StateId;
import com.autonomy.aci.content.identifier.stateid.StateIds;
import com.autonomy.aci.content.identifier.stateid.StateIdsBuilder;
import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.tests.ContentAbstractTest;
import com.autonomy.nonaci.indexing.impl.DreReplaceCommand;

import java.util.Arrays;

import org.apache.commons.lang.Validate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * StateIdsIntegrationTest
 */
public class StateIdsIntegrationTest extends ContentAbstractTest {
    @Test
    public void testNoStateIds() throws InterruptedException {
        // An empty builder shouldn't match any documents
        final StateIds stateIds = new StateIdsBuilder();

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(stateIds.getMatchParameterName(), stateIds);

        assertEquals(0, content.executeAction(parameters, new FlatDocumentsProcessor()).size());
    }

    @Test
    public void testSingleStateId() throws InterruptedException {
        final StateId stateId = new StateId(stateTokenFor(new Id(1)));

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(stateId.getMatchParameterName(), stateId);

        assertEquals(Arrays.asList(1), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testMultipleStateIds() throws InterruptedException {
        final StateIds stateIds = new StateId(stateTokenFor(new Id(1))).append(stateTokenFor(new Id(3)));

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(stateIds.getMatchParameterName(), stateIds);

        assertEquals(Arrays.asList(3, 1), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testMatchAndDontMatchIds() throws InterruptedException {
        final String stateToken = stateTokenFor(new Id(1));

        final StateId stateDontMatchIds = new StateId(stateToken);
        final StateIds stateMatchIds = new StateId(stateToken).append(stateTokenFor(new Id(3)));

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(stateMatchIds.getMatchParameterName(), stateMatchIds);
        parameters.add(stateDontMatchIds.getDontMatchParameterName(), stateDontMatchIds);

        assertEquals(Arrays.asList(3), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testGetContent() throws InterruptedException {
        final StateIds stateIds = new StateId(stateTokenFor(new Id(2))).append(stateTokenFor(new Id(3)));

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add(stateIds.getGetContentParameterName(), stateIds);

        assertEquals(Arrays.asList(2, 3), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testGetContentWithStateIdRange() {
        final StateId stateId = new StateId(stateTokenFor(new IdsBuilder(4, 3, 2))).forRange(0, 1);

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add("text", "*");
        parameters.add(stateId.getGetContentParameterName(), stateId);

        assertEquals(Arrays.asList(4, 3), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testReplaceWithStateId() {
        final StateId stateId = new StateId(stateTokenFor(new Id(2)));

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + stateId.getIndexingIdentifierName() + " " + stateId.toIndexingString() + "\n" +
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
    public void testReplaceWithStateIdRange() {
        final StateId stateId = new StateId(stateTokenFor(new IdsBuilder(2, 3, 4))).forDocument(1);

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + stateId.getIndexingIdentifierName() + " " + stateId.toIndexingString() + "\n" +
                "#DREFIELDNAME REPLACEFIELD\n" +
                "#DREFIELDVALUE cats and dogs\n" +
                "#DREENDDATANOOP\n\n"
        );

        content.index(replace).blockUntilComplete();

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add("id", new IdsBuilder(1, 2, 3, 4));

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(1, 2, 3, 4), documents.getIds());

        assertNull(documents.get(0).getFirstContentFieldValue("REPLACEFIELD"));
        assertNull(documents.get(1).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(2).getFirstContentFieldValue("REPLACEFIELD"));
        assertNull(documents.get(3).getFirstContentFieldValue("REPLACEFIELD"));
    }
    
    @Test
    public void testReplaceWithStateIdsBuilder() {
        final StateIds stateIds = new StateIdsBuilder(stateTokenFor(new Id(1)), stateTokenFor(new Id(3)));

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + stateIds.getIndexingIdentifierName() + " " + stateIds.toIndexingString() + "\n" +
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

    private String stateTokenFor(final Ids ids) {
        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add("storestate", true);
        parameters.add(ids.getMatchParameterName(), ids);

        final String stateToken = content.executeAction(parameters, new FlatDocumentsProcessor()).getStateToken();

        Validate.notNull(stateToken);

        return stateToken;
    }
}
