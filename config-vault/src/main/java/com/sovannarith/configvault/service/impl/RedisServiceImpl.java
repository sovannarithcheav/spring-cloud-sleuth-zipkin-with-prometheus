package com.sovannarith.configvault.service.impl;

import com.sovannarith.configvault.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by kimchheng on 3/19/18.
 */
@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private HashOperations<String, String, String> hashOperations;

	private ValueOperations<String, String> valueOperations;

	@PostConstruct
	private void postConstructor() {
		hashOperations = stringRedisTemplate.opsForHash();
		valueOperations = stringRedisTemplate.opsForValue();
	}

	@Override
	public void put(String key, String value) {

	}

	@Override
	public void put(String type, String key, String json) {

	}

	@Override
	public void put(String type, Map<String, String> map) {
		Assert.notNull(type, "Type can not be null");
		Assert.notNull(map, "Map can not null");
		for (Map.Entry<String, String> entry : map.entrySet())
			hashOperations.put(type, entry.getKey(), entry.getValue());
	}


	@Override
	public String get(String type, String key) {
		Assert.notNull(type, "Type can not be null");
		Assert.notNull(key, "Key can not be null");
		String vaule = hashOperations.get(type, key);
		return vaule != null ? vaule : "";
	}

	@Override
	public String get(String key) {
		return null;
	}

	@Override
	public void remove(String key) {

	}

	@Override
	public void remove(String type, String key) {

	}


}
