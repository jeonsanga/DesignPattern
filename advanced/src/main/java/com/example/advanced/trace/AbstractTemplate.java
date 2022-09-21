package com.example.advanced.trace;


import com.example.advanced.logtrace.LogTrace;

//추상메소드 만들어주기 T로 준이유는 제네릭 사용 ,반환타입 정의
public abstract class AbstractTemplate<T> {

	private LogTrace trace ;
	
	public AbstractTemplate(LogTrace trace) {
		this.trace = trace;
	}
	
	public T excute(String message) {
		TraceStatus status = null;
		try {
			status = trace.begin(message);
			
			//로직호출
			T result = call();
			trace.end(status);
			return result;
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
	//abstract T call() 은 변하는 부분을 처리하는 메서드이다. 이 부분은 상속으로 구현해야 한다.
	protected abstract T call();
	
}
