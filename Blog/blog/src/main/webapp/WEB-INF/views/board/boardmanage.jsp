<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="boardmanage-container">
	<h1>BOARD LIST</h1>
	<div class="board-article-container">
		<c:forEach items="${menuList}" var="menu">
		<article class="board-article">
		    <form id="${menu.category}" onsubmit="return false">
		        <input class="boardNm" name="boardNm" type="text" value="${menu.nm}" disabled>
		        <button class="boardNmUpdateBtn" name="boardNmUpdateBtn" type="submit">수정</button>
		    </form>
		    <div class="board-article-span-container">
		        <span>게시글 수 : <strong>${menu.seqCount}</strong></span>
		    </div>
		    <div class="board-article-btn">
		        <button class="nmUpdateBtn" onclick="nmUpdate(${menu.category})">게시판 이름 바꾸기</button>
		        <button class="nmDelBtn">삭제</button>
		    </div>
		</article>
		</c:forEach>
	</div>
</div>