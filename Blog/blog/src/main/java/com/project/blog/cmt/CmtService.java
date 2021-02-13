package com.project.blog.cmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.model.CmtEntity;

@Service
public class CmtService {
	
	@Autowired
	private CmtMapper mapper;
	
	public List<CmtEntity> selCmtList(CmtEntity p) {
		return mapper.selCmtList(p);
	}
	
	public int insCmt(CmtEntity p) {
		return mapper.insCmt(p);
	}
	
	public int delCmt(CmtEntity p) {
		return mapper.delCmt(p);
	}
}
