package com.sqli.romanrunner.players;

import com.sqli.romanrunner.Circenses;
import com.sqli.romanrunner.TrackSlot;
import com.sqli.romanrunner.exceptions.ObstacleHitedException;

public abstract class Player extends TrackSlot
{
  private final String name;
  private int score;
  
  private Circenses circenses;

  Player(String name)
  {
    this.name = name;
    score = 0;
  }

  @Override
  public final char draw()
  {
    return Character.toUpperCase(name.charAt(0));
  }
  
  public final void startGame(final Circenses circenses)
  {
    (this.circenses = circenses).setPlayer(this);
  }
  
  public final Player forward() throws ObstacleHitedException
  {
    circenses.forwardPlayer();
    
    return this;
  }
  
  public final Player right() throws ObstacleHitedException
  {
    circenses.rightPlayer();
    
    return this;
  } 
  
  public final int score()
  {
    return score;
  }
  
  abstract int scoreIncrementWhenArrivedAtFinalLine();
  abstract int scoreIncrementWhenArrivedAtCoin();
  
  public final void arrivedAtFinalLine()
  {
    score += scoreIncrementWhenArrivedAtFinalLine();
  }
  
  public final void arrivedAtCoin()
  {
    score += scoreIncrementWhenArrivedAtCoin();
  }
}
