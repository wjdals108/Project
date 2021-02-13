package com.project.blog.cmt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.blog.model.CmtEntity;

@Mapper
public interface CmtMapper {
	List<CmtEntity> selCmtList(CmtEntity p);
	int insCmt(CmtEntity p);
	int delCmt(CmtEntity p);
}
