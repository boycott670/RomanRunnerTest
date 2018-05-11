package com.sqli.romanrunner;

import com.sqli.romanrunner.players.Player;

final class Coin extends TrackSlot
{

  private boolean earned = false;

  @Override
  public char draw()
  {
    return earned ? 'x' : 'o';
  }

  @Override
  void arrivedAtByPlayer(Player player)
  {
    player.arrivedAtCoin();
    earned = true;
  }

}
