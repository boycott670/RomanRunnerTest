package com.sqli.romanrunner;

final class EmptySlot extends NeutralToPlayerArrivableTrackSlot
{

  @Override
  public char draw()
  {
    return ' ';
  }

}
