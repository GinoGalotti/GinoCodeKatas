package com.ginoprojects.ginocodekatas.sortingkata.firstround;

/**
 * Created by GinoGalotti on 01/06/2015.
 * ginogalotti.com
 * ginogalotti@gmail.com
 */

/*
 * My aim in this round is keeping this as simple as possible, using a hand made sorting method
 * probably the most inefficient one.
 *
 * I'm going to use Java dynamic ArrayList so I don't have to deal with sizes on my first round
 */

import org.junit.Assert;

import org.junit.Test;

import java.util.ArrayList;

public class SortingBallsTest {

    SortingBalls sorter = new SortingBalls();

    @Test public void testEmptyList() {
        sorter.clear();

        Assert.assertEquals(new ArrayList<Integer>(), sorter.getBalls());
    }

    @Test public void testAddOneValue() {
        sorter.clear();
        sorter.sortedAdd(2);
        ArrayList<Integer> oneValue = new ArrayList<Integer>();
        oneValue.add(2);
        Assert.assertEquals(oneValue, sorter.getBalls());
    }

    @Test public void testAddTwoAlreadySortedValues() {
        sorter.clear();
        sorter.sortedAdd(2);
        sorter.sortedAdd(5);
        ArrayList<Integer> twoValues = new ArrayList<Integer>();
        twoValues.add(2);
        twoValues.add(5);
        Assert.assertEquals(twoValues, sorter.getBalls());
    }

    @Test public void testAddTwoNonSortedValues() {
        sorter.clear();
        sorter.sortedAdd(4);
        sorter.sortedAdd(3);
        ArrayList<Integer> twoValues = new ArrayList<Integer>();
        twoValues.add(3);
        twoValues.add(4);
        Assert.assertEquals(twoValues, sorter.getBalls());
    }


    @Test public void testAddALotOfNonSortedValues() {
        sorter.clear();
        sorter.sortedAdd(4);
        sorter.sortedAdd(3);
        sorter.sortedAdd(3);
        sorter.sortedAdd(5);
        sorter.sortedAdd(4);
        sorter.sortedAdd(1);
        ArrayList<Integer> twoValues = new ArrayList<Integer>();
        twoValues.add(1);
        twoValues.add(3);
        twoValues.add(3);
        twoValues.add(4);
        twoValues.add(4);
        twoValues.add(5);
        Assert.assertEquals(twoValues, sorter.getBalls());
    }



}
