package com.sqli.romanrunner;

import com.sqli.romanrunner.players.Player;

abstract class ArrivableByPlayerTrackSlot extends TrackSlot
{
  abstract void arrivedAtByPlayer(final Player player);
}
