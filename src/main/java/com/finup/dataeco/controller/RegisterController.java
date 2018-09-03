package com.finup.dataeco.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finup.dataeco.model.testPlatform.Userinfo;
import com.finup.dataeco.service.UserinfoService;

@RestController
@RequestMapping("/api")
public class RegisterController {
	@Autowired
	UserinfoService userinfoService;

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	public String register(@RequestBody Userinfo userinfo) {
		try {
			userinfo.setStatus(1);
			userinfo.setCreateTime(new Date());
			userinfo.setUpdateTime(new Date());
			userinfoService.insert(userinfo);
			return "恭喜您，账号已成功注册";
		} catch (Exception e) {
			return "阿欧~~~账号注册失败";
		}
	}
}
