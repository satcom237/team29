package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Player {

    public void remove(int columnNumber, java.util.List<java.util.List<Card>> cols) {
        if(this.columnHasCards(columnNumber, cols)) {
            Card c = this.getTopCard(columnNumber, cols);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (this.columnHasCards(i, cols)) {
                        Card compare = this.getTopCard(i, cols);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                        //Is there a joker card in the playing field?
                        else if (compare.getSuit() == SpanishSuit.Comodines)
                        {
                            removeCard = true;
                            //Remove the joker card
                            cols.get(i).remove(cols.get(i).size() - 1);
                        }
                    }
                }
            }
            if (removeCard) {
                cols.get(columnNumber).remove(cols.get(columnNumber).size() - 1);
            }
        }
    }

    public boolean columnHasCards(int columnNumber, java.util.List<java.util.List<Card>> cols) {
        if(cols.get(columnNumber).size()>0){
            return true;
        }
        return false;
    }

    public Card getTopCard(int columnNumber, java.util.List<java.util.List<Card>> cols) {
        return cols.get(columnNumber).get(cols.get(columnNumber).size()-1);
    }

    public void move(int columnFrom, int columnTo, java.util.List<java.util.List<Card>> cols) {
        Card cardToMove = getTopCard(columnFrom, cols);
        if((cardToMove.getValue() == 14) && !columnHasCards(columnTo, cols)){
            System.out.print("moving card");
            this.removeCardFromCol(columnFrom, cols);
            this.addCardToCol(columnTo,cardToMove, cols);
        }else{
            System.out.print("not moving card");
        }
    }

    public void addCardToCol(int columnTo, Card cardToMove, java.util.List<java.util.List<Card>> cols) {
        cols.get(columnTo).add(cardToMove);
    }
    public void removeCardFromCol(int colFrom, java.util.List<java.util.List<Card>> cols) {
        cols.get(colFrom).remove(cols.get(colFrom).size()-1);
    }

}