package com.finup.dataeco.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finup.dataeco.service.ProjectService;
import com.finup.dataeco.service.UserinfoService;

@Controller
@RequestMapping("/api")
public class ViewsController {
	@Autowired
	UserinfoService userinfoService;
	@Autowired
	ProjectService projectService;
	// JSP页面
	// @RequestMapping("/index")
	// public String index(Map<String, Object> map) {
	// map.put("name", "HelloController");// 将数据返回到页面
	// return "index";
	// }

	// Thymeleaf模板引擎

	@RequestMapping("/login_page")
	public String loginPage(ModelMap modelMap) {
		// 向模板中添加属性
		modelMap.put("login_page", "loginPage");
		// return模板文件的名称，对应src/main/resources/templates/indexTest.html
		return "login";
	}

	@RequestMapping("/index_page")
	public String indexPage(HttpServletRequest request, @RequestParam String account, ModelMap modelMap) {
		modelMap.put("account", account);
		return "index";
	}

	@RequestMapping("/register_page")
	public String registerPage(ModelMap modelMap) {
		return "register";
	}

	@RequestMapping("/database_config_list")
	public String databaseConfigList(ModelMap modelMap) {
		return "database_config_list";
	}

	@RequestMapping("/add_database_config_info")
	public String addDatabaseConfigInfo(ModelMap modelMap) {
		return "add_database_config_info";
	}
	// @RequestMapping(value = "/login", method = { RequestMethod.POST })
	// public String login(HttpServletRequest request, RedirectAttributes
	// model, String account, String password) {
	// Userinfo userinfo = (Userinfo) userinfoService.find(account);
	// // 验证账号密码，如果符合则改变session里的状态，并重定向到主页
	// if (userinfo != null && userinfo.getPassword().equals(password)) {
	// request.getSession().setAttribute("isLogin", "yes");
	// model.addFlashAttribute("account", account);
	// return "redirect:index_page";
	// } else {
	// // 密码错误则重定向回登录页，并返回错误，因为是重定向所要要用到RedirectAttributes
	// model.addFlashAttribute("error", "账号密码错误");
	// return "redirect:login_page";
	// }

	// 登出，移除登录状态并重定向的登录页
	@RequestMapping(value = "/login_out", method = { RequestMethod.GET })
	public String loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("isLogin");
		return "redirect:login_page";
	}

	@RequestMapping(value = "/add_config_page", method = { RequestMethod.GET })
	public String addConfig(HttpServletRequest request) {
		return "add_config";
	}

	@RequestMapping(value = "/edit_config_page", method = { RequestMethod.GET })
	public String editConfig(HttpServletRequest request) {
		return "edit_config";
	}

	@RequestMapping(value = "/add_database_config_info_page", method = { RequestMethod.GET })
	public String addDatabaseConfigInfo(HttpServletRequest request) {
		return "add_database_config_info";
	}

	@RequestMapping(value = "/edit_database_config_info_page", method = { RequestMethod.GET })
	public String editDatabaseConfigInfo(HttpServletRequest request) {
		return "edit_database_config_info";
	}

	@RequestMapping(value = "/report_view_page", method = { RequestMethod.GET })
	public String reportView(HttpServletRequest request) {
		return "report_view";
	}

	@RequestMapping(value = "/report_template_page", method = { RequestMethod.GET })
	public String reportTemplate(HttpServletRequest request) {
		return "report_template";
	}

}
