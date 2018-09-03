package com.finup.dataeco.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finup.dataeco.model.testPlatform.Projectinfo;
import com.finup.dataeco.service.ProjectService;
import com.finup.dataeco.utils.Paging;

@Controller
@RequestMapping("/api")
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/add_project_page", method = { RequestMethod.GET })
	public String addProject(HttpServletRequest request) {
		return "add_project";
	}

	@RequestMapping(value = "/project_list_page", method = { RequestMethod.GET })
	public String projectList(HttpServletRequest request, Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "2") int size) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("projectName", request.getParameter("projectName"));
		paramMap.put("responsibleName", request.getParameter("responsibleName"));
		Paging paging = new Paging();
		paging.setIndex(page);
		paging.setSize(size);
		paging.setParams(paramMap);
		Paging pagingResult = projectService.list(paging);
		model.addAttribute("paging", pagingResult);
		model.addAttribute("pagNum", page);
		model.addAttribute("projectName", request.getParameter("projectName"));
		model.addAttribute("responsibleName", request.getParameter("responsibleName"));
		return "project_list";
	}

	@RequestMapping(value = "/add_project", method = { RequestMethod.POST })
	@ResponseBody
	public String addProject(@RequestBody Projectinfo projectinfo) {

		try {
			projectinfo.setCreateTime(new Date());
			projectinfo.setUpdateTime(new Date());
			projectService.insert(projectinfo);
			return "成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}

	@RequestMapping(value = "/project_list", method = { RequestMethod.POST })
	@ResponseBody
	public Paging projectList(@RequestBody Projectinfo projectinfo) {
		// "{"projectName":"1","responsibleName":"2"}"
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("projectName", projectinfo.getProjectName());
		paramMap.put("responsibleName", projectinfo.getResponsibleName());
		Paging paging = new Paging();
		paging.setParams(paramMap);
		return projectService.list(paging);
	}

	@RequestMapping(value = "/update_projectinfo", method = { RequestMethod.POST })
	@ResponseBody
	public String updateProjectinfo(@RequestBody Projectinfo projectinfo) {
		try {
			projectService.update(projectinfo);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}

	@RequestMapping(value = "/delete_projectinfo", method = { RequestMethod.POST })
	@ResponseBody
	public String deleteProjectinfo(@RequestBody Projectinfo projectinfo) {
		try {
			projectService.delete(projectinfo.getId());
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
}
