package com.sahil.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
        //System.out.println("Hello world!");
    }

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();
    }
}