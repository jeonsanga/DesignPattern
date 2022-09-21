package com.example.advanced.v4;

import org.springframework.stereotype.Service;

import com.example.advanced.logtrace.LogTrace;
import com.example.advanced.trace.AbstractTemplate;
import com.example.advanced.trace.HelloTraceV1;
import com.example.advanced.trace.HelloTraceV2;
import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
	
	private final OrderRepositoryV4 orderRepository;
	private final LogTrace trace;
	
	public void orderItem( String itemId) {
	//AbstractTemplate<Void> : 반환타입이 없을때 void를 선언하면된다.
		AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
			@Override
			protected Void call() {
				orderRepository.save(itemId);
				return null;
			}
		};
		
		template.excute("OrderService.orderItem()");
	}
}
