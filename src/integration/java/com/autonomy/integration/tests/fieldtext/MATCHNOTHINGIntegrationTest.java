/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests.fieldtext;

import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.aci.content.fieldtext.FieldTexts;
import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.tests.ContentAbstractTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MATCHNOTHINGTest
 */
public class MATCHNOTHINGIntegrationTest extends ContentAbstractTest {
    @Test
    public void testMATCHNOTHING() {
        final AciParameters parameters = new AciParameters("query");
        parameters.add("fieldtext", FieldTexts.MATCHNOTHING);

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(0, documents.size());
    }
}
