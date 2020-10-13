package com.none.components.pubsub;

import com.google.cloud.pubsub.v1.Publisher;

public interface PublisherService {

  Publisher getPublisher(String projectId, String topicId) throws Exception;

}
