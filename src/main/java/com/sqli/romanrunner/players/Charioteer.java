package com.sqli.romanrunner.players;

public final class Charioteer extends Player
{
  public Charioteer(String name)
  {
    super(name);
  }

  @Override
  int scoreIncrementWhenArrivedAtFinalLine()
  {
    return 100;
  }

  @Override
  int scoreIncrementWhenArrivedAtCoin()
  {
    return 10;
  }

  @Override
  int scoreIncrementWhenArrivedAtAnObstacle()
  {
    die();
    return -5;
  }
}
