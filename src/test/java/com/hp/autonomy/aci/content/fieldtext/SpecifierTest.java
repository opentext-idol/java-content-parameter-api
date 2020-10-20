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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Tests for the <tt>Specifier</tt> class.
 *
 * @author darrelln
 * @author boba
 * @version $Revision$ $Date$
 */
public class SpecifierTest {

    @Test
    public void testStringStringConstructor() {
        final Specifier specifier = new Specifier("operator", "/Path/NS:Field");

        assertEquals("OPERATOR{}:/Path/NS%3AField", specifier.toString());
        assertFalse(specifier.isEmpty());
        assertEquals(1, specifier.size());

        final List<String> fields = specifier.getFields();

        assertEquals(1, fields.size());
        assertEquals("/Path/NS:Field", fields.get(0));

        assertTrue(specifier.getValues().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringConstructorNullOperatorException() {
        new Specifier(null, "A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringConstructorBlankOperatorException() {
        new Specifier("  ", "A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringConstructorNullFieldException() {
        new Specifier("OPERATOR", (String)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringStringBlankFieldsException() {
        new Specifier("OPERATOR", "  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullIterableValues() {
        new Specifier("OPERATOR", "A", (Iterable<String>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullArrayValues() {
        new Specifier("OPERATOR", "A", (String[])null);
    }

    @Test
    public void testStringStringIterableConstructor() {
        final Specifier specifier = new Specifier("OPERATOR", "/ns:field", Arrays.asList("dog,cat", "mouse"));

        assertEquals("OPERATOR{dog%2Ccat,mouse}:/ns%3Afield", specifier.toString());
        assertFalse(specifier.isEmpty());
        assertEquals(1, specifier.size());

        final List<String> fields = specifier.getFields();

        assertEquals(1, fields.size());
        assertEquals("/ns:field", fields.get(0));

        final List<String> values = specifier.getValues();

        assertEquals(2, values.size());
        assertEquals("dog,cat", values.get(0));
        assertEquals("mouse", values.get(1));
    }

    @Test
    public void testStringArrayVarargsConstructor() {
        final Specifier specifier = new Specifier("OPERATOR", new String[]{"/ns:field", "title"}, "dog cat", "mouse");

        assertEquals("OPERATOR{dog%20cat,mouse}:/ns%3Afield:title", specifier.toString());
        assertFalse(specifier.isEmpty());
        assertEquals(1, specifier.size());

        final List<String> fields = specifier.getFields();

        assertEquals(2, fields.size());
        assertEquals("/ns:field", fields.get(0));
        assertEquals("title", fields.get(1));

        final List<String> values = specifier.getValues();

        assertEquals(2, values.size());
        assertEquals("dog cat", values.get(0));
        assertEquals("mouse", values.get(1));
    }

    @Test
    public void testStringArrayIterableConstructor() {
        final Specifier specifier = new Specifier("OPERATOR", new String[]{"/ns:field", "title"}, Arrays.asList("dog cat", "mouse"));

        assertEquals("OPERATOR{dog%20cat,mouse}:/ns%3Afield:title", specifier.toString());
        assertFalse(specifier.isEmpty());
        assertEquals(1, specifier.size());

        final List<String> fields = specifier.getFields();

        assertEquals(2, fields.size());
        assertEquals("/ns:field", fields.get(0));
        assertEquals("title", fields.get(1));

        final List<String> values = specifier.getValues();

        assertEquals(2, values.size());
        assertEquals("dog cat", values.get(0));
        assertEquals("mouse", values.get(1));
    }
    
    @Test
    public void testFinality() {
        // Most methods of Specifier are final to ensure immutability. This test ensures that this is not accidentally
        // changed.

        final Class<?>[] specifiers = {
                Specifier.class,
                BIAS.class,
                BIASVAL.class,
                EMPTY.class,
                EQUAL.class,
                EQUALALL.class,
                EXISTS.class,
                GREATER.class,
                LESS.class,
                MATCH.class,
                MATCHALL.class,
                MATCHRECURSE.class,
                NOTEQUAL.class,
                STRING.class,
                STRINGALL.class,
                WILD.class
        };

        for (final Class<?> specifier : specifiers) {
            final Method[] methods = specifier.getMethods();

            for (final Method method : methods) {
                final int modifiers = method.getModifiers();

                if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                    if (!Modifier.isFinal(modifiers) && !Modifier.isStatic(modifiers)) {
                        fail("Method " + method.getName() + " of " + specifier.getSimpleName() + " is not final, static or hidden");
                    }
                }
            }
        }
    }

    @Test
    public void testWhen() {
        final FieldText fieldText = new Specifier("MATCH", "FIELD", "VALUE").WHEN(new Specifier("LESS", "NUMERIC", "7"));

        assertEquals("MATCH{VALUE}:FIELD+WHEN+LESS{7}:NUMERIC", fieldText.toString());
        assertEquals(2, fieldText.size());
    }

    @Test
    public void testWhenN() {
        final FieldText fieldText = new Specifier("MATCH", "FIELD", "VALUE").WHEN(3, new Specifier("LESS", "NUMERIC", "7"));

        assertEquals("MATCH{VALUE}:FIELD+WHEN3+LESS{7}:NUMERIC", fieldText.toString());
        assertEquals(2, fieldText.size());
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Test
    public void testEqualsHashCode() {
        final FieldText specifier1 = new Specifier("OPERATOR", "field", "val1", "val2");
        final FieldText specifier2 = new Specifier("OPERATOR", "field", "val1", "val2");
        final FieldText specifier3 = new Specifier("OPERATOR", "field", "val1", "val3");
        final FieldText specifier4 = new Specifier("MATCH", "field", "val1", "val2");
        final FieldText specifier5 = new Specifier("OPERATOR", "title", "val1", "val2");

        final FieldText builder1 = new FieldTextBuilder(new Specifier("OPERATOR", "field", "val1", "val2"));

        //noinspection EqualsWithItself
        assertThat(specifier1.equals(specifier1), is(true));
        assertThat(specifier1.equals(specifier2), is(true));
        assertThat(specifier1.equals(builder1), is(true));

        assertThat(specifier1.equals(specifier3), is(false));
        assertThat(specifier1.equals(specifier4), is(false));
        assertThat(specifier1.equals(specifier5), is(false));

        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(specifier1.equals("OPERATOR{val1,val2}:field"), is(false));
        //noinspection ObjectEqualsNull
        assertThat(specifier1.equals(null), is(false));

        System.out.println("specifier1 - " + specifier1.toString() + ", hashcode - " + specifier1.hashCode());
        System.out.println("specifier2 - " + specifier2.toString() + ", hashcode - " + specifier2.hashCode());
        System.out.println("builder1   - " + builder1.toString() + ", hashcode - " + builder1.hashCode());

        assertThat(specifier1.hashCode(), is(equalTo(specifier1.hashCode())));
        assertThat(specifier1.hashCode(), is(equalTo(specifier2.hashCode())));
        assertThat(specifier1.hashCode(), is(equalTo(builder1.hashCode())));
    }

}


