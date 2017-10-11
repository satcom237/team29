package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        //this makes cols a 2D ArrayList
        for (int i = 0; i < 4; i++) {
            cols.add(new ArrayList<Card>(14));
        }
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
        // Shuffles deck using a temp class of Card object type
        int shuffl;
        Card temp;
        Random r = new Random();
        for (int i = this.deck.size() - 1; i > 0; i--){
            shuffl = r.nextInt(i + 1); // Get random number
            temp = this.deck.get(shuffl); // Gets random number into temp of deck
            this.deck.set(shuffl, this.deck.get(i)); // Store initial deck as random number
            this.deck.set(i, temp); // Put temp back into initial deck
        }
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns (this is mine)
        //for loop that increments through columns to add a card
        for (int i = 0; i < 4; i++){

            //adds card to the columns
            addCardToCol(i,this.deck.get(this.deck.size()-1));
            //remove top card from deck
            this.deck.remove(this.deck.size()-1);

        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        //Get the top card from the desired column then add that card to the column you want to add it to
        addCardToCol(columnTo, getTopCard(columnFrom));
        //Remove the card that was moved from the column that it was moved from
        removeCardFromCol(columnFrom);
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
