package com.none.components.pubsub;

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.pubsub.v1.PubsubMessage;

/**
 * Author: Tabata Mackenzie.
 */

public interface ApiFutureService {

  ApiFuture<String> publishMessage(Publisher publisher, PubsubMessage pubsubMessage);
}
