package com.sqli.romanrunner.players;

public final class Knight extends Player
{

  public Knight(String name)
  {
    super(name);
  }

  @Override
  int scoreIncrementWhenArrivedAtCoin()
  {
    return 20;
  }

  @Override
  int scoreIncrementWhenArrivedAtAnObstacle()
  {
    return -10;
  }

}
