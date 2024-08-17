package com.ait.microservices.edge;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class ZuulGatewayApplication {
	/*
	 * Zuul uses a blocking API, which means that the request processing thread is blocked until a response is 
	 * returned from the proxied service.
	 * It acts as an API gateway with routing, filtering, and load balancing features.
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulGatewayApplication.class).web(true).run(args);
	}

	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}
	
}
