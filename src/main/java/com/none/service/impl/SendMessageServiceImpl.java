package com.none.service.impl;

import com.none.components.messages.Actions;
import com.none.components.messages.Message;
import com.none.components.pubsub.TopicPublisher;
import com.none.components.utils.Utils;
import com.none.config.GcpProperties;
import com.none.service.SendMessageService;
import com.none.service.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tabata Mackenzie
 */
@Service
public class SendMessageServiceImpl implements SendMessageService {


  TopicPublisher topicPublisher;
  GcpProperties gcpProperties;
  Utils utils;

  private final String CURRENT_NAME_CLASS = SendMessageService.class.getSimpleName();

  @Autowired
  public SendMessageServiceImpl(TopicPublisher topicPublisher,
      GcpProperties gcpProperties, Utils utils) {
    this.topicPublisher = topicPublisher;
    this.gcpProperties = gcpProperties;
    this.utils = utils;
  }

  @Override
  public void sendMessageToTopic(MessageDTO messageDTO) throws Exception {
    Message message = utils
        .getPublishMessage(Actions.MODIFY.getValue(), CURRENT_NAME_CLASS,
            messageDTO);
    topicPublisher.send(utils.convertToJson(message), gcpProperties.getTp_order_status());
  }
}
