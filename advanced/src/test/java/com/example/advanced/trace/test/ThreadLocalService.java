package com.example.advanced.trace.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ThreadLocalService {
	
	//동시성문제해결
	// 현재 쓰레드와 관련된 로컬 변수를 하나 생성한다.
	private ThreadLocal<String> nameStore = new ThreadLocal<>();
	
	public String logic(String name) {
		log.info("저장 name={} -> nameStore={}", name, nameStore.get());
		nameStore.set(name);
		sleep(1000);
		log.info("조회 nameStore={}",nameStore);
		return nameStore.get();
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
