package com.none.components.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageComponents {

  VERSION("1.0"),
  VERSION2("2.0"),
  COUNTRY("CL"),
  DOMAIN("NONE"),
  CHANNEL("NONE"),
  COMMERCE("NONE"),
  CAPABILITY("FTRACK");
  private String value;
}
