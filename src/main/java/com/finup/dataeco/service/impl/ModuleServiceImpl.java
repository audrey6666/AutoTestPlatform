package com.finup.dataeco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finup.dataeco.mapper.CommonMapper;
import com.finup.dataeco.mapper.testPlatform.ModuleinfoMapper;
import com.finup.dataeco.model.testPlatform.Moduleinfo;
import com.finup.dataeco.service.ModuleService;

@Service
public class ModuleServiceImpl extends AbstractCommonServiceImpl<Moduleinfo> implements ModuleService {
	@Autowired
	ModuleinfoMapper moduleinfoMapper;

	@Override
	protected CommonMapper<Moduleinfo> getCommonMapper() {
		return this.moduleinfoMapper;
	}

}
