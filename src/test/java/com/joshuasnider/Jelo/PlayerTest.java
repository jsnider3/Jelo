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
}
