package com.example.advanced.logtrace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.advanced.trace.TraceStatus;

@SpringBootTest
class ThreadLocallogTraceTest {
	
	
	@Autowired
	private ThreadLocallogTrace trace = new ThreadLocallogTrace();

	@Test
	void begin_end_level2(){
		TraceStatus status1 = trace.begin("hello1");
		 TraceStatus status2 = trace.begin("hello2");
		 trace.end(status2);
		 trace.end(status1);
	}
	
	
	@Test
	 void begin_exception_level2() {
		 TraceStatus status1 = trace.begin("hello");
		 TraceStatus status2 = trace.begin("hello2");
		 trace.exception(status2, new IllegalStateException());
		 trace.exception(status1, new IllegalStateException());
	 }

}
