package com.kh.test.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.user.model.dao.UserMapper;


@Service
public class UserServiceImpl{

	@Autowired
	private UserMapper mapper;
}
