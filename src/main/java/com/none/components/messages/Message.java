package com.none.components.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Tabata Mackenzie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

  private String eventId;
  private String evenType;
  private String entityType;
  private String version;
  private String country;
  private String domain;
  private String date;
  private Object data;
}
