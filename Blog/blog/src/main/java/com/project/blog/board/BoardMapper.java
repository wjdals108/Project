package com.project.blog.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.blog.model.BoardDTO;
import com.project.blog.model.BoardDomain;
import com.project.blog.model.BoardEntity;
import com.project.blog.model.BoardManageDomain;
import com.project.blog.model.BoardManageEntity;

@Mapper
public interface BoardMapper {
	int insBoard(BoardEntity p);
	List<BoardEntity> selBoardList(BoardDTO p);
	int selPageLength(BoardDTO p);
	List<BoardManageDomain> selMenuList();
	BoardManageEntity selMenu(BoardDTO p);
	int selBoardCount(BoardDTO p);
	List<BoardDomain> selPostList(BoardDTO p);
	BoardDomain selBoard(BoardEntity p);
	int updHits(BoardEntity p);
}
