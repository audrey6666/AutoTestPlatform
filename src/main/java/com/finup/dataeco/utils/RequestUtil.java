package com.finup.dataeco.utils;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.Yaml;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class RequestUtil {
	private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);
	private static Map<String, Map<String, String>> config;

	static {
		Yaml yaml = new Yaml();
		InputStream is = RestTemplateUtil.class.getResourceAsStream("/application-config.yaml");
		config = (Map<String, Map<String, String>>) yaml.load(is);
	}

	public static String getRequest(String envName, String urlSuffix, Map<String, Object> uriVariables) {
		String serverUrl = config.get(envName).get("oauth.serverUrl");
		String url = handleUrl(serverUrl, urlSuffix, uriVariables);
		logger.info("请求的URL：{}", url);
		logger.info("get请求的入参：{}", JSON.toJSONString(uriVariables));
		String result = null;
		if (!serverUrl.contains("api")) {
			result = RestTemplateUtil.getRestTemplate().getForObject(url, String.class);
		} else {
			result = RestTemplateUtil.getOAuth2RestTemplate(config.get(envName)).getForObject(url, String.class);
		}
		logger.info("接口请求结果：{}", result);
		return result;
	}

	public static String getRequestWithHeader(String envName, String urlSuffix, Map<String, Object> uriVariables) {
		String serverUrl = config.get(envName).get("oauth.serverUrl");
		String url = handleUrl(serverUrl, urlSuffix, uriVariables);
		logger.info("请求的URL：{}", url);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/json;charset=UTF-8");
		headers.add("Accept", "*/*");
		HttpEntity<Object> entity = new HttpEntity<Object>(null, headers);

		ResponseEntity<String> responseEntity = null;
		if (!serverUrl.contains("api")) {
			responseEntity = RestTemplateUtil.getRestTemplate().exchange(url, HttpMethod.GET, entity, String.class);
		} else {
			responseEntity = RestTemplateUtil.getOAuth2RestTemplate(config.get(envName)).exchange(url, HttpMethod.GET,
					entity, String.class);
		}
		logger.info("接口请求结果：{}", responseEntity.getBody());
		return responseEntity.getBody();
	}

	public static String postRequest(String envName, String urlSuffix, Object requestBody) {
		String serverUrl = config.get(envName).get("oauth.serverUrl");
		String url = serverUrl + urlSuffix;
		logger.info("请求的URL：{}", url);
		logger.info("body入参：{}", JSONObject.toJSONString(requestBody, SerializerFeature.WriteMapNullValue));

		String result = null;
		if (!serverUrl.contains("api")) {
			result = RestTemplateUtil.getRestTemplate().postForObject(url, requestBody, String.class);
		} else {
			result = RestTemplateUtil.getOAuth2RestTemplate(config.get(envName)).postForObject(url, requestBody,
					String.class);

		}
		logger.info("接口请求结果：{}", result);
		return result;

	}

	public static String postRequest(String envName, String urlSuffix, Object requestBody,
			Map<String, Object> uriVariables) {
		String serverUrl = config.get(envName).get("oauth.serverUrl");
		String url = handleUrl(serverUrl, urlSuffix, uriVariables);
		logger.info("请求的URL：{}", url);
		logger.info("body入参：{}", JSONObject.toJSONString(requestBody));
		String result = null;
		if (!serverUrl.contains("api")) {
			result = RestTemplateUtil.getRestTemplate().postForObject(url, requestBody, String.class);
		} else {
			result = RestTemplateUtil.getOAuth2RestTemplate(config.get(envName)).postForObject(url, requestBody,
					String.class);
		}
		logger.info("接口请求结果：{}", result);
		return result;

	}

	public static String postRequestWithHeader(String envName, String urlSuffix, Object requestBody,
			Map<String, Object> uriVariables) {
		String serverUrl = config.get(envName).get("oauth.serverUrl");
		String url = handleUrl(serverUrl, urlSuffix, uriVariables);
		logger.info("请求的URL：{}", url);
		logger.info("body入参：{}", JSONObject.toJSONString(requestBody));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/json;charset=UTF-8");
		headers.add("Accept", "*/*");
		HttpEntity<Object> entity = new HttpEntity<Object>(requestBody, headers);

		String result = null;
		if (!serverUrl.contains("api")) {
			result = RestTemplateUtil.getRestTemplate().postForObject(url, entity, String.class);
		} else {
			result = RestTemplateUtil.getOAuth2RestTemplate(config.get(envName)).postForObject(url, entity,
					String.class);
		}
		logger.info("接口请求结果：{}", result);
		return result;

	}

	private static String handleUrl(String serverUrl, String urlSuffix, Map<String, Object> uriVariables) {
		StringBuffer sb = new StringBuffer();// StringBuilder(单线程操作字符串缓冲区)：线程非安全的
												// StringBuffer(多线程操作字符串缓冲区)：线程安全的
		sb.append(serverUrl);
		sb.append(urlSuffix);

		if (CollectionUtils.isEmpty(uriVariables)) {
			return sb.toString();
		}
		sb.append("?");
		Iterator<Map.Entry<String, Object>> it = uriVariables.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (null == value) {
				continue;
			} else {
				String str = key + "=" + value + "&";
				sb.append(str);
			}
		}
		String url = sb.toString();
		url = url.substring(0, url.length() - 1);
		return url;
	}

}
