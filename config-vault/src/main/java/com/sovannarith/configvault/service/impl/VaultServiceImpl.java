package com.sovannarith.configvault.service.impl;

import com.sovannarith.configvault.service.VaultService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.vault.core.VaultOperations;

import java.util.Map;


@Service
public class VaultServiceImpl implements VaultService {

	private VaultOperations operations;

	public VaultServiceImpl(VaultOperations operations) {
		this.operations = operations;
	}

	@Value("${vault-engine}")
	private String engine;

	@Override
	public String get(String appName, String key) {
		Map<String, Object> data = getData(appName);
		Object value = data.get(key);
		return value != null ? value.toString() : "";
	}

	@Override
	public Map<String, Object> getData(String appName) {
		Assert.notNull(appName, "appName can not be null");
		return operations.opsForVersionedKeyValue(engine).get(appName).getData();
	}


}
