package com.example.advanced.proxy.proxypattern.code;

public class ProxyPatternClient {
	
	
	private Subject subject;

	public ProxyPatternClient(Subject subject) {
		
		this.subject = subject;
	}
	
	public void execute() {
		subject.operation();
	}
	
	//subject인터페이스에 의존하고 subject를 호출하는 클라이언트 코드이다
	

}
