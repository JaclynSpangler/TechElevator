package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Tests {

    @Test
    public void isLessThanMultipleOf20_returns_true_if_one_less_than_20() {
        Less20 sut = new Less20();
        boolean value = sut.isLessThanMultipleOf20(19);
        Assert.assertTrue(value);
    }

    @Test
    public void isLessThanMultipleOf20_returns_true_if_two_less_than_20() {
        Less20 sut = new Less20();
        boolean value = sut.isLessThanMultipleOf20(18);
        Assert.assertTrue(value);
    }

        @Test
        public void isLessThanMultipleOf20_returns_false_if_n_equals_20 () {
            Less20 sut = new Less20();
            boolean value = sut.isLessThanMultipleOf20(20);
            Assert.assertFalse(value);
        }
}
