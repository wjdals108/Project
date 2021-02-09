<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="main-container">
	<h1>RECENT POST</h1>
	<div class="post-article-container">
	<c:forEach items="${postList}" var="post">
	<article class="post-article">
	    <h2 class="title"><c:out value="${post.title}"/></h2>
	    <div class="about_post">
	        <div class="post_dt">
	            <span><c:out value="${post.regDt}"/></span>
	        </div>
	        <div class="post_title_container">
	            <div class="circle"></div>
	            <span class="post_title"><c:out value="${post.nm}"/></span>
	        </div>
	    </div>
	    <p class="post_ctnt">
	    	<c:out value="${post.ctnt}"/>
	    </p>
	    <a href="/board/detail?boardPk=${post.boardPk}&page=1"><button class="read_more_btn" type="button">Read More +</button></a>
	</article>
	</c:forEach>
	
	<c:if test="${sessionScope.loginUser.userPk == 1}">
	<div class="main-write-container">
        <a href="/board/write">
            <img src="/res/img/add.png" alt="post write button">
        </a>
    </div>
	</c:if>
	
	</div>
</div>