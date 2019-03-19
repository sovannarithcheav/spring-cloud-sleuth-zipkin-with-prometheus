package com.sovannarith.prometheus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0")
public class WebController {

	@RequestMapping("")
	public String helloWorld() {
		return "Hello World";
	}



}
