package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testPlayer {

    @Test
    public void testMoveCard(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(51,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
        g.move(0,2);
        assertEquals(1,g.cols.get(2).size());
        assertEquals(0,g.cols.get(0).size());
    }
    @Test
    public void testMoveCardBad(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
        g.move(0,2);
        assertEquals(0, g.cols.get(2).size());
    }


    @Test
    public void testRemoveFunction(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }

    @Test
    public void testColumnhasCards(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0, 1, 2, 3);
        assertEquals(true, g.p.columnHasCards(1, g.cols));
    }

    @Test
    public void testGetTopCard(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0, 1, 2, 3);
        assertEquals("2Clubs", g.p.getTopCard(0, g.cols).toString());
    }

    @Test
    public void testClearSpanish()
    {
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,1, 2,3);
        g.p.clearSpanish(g.cols);
        int i;
        for(i = 0;i < 4;i++)
        {
            assertEquals(false, g.p.columnHasCards(i, g.cols));
        }
    }

    @Test
    public void testSpanishMove(){

        Game g = new Game();
        g.clearSpanish();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
        g.move(0,2);
        assertEquals(1,g.cols.get(2).size());
        assertEquals(0,g.cols.get(0).size());


    }
}
