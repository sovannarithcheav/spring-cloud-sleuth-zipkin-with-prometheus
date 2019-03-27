package com.sovannarith.configvault.service;

import java.util.Map;

public interface VaultService {

	String get(String appName, String key);

	Map<String, Object> getData(String appName);


}
