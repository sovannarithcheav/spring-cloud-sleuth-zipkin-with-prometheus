package com.sovannarith.checkhealth.custom;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component("appConfiguration")
@RefreshScope
@ConfigurationProperties("health-check-service")
public class AppConfiguration {

	private int min;
	private int max;
	private String vaultHost;
	private String token;
	private String type;
	private String roleId;
	private String secretId;

	public AppConfiguration() {
	}

	public void process(String message) {
		System.out.println(message.toString());
	}

	public void setMin(int min) {
		this.min = min;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public String getVaultHost() {
		return vaultHost;
	}

	public void setVaultHost(String vaultHost) {
		this.vaultHost = vaultHost;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	public String getRoleId() {
		return roleId;
	}

	public String getSecretId() {
		return secretId;
	}
}
