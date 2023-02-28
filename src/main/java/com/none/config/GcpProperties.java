package com.none.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "gcp")
public class GcpProperties {

  private String project_id;
  private String topic_name;
}
