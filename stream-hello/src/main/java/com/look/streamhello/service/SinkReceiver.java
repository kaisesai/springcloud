package com.look.streamhello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;

import java.util.Random;

/**
 * {@link EnableBinding} 启动消费驱动功能
 */
@Slf4j
// @EnableBinding(value = {Sink.class, SinkSender.class})
// @EnableBinding(value = {Sink.class, SinkSender.class})
@EnableBinding(value = {Processor.class})
public class SinkReceiver {

  @StreamListener(Processor.INPUT)
  @SendTo(Processor.OUTPUT)
  public String reciveFromInput(Object payload) {
    log.info("Recive: {}", payload);
    return "from inpput channel return - " + payload;
  }

  @StreamListener(Processor.OUTPUT)
  public void reciveFromOutput(Object payload) {
    log.info("from output channel return : {}", payload);
  }

  @Bean
  @InboundChannelAdapter(value = Processor.INPUT, poller = @Poller(fixedDelay = "2000"))
  public MessageSource<String> timerMessageSource() {
    // 函数式编程,返回函数的目标参数
    return () -> new GenericMessage<>(String.valueOf(new Random().nextInt(100)));
  }

  // @StreamListener(Sink.INPUT)
  // public void recive(Object payload) {
  //   log.info("Recive: {}", payload);
  // }

  // @ServiceActivator(inputChannel = Sink.INPUT)
  // public void recive(Object payload) {
  //   log.info("Recive: {}", payload);
  // }

}
