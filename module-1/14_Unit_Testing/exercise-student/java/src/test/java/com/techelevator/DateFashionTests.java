package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTests {
    @Test
    public void getATable_returns_2_if_you_and_date_are_both_above_8(){
        DateFashion sut = new DateFashion();
        int score =sut.getATable(5,10);

        Assert.assertEquals(2, score);
    }
    @Test
    public void getATable_returns_0_if_either_one_are_less_than_2(){
        DateFashion sut = new DateFashion();
        int score =sut.getATable(5,2);

        Assert.assertEquals(0 , score);
    }

    @Test
    public void getATable_returns_1_if_you_and_date_are_between_3_or_7(){
        DateFashion sut = new DateFashion();
        int score =sut.getATable(5,5);

        Assert.assertEquals(1, score);
    }


}
