package com.project.blog.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.SecurityUtils;
import com.project.blog.model.BoardDTO;
import com.project.blog.model.BoardDomain;
import com.project.blog.model.BoardEntity;
import com.project.blog.model.BoardManageEntity;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private SecurityUtils sUtils;
	
	public int insBoard(BoardEntity p) {
		return mapper.insBoard(p);
	}
	
	public List<BoardEntity> selBoardList(BoardDTO p) {
		if(p.getPage()==0) {
			p.setPage(1);
		}
		int sIdx = (p.getRowCnt() * (p.getPage() - 1));
		p.setsIdx(sIdx);
		
		return mapper.selBoardList(p);
	}
	
	public int selPageLength(BoardDTO p) {
		if(mapper.selPageLength(p)==0) {
			return 1;
		}
		return mapper.selPageLength(p);
	}
	
	public List<BoardManageEntity> selMenuList() {
		return mapper.selMenuList();
	}
	
	public BoardManageEntity selMenu(BoardDTO p) {
		return mapper.selMenu(p);
	}
	
	public int selBoardCount(BoardDTO p) {
		return mapper.selBoardCount(p);
	}
	
	public List<BoardDomain> selPostList(BoardDTO p) {
		if(p.getPage()==0) {
			p.setPage(1);
		}
		int sIdx = (p.getRowCnt() * (p.getPage() - 1));
		p.setsIdx(sIdx);
		
		return mapper.selPostList(p);
	}
	
	public BoardDomain selBoard(BoardEntity p, HttpSession hs) {
		if(sUtils.getLoginUser(hs) != null) {
			mapper.updHits(p);
		}
		return mapper.selBoard(p);
	}
}
