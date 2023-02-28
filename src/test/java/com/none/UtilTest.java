package com.none;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * @author Tabata Mackenzie
 */
public class UtilTest {
  public static String convertToJson(Object input) throws JsonProcessingException {
    ObjectWriter object = new ObjectMapper().writer().withDefaultPrettyPrinter();
    return object.writeValueAsString(input);
  }

}
