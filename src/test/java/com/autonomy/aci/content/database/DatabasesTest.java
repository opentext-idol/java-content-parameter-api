/*
 * Copyright 2009-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.content.database;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the <tt>Databases</tt> class.
 *
 * @author darrelln
 * @version $Revision$ $Date$
 */
public class DatabasesTest {

    @Test
    public void testAppend() {
        final Databases databases = new Databases("News", "Archive")
                              .append("Science")
                              .append(new Databases("World", "News"))
                              .append(Databases.parse("Natural World, Plus+"));
        
        assertEquals("News+Archive+Science+World+Natural+Plus", databases.toString());
        assertEquals("News+Archive+Science+World+Natural+Plus", databases.toIndexingString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorSpaceException() {
        new Databases("Outer space");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorCommaException() {
        new Databases("comma,comma");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorPlusException() {
        new Databases("plus+plus");
    }

    @Test
    public void testAll() {
        assertEquals(1, Databases.ALL.size());
        assertEquals("*", Databases.ALL.toString());
        assertEquals("*", Databases.ALL.toIndexingString());
        assertEquals("*", Databases.ALL.append("news").toString());
        assertEquals(Databases.ALL, new Databases("archive").append("*"));
        assertEquals(Databases.ALL, new Databases("archive", "*").append("*"));
        assertEquals(Databases.ALL, new Databases("archive", "*").append("news"));
    }

    @Test
    public void testEmpty() {
        final Databases databases = new Databases();

        assertTrue(databases.isEmpty());
        assertEquals("MATCH_NOTHING_9be3e331-8046-4182-9e2d-ebbcf12f6e4c", databases.toString());
    }

    @Test
    public void testParse() {
        assertSame(Databases.ALL, Databases.parse(""));
        assertSame(Databases.ALL, Databases.parse("    "));
        assertSame(Databases.ALL, Databases.parse("*"));
        assertSame(Databases.ALL, Databases.parse("*,news"));
        assertSame(Databases.ALL, Databases.parse(",*,news"));
        assertSame(Databases.ALL, Databases.parse("  , , * ,news"));

        assertEquals(Databases.ALL, Databases.parse(Databases.ALL.toString()));

        assertEquals(Databases.ALL, Databases.parse(" "));
        assertTrue(Databases.parse(",").isEmpty());
        assertTrue(Databases.parse("+").isEmpty());

        assertTrue(Databases.parse("  ,, ++  ").isEmpty());
        assertTrue(Databases.parse(new Databases().toString()).isEmpty());
        assertTrue(Databases.parse("MATCH_NOTHING_9be3e331-8046-4182-9e2d-ebbcf12f6e4c").isEmpty());

        final Databases db1 = Databases.parse("news,archive");

        assertEquals(2, db1.size());
        assertEquals("news+archive", db1.toString());

        final Databases db2 = Databases.parse("news+archive");

        assertEquals(2, db2.size());
        assertEquals("news+archive", db2.toString());

        final Databases db3 = Databases.parse("news archive");

        assertEquals(2, db3.size());
        assertEquals("news+archive", db3.toString());

        final Databases db4 = Databases.parse("news,*");

        assertEquals(1, db4.size());
        assertEquals("news", db4.toString());

        final Databases db5 = Databases.parse("news,,*");

        assertEquals(1, db5.size());
        assertEquals("news", db5.toString());

        final Databases db6 = Databases.parse("  ,, DD++  EE  ,*, ");

        assertEquals("DD+EE", db6.toString());
        assertEquals(2, db6.size());

        // Only the space character should be treated as a separator
        final Databases db7 = Databases.parse("  ,, ++\t\n\r  ");

        assertEquals(1, db7.size());
        assertEquals("\t\n\r", db7.toString());
    }

    @Test
    public void testFromIterable() {
        final Databases databases = Databases.from(Arrays.asList("db1", "db2"));

        assertEquals("db1+db2", databases.toString());
        assertEquals("db1+db2", databases.toIndexingString());
        assertEquals(2, databases.size());
    }

    @Test
    public void testFromDatabases() {
        final Databases original = new Databases(Arrays.asList("db1", "db2"));
        final Databases databases = Databases.from(original);

        assertSame(original, databases);
        assertEquals("db1+db2", databases.toString());
        assertEquals("db1+db2", databases.toIndexingString());
        assertEquals(2, databases.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromNullException() {
        Databases.from(null);
    }
    
    @Test
    public void testEqualsHashCode() {
        final Databases databases1 = new Databases();
        final Databases databases2 = new Databases();
        final Databases databases3 = new Databases("News");
        final Databases databases4 = new Databases("News");
        final Databases databases5 = new Databases("News", "Archive");
        final Databases databases6 = new Databases("Archive", "News");
        final Databases databases7 = new Databases("*");

        assertTrue(databases1.equals(databases1));
        assertTrue(databases3.equals(databases3));
        assertTrue(databases5.equals(databases5));
        assertTrue(databases7.equals(databases7));

        assertTrue(databases1.equals(databases2));
        assertTrue(databases3.equals(databases4));
        assertTrue(databases5.equals(databases6));
        assertTrue(databases6.equals(databases5));
        assertTrue(databases7.equals(Databases.ALL));
        assertTrue(Databases.ALL.equals(databases7));

        assertFalse(databases1.equals(databases3));
        assertFalse(databases1.equals(databases5));
        assertFalse(databases1.equals(databases7));
        assertFalse(databases3.equals(databases5));
        assertFalse(databases3.equals(databases7));
        assertFalse(databases5.equals(databases7));

        assertFalse(databases3.equals("field1"));
        assertFalse(databases1.equals(null));

        assertEquals(databases1.hashCode(), databases2.hashCode());
        assertEquals(databases3.hashCode(), databases4.hashCode());
        assertEquals(databases5.hashCode(), databases6.hashCode());
        assertEquals(databases7.hashCode(), Databases.ALL.hashCode());
    }
}
