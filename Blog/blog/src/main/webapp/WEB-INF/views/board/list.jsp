<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<div id="board-main">
	<h2>${menu.nm} (${boardCount})</h2>
	 <table id="board-list-table">
	     <thead>
	         <tr>
	             <th id="board-num">번호</th>
	             <th id="board-title">제목</th>
	             <th id="board-dt">날짜</th>
	             <th id="board-count">조회수</th>
	         </tr>
	     </thead>
	     <tbody>
	         <c:forEach items="${list}" var="list">
	         <tr>
	             <td class="center" ><c:out value="${list.seq}"/></td>
	             <td><a href="/board/detail?boardPk=${list.boardPk}&page=${param.page}"><c:out value="${list.title}"/></a></td>
	             <td class="board-dt"><c:out value="${list.regDt}"/></td>
	             <td class="center" ><c:out value="${list.hits}"/></td>
	         </tr>
	         </c:forEach>
	     </tbody>
	 </table>
	 <div class="write-btn-div">
	     <a href="/board/write?category=${param.category}"><button id="write-submit-btn" type="button">글 쓰기</button></a>
	 </div>
	 <div class="board-page-container">
	     <ul class="board-page">
	     	<c:if test="${param.page>1}">
	     		<li><a href="/board/list?category=${param.category}&page=1">처음</a></li>
     			<li><a href="/board/list?category=${param.category}&page=${param.page-1}">이전</a></li>
	     	</c:if>
	     	<c:forEach begin="1" end="${pagelength}" var="idx">
				<li class="selected-page"><a href="/board/list?category=${param.category}&page=${idx}">${idx}</a></li>
			</c:forEach>
			<c:if test="${param.page<pagelength}">
     			<li><a href="/board/list?category=${param.category}&page=${param.page+1}">다음</a></li>
     			<li><a href="/board/list?category=${param.category}&page=${pagelength}">끝</a></li>
     		</c:if>	
	     </ul>
	 </div>
 </div>