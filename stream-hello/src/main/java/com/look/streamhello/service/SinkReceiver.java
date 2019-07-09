package com.look.streamhello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.SubscribableChannel;

/**
 * {@link EnableBinding} 启动消费驱动功能
 */
@Slf4j
@EnableBinding(value = {SinkReceiver.ExampleBinder.class})
// @EnableBinding(value = {Processor.class})
public class SinkReceiver {

  @StreamListener(ExampleBinder.NAME)
  public void recive(Object payload) {
    log.info("Recive: {}", payload);
  }

  public interface ExampleBinder {

    String NAME = "example-topic";

    @Input(NAME)
    SubscribableChannel input();

  }
}
