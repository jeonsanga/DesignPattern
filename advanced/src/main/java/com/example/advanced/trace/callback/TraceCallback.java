package com.example.advanced.trace.callback;

public interface TraceCallback<T> {
	
	T call();
	
	//T라는 제네릭은 반환타입을 나중에 바꿀수 있다.

}
