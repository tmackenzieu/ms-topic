package com.none.components.pubsub.impl;

import com.none.components.pubsub.PubSubMessageService;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import org.springframework.stereotype.Service;

/**
 * @Author Tabata Mackenzie
 */
@Service
public class PubSubMessageServiceImpl implements PubSubMessageService {

  /**
   * convert message to bytes
   */
  @Override
  public PubsubMessage getPubSubMessage(String message) {
    ByteString messageByteString = ByteString.copyFromUtf8(message);
    return PubsubMessage.newBuilder()
        .setData(messageByteString)
        .build();
  }
}
