package com.finup.dataeco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finup.dataeco.mapper.CommonMapper;
import com.finup.dataeco.mapper.testPlatform.TestcaseinfoMapper;
import com.finup.dataeco.model.testPlatform.Testcaseinfo;
import com.finup.dataeco.service.CaseService;

@Service
public class CaseServiceImpl extends AbstractCommonServiceImpl<Testcaseinfo> implements CaseService {
	@Autowired
	TestcaseinfoMapper testcaseinfoMapper;

	@Override
	protected CommonMapper<Testcaseinfo> getCommonMapper() {
		return this.testcaseinfoMapper;
	}

}
