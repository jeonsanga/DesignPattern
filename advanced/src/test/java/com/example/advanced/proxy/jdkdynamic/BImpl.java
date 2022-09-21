package com.example.advanced.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface{

	@Override
	public String call() {
		log.info("A호출");
		return "a";
	}

}
