<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TODO LIST</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/res/css/style.css">
</head>
<body>
    <div class="container">
        <header class="todo-header">
            <h1 class="title">ToDo List</h1>
            <div class="day"></div>
        </header>
        <main class="todo-main">
            <div class="input-section">
                <form action="/add" method="POST">
                    <input type="text" name="item" class="item" placeholder="오늘의 할 일을 입력하세요" autofocus required>
                    <div class="input-section-btn">
                        <button type="submit" id="add_btn"><img src="/res/assets/add.png" alt="add button"></button>
                    </div>
                </form>
            </div>
            <div class="todo-list">
                <ul>
               	<c:forEach items="${list}" var="item">
                    <li id="${item.i_todo}">
                    	<input type="hidden" class="hidden-i_todo" value="${item.i_todo}">
                        <input type="text" class="list-item" value="${item.item}" disabled>
                        <div class="list-btn">
                            <input type="checkbox" id="check_box${item.i_todo}" onclick="check(${item.i_todo})">
                            <label for="check_box${item.i_todo}" id="check_btn" >
                            	<img src="/res/assets/check.png" alt="check button">
                            </label>
                            <button id="del_btn">
                            	<a href="/del?i_todo=${item.i_todo}">
                                	<img src="/res/assets/del.png" alt="delete button">
                                </a>
                            </button>
                        </div>
                    </li>
               	</c:forEach>
                <c:if test="${count>0}">
                    <li id="last-list">
                    	<input type="hidden" class="hidden-count" value="${count}">
                        <span class="left-item"></span>
                        <a href="/del">
	                        <button type="submit" id="delAll_btn">DeleteAll</button>
                        </a>
                    </li>
                </c:if>
                </ul>
            </div>
        </main>
    </div>
    <script src="/res/js/app.js"></script>
</body>
</html>