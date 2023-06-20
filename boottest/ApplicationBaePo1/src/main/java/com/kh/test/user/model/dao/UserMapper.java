package com.kh.test.user.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper
public interface UserMapper {
	
	@Autowired
	private SqlSessionTemplate mapper;
	
	
	
}
