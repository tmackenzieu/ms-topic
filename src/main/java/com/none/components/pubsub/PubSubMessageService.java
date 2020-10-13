package com.none.components.pubsub;

import com.google.pubsub.v1.PubsubMessage;

public interface PubSubMessageService {

  PubsubMessage getPubSubMessage(String message);
}
