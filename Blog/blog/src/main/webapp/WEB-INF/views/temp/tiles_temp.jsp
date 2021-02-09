<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BLOG</title>
<link rel="stylesheet" href="/res/css/styles.css">
<script defer src="<tiles:getAsString name="categoryJs"/>"></script>

</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		<main>
			<tiles:insertAttribute name="content"/>
		</main>
	</div>
</body>
</html>