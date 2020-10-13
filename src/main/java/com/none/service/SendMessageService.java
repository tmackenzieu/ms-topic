package com.none.service;

import com.none.service.dto.MessageDTO;

/**
 * @author Tabata Mackenzie
 */
public interface SendMessageService {

  void sendMessageToTopic(MessageDTO messageDTO) throws Exception;

}
