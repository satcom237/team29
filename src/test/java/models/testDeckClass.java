package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class testDeckClass {
    @Test
    public void testBuildDeck(){
        Deck d = new Deck();
        java.util.List<Card> deck = new ArrayList<>();
        d.buildDeck(deck,0);
        assertEquals(52, deck.size());
    }

    @Test
    public void testShuffle(){
        //make deck objects
        Deck d = new Deck();
        //make decks
        java.util.List<Card> deck1 = new ArrayList<>();
        java.util.List<Card> deck2 = new ArrayList<>();
        //build decks
        d.buildDeck(deck1,0);
        d.buildDeck(deck2,0);
        //shuffle decks
        d.shuffle(deck1);
        d.shuffle(deck2);
        assertFalse(Arrays.equals(deck1.toArray(),deck2.toArray()));
    }
}