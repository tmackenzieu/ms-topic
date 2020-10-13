package com.none.components.pubsub.impl;

import com.none.components.pubsub.ApiFutureService;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.pubsub.v1.PubsubMessage;
import org.springframework.stereotype.Service;

@Service
public class ApiFutureServiceImpl implements ApiFutureService {

  @Override
  public ApiFuture<String> publishMessage(Publisher publisher, PubsubMessage pubsubMessage) {
    return publisher.publish(pubsubMessage);

  }
}
