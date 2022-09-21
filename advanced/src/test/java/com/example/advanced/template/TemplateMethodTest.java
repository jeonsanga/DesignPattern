package com.example.advanced.template;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.advanced.template.code.AbstractTemplate;
import com.example.advanced.template.code.SubClassLogic1;
import com.example.advanced.template.code.SubClassLogic2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TemplateMethodTest {

	@Test
	 void templateMethodV0() {
		 logic1();
		 logic2();
	 }

	private void logic2() {
		long startTime = System.currentTimeMillis();
		
		log.info("비즈니스 로직1 실행");
		
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
		
	}

	private void logic1() {
		long startTime = System.currentTimeMillis();
		 //비즈니스 로직 실행
		 log.info("비즈니스 로직2 실행");
		 //비즈니스 로직 종료
		 long endTime = System.currentTimeMillis();
		 long resultTime = endTime - startTime;
		 log.info("resultTime={}", resultTime);
		
	}
	
	//변하는 부분 : 비즈니스로직만 변함
	
	//템플릿 메서드 패턴 적용
	@Test
	void templateMethod1() {
		AbstractTemplate template1 = new SubClassLogic1();
		template1.execute();
		
		 AbstractTemplate template2 = new SubClassLogic2();
		 template2.execute();
	
	}
	
	//템플릿 메서드 패턴은 클래스를 계속만들어야하는 단점이잇는데 익명내부클래스를 사용하면 단점보완			
	@Test
	void templateMethodV2() {
		AbstractTemplate template1 = new AbstractTemplate() {

			@Override
			protected void call() {
				log.info("비즈니스 로직1 실행");
			}
		};
		
		log.info("클래스 이름1={}", template1.getClass());
		template1.execute();
		
		AbstractTemplate template2 = new AbstractTemplate() {
			 @Override
		protected void call() {
			 log.info("비즈니스 로직1 실행");
			 	}
			 };
			 log.info("클래스 이름2={}", template2.getClass());
			 template2.execute();
	}
}
