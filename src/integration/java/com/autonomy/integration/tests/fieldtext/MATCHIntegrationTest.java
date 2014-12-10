/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.tests.fieldtext;

import com.autonomy.aci.content.fieldtext.FieldText;
import com.autonomy.aci.content.fieldtext.MATCH;
import com.autonomy.aci.client.util.AciParameters;
import com.autonomy.integration.processor.FlatDocumentsProcessor;
import com.autonomy.integration.processor.FlatDocuments;
import com.autonomy.integration.tests.ContentAbstractTest;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MATCHTest
 */
public class MATCHIntegrationTest extends ContentAbstractTest {
    @Test
    public void testSimpleMatch() {
        final FieldText match = new MATCH("MATCH_FIELD", "ABC DEF 123");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("fieldtext", match);

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(3, 2), documents.getIds());
    }
    
    @Test
    public void testMatchCommaEscaping() {
        final FieldText match = new MATCH("MATCH_FIELD", "DEF GHI 1,2,3,4%2C");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("fieldtext", match);

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(3), documents.getIds());
    }

    @Test
    public void testAwkwardMatch() {
        final FieldText match = new MATCH("MATCH_FIELD", "!\"\u00A3$%^&*()-_+=[{]}: ;@'#~<,>.?/\\|\u00AC`¦\u20AC");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("fieldtext", match);

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(1), documents.getIds());
    }

    @Test
    public void testMultivaluedMatch() {
        final FieldText match = new MATCH("MATCH_FIELD", "DEF GHI 1,2,3,4%2C", "!\"\u00A3$%^&*()-_+=[{]}: ;@'#~<,>.?/\\|\u00AC`¦\u20AC");

        final AciParameters parameters = new AciParameters("query");
        parameters.add("fieldtext", match);

        final FlatDocuments documents = content.executeAction(parameters, new FlatDocumentsProcessor());

        assertEquals(Arrays.asList(3, 1), documents.getIds());
    }
}
