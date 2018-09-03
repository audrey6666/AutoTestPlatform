package com.finup.dataeco.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finup.dataeco.model.testPlatform.Moduleinfo;
import com.finup.dataeco.model.testPlatform.Projectinfo;
import com.finup.dataeco.service.ModuleService;
import com.finup.dataeco.service.ProjectService;
import com.finup.dataeco.utils.Paging;

@Controller
@RequestMapping("/api")
public class ModuleController {
	@Autowired
	ModuleService moduleService;
	@Autowired
	ProjectService projectService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/add_module_page", method = { RequestMethod.GET })
	public String addModule(HttpServletRequest request, Model model) {
		List<Projectinfo> projectinfos = (List<Projectinfo>) projectService.select(new Projectinfo());
		model.addAttribute("projectinfos", projectinfos);
		return "add_module";
	}

	@RequestMapping(value = "/module_list_page", method = { RequestMethod.GET })
	public String moduleList(HttpServletRequest request, Model model) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("testUser", request.getParameter("testUser"));
		paramMap.put("moduleName", request.getParameter("moduleName"));
		Paging paging = new Paging();
		paging.setParams(paramMap);
		Paging pagingResult = moduleService.list(paging);
		model.addAttribute("paging", pagingResult);
		return "module_list";
	}

	@RequestMapping(value = "/add_module", method = { RequestMethod.POST })
	@ResponseBody
	public String addProject(@RequestBody Moduleinfo moduleinfo) {
		moduleinfo.setCreateTime(new Date());
		moduleinfo.setUpdateTime(new Date());
		try {
			moduleService.insert(moduleinfo);
			return "成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}

	@RequestMapping(value = "/update_moduleinfo", method = { RequestMethod.POST })
	@ResponseBody
	public String updateModuleinfo(@RequestBody Moduleinfo moduleinfo) {
		try {
			moduleService.update(moduleinfo);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}

	@RequestMapping(value = "/delete_moduleinfo", method = { RequestMethod.POST })
	@ResponseBody
	public String deleteModuleinfo(@RequestBody Moduleinfo moduleinfo) {
		try {
			moduleService.delete(moduleinfo.getId());
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/select_moduleinfo", method = { RequestMethod.POST })
	@ResponseBody
	public List<Moduleinfo> selectModuleinfo(@RequestBody Moduleinfo moduleinfo) {
		try {
			List<Moduleinfo> moduleinfos = moduleService.select(moduleinfo.getId());
			return moduleinfos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
