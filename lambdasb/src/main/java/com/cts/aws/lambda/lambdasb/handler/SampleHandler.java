package com.cts.aws.lambda.lambdasb.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

@Configuration
public class SampleHandler {
    @Bean(name="springManagedUpperCase")
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}



	@Bean(name="springManagedHandleHelloRequest")
	public Function<Message<String>, Message<String>> handleHelloRequest() {
		return value -> {			
			String payload=value.getPayload();
			Map<String, Object> resultHeader = new HashMap();
    		resultHeader.put("statuscode", HttpStatus.OK.value());
			resultHeader.put("X-Custom-Header", "Hello World from Spring Cloud Function AWS Adapter");
			resultHeader.put("Content-Type",MimeTypeUtils.APPLICATION_JSON_VALUE);
    		return new GenericMessage(payload, resultHeader);
		};
	}
}
