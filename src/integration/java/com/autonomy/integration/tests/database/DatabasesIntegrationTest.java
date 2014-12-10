/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests.database;

import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.aci.content.database.Databases;
import com.autonomy.aci.content.identifier.id.IdsBuilder;
import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.tests.ContentAbstractTest;
import com.autonomy.nonaci.indexing.impl.DreReplaceCommand;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * DatabasesIntegrationTest
 */
public class DatabasesIntegrationTest extends ContentAbstractTest {
    @Test
    public void testEmpty() {
        final Databases databases = new Databases();

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(databases.getMatchParameterName(), databases);

        assertEquals(0, content.executeAction(parameters, new FlatDocumentsProcessor()).size());
    }

    @Test
    public void testSingleDatabase() {
        final Databases databases = new Databases("Archive");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(databases.getMatchParameterName(), databases);

        assertEquals(Arrays.asList(3), content.executeAction(parameters, new FlatDocumentsProcessor()).getIds());
    }

    @Test
    public void testMultipleDatabases() {
        final Databases databases = new Databases("News", "Archive");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(databases.getMatchParameterName(), databases);

        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());
    }

    @Test
    public void testAll() {
        final Databases databases = Databases.ALL;

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(databases.getMatchParameterName(), databases);

        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());
    }

    @Test
    public void testStarAppend() {
        final Databases databases = new Databases("Archive").append("*");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");
        parameters.add(databases.getMatchParameterName(), databases);

        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());
    }

    @Test
    public void testReplaceSingleDatabase() {
        final Databases databases = new Databases("Archive");

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + databases.getIndexingIdentifierName() + " " + databases.toIndexingString() + "\n" +
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
        assertNull(documents.get(1).getFirstContentFieldValue("REPLACEFIELD"));
        assertEquals("cats and dogs", documents.get(2).getFirstContentFieldValue("REPLACEFIELD"));
    }

    @Test
    public void testReplaceMultipleDatabases() {
        final Databases databases = new Databases("News", "Archive");

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + databases.getIndexingIdentifierName() + " " + databases.toIndexingString() + "\n" +
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

    @Test
    public void testReplaceAllDatabases() {
        final Databases databases = Databases.ALL;

        final DreReplaceCommand replace = new DreReplaceCommand();

        replace.setPostData(
                "#" + databases.getIndexingIdentifierName() + " " + databases.toIndexingString() + "\n" +
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
    
    @Test
    public void testAssumptions() {
        // The following queries test the behaviour of IDOL, not the Databases class. This behaviour is important as it
        // determines the requirements for the Databases class, especially its parser
        final String databaseMatch = "databasematch";

        final AciParameters parameters = new AciParameters("query");
        parameters.add("text", "*");

        parameters.put(databaseMatch, "");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, " ");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, ",");
        assertEquals(0, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, "+");
        assertEquals(0, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, "*");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, "News,Archive");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, "News+Archive");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, "News Archive");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, "News\tArchive");
        assertEquals(0, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, " ,*");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, "*,News");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, ",+ *,News");
        assertEquals(5, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, "**");
        assertEquals(0, content.executeAction(parameters, new FlatDocumentsProcessor()).size());

        parameters.put(databaseMatch, " News ,*");
        assertEquals(4, content.executeAction(parameters, new FlatDocumentsProcessor()).size());
    }
}
