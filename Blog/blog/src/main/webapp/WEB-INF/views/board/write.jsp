<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="write-container">
    <form id="write-form">
        <div class="choose-board">
            <span>게시판</span>
            <select name="board">
                <option value=0>선택</option>
                <c:forEach items="${menuList}" var="menu">
	                <option value="${menu.category}">${menu.nm}</option>
                </c:forEach>
            </select>
        </div>
        <input type="text" name="title" id="input-title" placeholder="제목" required>
        <textarea name="ctnt" id="input_ctnt" placeholder="내용" required></textarea>
        <div class="write-btn-div">
            <button id="write-submit-btn" type="button">글 쓰기</button>
        </div>
    </form>
</div>