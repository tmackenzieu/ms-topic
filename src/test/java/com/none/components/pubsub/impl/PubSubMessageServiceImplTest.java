package com.none.components.pubsub.impl;

import com.none.components.pubsub.PubSubMessageService;
import com.google.pubsub.v1.PubsubMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PubSubMessageServiceImplTest {

  @Autowired
  PubSubMessageService pubSubMessageService;

  @TestConfiguration
  static class PubSubMessageServiceImplContextConfiguration {

    @Primary
    @Bean
    public PubSubMessageService pubSubMessageService() {
      return new PubSubMessageServiceImpl();
    }
  }


  @Test
  public void getPubSubMessage() {
    PubsubMessage pubsubMessage = pubSubMessageService.getPubSubMessage("anyText");
    Assert.assertEquals(PubsubMessage.class, pubsubMessage.getClass());
  }
}