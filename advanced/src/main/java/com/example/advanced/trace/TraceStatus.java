package com.example.advanced.trace;

public class TraceStatus {

	//로그의 상태 정보를 나타낸다
	//로그를 시작하면 끝이잇어야한다.
	// traceId: 내부에 트랜잭션ID와 level을 가지고 있다.
	 private TraceId traceId;
	 private Long startTimeMs;
	 private String message;
	 
	 
	 public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
		 this.traceId = traceId;
		 this.startTimeMs = startTimeMs;
		 this.message = message;
	}
	 public Long getStartTimeMs() {
		 return startTimeMs;
	 } 
	 public String getMessage() {
		 return message;
	 }
	 public TraceId getTraceId() {
		 return traceId;
	 }
}
