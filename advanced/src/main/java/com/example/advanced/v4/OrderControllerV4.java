package com.example.advanced.v4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advanced.logtrace.LogTrace;
import com.example.advanced.trace.AbstractTemplate;
import com.example.advanced.trace.HelloTraceV1;
import com.example.advanced.trace.HelloTraceV2;
import com.example.advanced.trace.TraceStatus;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {
	
	private final OrderServiceV4 orderService;
	private final LogTrace trace;
	
	 @GetMapping("/v4/request")
	 public String request(String itemId) {
		 //제네릭을 String 으로 설정 따라서 반환타입은 String이된다.
		 AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
			 //익명내부클래스
			@Override
			protected String call() {
				orderService.orderItem(itemId);
				return "ok";
			}
			 
		 };
		 return template.excute("OrderController.request()");
		
	 }

}
