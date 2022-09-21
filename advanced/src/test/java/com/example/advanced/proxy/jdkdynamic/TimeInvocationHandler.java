package com.example.advanced.proxy.jdkdynamic;

import java.lang.reflect.Method;

import com.example.advanced.proxy.reflect.InvocationHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler{

	//InvocationHandler 인터페이스 구현
	
	//동적프록시가 호출할대상
	private final Object target ;
	

	public TimeInvocationHandler(Object target) {
		super();
		//this로 인스터번변수에 접근
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("TimeProxy실행");
		long startTime = System.currentTimeMillis();
		
		//method클래스 기능
		Object result = method.invoke(target, args);
		long endTime = System.currentTimeMillis();
		 long resultTime = endTime - startTime;
		 log.info("TimeProxy 종료 resultTime={}", resultTime);
		 return result;
	}

}
