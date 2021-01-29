package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTests {

    @Test
    public void getBits_alternates_letter_starting_with_the_first(){
        StringBits sut = new StringBits();
        String words = sut.getBits("Hello");
        Assert.assertEquals("Hlo", words);
    }
    @Test
    public void getBits_empty_string(){
        StringBits sut = new StringBits();
        String words = sut.getBits("");
        Assert.assertEquals("", words);
    }
}
