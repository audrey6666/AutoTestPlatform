package com.finup.dataeco.mapper.testPlatform;

import com.finup.dataeco.model.testPlatform.Envinfo;

public interface EnvinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Envinfo record);

    int insertSelective(Envinfo record);

    Envinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Envinfo record);

    int updateByPrimaryKey(Envinfo record);
}