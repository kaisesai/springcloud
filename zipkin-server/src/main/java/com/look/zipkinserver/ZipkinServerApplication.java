package com.look.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.Compression;
import org.springframework.context.annotation.Bean;
import zipkin2.server.internal.EnableZipkinServer;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableZipkinServer
// @EnableEurekaClient
@SpringBootApplication
public class ZipkinServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZipkinServerApplication.class, args);
  }

}
