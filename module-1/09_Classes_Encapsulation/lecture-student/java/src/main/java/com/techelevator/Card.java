package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Card {


    //private cannot be accessed outside of the card.java class, it can also only be changed inside the class
    private final String suit; //declaring variable string suit of card
    private final String rank;//final makes clear that its supposed to only be set one time
    private boolean faceUp; //if faceup is true then the card is face up


    public static String shape = "Rectangle";

    /*public void setSuit(String suit) {//setting the suit
        this.suit = suit; //this. convention is referring to the first suit (this class' property, notclosestin scope)
    }*/
    public String getRank(){

        return rank;
    }
   /* public void setRank(String rank){
        this.rank = rank;
    }*/
    public boolean isFaceUp(){// is instead of get because it is a boolean

        return faceUp;
    }
    public void setFaceUp(boolean faceUp){

        this.faceUp = faceUp;
    }
    public String getDescription(){
        String description = "Back of Card";
        if(faceUp) {
            description = rank + " of " + suit;
        }
        return description;
    }

    public int getValue(){

        Map<String, Integer> cardValues = new HashMap<>();
        cardValues.put("Two", 2);
        cardValues.put("Three", 3);
        cardValues.put("Four", 4);
        cardValues.put("Five", 5);
        cardValues.put("Six", 6);
        cardValues.put("Seven", 7);
        cardValues.put("Eight", 8);
        cardValues.put("Nine", 9);
        cardValues.put("Ten", 10);
        cardValues.put("Jack", 11);
        cardValues.put("Queen", 12);
        cardValues.put("King", 13);
        cardValues.put("Ace", 14);


        return cardValues.get(rank);
    }

    public Card(){//default constructor, allocating memory on heap to hold variables but not doing anything else really
        suit = "Spades";
        rank = "Ace";// sets default until it gets set to something else instead of null

    }

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;

    }

    public void flip(){

        faceUp = !faceUp;
    }
    public boolean isHigherThan(Card otherCard){
        return this.getValue() > otherCard.getValue();//otherCard is the parameter within the isHigherThan
    }


}
