package com.example.advanced.proxy.intercept;

import org.aopalliance.intercept.Interceptor;
import org.aopalliance.intercept.MethodInvocation;

public interface MethodInterceptor extends Interceptor{
	
	Object invoke(MethodInvocation invocation)throws Throwable;
}
