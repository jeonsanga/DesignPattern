package com.example.advanced.logtrace.template;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TemplateCallbackTest {

	@Test
	void test() {
		TimeLogTemplate template = new TimeLogTemplate();
		
		template.execute(new Callback() {
			
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");
			}
		});
	}
	
	@Test
	void callback2() {
		TimeLogTemplate template = new TimeLogTemplate();
		 template.execute(() -> log.info("비즈니스 로직1 실행"));
		 template.execute(() -> log.info("비즈니스 로직2 실행"));
	}

}
