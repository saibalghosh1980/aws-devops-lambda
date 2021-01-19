package com.cts.aws.lambda.lambdasb.handler;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleHandler {
    @Bean(name="springManagedUpperCase")
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}
}
