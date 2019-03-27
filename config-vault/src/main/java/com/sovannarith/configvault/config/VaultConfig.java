package com.sovannarith.configvault.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.AppRoleAuthentication;
import org.springframework.vault.authentication.AppRoleAuthenticationOptions;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import java.net.URI;


@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

	private Logger log = LoggerFactory.getLogger(VaultConfig.class);

	@Value("${VAULT_HOST}")
	private String vaultHost;

	@Value("${VAULT_ROLE_ID}")
	private String roleId;

	@Value("${VAULT_SECRET_ID}")
	private String secretId;

	@Override
	public VaultEndpoint vaultEndpoint() {
		log.info("vault host:" + vaultHost);
		return VaultEndpoint.from(URI.create(vaultHost));
	}

	@Override
	public ClientAuthentication clientAuthentication() {
		AppRoleAuthenticationOptions options = AppRoleAuthenticationOptions.builder()
				.roleId(AppRoleAuthenticationOptions.RoleId.provided(roleId))
				.secretId(AppRoleAuthenticationOptions.SecretId.provided(secretId))
				.build();
		return new AppRoleAuthentication(options, restOperations());
	}
}
