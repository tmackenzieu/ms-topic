package com.none.components.messages;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
/**
 * @Author Tabata Mackenzie
 */

public enum Actions {

  ADD("ADD"),
  DELETE("DELETE"),
  MODIFY("MODIFY"),
  ACTIVATE("ACTIVATE"),
  DEACTIVATE("DEACTIVATE");

  private String value;
}
