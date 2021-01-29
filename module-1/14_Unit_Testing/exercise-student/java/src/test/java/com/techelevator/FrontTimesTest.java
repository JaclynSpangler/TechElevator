package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    @Test
    public void generateString_if_length_is_less_than_or_equal_3_returns_whatever_is_there() {
        FrontTimes sut = new FrontTimes();
        String result = sut.generateString("Ch", 2);
        Assert.assertEquals("ChCh", result);
    }

    @Test
    public void generateString_returns_n_copies_of_String_if_length_is_greater_than_3() {
        FrontTimes sut = new FrontTimes();
        String result = sut.generateString("Chocolate", 2);
        Assert.assertEquals("ChoCho", result);
    }

    @Test
    public void generateString_return_null_if_String_is_empty() {
        FrontTimes sut = new FrontTimes();
        String result = sut.generateString("", 3);
        Assert.assertEquals("", result);
    }
}
