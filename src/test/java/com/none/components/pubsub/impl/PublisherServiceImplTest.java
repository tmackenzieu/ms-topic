package com.none.components.pubsub.impl;

import com.none.components.pubsub.PublisherService;
import com.google.cloud.pubsub.v1.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class PublisherServiceImplTest {

  PublisherService publisherService;

  @Before
  public void setUp() {
    publisherService = new PublisherServiceImpl() {
    };
  }

  @Test
  public void getPublisherWithMessagesSet() throws Exception {
    Publisher publisherMock = Mockito.mock(Publisher.class);
    PublisherServiceImpl publisherServiceSpy = Mockito.spy(PublisherServiceImpl.class);

    Mockito.doReturn(publisherMock).when(publisherServiceSpy).getBuild(Mockito.any());

    publisherServiceSpy.getPublisher("projectId", "topicId");

    Mockito.verify(publisherServiceSpy, Mockito.times(1)).getBuild(Mockito.any());

  }
}