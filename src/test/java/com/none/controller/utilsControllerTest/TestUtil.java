package com.none.controller.utilsControllerTest;

import java.nio.charset.StandardCharsets;
import org.springframework.http.MediaType;

/**
 * Utility class for testing REST controllers.
 */
public class TestUtil {

  /**
   * MediaType for JSON UTF8
   */
  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
      MediaType.APPLICATION_JSON.getType (),
      MediaType.APPLICATION_JSON.getSubtype (), StandardCharsets.UTF_8);
}
