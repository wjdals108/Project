package com.project.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.todo.dao.ToDoDAO;
import com.project.todo.model.ToDoEntity;

@WebServlet("/add")
public class ToDoAddServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
		ToDoEntity vo = new ToDoEntity();
		vo.setItem(item);
		
		ToDoDAO.insToDo(vo);
		
		response.sendRedirect("/todo");
	}
}
