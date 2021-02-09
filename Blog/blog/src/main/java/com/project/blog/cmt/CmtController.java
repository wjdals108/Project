package com.project.blog.cmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.model.CmtEntity;

@RequestMapping("/cmt")
@RestController
public class CmtController {
	
	@Autowired
	private CmtService service;
	
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
}
