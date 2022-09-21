package com.example.advanced.v1;


import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

//Componentscan 대상이됨
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
	
	public void save(String itemId) {
		//저장로직
		if(itemId.equals("ex")) {
			//ex이면 예외발생하게
			throw new IllegalStateException();
		}
		//정상적인흐름일때
		sleep(1000);
	}

	private void sleep(int mills) {
		try {
			//주어진 시간동안 일시정지. 실행대기상태로 돌아감
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
