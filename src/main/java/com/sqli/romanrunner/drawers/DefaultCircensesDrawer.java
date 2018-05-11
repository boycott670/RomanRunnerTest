package com.sqli.romanrunner.drawers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sqli.romanrunner.TrackSlot;

public final class DefaultCircensesDrawer implements CircensesDrawer
{

  @Override
  public String drawCircenses(List<TrackSlot> leftTrack, List<TrackSlot> rightTrack)
  {
    return IntStream.iterate(leftTrack.size() - 1, index -> index - 1)
        .limit(leftTrack.size())
        .mapToObj(index -> String.format("|%c%c|", leftTrack.get(index)
            .draw(),
            rightTrack.get(index)
                .draw()))
        .collect(Collectors.joining("\n"));
  }

}
