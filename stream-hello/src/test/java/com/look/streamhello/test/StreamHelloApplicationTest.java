package com.look.streamhello.test;

import com.look.streamhello.service.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamHelloApplicationTest {

  @Autowired
  private SinkSender sinkSender;

  @Test
  public void contextLoads() {
    sinkSender.output().send(MessageBuilder.withPayload("from sinksender").build());
  }

}
