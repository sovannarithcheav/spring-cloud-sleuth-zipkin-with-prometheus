package com.sovannarith.configvault.service;

import java.util.Map;

public interface RedisService {

	void put(String key, String value);

	void put(String type, String key, String json);

	void put(String type, Map<String, String> map);

	String get(String type, String key);

	String get(String key);

	void remove(String key);

	void remove(String type, String key);

}
