/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests.identifier.reference;

import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.aci.content.identifier.reference.Reference;
import com.autonomy.aci.content.identifier.reference.References;
import com.autonomy.aci.content.identifier.reference.ReferencesBuilder;
import com.autonomy.integration.processor.FlatDocument;
import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.tests.ContentAbstractTest;
import com.autonomy.nonaci.indexing.impl.DreReplaceCommand;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ReferencesIntegrationTest
 */
public class ReferencesIntegrationTest extends ContentAbstractTest {
    private static final String CRAZY_REFERENCE = "!\"\u00A3$%^&*()-_+=[{]}: ;@'#~<,>.?/\\|\u00AC`¦\u20AC";

    @Test
    public void testNoReferences() {
        // An empty builder shouldn't match any documents
        final References references = new ReferencesBuilder();

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(references.getMatchParameterName(), references);

        assertEquals(0, content.executeAction(parameters, new FlatDocumentsProcessor()).size());
    }

    @Test
    public void testSingleReference() {
        final References references = new Reference("DREREF-2");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add("print", "reference");
        parameters.add(references.getMatchParameterName(), references);

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(1, documents.size());

        final FlatDocument document = documents.get(0);

        assertEquals("DREREF-2", document.getFirstContentFieldValue("DREREFERENCE"));
        assertEquals(CRAZY_REFERENCE, document.getFirstContentFieldValue("REFERENCE_FIELD"));
    }

    @Test
    public void testSingleAwkwardReference() {
        // Reference with a section number
        final References references = new Reference(CRAZY_REFERENCE, 1);

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(references.getMatchParameterName(), references);

        final FlatDocuments section = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(5), section.getIds());
    }

    @Test
    public void testMultipleReferences() {
        final References references = new Reference("DREREF-1").append("DOES+NOT+EXIST").append("DREREF-3");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(references.getMatchParameterName(), references);

        assertEquals(Arrays.asList(3, 1), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testMatchAndDontMatchReferences() {
        final References matchReferences = new Reference("DREREF-1").append("DREREF-DUP", 1);
        final References dontMatchReferences = new Reference("DREREF-1");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(matchReferences.getMatchParameterName(), matchReferences);
        parameters.add(dontMatchReferences.getDontMatchParameterName(), dontMatchReferences);

        assertEquals(Arrays.asList(5), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testGetContent() {
        final References references = new Reference("DREREF-2").append("DREREF-3");

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add(references.getGetContentParameterName(), references);

        assertEquals(Arrays.asList(2, 3), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testReplaceWithReference() {
        final References reference = new Reference(CRAZY_REFERENCE);

        final DreReplaceCommand replace = new DreReplaceCommand();
        replace.setReplaceAllRefs(true);

        replace.setPostData(
                "#" + reference.getIndexingIdentifierName() + " " + reference.toIndexingString() + "\n" +
                "#DREFIELDNAME REPLACEFIELD\n" +
                "#DREFIELDVALUE cats and dogs\n" +
                "#DREENDDATANOOP\n\n"
        );

        content.index(replace).blockUntilComplete();

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add("reference", new ReferencesBuilder("DREREF-1", "DREREF-2", "DREREF-3", "DREREF-DUP"));

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(1, 2, 3, 4 , 5), documents.getIds());

        assertNull(documents.get(0).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(1).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(2).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(3).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(4).getFirstContentFieldValue("REPLACEFIELD"));
    }

    @Test
    public void testReplaceWithReferencesBuilder() {
        // Note the section number shouldn't have any effect
        final References references = new ReferencesBuilder("DREREF-1").append("DREREF-DUP", 1);

        final DreReplaceCommand replace = new DreReplaceCommand();
        replace.setReplaceAllRefs(true);

        replace.setPostData(
                "#" + references.getIndexingIdentifierName() + " " + references.toIndexingString() + "\n" +
                "#DREFIELDNAME REPLACEFIELD\n" +
                "#DREFIELDVALUE cats and dogs\n" +
                "#DREENDDATANOOP\n\n"
        );

        content.index(replace).blockUntilComplete();

        final AciParameters parameters = new AciParameters("getcontent");
        parameters.add("reference", new ReferencesBuilder("DREREF-1", "DREREF-2", "DREREF-3", "DREREF-DUP"));

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(1, 2, 3, 4, 5), documents.getIds());

        assertEquals("cats and dogs", documents.get(0).getFirstContentFieldValue("REPLACEFIELD"));
        assertNull(documents.get(1).getFirstContentFieldValue("REPLACEFIELD"));
        assertNull(documents.get(2).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(3).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(4).getFirstContentFieldValue("REPLACEFIELD"));
    }
}
