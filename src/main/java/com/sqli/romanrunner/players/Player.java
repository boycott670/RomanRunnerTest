package com.sqli.romanrunner.players;

import com.sqli.romanrunner.Circenses;
import com.sqli.romanrunner.TrackSlot;

public abstract class Player extends TrackSlot
{
  private final String name;

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
    circenses.setPlayer(this);
  }
}
