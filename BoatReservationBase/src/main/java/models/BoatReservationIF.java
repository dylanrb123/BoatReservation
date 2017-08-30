package models;

import org.immutables.value.Value.Immutable;

import annotations.MyStyle;

@MyStyle
@Immutable
public interface BoatReservationIF {
  int getBoatId();
  int getUserId();
  long getStartTime();
  long getEndTime();
}
