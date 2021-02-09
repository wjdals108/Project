<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:importAttribute name="menuList"/>
<header>
	 <div class="logo">
                <a href="/board/home"><img src="/res/img/blog.png" alt="Blog image"></a>
            </div>
            <nav class="menu-bar-container">
                <ul class="menu-bar">
                    <li id="nav-home"><a href="/board/home">Home</a></li>
                    <li><a href="#">게시판</a>
                        <ul class="drop-board">
                            <c:forEach items="${menuList}" var="menu">
                            <li><a href="/board/list?category=${menu.category}&page=1"><c:out value="${menu.nm}"/></a></li>
                            </c:forEach>
                            <c:if test="${sessionScope.loginUser.userPk == 1}">
                            <li id="last-drop-menu">
                                <a href="#">게시판 관리</a>
                            </li>
                            </c:if>
                        </ul>
                    </li>
                </ul>
                <c:choose>
					<c:when test="${sessionScope.loginUser != null}">
		                <span id="nav-span">${sessionScope.loginUser.nickname} 님 로그인을 환영합니다.</span>
		                <div><a href="/user/logout"><button type="button" id="logout-btn">Logout</button></a></div>                	
                	</c:when>
                	<c:otherwise>
                		<span id="nav-span"></span>
                		<div><a href="/user/login"><button type="button" id="login-btn">Login</button></a></div>
                	</c:otherwise>
                </c:choose>  
            </nav>
</header>