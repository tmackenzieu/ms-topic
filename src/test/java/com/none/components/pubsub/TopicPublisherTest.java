package com.none.components.pubsub;


import static org.mockito.BDDMockito.given;

import com.none.config.GcpProperties;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.pubsub.v1.PubsubMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TopicPublisherTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Mock
  PublisherService publisherService;

  @Mock
  PubSubMessageService pubSubMessageService;

  @Mock
  ApiFutureService apiFutureService;

  @Mock
  GcpProperties gcpProperties;

  TopicPublisher nodePublisher;

  @Before
  public void setUp() {
    nodePublisher = new TopicPublisher(publisherService,pubSubMessageService,apiFutureService,gcpProperties);
  }


  @Test
  public void sendMessageToPubSub() throws Exception {
    Publisher publisherMock = Mockito.mock(Publisher.class);

    ApiFuture<String> futuresMock = null;

    Mockito.doReturn(publisherMock).when(publisherService).getPublisher(Mockito.any(), Mockito.any());

    Mockito.doReturn(PubsubMessage.newBuilder().build()).when(pubSubMessageService).getPubSubMessage(
        Mockito.anyString());

    Mockito.when(apiFutureService
        .publishMessage(Mockito.any(), Mockito.any()))
        .thenReturn(futuresMock);


    Boolean nodePublisherIsSend = nodePublisher.send("text", "text");
    Assert.assertTrue(nodePublisherIsSend);
  }

  @Test
  public void sendMessageToPubSub_thenReturnException() throws Exception {

    given(apiFutureService.publishMessage(Mockito.any(), Mockito.any()))
        .willAnswer(invocationOnMock -> {
          throw new Exception("");
        });
    expectedException.expect(Exception.class);
    nodePublisher.send("", "");
  }


}