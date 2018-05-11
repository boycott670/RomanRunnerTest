package com.sqli.romanrunner;

import com.sqli.romanrunner.players.Player;

final class FinishSlot extends ArrivableByPlayerTrackSlot
{

  @Override
  public char draw()
  {
    return '#';
  }

  @Override
  void arrivedAtByPlayer(Player player)
  {
    player.arrivedAtFinalLine();
  }

}
