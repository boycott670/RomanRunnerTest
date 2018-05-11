package com.sqli.romanrunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sqli.romanrunner.players.Player;

public final class Circenses
{
  private final List<TrackSlot> leftTrack;
  private final List<TrackSlot> rightTrack;
  
  Circenses(List<TrackSlot> leftTrack, List<TrackSlot> rightTrack)
  {
    this.leftTrack = leftTrack;
    this.rightTrack = rightTrack;
  }
  
  public String draw()
  {
    return IntStream.iterate(leftTrack.size() - 1, index -> index - 1)
        .limit(leftTrack.size())
        .mapToObj(index -> String.format("|%c%c|", leftTrack.get(index)
            .draw(),
            rightTrack.get(index)
                .draw()))
        .collect(Collectors.joining("\n"));
  }
  
  public void setPlayer(final Player player)
  {
    leftTrack.set(0, player);
  }
}
