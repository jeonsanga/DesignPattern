package com.example.advanced.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
	
	//템플릿 매서드 패턴은 다형성을 사용해서 변하는 부분과 변하지 않는 부분을 분리하는 방법
	
	public void execute() {
		 long startTime = System.currentTimeMillis();
		 //비즈니스 로직 실행
		 call(); //상속
		 //비즈니스 로직 종료
		 long endTime = System.currentTimeMillis();
		 long resultTime = endTime - startTime;
		 log.info("완료시간={}", resultTime);
		 }
	
	//템플릿이라는 틀에 변하지 않는 부분을 몰아둔다. 그리고 일부 변하는 부분을 별도로 호출해서 해결한다.
	//추상클래스를 상속받은 실체클래스들은 반드시 추상메서드를 재정의해서 실행내용을 작성해야한다.
	//추상클래스안에서 abstract키워드를 가지고잇는 메서드를 추상메서드라고하고 상속시 반드시 재정의해줘야한다
	 protected abstract void call();

}
