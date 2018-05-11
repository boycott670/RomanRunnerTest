package com.sqli.romanrunner.players;

import com.sqli.romanrunner.Circenses;
import com.sqli.romanrunner.TrackSlot;
import com.sqli.romanrunner.exceptions.ObstacleHitedException;

public abstract class Player extends TrackSlot
{
  private final String name;
  
  private Circenses circenses;

  Player(String name)
  {
    this.name = name;
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
  
  public final void forward() throws ObstacleHitedException
  {
    circenses.forwardPlayer();
  }
}
