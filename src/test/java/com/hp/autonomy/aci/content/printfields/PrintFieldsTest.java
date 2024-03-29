/*
 * Copyright 2009-2015 Open Text.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Open Text and its affiliates
 * and licensors ("Open Text") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Open Text shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.hp.autonomy.aci.content.printfields;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the <TT>PrintFields</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class PrintFieldsTest {

    @Test
    public void testAppend() {
        final PrintFields printfields = new PrintFields("DOCUMENT/TITLE", "*/NS:FIELD")
                                  .append("DRETITLE")
                                  .append(new PrintFields("*/NS:FIELD", "*/SUBJECT"));
        
        assertEquals("Complex printfields not as expected", "DOCUMENT/TITLE+*/NS:FIELD+DRETITLE+*/SUBJECT", printfields.toString());
        assertEquals("Complex printfields size not as expected", 4, printfields.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSpaceException() {
        new PrintFields("Outer space");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorCommaException() {
        new PrintFields("comma,comma");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorPlusException() {
        new PrintFields("plus+plus");
    }

    @Test
    public void testParse() {
        assertTrue(PrintFields.parse("").isEmpty());
        assertEquals("", PrintFields.parse("").toString());

        assertTrue(PrintFields.parse("  ,, ++\t\n\r  ").isEmpty());
        assertEquals("", PrintFields.parse("  ,, ++\t\n\r  ").toString());

        final PrintFields printFields = PrintFields.parse("  ,, DD++\t\nEE\r  ");

        assertEquals("DD+EE", printFields.toString());
        assertEquals(2, printFields.size());
    }

    @Test
    public void testFromIterable() {
        final PrintFields printFields = PrintFields.from(Arrays.asList("field1", "field2"));

        assertEquals("field1+field2", printFields.toString());
        assertEquals(2, printFields.size());
    }

    @Test
    public void testFromDatabases() {
        final PrintFields original = new PrintFields(Arrays.asList("field1", "field2"));
        final PrintFields printFields = PrintFields.from(original);

        assertSame(original, printFields);
        assertEquals("field1+field2", printFields.toString());
        assertEquals(2, printFields.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromNullException() {
        PrintFields.from(null);
    }

    @Test
    public void testEqualsHashCode() {
        final PrintFields printFields1 = new PrintFields();
        final PrintFields printFields2 = new PrintFields();
        final PrintFields printFields3 = new PrintFields("field1");
        final PrintFields printFields4 = new PrintFields("field1");
        final PrintFields printFields5 = new PrintFields("field1", "field2");
        final PrintFields printFields6 = new PrintFields("field2", "field1");

        //noinspection EqualsWithItself
        assertTrue(printFields1.equals(printFields1));
        //noinspection EqualsWithItself
        assertTrue(printFields3.equals(printFields3));
        //noinspection EqualsWithItself
        assertTrue(printFields5.equals(printFields5));

        assertTrue(printFields1.equals(printFields2));
        assertTrue(printFields3.equals(printFields4));
        assertTrue(printFields5.equals(printFields6));
        assertTrue(printFields6.equals(printFields5));

        assertFalse(printFields1.equals(printFields3));
        assertFalse(printFields1.equals(printFields5));
        assertFalse(printFields3.equals(printFields5));

        //noinspection EqualsBetweenInconvertibleTypes
        assertFalse(printFields3.equals("field1"));
        //noinspection ObjectEqualsNull
        assertFalse(printFields1.equals(null));

        assertEquals(printFields1.hashCode(), printFields2.hashCode());
        assertEquals(printFields3.hashCode(), printFields4.hashCode());
        assertEquals(printFields5.hashCode(), printFields6.hashCode());
    }
}
