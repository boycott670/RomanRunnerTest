package com.sqli.romanrunner;

import com.sqli.romanrunner.exceptions.ObstacleHitedException;
import com.sqli.romanrunner.players.Player;

public abstract class TrackSlot
{
  public abstract char draw();
  
  void arrivedAtByPlayer(final Player player) throws ObstacleHitedException
  {
    
  }
}
