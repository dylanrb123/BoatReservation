package models;


import org.immutables.value.Value.Immutable;

import annotations.MyStyle;

@MyStyle
@Immutable
public interface BoatIF {
  String getName();
}
