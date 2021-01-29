package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Tests {
    @Test
    public void getLucky_returns_true_if_no_1_or_3(){
        Lucky13 sut = new Lucky13();
        int[] nums = new int[]{0, 2, 4};
        boolean values = sut.getLucky(nums);
        Assert.assertTrue(values);
    }
    @Test
    public void getLucky_returns_false_if_1_and_3(){
        Lucky13 sut = new Lucky13();
        int[] nums = new int[]{1, 2, 3};
        boolean values = sut.getLucky(nums);
        Assert.assertFalse(values);
    }
    @Test
    public void getLucky_returns_false_if_1_or_3(){
        Lucky13 sut = new Lucky13();
        int[] nums = new int[]{1, 2, 4};
        boolean values = sut.getLucky(nums);
        Assert.assertFalse(values);
    }


}
