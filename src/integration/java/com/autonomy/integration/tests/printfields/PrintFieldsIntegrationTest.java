/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests.printfields;

import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.aci.content.printfields.PrintFields;
import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.tests.ContentAbstractTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * PrintFieldsIntegrationTest
 */
public class PrintFieldsIntegrationTest extends ContentAbstractTest {
    @Test
    public void testPrintFields() {
        final AciParameters parameters = new AciParameters("query");
        parameters.put("text", "*");
        parameters.put("matchid", 1);

        // PrintFields 1: empty
        final PrintFields printFields = new PrintFields();
        parameters.put("printfields", printFields);

        FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertNull(documents.get(0).getFirstContentFieldValue("COLOR"));
        assertNull(documents.get(0).getFirstContentFieldValue("DATABASE"));

        // PrintFields 2: COLOR
        printFields.append("*/COLOR");
        parameters.put("printfields", printFields);

        documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals("RED", documents.get(0).getFirstContentFieldValue("COLOR"));
        assertNull(documents.get(0).getFirstContentFieldValue("DATABASE"));

        // PrintFields 3: COLOR and DATABASE
        printFields.append("DATABASE");
        parameters.put("printfields", printFields);

        documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals("RED", documents.get(0).getFirstContentFieldValue("COLOR"));
        assertEquals("News", documents.get(0).getFirstContentFieldValue("DATABASE"));
    }
}
