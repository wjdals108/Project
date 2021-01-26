package com.project.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.todo.model.ToDoEntity;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService service;
	
	@GetMapping("/ToDoList")
	public void todo(Model model) {
		model.addAttribute("list", service.selToDoList());
		model.addAttribute("count", service.selToDoCount());
	}
	
	@GetMapping("/del")
	public String del(ToDoEntity vo) {
		service.delToDo(vo);
		
		return "redirect:/ToDoList";
	}
	
	@PostMapping("/add")
	public String add(ToDoEntity vo) {
		service.insToDo(vo);
		
		return "redirect:/ToDoList";
	}
}
