package com.sahil.dockerforjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sahil.dockerforjava")
public class DockerforjavaApplication {

	//Spring Initializer - Java 17, Maven, War (ie tomcat must be provided by the host), spring web & spring boot actuator.
	public static void main(String[] args) {
		SpringApplication.run(DockerforjavaApplication.class, args);
	}

}
