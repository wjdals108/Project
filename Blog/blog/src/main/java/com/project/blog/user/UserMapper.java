package com.project.blog.user;

import org.apache.ibatis.annotations.Mapper;

import com.project.blog.model.UserEntity;

@Mapper
public interface UserMapper {
	int insUser(UserEntity p);
	UserEntity selUser(UserEntity p);
	UserEntity selNickname(UserEntity p);
}
