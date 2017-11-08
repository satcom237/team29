package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    public void buildDeck(java.util.List<Card> deck) {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle(java.util.List<Card> deck) {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealFour(java.util.List<Card> deck, java.util.List<java.util.List<Card>> cols) {
        for(int i = 0; i < 4; i++){
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }
}
