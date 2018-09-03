package com.finup.dataeco.utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.util.Assert;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {
	private static Logger logger = LoggerFactory.getLogger(RestTemplateUtil.class);

	public static RestTemplate getOAuth2RestTemplate(Map<String, String> envConfig) {

		ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
		resource.setAccessTokenUri(envConfig.get("oauth.accessTokenUri"));
		resource.setClientId(envConfig.get("oauth.clientId"));
		resource.setClientSecret(envConfig.get("oauth.secret"));
		resource.setGrantType(envConfig.get("oauth.grantType"));

		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource,
				new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));

		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setReadTimeout(80000);
		httpComponentsClientHttpRequestFactory.setConnectTimeout(80000);
		restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);

		restTemplate.setErrorHandler(new ResponseErrorHandler() {

			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}

			public void handleError(ClientHttpResponse response) throws IOException {

				logger.error("ResponseStatus:{} {}", response.getRawStatusCode(), response.getStatusText());
				Assert.state(response.getRawStatusCode() == 200, "********* http请求失败  *********");
			}
		});
		return restTemplate;

	}

	public static RestTemplate getOAuth2SSLRestTemplate(Map<String, String> envConfig)
			throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {

		ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
		resource.setAccessTokenUri(envConfig.get("oauth.accessTokenUri"));
		resource.setClientId(envConfig.get("oauth.clientId"));
		resource.setClientSecret(envConfig.get("oauth.secret"));
		resource.setGrantType(envConfig.get("oauth.grantType"));

		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource,
				new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
		// 指定自定义的httpClient
		CloseableHttpClient httpClient = HttpClientUtils.acceptsUntrustedCertsHttpClient();
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				httpClient);
		httpComponentsClientHttpRequestFactory.setReadTimeout(80000);
		httpComponentsClientHttpRequestFactory.setConnectTimeout(80000);
		restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
		restTemplate.setErrorHandler(new ResponseErrorHandler() {

			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}

			public void handleError(ClientHttpResponse response) throws IOException {

				logger.error("ResponseStatus:{} {}", response.getRawStatusCode(), response.getStatusText());
				Assert.state(response.getRawStatusCode() == 200, "********* http请求失败  *********");
			}
		});
		return restTemplate;

	}

	public static RestTemplate getSSLRestTemplate(Map<String, String> envConfig)
			throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		// 指定自定义的httpClient
		CloseableHttpClient httpClient = HttpClientUtils.acceptsUntrustedCertsHttpClient();
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				httpClient);
		httpComponentsClientHttpRequestFactory.setReadTimeout(80000);
		httpComponentsClientHttpRequestFactory.setConnectTimeout(80000);

		RestTemplate restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory);
		restTemplate.setErrorHandler(new ResponseErrorHandler() {

			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}

			public void handleError(ClientHttpResponse response) throws IOException {

				logger.error("ResponseStatus:{} {}", response.getRawStatusCode(), response.getStatusText());
				Assert.state(response.getRawStatusCode() == 200, "********* http请求失败  *********");
			}
		});
		return restTemplate;

	}

	public static RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(80000);
		requestFactory.setReadTimeout(80000);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		restTemplate.setErrorHandler(new ResponseErrorHandler() {

			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}

			public void handleError(ClientHttpResponse response) throws IOException {

				logger.error("ResponseStatus:{} {}", response.getRawStatusCode(), response.getStatusText());
				Assert.state(response.getRawStatusCode() == 200, "********* http请求失败  *********");
			}
		});
		return restTemplate;
	}
}
