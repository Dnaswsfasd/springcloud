package com.ddfree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NativeConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(NativeConfigServer.class,args);
    }
}
