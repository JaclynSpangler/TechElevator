package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTests {

    @Test
    public void isItTheSame_returns_false_first_and_last_not_equal(){
        SameFirstLast sut = new SameFirstLast();
        boolean nums = sut.isItTheSame(new int[]{1, 2, 3});
        Assert.assertFalse(nums);
    }

    @Test
    public void isItTheSame_returns_true_first_and_last_char_equal(){
        SameFirstLast sut = new SameFirstLast();
        boolean nums = sut.isItTheSame(new int[]{1, 2, 3, 1});
        Assert.assertTrue(nums);
    }


}
