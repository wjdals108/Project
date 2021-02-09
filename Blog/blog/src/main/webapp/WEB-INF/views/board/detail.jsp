<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="detail-main">
	<div class="detail-container">
        <div class="detail-header">
            <span>No.<c:out value="${data.seq}"/></span>
            <span><c:out value="${data.regDt}"/></span>
        </div>
        <span id="detail-hits">조회수 : <c:out value="${data.hits}"/></span>
        <h2><c:out value="${data.title}"/></h2>
        <p>
            <c:out value="${data.ctnt}"/>
        </p>
        <div class="detail-btn">
            <a href="update.html"><button type="button">수정</button></a>
            <a href="###"><button type="button">삭제</button></a>
        </div>
        <a href="/board/list?category=${data.category}&page=${param.page}"><c:out value="${data.nm}"/> 게시판의 게시글 더보기 ></a>
    </div>
	
	<div class="cmt-container">
		<div class="cmt-article-container">
			<input id="getBoardPk" type="hidden" value="${param.boardPk}">
			<h3>댓글</h3>
		</div>
		<c:if test="${sessionScope.loginUser != null}">
		<div class="cmt-input">
			<input type="hidden" value="${sessionScope.loginUser.nickname}" id="cmt-nickname">
            <strong>${sessionScope.loginUser.nickname}</strong>
            <textarea onkeydown="resize(this)" onkeyup="resize(this)" name="ctnt" id="input_cmt" placeholder="댓글을 남겨보세요"></textarea>
            <button type="button" id="input_cmt_btn">등록</button>
        </div>
        </c:if>
    </div>
</div>