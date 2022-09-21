package com.example.advanced.trace;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.advanced.trace.HelloTraceV1;
import com.example.advanced.trace.TraceStatus;

@SpringBootTest
class TraceStatusV1Test {

	@Test
	void begin_end() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.end(status);
	}
	
	@Test
	void begin_exception() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("helo");
		trace.exception(status, new IllegalStateException());
	}
	


}
