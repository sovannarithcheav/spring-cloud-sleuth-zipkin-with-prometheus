package com.sovannarith.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constant {

	static Logger getLogger(Object clazz) {
		return LoggerFactory.getLogger(clazz.getClass());
	}

}
