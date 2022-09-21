package com.example.advanced.v3;

import org.springframework.stereotype.Service;

import com.example.advanced.logtrace.LogTrace;
import com.example.advanced.trace.HelloTraceV1;
import com.example.advanced.trace.HelloTraceV2;
import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
	
	private final OrderRepositoryV3 orderRepository;
	private final LogTrace trace;
	
	public void orderItem( String itemId) {
		TraceStatus status = null;
		 try {
			 status = trace.begin("OrderService.orderItem()");
			 orderRepository.save(itemId);
			 trace.end(status);
		 } catch (Exception e) {
		 		trace.exception(status, e);
		 		throw e;
		 }
	}
}
