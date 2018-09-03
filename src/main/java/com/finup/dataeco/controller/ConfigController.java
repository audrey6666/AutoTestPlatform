package com.finup.dataeco.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finup.dataeco.model.testPlatform.Moduleinfo;

@RestController
@RequestMapping("/api")
public class ConfigController {
	@RequestMapping(value = "/add_config", method = { RequestMethod.POST })
	public String addConfig(@RequestBody Moduleinfo moduleinfo) {
		return null;
	}

	@RequestMapping(value = "/edit_config", method = { RequestMethod.POST })
	public String editConfig(@RequestBody Moduleinfo moduleinfo) {
		return null;
	}

	@RequestMapping(value = "/add_database_config", method = { RequestMethod.POST })
	public String addDatabaseConfig(@RequestBody Moduleinfo moduleinfo) {
		return null;
	}

	@RequestMapping(value = "/edit_database_config", method = { RequestMethod.POST })
	public String editDatabaseConfig(@RequestBody Moduleinfo moduleinfo) {
		return null;
	}

}
