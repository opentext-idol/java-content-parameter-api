package com.hp.autonomy.aci.content.fieldtext;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FieldTextParserTest {

    @Test
    public void testParseSpecifier() {
        final Specifier parsed = FieldTextParser.parseSpecifier("MATCH{val}:testfield");
        final Specifier expected = new Specifier("MATCH", "testfield", "val");
        Assert.assertEquals(expected, parsed);
    }

    @Test
    public void testParseSpecifier_caseChanges() {
        final Specifier parsed = FieldTextParser.parseSpecifier("Match{Val}:TestField");
        final Specifier expected = new Specifier("MATCH", "testfield", "Val");
        Assert.assertEquals(expected, parsed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseSpecifier_noOperator() {
        FieldTextParser.parseSpecifier("{val}:testfield");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseSpecifier_noClosingBrace() {
        FieldTextParser.parseSpecifier("OP{val:testfield");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseSpecifier_multipleSpecifiers() {
        FieldTextParser.parseSpecifier("MATCH{val1}:field1 AND MATCH{val2}:field2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseSpecifier_not() {
        FieldTextParser.parseSpecifier("NOT MATCH{val}:testfield");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseSpecifier_noFields() {
        FieldTextParser.parseSpecifier("OP{val}");
    }

    @Test
    public void testParseSpecifier_multipleFields() {
        final Specifier parsed = FieldTextParser.parseSpecifier("MATCH{val}:field1:field2:field3");
        final Specifier expected = new Specifier("MATCH", List.of("field1", "field2", "field3"), "val");
        Assert.assertEquals(expected, parsed);
    }

    @Test
    public void testParseSpecifier_escapedField() {
        final Specifier parsed = FieldTextParser.parseSpecifier("MATCH{val}:test%3A%3Dfie%3Ald");
        final Specifier expected = new Specifier("MATCH", "test:%3dfie:ld", "val");
        Assert.assertEquals(expected, parsed);
    }

    @Test
    public void testParseSpecifier_multipleValues() {
        final Specifier parsed = FieldTextParser.parseSpecifier("OP{val1,val2,val3}:testfield");
        final Specifier expected = new Specifier("OP", "testfield", List.of("val1", "val2", "val3"));
        Assert.assertEquals(expected, parsed);
    }

    @Test
    public void testParseSpecifier_decodeValue() {
        final Specifier parsed = FieldTextParser.parseSpecifier("MATCH{val%2Cwith%7Dspecial%2Fchars}:testfield");
        final Specifier expected = new Specifier("MATCH", "testfield", "val,with}special/chars");
        Assert.assertEquals(expected, parsed);
    }

    @Test
    public void testParseSpecifier_whitespace() {
        final Specifier parsed = FieldTextParser.parseSpecifier(" MATCH\n{ val1 ,\tval2 }:field1:field2 ");
        final Specifier expected = new Specifier("MATCH", List.of("field1", "field2"), List.of("val1", "val2"));
        Assert.assertEquals(expected, parsed);
    }

}
