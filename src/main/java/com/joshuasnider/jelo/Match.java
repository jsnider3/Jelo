package com.joshuasnider.jelo;

/**
 * Represents a match between two players.
 *
 */
public class Match<E>
{
    private Outcomes result;
    private Player<E> winner;
    private Player<E> loser;

    public enum Outcomes {
      ePlayer_One_Won,
      ePlayer_Two_Won,
      eDraw
    };

    public Match(Player<E> firstPlayer, Player<E> secondPlayer,
        Outcomes result)
    {
        if(result == Outcomes.ePlayer_One_Won){
            winner = firstPlayer;
            loser = secondPlayer;
        }
        if(result == Outcomes.ePlayer_Two_Won){
            loser = firstPlayer;
            winner = secondPlayer;
        }
      this.result = result;
      winner.addMatch(this);
      loser.addMatch(this);
      winner.commitLatestMatch();
      loser.commitLatestMatch();
    }

    /**
     * The opponent of the given player in this match.
     * @param player played in this match.
     */
    public Player<E> getOpponent(Player<E> player) {
      Player<E> opponent = null;
      if (player == winner) {
        opponent = loser;
      }
      else if (player == loser) {
        opponent = winner;
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
        if(result == Outcomes.eDraw &&
                (player == winner || player == loser)){
            return 0.5;
        }
      if (player == winner) {
          return 1.0;
      } else if (player == loser) {
        return 0.0;
      } else {
        throw new IllegalArgumentException(
          "Given player was not in this match.");
      }
    }
}
