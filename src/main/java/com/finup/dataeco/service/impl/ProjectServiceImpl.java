package com.finup.dataeco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finup.dataeco.mapper.CommonMapper;
import com.finup.dataeco.mapper.testPlatform.ProjectinfoMapper;
import com.finup.dataeco.model.testPlatform.Projectinfo;
import com.finup.dataeco.service.ProjectService;

@Service
public class ProjectServiceImpl extends AbstractCommonServiceImpl<Projectinfo> implements ProjectService {
	@Autowired
	ProjectinfoMapper projectinfoMapper;

	@Override
	protected CommonMapper<Projectinfo> getCommonMapper() {
		return this.projectinfoMapper;
	}

}
