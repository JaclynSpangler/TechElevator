package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTests {
    @Test
    public void getHeard_returns_tower_for_giraffe(){
        //arrange
        AnimalGroupName sut = new AnimalGroupName();

        //act

        String herd = sut.getHerd("giraffe");

        //assert
        Assert.assertEquals("Tower", herd);
    }

    @Test
    public void getHeard_returns_tower_for_Giraffe() {
        //arrange
        AnimalGroupName sut = new AnimalGroupName();

        //act

        String herd = sut.getHerd("Giraffe");

        //assert
        Assert.assertEquals("Tower", herd);
    }

    @Test
    public void getHeard_returns_unknown_for_empty_string(){
        AnimalGroupName sut = new AnimalGroupName();
        String herd = sut.getHerd("");
        Assert.assertEquals("unknown", herd);
    }
    @Test
    public void getHeard_returns_unknow_for_mispelled_animal(){
        AnimalGroupName sut = new AnimalGroupName();
        String herd = sut.getHerd("walrus");
        Assert.assertEquals("unknown", herd);
    }

}
