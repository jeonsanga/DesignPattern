package com.example.advanced.trace;

import java.util.UUID;

public class TraceId {
	
	private String id;
	private int level;
	
	public TraceId() {
		 this.id = createId();
		 this.level = 0;
		 }
		 private TraceId(String id, int level) {
		 this.id = id;
		 this.level = level;
		 }

	private String createId() {
		//uuid로 생성된 앞 8자리만 잘라서 사용
		return UUID.randomUUID().toString().substring(0,8);
	}
	
	//id는 똑같고 레벨은 하나증가
	public TraceId createNextId() {
		return new TraceId(id,level+1);
	}
	//id 는 기존과 같고, level 은 하나 감소한다.
	public TraceId createPreviousId() {
		return new TraceId(id,level-1);
	}
	
	//첫번째 레벨 여부를 편리하게 확인할수 있는 메서드
	 public boolean isFirstLevel() {
		 return level == 0;
	}
	 
	 public String getId() {
		 return id;
	}
	 public int getLevel() {
	 return level;
	}
	

}
