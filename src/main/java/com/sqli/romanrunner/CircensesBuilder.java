package com.sqli.romanrunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import com.sqli.romanrunner.drawers.CircensesDrawer;
import com.sqli.romanrunner.drawers.DefaultCircensesDrawer;

public final class CircensesBuilder
{
  private final CircensesDrawer circensesDrawer = new DefaultCircensesDrawer();

  private final List<TrackSlot> leftTrack;
  private final List<TrackSlot> rightTrack;

  public CircensesBuilder()
  {
    final Supplier<Collection<TrackSlot>> defaultTrackValueSupplier = () -> Collections.singleton(new EmptySlot());

    leftTrack = new ArrayList<>(defaultTrackValueSupplier.get());
    rightTrack = new ArrayList<>(defaultTrackValueSupplier.get());
  }

  public CircensesBuilder addCoin()
  {
    leftTrack.add(new Coin());
    rightTrack.add(new EmptySlot());

    return this;
  }

  public CircensesBuilder addEmptySlot()
  {
    leftTrack.add(new EmptySlot());
    rightTrack.add(new EmptySlot());

    return this;
  }

  public CircensesBuilder addObstacle()
  {
    leftTrack.add(new Obstacle());
    rightTrack.add(new EmptySlot());

    return this;
  }

  public Circenses build()
  {
    leftTrack.add(new FinishSlot());
    rightTrack.add(new FinishSlot());

    return new Circenses(circensesDrawer, leftTrack, rightTrack);
  }
}
