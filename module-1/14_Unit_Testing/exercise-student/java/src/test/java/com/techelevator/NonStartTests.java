package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTests {

    @Test
    public void getPartialString_with_first_letters_capitalized(){
        NonStart sut = new NonStart();
        String partialString = sut.getPartialString("Hello", "There");
        Assert.assertEquals("ellohere", partialString);
    }
    @Test
    public void getPartialString_with_first_letters_not_capitalized() {
        NonStart sut = new NonStart();
        String partialString = sut.getPartialString("java", "code");
        Assert.assertEquals("avaode", partialString);
    }
    @Test
    public void getPartialString_with_mispelled_word() {
        NonStart sut = new NonStart();
        String partialString = sut.getPartialString("shotl", "java");
        Assert.assertEquals("hotlava", partialString);
    }

    @Test
    public void getPartialString_with_String_a_with_one_char() {
        NonStart sut = new NonStart();
        String partialString = sut.getPartialString("", "There");
        Assert.assertEquals("here", partialString);
    }
    @Test
    public void getPartialString_with_String_b_with_one_char() {
        NonStart sut = new NonStart();
        String partialString = sut.getPartialString("Hello", "");
        Assert.assertEquals("ello", partialString);
    }
//directions differ and said that there would be atleast one character in the string

}
