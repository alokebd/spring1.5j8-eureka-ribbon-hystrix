package com.ait.microservices.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScans;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
//@ComponentScans("com.ait.microservices.zipkin")
public class ZipkinApplication {
   
	/*
	 * Zipkin is a distributed tracing system that helps gather timing data needed to troubleshoot latency problems in microservice 
	 * architectures
	 * 
	 * While Sleuth helps to generate trace information, visualizing and storing it is a job for a tool like Zipkin
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZipkinApplication.class, args);
	}

}
