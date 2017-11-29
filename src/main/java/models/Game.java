package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Students must implement dealFour(), remove(), move(), and columnHasCards() methods
 *
 * The customDeal() method is not present in the Assignment1_Student version since tests (and the test dir) are removed
 * to prevent confusion regarding testing and the use of unit tests; testing is covered more thoroughly in CS362.
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public int flag = 0;

    public Game() {
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
    }

    //Code for calling Deck class
    Deck d = new Deck();
    Deck sd = new Deck();

    public void buildDeck() {
        d.buildDeck(this.deck, flag);
        if(flag == 1){
            sd.buildDeck(this.deck, flag);
        }
    }

    public void shuffle() {
        d.shuffle(this.deck);
    }

    public void dealFour() {
        d.dealFour(this.deck, this.cols);
    }
//////////////////////////////////


    //customDeal to setup game for testing purposes
    public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).add(deck.get(c1));
        deck.remove(c1);
        cols.get(1).add(deck.get(c2));
        deck.remove(c2);
        cols.get(2).add(deck.get(c3));
        deck.remove(c3);
        cols.get(3).add(deck.get(c4));
        deck.remove(c4);
    }

 //This is the code for using class player
    Player p = new Player();

    public void remove(int columnNumber) {
        p.remove(columnNumber, this.cols);
    }

    private boolean columnHasCards(int columnNumber) {
        return p.columnHasCards(columnNumber, this.cols);
    }

    private Card getTopCard(int columnNumber) {
        return p.getTopCard(columnNumber, this.cols);
    }


    public void move(int columnFrom, int columnTo) {
        p.move(columnFrom, columnTo, this.cols);
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {

        p.removeCardFromCol(colFrom, this.cols);
    }
    //////////////////////////////////////////////////
}