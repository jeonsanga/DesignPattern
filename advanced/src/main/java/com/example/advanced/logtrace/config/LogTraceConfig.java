package com.example.advanced.logtrace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.advanced.logtrace.FieldLogTrace;
import com.example.advanced.logtrace.LogTrace;
import com.example.advanced.logtrace.ThreadLocallogTrace;

@Configuration
public class LogTraceConfig {
	
	//싱글톤으로 빈으로 등록
	@Bean
	 public LogTrace logTrace() {
		return new ThreadLocallogTrace();

	 }

}
