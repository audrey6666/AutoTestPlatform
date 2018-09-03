package com.finup.dataeco.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.finup.dataeco.model.testPlatform.Projectinfo;
import com.finup.dataeco.model.testPlatform.Testcaseinfo;
import com.finup.dataeco.service.CaseService;
import com.finup.dataeco.service.ModuleService;
import com.finup.dataeco.service.ProjectService;
import com.finup.dataeco.utils.Paging;
import com.finup.dataeco.vo.TestcaseInfoVo;

@Controller
@RequestMapping("/api")
public class CaseController {
	@Autowired
	CaseService caseService;
	@Autowired
	ProjectService projectService;
	@Autowired
	ModuleService moduleService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/add_case_page", method = { RequestMethod.GET })
	public String addCase(HttpServletRequest request, Model model) {
		Projectinfo projectinfo = new Projectinfo();
		List<Projectinfo> projectinfos = projectService.select(projectinfo);
		model.addAttribute("projectinfos", projectinfos);
		return "add_case";
	}

	@RequestMapping(value = "/test_list_page", method = { RequestMethod.GET })
	public String testList(HttpServletRequest request, Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "2") int size) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("author", request.getParameter("user"));
		paramMap.put("name", request.getParameter("name"));
		Paging paging = new Paging();
		paging.setIndex(page);
		paging.setSize(size);
		paging.setParams(paramMap);
		Paging pagingResult = caseService.list(paging);
		model.addAttribute("paging", pagingResult);
		model.addAttribute("pagNum", page);
		model.addAttribute("user", request.getParameter("user"));
		model.addAttribute("name", request.getParameter("name"));
		return "test_list";
	}

	@RequestMapping(value = "/insert_case", method = { RequestMethod.POST })
	@ResponseBody
	public String insertCase(@RequestBody TestcaseInfoVo testcaseInfoVo)
			throws IllegalAccessException, InvocationTargetException {
		Testcaseinfo testcaseinfo = new Testcaseinfo();
		BeanUtils.copyProperties(testcaseinfo, testcaseInfoVo.getCaseInfo());
		testcaseinfo.setRequest(JSON.toJSONString(testcaseInfoVo.getRequest()));
		testcaseinfo.setCreateTime(new Date());
		testcaseinfo.setUpdateTime(new Date());
		JSONObject requestJson = JSON.parseObject(testcaseInfoVo.getRequest().toString());
		testcaseinfo.setInterfaceUrl(requestJson.getJSONObject("request").getString("url"));
		try {
			caseService.insert(testcaseinfo);
			return "成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}

	@RequestMapping(value = "/edit_case", method = { RequestMethod.POST })
	public String editCase(HttpServletRequest request, Model model, Testcaseinfo testcaseinfo) {// form表单提交
		// {'id':'${ d.id }', 'account':'${ d.author }'}
		Testcaseinfo caseinfo = null;
		try {
			caseinfo = (Testcaseinfo) caseService.get(Long.valueOf(testcaseinfo.getId()));
			// caseService.update(testcaseinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("caseInfo", caseinfo);
		return "add_case";// 将要编辑的case数据返回到添加case的页面上

	}

	@RequestMapping(value = "/delete_case", method = { RequestMethod.POST })
	@ResponseBody
	public String deleteCase(@RequestBody Map<String, Object> data) {
		// data={"id":id,'mode':'del'}

		try {
			caseService.delete(Integer.parseInt(data.get("id").toString()));
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
