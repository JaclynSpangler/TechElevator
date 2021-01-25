package com.techelevator.playingcards;


import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {

        Map<String, Card> dealtCards = new HashMap<>();
        Deck deck = new Deck();
        deck.shuffle();

        dealtCards.put("Vera", deck.drawCard());
        dealtCards.put("Max", deck.drawCard());
        dealtCards.put("Jason", deck.drawCard());

        for(Map.Entry<String, Card> entry : dealtCards.entrySet()){
            Card currentCard = entry.getValue();
            currentCard.flip();
            System.out.println(entry.getKey() + " has the card " + currentCard.getDescription());

            String rank = currentCard.getRank();
            boolean hasFaceCard = rank.equals("Jack") || rank.equals("Queen") || rank.equals("King") || rank.equals("Ace");

            if(hasFaceCard){
                System.out.println(entry.getKey() + " has a face card!");
            }


        }



    }
}
