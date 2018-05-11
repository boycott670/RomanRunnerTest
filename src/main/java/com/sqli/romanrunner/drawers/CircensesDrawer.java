package com.sqli.romanrunner.drawers;

import java.util.List;

import com.sqli.romanrunner.TrackSlot;

public interface CircensesDrawer
{
  String drawCircenses(final List<TrackSlot> leftTrack, final List<TrackSlot> rightTrack);
}
