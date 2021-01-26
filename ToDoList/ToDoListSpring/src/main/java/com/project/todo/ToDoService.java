package com.project.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todo.model.ToDoEntity;

@Service
public class ToDoService {
	@Autowired
	private ToDoMapper mapper;
	
	public int insToDo(ToDoEntity vo) {
		return mapper.insToDo(vo);
	}
	
	public List<ToDoEntity> selToDoList() {
		return mapper.selToDoList();
	}
	
	public int selToDoCount() {
		return mapper.selToDoCount();
	}
	
	public int delToDo(ToDoEntity vo) {
		if(vo.getI_todo() == 0) {
			return mapper.delToDoAll();
		} else {
			return mapper.delToDo(vo);
		}
	}
}
