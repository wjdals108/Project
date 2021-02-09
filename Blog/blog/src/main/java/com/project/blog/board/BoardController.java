package com.project.blog.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.blog.Const;
import com.project.blog.model.BoardDTO;
import com.project.blog.model.BoardEntity;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/home")
	public void home(Model model, BoardDTO p) {
		p.setRowCnt(12);
		model.addAttribute("postList", service.selPostList(p));
		
	}
	
	@GetMapping("/write")
	public void write(Model model) {
		model.addAttribute(Const.KEY_MENULIST, service.selMenuList());
	}
	
	@ResponseBody
	@PostMapping("/write")
	public Map<String, Object> write(@RequestBody BoardEntity p) {
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", service.insBoard(p));
		
		return returnValue;
	}
	
	@GetMapping("/list")
	public void list(BoardDTO p, Model model) {
		p.setRowCnt(10);
		model.addAttribute(Const.KEY_LIST, service.selBoardList(p));
		model.addAttribute(Const.KEY_PAGELENGTH, service.selPageLength(p));
		model.addAttribute("menu", service.selMenu(p));
		model.addAttribute("boardCount", service.selBoardCount(p));
	}
	
	@GetMapping("/detail")
	public void detail(Model model, BoardEntity p, HttpSession hs) {
		model.addAttribute(Const.KEY_DATA, service.selBoard(p, hs));
	}
}
