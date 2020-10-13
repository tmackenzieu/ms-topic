package com.none.components.pubsub.impl;

import com.none.components.pubsub.PublisherService;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.pubsub.v1.ProjectTopicName;
import java.io.IOException;
import org.springframework.stereotype.Service;

/**
 * @Author Tabata Mackenzie
 */

@Service
public class PublisherServiceImpl implements PublisherService {

  /**
   * Create a publisher instance with default settings bound to the topic
   *
   * @return Publisher
   */
  @Override
  public Publisher getPublisher(String projectId, String topicId) throws Exception {
    ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);
    return getBuild(topicName);
  }

  Publisher getBuild(ProjectTopicName topicName) throws IOException {
    return Publisher.newBuilder(topicName).build();
  }
}
