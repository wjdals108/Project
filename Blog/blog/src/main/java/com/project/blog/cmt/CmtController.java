package com.project.blog.cmt;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.SecurityUtils;
import com.project.blog.model.CmtEntity;

@RequestMapping("/cmt")
@RestController
public class CmtController {
	
	@Autowired
	private CmtService service;
	
	@Autowired
	private SecurityUtils sUtils;
	
	@GetMapping
	public List<CmtEntity> list(CmtEntity p) {
		return service.selCmtList(p);
	}
	
	@PostMapping
	public int ins(@RequestBody CmtEntity p) {
		System.out.println(p.getNickname());
		System.out.println(p.getBoardPk());
		System.out.println(p.getCtnt());
		
		return service.insCmt(p);
	}
	
	@DeleteMapping
	public int del(CmtEntity p, HttpSession hs) {
		
		p.setNickname(sUtils.getLoginUserNickname(hs));
		return service.delCmt(p);
	}
}
