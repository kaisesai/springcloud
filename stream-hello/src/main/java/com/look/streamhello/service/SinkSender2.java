// package com.look.streamhello.service;
//
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.cloud.stream.annotation.EnableBinding;
// import org.springframework.cloud.stream.annotation.Output;
// import org.springframework.cloud.stream.messaging.Processor;
// import org.springframework.cloud.stream.messaging.Sink;
// import org.springframework.context.annotation.Bean;
// import org.springframework.integration.annotation.InboundChannelAdapter;
// import org.springframework.integration.annotation.Poller;
// import org.springframework.integration.annotation.Transformer;
// import org.springframework.integration.core.MessageSource;
// import org.springframework.messaging.MessageChannel;
// import org.springframework.messaging.support.GenericMessage;
//
// import java.text.SimpleDateFormat;
// import java.util.Date;
//
// @Slf4j
// // @EnableBinding(value = {SinkSender2.SinkOutput.class})
// @EnableBinding(value = {Processor.class})
// public class SinkSender2 {
//
//   /**
//    * {@link Poller} 定时创建 bean
//    *
//    * <p>
//    *   () -> new GenericMessage<>(new Date()); 函数式变成,返回一个
//    * </p>
//    *
//    * @return
//    */
//   @Bean
//   @InboundChannelAdapter(value = SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "2000"))
//   public MessageSource<Date> timerMessageSource() {
//     // 函数式编程,返回函数的目标参数
//     return () -> new GenericMessage<>(new Date());
//   }
//
//   @Transformer(inputChannel = Sink.INPUT, outputChannel = SinkOutput.OUTPUT)
//   public Object transform(Date message){
//     return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(message);
//   }
//
//
//   public interface SinkOutput {
//
//     String OUTPUT = "output";
//
//     @Output(value = OUTPUT)
//     MessageChannel output();
//   }
// }
