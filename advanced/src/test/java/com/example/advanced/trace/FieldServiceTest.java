package com.example.advanced.trace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.advanced.trace.test.FieldService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class FieldServiceTest {
	
	@Autowired
	private FieldService fieldService;

	@Test
	void field() {
		log.info("main start");
		
		Runnable userA = ()->{
			fieldService.logic("userA");
		};
		
		Runnable userB = ()->{
			fieldService.logic("userB");
		};
		
		//상속을 받아사용해야 하기때문에 다른 클래스를 상속받아 사용할수 없다는 단점이있다.
		//setName : 스레드 이름 설정
		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");
		
		threadA.start();
		sleep(2000); //동시성문제 발생x
		
		
		threadB.start();
		sleep(3000); //메인쓰레드 종료대기
		log.info("main exit");
	}

	private void sleep(int millis) {
		try {
			 Thread.sleep(millis);
			 } catch (InterruptedException e) {
			 e.printStackTrace();
			 }
		
	}

}
