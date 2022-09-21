package com.example.advanced.proxy.jdkdynamic;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ReflectionTest {

	@Test
	void reflection0() {
		Hello target = new Hello();
		//공통로직1시작
		log.info("start");
		String result1 = target.callA();
		log.info("result={}", result1);
		
		//공통 로직2 시작
		 log.info("start");
		 String result2 = target.callB(); //호출하는 메서드가 다름
		 log.info("result={}", result2);
		 //공통 로직2 종료
	}
	
	//리플렉션
	@Test
	void reflection1()throws Exception{
		//클래스 정보
		Class classHello = Class.forName("com.example.advanced.proxy.jdkdynamic.ReflectionTest$Hello");
		
		Hello target = new Hello();
		// callA 메서드 정보
		Method methodCallA = classHello.getMethod("callA");
		Object result1 = methodCallA.invoke(target);
		log.info("result1={}", result1);
		// callB 메서드 정보
		Method methodCallB = classHello.getMethod("callB");
		Object result2 = methodCallB.invoke(target);
		log.info("result2={}", result2);

	}
	
	
	
	 @Slf4j
	 static class Hello {
			public String callA() {
				log.info("callA");
				return "A";
			}

			public String callB() {
				log.info("callB");
				return "B";
			}
		}
	 
	//리플렉션
		@Test
		void reflection2()throws Exception{
			//클래스 정보
			Class classHello = Class.forName("com.example.advanced.proxy.jdkdynamic.ReflectionTest$Hello");
			
			Hello target = new Hello();
			// callA 메서드 정보
			Method methodCallA = classHello.getMethod("callA");
			dynamicCall(methodCallA, target);
			// callB 메서드 정보
			Method methodCallB = classHello.getMethod("callB");
			dynamicCall(methodCallB, target);

		}

	private void dynamicCall(Method method, Hello target) throws Exception {
		log.info("start");
		Object result = method.invoke(target);
		 log.info("result={}", result);
		 
	}

}
