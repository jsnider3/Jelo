package com.joshuasnider.Jelo;

/**
 * Represents a match between two players.
 *
 */
public class Match<E>
{
    public enum Outcomes {
      ePlayer_One_Won,
      ePlayer_Two_Won,
      eDraw
    };

    public Match(Player<E> firstPlayer, Player<E> secondPlayer,
        Outcomes result)
    {

    }
}
