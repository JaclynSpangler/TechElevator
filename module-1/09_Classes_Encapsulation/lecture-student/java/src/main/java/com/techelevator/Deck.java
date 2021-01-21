package com.techelevator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {

    public static final String[] ALL_SUITS = {"Spades", "Diamonds", "Hearts", "Clubs"};
    public static final String[] ALL_RANKS = {"Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

    List<Card> allCards = new ArrayList<>();

    public Deck(){
        for(String suit : ALL_SUITS){
            for(String rank : ALL_RANKS){//nested for loop
                Card card = new Card(rank, suit); //creating new card
                allCards.add(card);//will put all ranks per suit into allcards list
            }
        }
    }

    public Card drawCard(){
        Card drawnCard = allCards.remove(0);
        return drawnCard;
    }

    public int getCardCount(){
        return allCards.size();
    }

    public void shuffle(){
        Collections.shuffle(allCards);
    }
}
