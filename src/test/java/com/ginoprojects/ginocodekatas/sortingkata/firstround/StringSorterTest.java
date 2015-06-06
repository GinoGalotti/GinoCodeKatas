package com.ginoprojects.ginocodekatas.sortingkata.firstround;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GinoGalotti on 04/06/2015.
 * ginogalotti.com
 * ginogalotti@gmail.com
 */
public class StringSorterTest {

    @Test public void testEmptyString() {
        Assert.assertEquals("", StringSorter.sortString(""));
    }

    @Test public void testOneLetterString() {
        Assert.assertEquals("a", StringSorter.sortString("a"));
    }

    @Test public void testOnlyLettersString() {
        Assert.assertEquals("aahst", StringSorter.sortString("hasta"));
    }

    @Test public void testWithWhiteSpaces() {
        Assert.assertEquals("aceghiinprsssttw", StringSorter.sortString("string with spaces"));
    }

    @Test public void testWithChangedCases() {
        Assert.assertEquals("deeefiiikllpstu", StringSorter.sortString("IFeElLikEStuPid"));
    }

    @Test public void testWithPunctuation() {
        Assert.assertEquals("ehhiorty", StringSorter.sortString("hiyo!%^$th.er,;"));
    }

    @Test public void testHardMode() {
        Assert.assertEquals("adddddeeeffffggghhhijloqqrrrrssssssttuuwwwwyyz", StringSorter
            .sortString(
                "hiyssaDWQFD ^^%$$# S t4329quszd8 ughrwegf 43fds grwey4wfdsl jr2432543 543 o!% ^$th.er,;"));
    }



}
