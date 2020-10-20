/*
 * (c) Copyright 2009-2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */
package com.hp.autonomy.aci.content.fieldtext;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * FieldTextsTest
 */
public class FieldTextsTest {

    @Test
    public void testANDNothing() {
        // Create a builder suitable for ANDing
        final FieldTextBuilder builder = FieldTexts.AND();

        builder.AND(new EQUAL("FIELD", 1, 2));

        assertEquals("EQUAL{1,2}:FIELD", builder.toString());
    }

    @Test
    public void testANDVarArgs() {
        final FieldTextBuilder single = FieldTexts.AND(new EQUAL("FIELD", 1, 2));
        assertEquals("single toString()", "EQUAL{1,2}:FIELD", single.toString());

        final FieldTextBuilder pair = FieldTexts.AND(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"));
        assertEquals("pair toString()", "EQUAL{1,2}:FIELD+AND+MATCH{dog}:TEXT", pair.toString());

        final FieldTextBuilder triple = FieldTexts.AND(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"), new EQUAL("NUM", 0));
        assertEquals("triple toString()", "EQUAL{1,2}:FIELD+AND+MATCH{dog}:TEXT+AND+EQUAL{0}:NUM", triple.toString());
    }

    @Test
    public void testANDIterable() {
        final FieldTextBuilder single = FieldTexts.AND(Collections.singletonList(new EQUAL("FIELD", 1, 2)));
        assertEquals("single toString()", "EQUAL{1,2}:FIELD", single.toString());

        final FieldTextBuilder pair = FieldTexts.AND(Arrays.asList(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog")));
        assertEquals("pair toString()", "EQUAL{1,2}:FIELD+AND+MATCH{dog}:TEXT", pair.toString());

        final FieldTextBuilder triple = FieldTexts.AND(Arrays.asList(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"), new EQUAL("NUM", 0)));
        assertEquals("triple toString()", "EQUAL{1,2}:FIELD+AND+MATCH{dog}:TEXT+AND+EQUAL{0}:NUM", triple.toString());
    }

    @Test
    public void testORNothing() {
        // Create a builder suitable for ORing
        final FieldTextBuilder builder = FieldTexts.OR();

        builder.OR(new EQUAL("FIELD", 1, 2));

        assertEquals("EQUAL{1,2}:FIELD", builder.toString());
    }

    @Test
    public void testORVarArgs() {
        final FieldTextBuilder single = FieldTexts.OR(new EQUAL("FIELD", 1, 2));
        assertEquals("single toString()", "EQUAL{1,2}:FIELD", single.toString());

        final FieldTextBuilder pair = FieldTexts.OR(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"));
        assertEquals("pair toString()", "EQUAL{1,2}:FIELD+OR+MATCH{dog}:TEXT", pair.toString());

        final FieldTextBuilder triple = FieldTexts.OR(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"), new EQUAL("NUM", 0));
        assertEquals("triple toString()", "EQUAL{1,2}:FIELD+OR+MATCH{dog}:TEXT+OR+EQUAL{0}:NUM", triple.toString());
    }

    @Test
    public void testORIterable() {
        final FieldTextBuilder single = FieldTexts.OR(Collections.singletonList(new EQUAL("FIELD", 1, 2)));
        assertEquals("single toString()", "EQUAL{1,2}:FIELD", single.toString());

        final FieldTextBuilder pair = FieldTexts.OR(Arrays.asList(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog")));
        assertEquals("pair toString()", "EQUAL{1,2}:FIELD+OR+MATCH{dog}:TEXT", pair.toString());

        final FieldTextBuilder triple = FieldTexts.OR(Arrays.asList(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"), new EQUAL("NUM", 0)));
        assertEquals("triple toString()", "EQUAL{1,2}:FIELD+OR+MATCH{dog}:TEXT+OR+EQUAL{0}:NUM", triple.toString());
    }

    @Test
    public void testXORNothing() {
        // Create a builder suitable for XORing
        final FieldTextBuilder builder = FieldTexts.XOR();

        builder.XOR(new EQUAL("FIELD", 1, 2));

        assertEquals("EQUAL{1,2}:FIELD", builder.toString());
    }

    @Test
    public void testXORVarArgs() {
        final FieldTextBuilder single = FieldTexts.XOR(new EQUAL("FIELD", 1, 2));
        assertEquals("single toString()", "EQUAL{1,2}:FIELD", single.toString());

        final FieldTextBuilder pair = FieldTexts.XOR(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"));
        assertEquals("pair toString()", "EQUAL{1,2}:FIELD+XOR+MATCH{dog}:TEXT", pair.toString());

        final FieldTextBuilder triple = FieldTexts.XOR(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"), new EQUAL("NUM", 0));
        assertEquals("triple toString()", "EQUAL{1,2}:FIELD+XOR+MATCH{dog}:TEXT+XOR+EQUAL{0}:NUM", triple.toString());
    }

    @Test
    public void testXORIterable() {
        final FieldTextBuilder single = FieldTexts.XOR(Collections.singletonList(new EQUAL("FIELD", 1, 2)));
        assertEquals("single toString()", "EQUAL{1,2}:FIELD", single.toString());

        final FieldTextBuilder pair = FieldTexts.XOR(Arrays.asList(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog")));
        assertEquals("pair toString()", "EQUAL{1,2}:FIELD+XOR+MATCH{dog}:TEXT", pair.toString());

        final FieldTextBuilder triple = FieldTexts.XOR(Arrays.asList(new EQUAL("FIELD", 1, 2), new MATCH("TEXT", "dog"), new EQUAL("NUM", 0)));
        assertEquals("triple toString()", "EQUAL{1,2}:FIELD+XOR+MATCH{dog}:TEXT+XOR+EQUAL{0}:NUM", triple.toString());
    }

    @Test
    public void testNOT() {
        final FieldTextBuilder not = FieldTexts.NOT(new EQUAL("FIELD", 1, 2));
        assertEquals("NOT+EQUAL{1,2}:FIELD", not.toString());
    }
}
