package com.example.advanced.proxy.common.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeAdvice implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("Timeproxy 실행");
		long startTime = System.currentTimeMillis();
		//target클래스를 호출하고 그결과를 받는다 MethodInvocation invocation 안에 모두 포함되어잇다
		Object result = invocation.proceed();
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("TimeProxy 종료 resultTime={}ms", resultTime);
	return result;
	}

}
