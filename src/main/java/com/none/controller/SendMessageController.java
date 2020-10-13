package com.none.controller;

import com.none.service.SendMessageService;
import com.none.service.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Tabata Mackenzie
 */
@Controller
public class SendMessageController {

  private static final Logger LOG = LoggerFactory.getLogger(SendMessageController.class);

  @Autowired
  SendMessageService sendMessageService;


  @GetMapping(value = "/send/message", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> sendMessageToTopic(
      @RequestBody MessageDTO messageDTO) throws Exception {

    LOG.debug("Rest GET: /send/message");

    sendMessageService.sendMessageToTopic(messageDTO);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
