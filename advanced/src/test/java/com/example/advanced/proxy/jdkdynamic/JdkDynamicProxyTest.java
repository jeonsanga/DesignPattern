package com.example.advanced.proxy.jdkdynamic;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class JdkDynamicProxyTest {

	@Test
	void dynamicA() {
		//인터페이스는 객체 생성이안되므로 부모로 구현받은 자식이부모로 객체를 생성한다
		AInterface target = new AImpl();
		TimeInvocationHandler handler = new TimeInvocationHandler(target);
		 AInterface proxy = (AInterface)
				 Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, (InvocationHandler) handler);
		 log.info("targetClass={}", target.getClass());
		 log.info("proxyClass={}", proxy.getClass());
	}

}
