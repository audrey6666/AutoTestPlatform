package com.finup.dataeco.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finup.dataeco.common.Result;
import com.finup.dataeco.model.testPlatform.Userinfo;
import com.finup.dataeco.service.UserinfoService;

@RestController
@RequestMapping("/api/")
public class LoginController {
	@Autowired
	UserinfoService userinfoService;

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public Result login(HttpServletRequest request, RedirectAttributes model, String account, String password) {
		Userinfo userinfo = (Userinfo) userinfoService.find(account);
		// 验证账号密码，如果符合则改变session里的状态，并重定向到主页
		if (userinfo != null && userinfo.getPassword().equals(password)) {
			request.getSession().setAttribute("isLogin", "yes");
			return new Result().SUCCESSED;
		} else {
			return new Result().FAILED;
		}
	}
}
