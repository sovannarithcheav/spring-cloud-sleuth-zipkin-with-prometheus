package com.sovannarith.clientservice.controller;

import com.sovannarith.configvault.service.VaultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private VaultService vaultService;

	public TestController(VaultService vaultService) {
		this.vaultService = vaultService;
	}

	@GetMapping("")
	public String getVal(){
		return vaultService.get("limit-service", "name");
	}

}
