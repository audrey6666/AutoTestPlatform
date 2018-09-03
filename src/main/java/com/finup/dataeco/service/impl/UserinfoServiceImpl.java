package com.finup.dataeco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finup.dataeco.mapper.CommonMapper;
import com.finup.dataeco.mapper.testPlatform.UserinfoMapper;
import com.finup.dataeco.model.testPlatform.Userinfo;
import com.finup.dataeco.service.UserinfoService;

@Service
public class UserinfoServiceImpl extends AbstractCommonServiceImpl<Userinfo> implements UserinfoService {
	@Autowired
	UserinfoMapper userinfoMapper;

	@Override
	protected CommonMapper<Userinfo> getCommonMapper() {
		return this.userinfoMapper;
	}

}
