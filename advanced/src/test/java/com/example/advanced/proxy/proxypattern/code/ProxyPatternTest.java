package com.example.advanced.proxy.proxypattern.code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProxyPatternTest {

	@Test
	void noProcyTest() {
		RealSubject realSubject = new RealSubject();
		ProxyPatternClient client = new ProxyPatternClient(realSubject);
		client.execute();
		client.execute();
		client.execute();
	}
	
	@Test
	void cahceProxyTest() {
		Subject realSubject = new RealSubject();
		Subject cahceProxy = new  CacheProxy(realSubject);
		ProxyPatternClient client = new ProxyPatternClient(cahceProxy);
		client.execute();
		 client.execute();
		 client.execute();
	}
}


