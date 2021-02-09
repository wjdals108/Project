package com.project.blog;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.blog.model.BoardManageEntity;

@Mapper
public interface CommonMapper {
	List<BoardManageEntity> selMenuList();
}
