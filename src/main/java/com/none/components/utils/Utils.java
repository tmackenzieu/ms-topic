package com.none.components.utils;

import com.none.components.messages.Message;
import com.none.components.messages.MessageComponents;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Tabata Mackenzie
 */
@Component
public class Utils {

  private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

  /**
   * Convierte un objeto ( Entidad,Dto) en un pretty json
   *
   * @return Objeto convertido en Json String
   */
  public String convertToJson(Object object) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.setSerializationInclusion(Include.NON_NULL);
      ObjectWriter objectWriter = mapper.writer();
      return objectWriter.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      LOG.error(e.getMessage());
      return e.getMessage();
    }
  }

  /**
   * Convierte un objeto ( Entidad,Dto) en un pretty json
   *
   * @return Objeto convertido en Json String
   */
  public String convertToJsonWithNull(Object object) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      ObjectWriter objectWriter = mapper.writer();
      return objectWriter.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      LOG.error(e.getMessage());
      return e.getMessage();
    }
  }

  /**
   * Obtiene la fecha actual en UTC (Universal Time Coordinated)
   *
   * @return Fecha actual en UTC.
   */
  public String getCurrentDateUTC() {
    LocalDateTime utc = LocalDateTime.now(ZoneId.of(ZoneOffset.UTC.getId()));
    return Date.from(utc.atZone(ZoneId.systemDefault()).toInstant()).toString();
  }

  /**
   * Construye el objeto Message para publicar evento
   *
   * @return Objeto mensaje.
   */
  public Message getPublishMessage(String eventType, String entityType, Object data) {
    return new Message(
        UUID.randomUUID().toString(),
        eventType,
        entityType,
        MessageComponents.VERSION.getValue(),
        MessageComponents.COUNTRY.getValue(),
        MessageComponents.DOMAIN.getValue(),
        getCurrentDateUTC(),
        data);
  }
}

