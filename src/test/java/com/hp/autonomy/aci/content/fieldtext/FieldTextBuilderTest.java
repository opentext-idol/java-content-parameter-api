/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
package com.hp.autonomy.aci.content.fieldtext;

import static com.hp.autonomy.aci.content.fieldtext.FieldTexts.AND;
import static com.hp.autonomy.aci.content.fieldtext.FieldTexts.MATCHNOTHING;
import static com.hp.autonomy.aci.content.fieldtext.FieldTexts.OR;
import static com.hp.autonomy.aci.content.fieldtext.FieldTexts.XOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the <tt>FieldTextBuilder</tt> class.
 *
 * @author darrelln
 * @author boba
 * @version $Revision$ $Date$
 */
public class FieldTextBuilderTest {

    private MATCH match1;
    private MATCH match2;
    private EQUAL equal;
    private FieldText mockMatchEqual;

    @Before
    public void setUp() {
        match1 = new MATCH("FIELD", "Value");
        match2 = new MATCH("TAG", "Contents");
        equal = new EQUAL("NUMBER", 7.8);
        mockMatchEqual = new FieldTextWrapper("MATCH{s}:TEXT+AND+EQUAL{7}:NUM", 2);
    }

    @Test
    public void testANDBuilderFactoryMethod() {
        final FieldText builder = AND();
        assertEquals("size()", 0, builder.size());
        assertTrue("isEmpty()", builder.isEmpty());
        assertEquals("toString()", "", builder.toString());
        assertEquals("hashCode()", "".hashCode(), builder.hashCode());

        assertEquals("AND", match1, AND().AND(match1));
        assertEquals("XOR", match1.NOT(), AND().XOR(match1));
        assertTrue("OR", AND().OR(match1).isEmpty());
    }

    @Test
    public void testORBuilderFactoryMethod() {
        final FieldText builder = OR();

        // These are not really invariants but they are interesting to check anyway
        assertEquals("size()", 1, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("toString()", "MATCH{MATCHNOTHING}:autn_date", builder.toString());

        assertEquals("OR", match1, OR().OR(match1));
        assertEquals("XOR", match1, OR().XOR(match1));
        assertTrue("AND", OR().AND(match1).isMatchNothing());
    }

    @Test
    public void testXORBuilderFactoryMethod() {
        final FieldText builder = XOR();

        // These are not really invariants but they are interesting to check anyway
        assertEquals("size()", 1, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("toString()", "MATCH{MATCHNOTHING}:autn_date", builder.toString());

        assertEquals("OR", match1, XOR().OR(match1));
        assertEquals("XOR", match1, XOR().XOR(match1));
        assertTrue("AND", XOR().AND(match1).isMatchNothing());
    }

    @Test
    public void testNonEmptyConstructor() {
        FieldText builder = new FieldTextBuilder(AND());
        assertEquals("toString()", "", builder.toString());
        assertEquals("size()", 0, builder.size());
        assertTrue("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", "".hashCode(), builder.hashCode());

        final String match1String = "MATCH{Value}:FIELD";
        
        builder = new FieldTextBuilder(match1);
        assertEquals("toString()", match1String, builder.toString());
        assertEquals("size()", 1, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", match1String.hashCode(), builder.hashCode());

        final String match1AND2String = "MATCH{Value}:FIELD+AND+MATCH{Contents}:TAG";
        
        builder = new FieldTextBuilder(match1.AND(match2));
        assertEquals("toString()", match1AND2String, builder.toString());
        assertEquals("size()", 2, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", match1AND2String.hashCode(), builder.hashCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException() {
        new FieldTextBuilder(null);
    }

    @Test
    public void testAND() {
        final String tripleAND = "MATCH{Value}:FIELD+AND+MATCH{Contents}:TAG+AND+EQUAL{7.8}:NUMBER";
        
        FieldText builder = new FieldTextBuilder(match1).AND(match2).AND(equal);
        assertEquals("toString()", tripleAND, builder.toString());
        assertEquals("size()", 3, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", tripleAND.hashCode(), builder.hashCode());

        builder = new FieldTextBuilder(match1).AND(new FieldTextBuilder(match2).AND(equal));
        assertEquals("toString()", tripleAND, builder.toString());
        assertEquals("size()", 3, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", tripleAND.hashCode(), builder.hashCode());
    }

    @Test
    public void testANDEmpty() {
        final FieldText builder1 = new FieldTextBuilder(match1).AND(AND());
        assertEquals("toString", "MATCH{Value}:FIELD", builder1.toString());
        assertEquals("size()", 1, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());

        final FieldText builder2 = AND().AND(match1);
        assertEquals("toString", "MATCH{Value}:FIELD", builder2.toString());
        assertEquals("size()", 1, builder2.size());
        assertFalse("isEmpty()", builder2.isEmpty());
    }

    @Test
    public void testANDMatchNothing() {
        final String matchNothing = "MATCH{MATCHNOTHING}:autn_date";

        final FieldText builder1 = new FieldTextBuilder(match1).AND(MATCHNOTHING);
        assertEquals("toString", matchNothing, builder1.toString());
        assertEquals("size()", 1, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());

        final FieldText builder2 = new FieldTextBuilder(MATCHNOTHING).AND(match1);
        assertEquals("toString", matchNothing, builder2.toString());
        assertEquals("size()", 1, builder2.size());
        assertFalse("isEmpty()", builder2.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testANDBuilderANDNullException() {
        AND().AND(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testORBuilderANDNullException() {
        OR().AND(null);
    }

    @Test
    public void testOR() {
        final String tripleOR = "MATCH{Value}:FIELD+OR+MATCH{Contents}:TAG+OR+EQUAL{7.8}:NUMBER";
        
        FieldText builder = new FieldTextBuilder(match1).OR(match2).OR(equal);
        assertEquals("toString()", tripleOR, builder.toString());
        assertEquals("size()", 3, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", tripleOR.hashCode(), builder.hashCode());

        builder = new FieldTextBuilder(match1).OR(new FieldTextBuilder(match2).OR(equal));
        assertEquals("toString()", tripleOR, builder.toString());
        assertEquals("size()", 3, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", tripleOR.hashCode(), builder.hashCode());
    }

    @Test
    public void testOREmpty() {
        final FieldText builder1 = new FieldTextBuilder(match1).OR(AND());
        assertEquals("toString", "", builder1.toString());
        assertEquals("size()", 0, builder1.size());
        assertTrue("isEmpty()", builder1.isEmpty());

        final FieldText builder2 = AND().OR(new FieldTextBuilder(match1));
        assertEquals("toString", "", builder2.toString());
        assertEquals("size()", 0, builder2.size());
        assertTrue("isEmpty()", builder2.isEmpty());
    }

    @Test
    public void testORMatchNothing() {
        final String match = "MATCH{Value}:FIELD";

        final FieldText builder1 = new FieldTextBuilder(match1).OR(MATCHNOTHING);
        assertEquals("toString", match, builder1.toString());
        assertEquals("size()", 1, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());

        final FieldText builder2 = new FieldTextBuilder(MATCHNOTHING).OR(match1);
        assertEquals("toString", match, builder2.toString());
        assertEquals("size()", 1, builder2.size());
        assertFalse("isEmpty()", builder2.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testORBuilderORNullException() {
        OR().OR(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testANDBuilderORNullException() {
        AND().OR(null);
    }

    @Test
    public void testXOR() {
        final String tripleXOR = "MATCH{Value}:FIELD+XOR+MATCH{Contents}:TAG+XOR+EQUAL{7.8}:NUMBER";

        FieldText builder = new FieldTextBuilder(match1).XOR(match2).XOR(equal);
        assertEquals("toString()", tripleXOR, builder.toString());
        assertEquals("size()", 3, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", tripleXOR.hashCode(), builder.hashCode());

        builder = new FieldTextBuilder(match1).XOR(new FieldTextBuilder(match2).XOR(equal));
        assertEquals("toString()", tripleXOR, builder.toString());
        assertEquals("size()", 3, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", tripleXOR.hashCode(), builder.hashCode());
    }

    @Test
    public void testXOREmpty() {
        final String notMatch = "NOT+MATCH{Value}:FIELD";

        final FieldText builder1 = new FieldTextBuilder(match1).XOR(AND());
        assertEquals("toString", notMatch, builder1.toString());
        assertEquals("size()", 1, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());
    }

    @Test
    public void testXORMatchNothing() {
        final String match = "MATCH{Value}:FIELD";

        final FieldText builder1 = new FieldTextBuilder(match1).XOR(MATCHNOTHING);
        assertEquals("toString", match, builder1.toString());
        assertEquals("size()", 1, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());

        final FieldText builder2 = new FieldTextBuilder(MATCHNOTHING).XOR(match1);
        assertEquals("toString", match, builder2.toString());
        assertEquals("size()", 1, builder2.size());
        assertFalse("isEmpty()", builder2.isEmpty());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testANDBuilderXORNullException() {
        AND().XOR(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testORBuilderXORNullException() {
        OR().XOR(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testXORBuilderXORNullException() {
        XOR().XOR(null);
    }

    @Test
    public void testNOT() {
        final String complexNOT1 = "NOT(NOT+MATCH{Value}:FIELD+AND+NOT+MATCH{Contents}:TAG)";
        
        final FieldText builder1 = new FieldTextBuilder(match1).NOT().AND(AND()).AND(new FieldTextBuilder(match2).NOT()).NOT();
        assertEquals("toString()", complexNOT1, builder1.toString());
        assertEquals("size()", 2, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());
        assertEquals("hashCode()", complexNOT1.hashCode(), builder1.hashCode());
        
        final String complexNOT1NOT = "NOT+MATCH{Value}:FIELD+AND+NOT+MATCH{Contents}:TAG";
        builder1.NOT();

        assertEquals("toString()", complexNOT1NOT, builder1.toString());
        assertEquals("size()", 2, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());
        assertEquals("hashCode()", complexNOT1NOT.hashCode(), builder1.hashCode());
        
        final String complexNOT2 = "NOT(MATCH{Value}:FIELD+AND+MATCH{Contents}:TAG)+AND+NOT+EQUAL{7.8}:NUMBER";
        
        final FieldText builder2 = new FieldTextBuilder(match1).AND(match2).NOT().AND(new FieldTextBuilder(equal).NOT());
        assertEquals("toString()", complexNOT2, builder2.toString());
        assertEquals("size()", 3, builder2.size());
        assertFalse("isEmpty()", builder2.isEmpty());
        assertEquals("hashCode()", complexNOT2.hashCode(), builder2.hashCode());
    }

    @Test
    public void testNOTEmpty() {
        final String matchNothing = "MATCH{MATCHNOTHING}:autn_date";

        final FieldText builder = AND().NOT();
        assertEquals("toString()", matchNothing, builder.toString());
        assertEquals("size()", 1, builder.size());
        assertFalse("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", matchNothing.hashCode(), builder.hashCode());

        builder.NOT();

        assertEquals("toString()", "", builder.toString());
        assertEquals("size()", 0, builder.size());
        assertTrue("isEmpty()", builder.isEmpty());
        assertEquals("hashCode()", "".hashCode(), builder.hashCode());
    }
    
    @Test
    public void testMixed() {
        final String mixed1 = "(MATCH{Value}:FIELD+AND+MATCH{Contents}:TAG+AND+EQUAL{7.8}:NUMBER)+OR+(NOT+MATCH{Value}:FIELD+AND+NOT+MATCH{Contents}:TAG)";
        
        final FieldText builder1 = new FieldTextBuilder(match1).AND(match2).AND(equal).OR(match1.NOT().AND(match2.NOT()));
        assertEquals("toString()", mixed1, builder1.toString());
        assertEquals("size()", 5, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());
        assertEquals("hashCode()", mixed1.hashCode(), builder1.hashCode());
        
        final FieldText builder2 = new FieldTextBuilder(match1.AND(match2.AND(equal))).OR(AND().AND(match1.NOT().AND(match2.NOT())));
        assertEquals("toString()", mixed1, builder2.toString());
        assertEquals("size()", 5, builder2.size());
        assertFalse("isEmpty()", builder2.isEmpty());
        assertEquals("hashCode()", mixed1.hashCode(), builder2.hashCode());
        
        final String mixed2 = "MATCH{s}:TEXT+AND+EQUAL{7}:NUM";
        
        final FieldText builder3 = new FieldTextBuilder(mockMatchEqual);
        assertEquals("toString()", mixed2, builder3.toString());
        assertEquals("size()", 2, builder3.size());
        assertFalse("isEmpty()", builder3.isEmpty());
        assertEquals("hashCode()", mixed2.hashCode(), builder3.hashCode());
        
        final String mixed3 = "MATCH{Value}:FIELD+AND+(MATCH{s}:TEXT+AND+EQUAL{7}:NUM)";
        
        final FieldText builder4 = new FieldTextBuilder(match1).AND(mockMatchEqual);
        assertEquals("toString()", mixed3, builder4.toString());
        assertEquals("size()", 3, builder4.size());
        assertFalse("isEmpty()", builder4.isEmpty());
        assertEquals("hashCode()", mixed3.hashCode(), builder4.hashCode());
        
        final String mixed4 = "(MATCH{s}:TEXT+AND+EQUAL{7}:NUM)+AND+MATCH{Value}:FIELD";
        
        final FieldText builder5 = new FieldTextBuilder(mockMatchEqual).AND(match1);
        assertEquals("toString()", mixed4, builder5.toString());
        assertEquals("size()", 3, builder5.size());
        assertFalse("isEmpty()", builder5.isEmpty());
        assertEquals("hashCode()", mixed4.hashCode(), builder5.hashCode());

        final String mixed5 = "MATCH{Value}:FIELD+XOR+NOT(EQUAL{7.8}:NUMBER+XOR+(MATCH{Contents}:TAG+AND+EQUAL{7.8}:NUMBER))";

        final FieldText builder6 = new FieldTextBuilder(match1).XOR(equal.XOR(match2.AND(equal)).NOT());
        assertEquals("toString()", mixed5, builder6.toString());
        assertEquals("size()", 4, builder6.size());
        assertFalse("isEmpty()", builder6.isEmpty());
        assertEquals("hashCode()", mixed5.hashCode(), builder6.hashCode());

        final String mixed6 = "MATCH{Value}:FIELD+AND+NOT(EQUAL{7.8}:NUMBER+XOR+(MATCH{Contents}:TAG+OR+EQUAL{7.8}:NUMBER))";

        final FieldText builder7 = new FieldTextBuilder(match1).AND(equal.XOR(match2.OR(equal)).NOT());
        assertEquals("toString()", mixed6, builder7.toString());
        assertEquals("size()", 4, builder7.size());
        assertFalse("isEmpty()", builder7.isEmpty());
        assertEquals("hashCode()", mixed6.hashCode(), builder7.hashCode());

        final String mixed7 = "MATCH{Value}:FIELD+AND+NOT+EQUAL{7.8}:NUMBER+AND+MATCH{Contents}:TAG";
        final FieldText builder8 = new FieldTextBuilder(match1).AND(equal.NOT().AND(match2));
        assertEquals("toString()", mixed7, builder8.toString());
        assertEquals("size()", 3, builder8.size());
        assertFalse("isEmpty()", builder8.isEmpty());
        assertEquals("hashCode()", mixed7.hashCode(), builder8.hashCode());
    }

    @Test
    public void testEquals() {
        final FieldText builder = new FieldTextBuilder(match1);
        assertTrue("equals() equal FieldText", builder.equals(match1));
        //noinspection EqualsWithItself
        assertTrue("equals() self", builder.equals(builder));
        //noinspection ObjectEqualsNull
        assertFalse("equals() null", builder.equals(null));
        assertFalse("equals() object", builder.equals(new Object()));
        assertFalse("equals() unequal builder", builder.equals(new FieldTextBuilder(match2)));
    }

    @Test
    public void testSelfAppendAND() {
        // Need to test both the single and multiple specifier cases because so much of FieldTextBuilder treats the two
        // cases differently due to bracketing... though in the case of this functionality it happens to be done the
        // same way in both cases this could easily change.

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A AND A => A
        builder1.AND(builder1);
        assertEquals("Self-appending toString()", "MATCH{Value}:FIELD", builder1.toString());
        assertEquals("Self-appending size()", 1, builder1.size());

        final FieldTextBuilder builder2 = new FieldTextBuilder(match1).OR(equal);

        // (A OR B) AND (A OR B) => A OR B
        builder2.AND(builder2);
        assertEquals("Self-appending toString()", "MATCH{Value}:FIELD+OR+EQUAL{7.8}:NUMBER", builder2.toString());
        assertEquals("Self-appending size()", 2, builder2.size());
    }

    @Test
    public void testEqualAppendAND() {
        // Similar to the previous testcase but the fieldtexts are equal, not identical

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A AND A => A
        builder1.AND(match1);
        assertEquals("MATCH{Value}:FIELD", builder1.toString());
        assertEquals(1, builder1.size());
    }

    @Test
    public void testSelfAppendOR() {
        // Need to test both the single and multiple specifier cases because so much of FieldTextBuilder treats the two
        // cases differently due to bracketing... though in the case of this functionality it happens to be done the
        // same way in both cases this could easily change.

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A OR A => A
        builder1.OR(builder1);
        assertEquals("Self-appending toString()", "MATCH{Value}:FIELD", builder1.toString());
        assertEquals("Self-appending size()", 1, builder1.size());

        final FieldTextBuilder builder2 = new FieldTextBuilder(match1).OR(equal);

        // (A OR B) OR (A OR B) => A OR B
        builder2.OR(builder2);
        assertEquals("Self-appending toString()", "MATCH{Value}:FIELD+OR+EQUAL{7.8}:NUMBER", builder2.toString());
        assertEquals("Self-appending size()", 2, builder2.size());
    }

    @Test
    public void testEqualAppendOR() {
        // Similar to the previous testcase but the fieldtexts are equal, not identical

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A OR A => A
        builder1.OR(match1);
        assertEquals("MATCH{Value}:FIELD", builder1.toString());
        assertEquals(1, builder1.size());
    }

    @Test
    public void testSelfAppendXOR() {
        // Need to test both the single and multiple specifier cases because so much of FieldTextBuilder treats the two
        // cases differently due to bracketing... though in the case of this functionality it happens to be done the
        // same way in both cases this could easily change.

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A OR A => 0
        builder1.XOR(builder1);
        assertEquals("Self-appending toString()", "MATCH{MATCHNOTHING}:autn_date", builder1.toString());
        assertEquals("Self-appending size()", 1, builder1.size());

        final FieldTextBuilder builder2 = new FieldTextBuilder(match1).OR(equal);

        // (A OR B) XOR (A OR B) => 0
        builder2.XOR(builder2);
        assertEquals("Self-appending toString()", "MATCH{MATCHNOTHING}:autn_date", builder2.toString());
        assertEquals("Self-appending size()", 1, builder2.size());
    }

    @Test
    public void testEqualAppendXOR() {
        // Similar to the previous testcase but the fieldtexts are equal, not identical

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A XOR A => 0
        builder1.XOR(match1);
        assertEquals("MATCH{MATCHNOTHING}:autn_date", builder1.toString());
        assertEquals(1, builder1.size());
    }

    @Test
    public void testWHEN() {
        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);
        builder1.WHEN(match2);

        assertEquals("Simple WHEN", "MATCH{Value}:FIELD+WHEN+MATCH{Contents}:TAG", builder1.toString());
    }

    @Test
    public void testSelfAppendWHEN() {
        // Need to test both the single and multiple specifier cases because so much of FieldTextBuilder treats the two
        // cases differently due to bracketing... though in the case of this functionality it happens to be done the
        // same way in both cases this could easily change.

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A WHEN A => A
        builder1.WHEN(builder1);
        assertEquals("Self-appending toString()", "MATCH{Value}:FIELD", builder1.toString());
        assertEquals("Self-appending size()", 1, builder1.size());
    }

    @Test
    public void testEqualAppendWHEN() {
        // Similar to the previous testcase but the fieldtexts are equal, not identical

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A WHEN A => A
        builder1.WHEN(match1);
        assertEquals("MATCH{Value}:FIELD", builder1.toString());
        assertEquals(1, builder1.size());
    }

    @Test
    public void testWHENMatchNothing() {
        final String matchNothing = "MATCH{MATCHNOTHING}:autn_date";

        final FieldText builder1 = new FieldTextBuilder(match1).WHEN(MATCHNOTHING);
        assertEquals("toString", matchNothing, builder1.toString());
        assertEquals("size()", 1, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());

        final FieldText builder2 = new FieldTextBuilder(MATCHNOTHING).WHEN(match1);
        assertEquals("toString", matchNothing, builder2.toString());
        assertEquals("size()", 1, builder2.size());
        assertFalse("isEmpty()", builder2.isEmpty());
    }

    @Test
    public void testWHENn() {
        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);
        builder1.WHEN(4, match2);

        assertEquals("Simple WHEN4", "MATCH{Value}:FIELD+WHEN4+MATCH{Contents}:TAG", builder1.toString());
    }

    @Test
    public void testSelfAppendWHENn() {
        // Need to test both the single and multiple specifier cases because so much of FieldTextBuilder treats the two
        // cases differently due to bracketing... though in the case of this functionality it happens to be done the
        // same way in both cases this could easily change.

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // Cannot assume that A WHENn A => A
        builder1.WHEN(2, builder1);
        assertEquals("Self-appending toString()", "MATCH{Value}:FIELD+WHEN2+MATCH{Value}:FIELD", builder1.toString());
        assertEquals("Self-appending size()", 2, builder1.size());
    }

    @Test
    public void testEqualAppendWHENn() {
        // Similar to the previous testcase but the fieldtexts are equal, not identical

        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);

        // A WHEN A can't be simplified
        builder1.WHEN(2, match1);
        assertEquals("MATCH{Value}:FIELD+WHEN2+MATCH{Value}:FIELD", builder1.toString());
        assertEquals(2, builder1.size());
    }

    @Test
    public void testWHENnMatchNothing() {
        final String matchNothing = "MATCH{MATCHNOTHING}:autn_date";

        final FieldText builder1 = new FieldTextBuilder(match1).WHEN(1, MATCHNOTHING);
        assertEquals("toString", matchNothing, builder1.toString());
        assertEquals("size()", 1, builder1.size());
        assertFalse("isEmpty()", builder1.isEmpty());

        final FieldText builder2 = new FieldTextBuilder(MATCHNOTHING).WHEN(1, match1);
        assertEquals("toString", matchNothing, builder2.toString());
        assertEquals("size()", 1, builder2.size());
        assertFalse("isEmpty()", builder2.isEmpty());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testWHENnWithInvalidDepth() {
        new FieldTextBuilder(match1).WHEN(0, match2);
    }

    @Test
    public void testWHENandANDMix() {
        // TODO: Is this case actually well-defined or should we throw an IllegalStateException?
        final FieldTextBuilder builder1 = new FieldTextBuilder(match1);
        builder1.WHEN(match2).AND(equal);

        assertEquals("WHEN then AND", "(MATCH{Value}:FIELD+WHEN+MATCH{Contents}:TAG)+AND+EQUAL{7.8}:NUMBER", builder1.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void testWHENThisTooSmall() {
        AND().WHEN(match1);
    }

    @Test(expected = IllegalStateException.class)
    public void testWHENnThisTooSmall() {
        AND().WHEN(2, match1);
    }

//    @Test(expected = IllegalStateException.class)
//    public void testWHENThisTooBig() {
//        new FieldTextBuilder(match1.AND(match2)).WHEN(equal);
//    }

//    @Test(expected = IllegalStateException.class)
//    public void testWHENnThisTooBig() {
//        new FieldTextBuilder(match1.AND(match2)).WHEN(2, equal);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void testWHENArgumentTooSmall() {
        new FieldTextBuilder(match1).WHEN(AND());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWHENnArgumentTooSmall() {
        new FieldTextBuilder(match1).WHEN(2, AND());
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testWHENArgumentTooBig() {
//        new FieldTextBuilder(equal).WHEN(match1.AND(match2));
//    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testWHENnArgumentTooBig() {
//        new FieldTextBuilder(equal).WHEN(2, match1.AND(match2));
//    }

    @Test
    public void testFromSpecifier() {
        final FieldTextBuilder builder = FieldTextBuilder.from(new MATCH("FIELD", "VALUE"));

        assertEquals("MATCH{VALUE}:FIELD", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test
    public void testFromBuilder() {
        final FieldTextBuilder original = AND(new MATCH("FIELD", "VALUE"));
        final FieldTextBuilder builder = FieldTextBuilder.from(original);

        assertSame(original, builder);
        assertEquals("MATCH{VALUE}:FIELD", builder.toString());
        assertEquals(1, builder.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromNullException() {
        FieldTextBuilder.from(null);
    }
}
