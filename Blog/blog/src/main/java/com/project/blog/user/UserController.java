package com.project.blog.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.blog.model.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/login")
	public void login() {}
	
	@ResponseBody
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody UserEntity p, HttpSession hs) {			//json 형태로 body를 날렸기때문에 @RequestBody가 있어야함
		System.out.println("ID: " + p.getUserId());
		System.out.println("PW: " + p.getUserPw());
		
		Map<String, Object> returnValue = new HashMap<>();
		System.out.println(service.login(p, hs));
		returnValue.put("result", service.login(p, hs));
		
		return returnValue;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "redirect:/user/login";
	}
	
	@GetMapping("/join")
	public void join() {}
	
	@ResponseBody
	@PostMapping("/join")
	public Map<String, Object> join(@RequestBody UserEntity p) {
		System.out.println("ID: " + p.getUserId());
		System.out.println("NICKNAME: " + p.getNickname());
		System.out.println("PW: " + p.getUserPw());
		
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", service.insUser(p));
		
		return returnValue;
	}
	
	
	@ResponseBody
	@GetMapping("/chkId/{userId}")
	public Map<String, Object> chkId(UserEntity p){
		System.out.println("userId : " + p.getUserId());
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", service.chkId(p)); 
		
		return returnValue;
	}
	
	@ResponseBody
	@GetMapping("/chkNickname/{nickname}")
	public Map<String, Object> chkNickname(UserEntity p){
		System.out.println("nickname : " + p.getNickname());
		Map<String, Object> returnValue = new HashMap<>();
		returnValue.put("result", service.chkNickname(p)); 
		
		return returnValue;
	}
}
