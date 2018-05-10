package ar.edu.unlp.pasae.pasaepractica.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig {

	@Value("${security.oauth2.resource.jwt.key-pair.store-password}")
	private String keyStorePass;

	@Value("${security.oauth2.resource.jwt.key-pair.alias}")
	private String keyPairAlias;

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		final KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"),
				keyStorePass.toCharArray()).getKeyPair(keyPairAlias);
		converter.setKeyPair(keyPair);
		return converter;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
