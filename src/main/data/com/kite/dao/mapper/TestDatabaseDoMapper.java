package com.kite.dao.mapper;

import com.kite.dao.TestDatabaseDo;

public interface TestDatabaseDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestDatabaseDo record);

    int insertSelective(TestDatabaseDo record);

    TestDatabaseDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestDatabaseDo record);

    int updateByPrimaryKey(TestDatabaseDo record);
}