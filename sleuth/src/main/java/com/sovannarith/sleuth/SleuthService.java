package com.sovannarith.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SleuthService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void doSomeWorkSameSpan() throws InterruptedException {
		Thread.sleep(1000L);
		logger.info("Doing some work");
	}
}