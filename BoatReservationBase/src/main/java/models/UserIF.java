package models;

import java.util.Optional;

import org.immutables.value.Value.Immutable;

import annotations.MyStyle;

@MyStyle
@Immutable
public interface UserIF {
  String getFIrstName();
  String getLastName();
  Optional<String> getAccesToken();
}
