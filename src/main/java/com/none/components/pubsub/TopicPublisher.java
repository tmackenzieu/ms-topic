package com.none.components.pubsub;

import com.none.config.GcpProperties;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.pubsub.v1.PubsubMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Tabata Mackenzie
 */
@Component
public class TopicPublisher {

  private static final Logger LOG = LoggerFactory.getLogger(TopicPublisher.class);

  PublisherService publisherService;

  PubSubMessageService pubSubMessageService;

  ApiFutureService apiFutureService;

  GcpProperties gcpProperties;

  @Autowired
  public TopicPublisher(PublisherService publisherService,
                       PubSubMessageService pubSubMessageService,
                       ApiFutureService apiFutureService, GcpProperties gcpProperties) {
    this.publisherService = publisherService;
    this.pubSubMessageService = pubSubMessageService;
    this.apiFutureService = apiFutureService;
    this.gcpProperties = gcpProperties;
  }

  public Boolean send(String value, String topicName) throws Exception {
    Publisher publisher = publisherService
        .getPublisher(gcpProperties.getProject_id(), topicName);
    List<ApiFuture<String>> futures = new ArrayList<>();
    try {
      PubsubMessage pubsubMessage = pubSubMessageService.getPubSubMessage(value);
      futures.add(apiFutureService.publishMessage(publisher, pubsubMessage));
    } finally {
      List<ApiFuture<String>> futureList = futures.stream().filter(Objects::nonNull)
          .collect(Collectors.toList());

      ApiFutures.allAsList(futureList).get().stream().forEach(LOG::info);

      if (publisher != null) {
        publisher.shutdown();
      }
    }
    return true;
  }
}
