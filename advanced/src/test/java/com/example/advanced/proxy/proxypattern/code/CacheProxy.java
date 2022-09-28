package com.example.advanced.proxy.proxypattern.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

	//캐사 사용
	private Subject target;
	private String canchValue;
	
	public CacheProxy(Subject target) {
		super();
		this.target = target;
	}

	@Override
	public String operation() {
		log.info("프록시 호출");
		if(canchValue == null) {
			canchValue = target.operation();
		}
		return canchValue;
	}
	
	
}
