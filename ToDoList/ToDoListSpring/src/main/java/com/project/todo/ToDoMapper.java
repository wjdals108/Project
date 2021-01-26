package com.project.todo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.todo.model.ToDoEntity;

@Mapper
public interface ToDoMapper {
	int insToDo(ToDoEntity vo);
	List<ToDoEntity> selToDoList();
	int selToDoCount();
	int delToDo(ToDoEntity vo);
	int delToDoAll();
	
}
