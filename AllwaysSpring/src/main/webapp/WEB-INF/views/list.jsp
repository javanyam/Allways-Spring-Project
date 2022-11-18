<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div {
   margin : 10px;
}
</style>
<meta charset="UTF-8">
<title>MVC 연락처</title>
</head>
<body>
<div align="center">
	<h1>MVC 연락처</h1>
	<form action="search">
		검색 선택 : 
			<select name="query">
				<option value="name" selected="selected">이름</option>
				<option value="phone">전화번호</option>
				<option value="address">주소</option>
				<option value="relation">관계</option>
			</select>&nbsp;&nbsp;&nbsp;
			<input type="text" name="content" size="30">
			<input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<th>번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>이메일</th><th>관계</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<c:set var="i" value="${i+1 }"/>
			<tr>
				<td>${dto.seq}</td>
				<td><a href="content_view?seq=${dto.seq}">${dto.name}</a></td>
				<td>${dto.phone}</td>
				<td>${dto.address}</td>
				<td>${dto.email}</td>
				<td>${dto.relation}</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="6"><a href="write_view">추가</a></td>
			</tr>
	</table>
	<c:out value="${i }명 입니다."/>
</div>
</body>
</html>