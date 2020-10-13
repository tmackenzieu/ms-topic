package com.none.components.pubsub.impl;


import com.none.components.pubsub.ApiFutureService;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.pubsub.v1.PubsubMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ApiFutureServiceImplTest {

  @Autowired
  ApiFutureService apiFutureService;

  @TestConfiguration
  static class ApiFutureServiceImplContextConfiguration {

    @Primary
    @Bean
    public ApiFutureService apiFutureService() {
      return new ApiFutureServiceImpl();
    }
  }

  @Test
  public void publishMessage() {
    Publisher publisher = Mockito.mock(Publisher.class);
    PubsubMessage pubsubMessage = PubsubMessage.newBuilder().build();
    apiFutureService.publishMessage(publisher, pubsubMessage);
  }
}