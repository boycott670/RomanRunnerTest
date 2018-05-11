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

  private List<TrackSlot> trackToFill;
  private boolean ignoreToFillOtherTrack = false;

  public CircensesBuilder()
  {
    final Supplier<Collection<TrackSlot>> defaultTrackValueSupplier = () -> Collections.singleton(new EmptySlot());

    leftTrack = new ArrayList<>(defaultTrackValueSupplier.get());
    rightTrack = new ArrayList<>(defaultTrackValueSupplier.get());

    trackToFill = leftTrack;
  }

  private void addTrackSlot(final TrackSlot slot)
  {
    if (!ignoreToFillOtherTrack)
    {
      trackToFill.add(slot);
      (trackToFill == leftTrack ? rightTrack : leftTrack).add(new EmptySlot());
    }
    else
    {
      trackToFill.set(trackToFill.size() - 1, slot);
      ignoreToFillOtherTrack = false;
    }
  }

  public CircensesBuilder addCoin()
  {
    addTrackSlot(new Coin());

    return this;
  }

  public CircensesBuilder addEmptySlot()
  {
    addTrackSlot(new EmptySlot());

    return this;
  }

  public CircensesBuilder addObstacle()
  {
    addTrackSlot(new Obstacle());

    return this;
  }

  public CircensesBuilder right()
  {
    trackToFill = rightTrack;
    
    ignoreToFillOtherTrack = true;

    return this;
  }

  public CircensesBuilder left()
  {
    trackToFill = leftTrack;
    
    ignoreToFillOtherTrack = true;

    return this;
  }

  public Circenses build()
  {
    leftTrack.add(new FinishSlot());
    rightTrack.add(new FinishSlot());

    return new Circenses(circensesDrawer, leftTrack, rightTrack);
  }
}
