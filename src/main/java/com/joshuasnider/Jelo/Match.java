package com.joshuasnider.Jelo;

/**
 * Represents a match between two players.
 *
 */
public class Match<E>
{
    private Outcomes result;
    private Player<E> first;
    private Player<E> second;

    public enum Outcomes {
      ePlayer_One_Won,
      ePlayer_Two_Won,
      eDraw
    };

    public Match(Player<E> firstPlayer, Player<E> secondPlayer,
        Outcomes result)
    {
      first = firstPlayer;
      second = secondPlayer;
      this.result = result;
      firstPlayer.addMatch(this);
      secondPlayer.addMatch(this);
    }

    /**
     * The opponent of the given player in this match.
     * @param player played in this match.
     */
    public Player<E> getOpponent(Player<E> player) {
      Player<E> opponent = null;
      if (player == first) {
        opponent = second;
      }
      else if (player == second) {
        opponent = first;
      }
      else {
        throw new IllegalArgumentException(
          "Given player was not in this match.");
      }
      return opponent;
    }

    /**
     * The score of the given player in this match.
     * @return 1 for a win, 0 for a loss, and 0.5 for a tie.
     * @throws IllegalArgumentException if player was not in this match.
     */
    public double getScore(Player<E> player) {
      double score = 0.5;
      if (player == first) {
        switch (result) {
          case ePlayer_One_Won:
            score = 1.0;
            break;
          case ePlayer_Two_Won:
            score = 0.0;
            break;
          case eDraw:
            score = .5;
            break;
        }
      } else if (player == second) {
        switch (result) {
          case ePlayer_One_Won:
            score = 0.0;
            break;
          case ePlayer_Two_Won:
            score = 1.0;
            break;
          case eDraw:
            score = .5;
            break;
        }
      } else {
        throw new IllegalArgumentException(
          "Given player was not in this match.");
      }
      return score;
    }
}
