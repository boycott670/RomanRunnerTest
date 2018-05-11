package com.sqli.romanrunner;

import java.util.List;

import com.sqli.romanrunner.drawers.CircensesDrawer;
import com.sqli.romanrunner.exceptions.ObstacleHitedException;
import com.sqli.romanrunner.players.Player;

public final class Circenses
{
  private final CircensesDrawer drawer;
  private final List<TrackSlot> leftTrack;
  private final List<TrackSlot> rightTrack;
  
  private List<TrackSlot> playerCurrentTrack;
  private int playerCurrentPosition;
  
  private TrackSlot previousOverriddenTrackSlot = new PreviousInitialPlayerSlot();
  
  Circenses(CircensesDrawer drawer, List<TrackSlot> leftTrack, List<TrackSlot> rightTrack)
  {
    this.drawer = drawer;
    this.leftTrack = leftTrack;
    this.rightTrack = rightTrack;
  }

  public String draw()
  {
    return drawer.drawCircenses(leftTrack, rightTrack);
  }
  
  public void setPlayer(final Player player)
  {
    (playerCurrentTrack = leftTrack).set(playerCurrentPosition = 0, player);
  }
  
  private void movePlayer(final int playerNextPosition, final List<TrackSlot> playerNextTrack) throws ObstacleHitedException
  {
    final Player player = (Player) playerCurrentTrack.get(playerCurrentPosition);

    final TrackSlot overriddenTrackSlot = playerNextTrack.get(playerNextPosition);

    overriddenTrackSlot.arrivedAtByPlayer(player);

    playerCurrentTrack.set(playerCurrentPosition, previousOverriddenTrackSlot);

    playerNextTrack.set(playerCurrentPosition = playerNextPosition, player);

    previousOverriddenTrackSlot = overriddenTrackSlot;
    
    playerCurrentTrack = playerNextTrack;
  }
  
  public void forwardPlayer() throws ObstacleHitedException
  {
    movePlayer(playerCurrentPosition + 1, playerCurrentTrack);
  }
  
  public void rightPlayer() throws ObstacleHitedException
  {
    movePlayer(playerCurrentPosition, rightTrack);
  }
}
