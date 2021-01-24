package com.project.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.todo.dao.ToDoDAO;
import com.project.todo.model.ToDoEntity;

@WebServlet("/del")
public class ToDoDelServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_todo = request.getParameter("i_todo");
		if(strI_todo==null) {
			ToDoDAO.delToDoAll();
		} else {
			int i_todo = Integer.parseInt(strI_todo);
			ToDoEntity vo = new ToDoEntity();
			vo.setI_todo(i_todo);
			ToDoDAO.delToDo(vo);
		}
		
		response.sendRedirect("/todo");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
