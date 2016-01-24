package com.joshuasnider.Jelo;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for Player.
 */
public class PlayerTest
{
    /**
     * Test that we can make a player.
     */
    @Test
    public void testPlayer()
    {
      Player<String> rick = new Player("Hello");
    }

    /**
     * Test that we can change a player's rating.
     */
    @Test
    public void testSetRating()
    {
      Player<String> rick = new Player("Hello");
      assertTrue(rick.getRating() == 1000);
      rick.setRating(2000);
      assertTrue(rick.getRating() == 2000);
    }

    /**
     * Test that we calculate win odds correctly.
     */
    @Test
    public void testWinOdds()
    {
      Player<String> rick = new Player("Rick");
      Player<String> john = new Player("John");
      assertEquals(rick.getWinOdds(john), .5, .01);
      assertEquals(john.getWinOdds(rick), .5, .01);
      rick.setRating(1500);
      assertEquals(rick.getWinOdds(john), 1 - .053, .01);
      assertEquals(john.getWinOdds(rick), .053, .01);
      //TODO More
    }

    /**
     * Test that we change our scores correctly.
     */
    @Test
    public void testAdjustScore()
    {
      Player<String> rick = new Player("Rick");
      Player<String> john = new Player("John");
    }

}
