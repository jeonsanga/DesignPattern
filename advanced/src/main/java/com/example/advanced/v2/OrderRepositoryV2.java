package com.example.advanced.v2;


import org.springframework.stereotype.Repository;

import com.example.advanced.trace.HelloTraceV2;
import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;

import lombok.RequiredArgsConstructor;

//Componentscan 대상이됨
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
	private final HelloTraceV2 trace;
	public void save(TraceId traceId, String itemId) {
		TraceStatus status = null;
		
		try {
			status = trace.beginSync(traceId, "OrderRepository.save()");
			//저장로직
			if(itemId.equals("ex")) {
				//ex이면 예외발생하게
				throw new IllegalStateException();
				
			}
			//정상적인흐름일때
			sleep(1000);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			 throw e;
		}
		
		
		
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
