package com.joshuasnider.Jelo;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for Match.
 */
public class MatchTest
{
    /**
     * Test that we can make a match.
     */
    @Test
    public void testMatch()
    {
      Player<String> rick = new Player("Hello");
      Player<String> john = new Player("Hello");
      Match<String> gae = new Match(rick, john, Match.Outcomes.eDraw);
      gae = new Match(rick, john, Match.Outcomes.ePlayer_One_Won);
    }
}
