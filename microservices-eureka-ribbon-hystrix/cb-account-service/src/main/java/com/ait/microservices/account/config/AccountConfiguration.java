package com.ait.microservices.account.config;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ait.microservices.account")
public class AccountConfiguration {
    /*
     * Spring Boot application is also to export the logs into Zipkin server.
     */
	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}
	
}
