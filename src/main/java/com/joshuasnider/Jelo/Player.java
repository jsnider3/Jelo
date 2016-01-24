package com.joshuasnider.Jelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player with matches and scores.
 *
 */
public class Player<E>
{
  private int rating;
  private E id;
  private List<Match<E>> matches;

  /**
   * Create a player with the given ID.
   */
  public Player(E id) {
    this.id = id;
    rating = 1000;
    matches = new ArrayList<>();
  }

  /**
   * Record us playing in a match. Change our score to reflect playing
   *  an opponent.
   * @see <a href="https://en.wikipedia.org/wiki/Elo_rating_system#Mathematical_details">Source</a>
   */
  public void addMatch(Match<E> match) {
    matches.add(match);
    double k = 25;
    rating += k * (match.getScore(this) - getWinOdds(match.getOpponent(this)));
  }

  /**
   * Get the odds of us winning against the given opponent.
   * @see <a href="https://en.wikipedia.org/wiki/Elo_rating_system#Mathematical_details">Source</a>
   */
  public double getWinOdds(Player<E> opponent) {
    return 1.0 /(1 + Math.pow(10,
        (opponent.getRating() - getRating()) / 400.0));
  }

  /**
   * Get our ID.
   */
  public E getID() {
    return id;
  }

  /**
   * Get our rating.
   */
  public int getRating() {
    return rating;
  }

  /**
   * Set our rating.
   */
  public void setRating(int newrating) {
    rating = newrating;
  }

}
