package com.example.advanced.proxy.proxypattern.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{

	//RealSubject 는 Subject 인터페이스를 구현햇다
	@Override
	public String operation() {
		log.info("실제객체호출");
		
		//데이터 조호히를 시뮬레이션하기 위해 1초 쉬도록함
		sleep(1000);
		return "data";
	}

	private void sleep(int mills) {
		try {
			Thread.sleep(mills);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
