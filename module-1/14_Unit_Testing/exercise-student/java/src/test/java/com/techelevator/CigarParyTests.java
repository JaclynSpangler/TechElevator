package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarParyTests {

    @Test
    public void haveParty_returns_false_if_tooFewCigars_and_not_weekend(){
        CigarParty sut = new CigarParty();
        boolean succesful = sut.haveParty(30,false);
        Assert.assertFalse(succesful);
    }
    @Test
    public void haveParty_returns_true_if_enough_Cigars_and_is_not_weekend() {
        CigarParty sut = new CigarParty();
        boolean succesful = sut.haveParty(50, false);
        Assert.assertTrue(succesful);
    }

    @Test
    public void haveParty_returns_true_if_enough_Cigars_and_is_weekend() {
        CigarParty sut = new CigarParty();
        boolean succesful = sut.haveParty(70, true);
        Assert.assertTrue(succesful);
    }



}
