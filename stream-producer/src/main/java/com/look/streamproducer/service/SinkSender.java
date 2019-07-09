package com.look.streamproducer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

@Slf4j
@EnableBinding(value = {SinkSender.ExampleBinder.class})
public class SinkSender {

  @Bean
  @InboundChannelAdapter(value = ExampleBinder.NAME, poller = @Poller(fixedDelay = "2000"))
  public MessageSource<String> timerMessageSource() {

    String payload = "{\"name\":\"didi\", \"age\":30}";
    log.info("send: " + payload);
    return () -> new GenericMessage<>(payload);
  }

  public interface ExampleBinder {

    String NAME = "example-topic";

    @Output(NAME)
    MessageChannel output();

  }

}
