package com.example.advanced.trace.test;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FieldService {
	
	private String nameStore;
	
	public String logic(String name) {
		log.info("저장 name={} -> nameStore={}", name, nameStore);
		nameStore = name;
		sleep(1000);
		log.info("조회 nameStore={}",nameStore);
		return nameStore;
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
