// package com.look.streamhello.controller;
//
// import com.look.streamhello.service.SinkSender;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.messaging.support.MessageBuilder;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
//
// @Slf4j
// @RestController
// public class SinkController {
//
//   private final SinkSender sinkSender;
//
//   public SinkController(SinkSender sinkSender) {
//     this.sinkSender = sinkSender;
//   }
//
//   @RequestMapping(value = "/sinksend")
//   public String sinkSend(@RequestParam(value = "msg") String msg) {
//     log.info("msg: " + msg);
//     sinkSender.output().send(MessageBuilder.withPayload(msg).build());
//     return msg;
//   }
//
// }
