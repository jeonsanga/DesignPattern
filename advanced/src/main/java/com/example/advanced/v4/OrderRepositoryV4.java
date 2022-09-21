package com.example.advanced.v4;


import org.springframework.stereotype.Repository;

import com.example.advanced.logtrace.LogTrace;
import com.example.advanced.trace.AbstractTemplate;
import com.example.advanced.trace.HelloTraceV2;
import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;

import lombok.RequiredArgsConstructor;

//Componentscan 대상이됨
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {
	private final LogTrace trace;
	public void save( String itemId) {
		AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
			
			@Override
			protected Void call() {
				if (itemId.equals("ex")) {
					 throw new IllegalStateException("예외 발생!");
					 }
				sleep(1000);
				return null;
			}
		};
		template.excute("OrderRepository.save()");
		
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
