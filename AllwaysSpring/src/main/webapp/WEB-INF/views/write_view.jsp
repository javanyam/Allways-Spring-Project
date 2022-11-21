<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="write" method="post">
		<table border="0">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20" style="background-color: #ffd7ff;, border-color: #ffd7ff"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="20" style="background-color: #ffd7ff;"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" size="20" style="background-color: #ffd7ff;"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20" style="background-color: #ffd7ff;"></td>
			</tr>
			<tr>
				<td>관계</td>
				<td><input type="text" name="relation" size="20" style="background-color: #ffd7ff;"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;&nbsp;<a href="list">목록보기</a></td>
				
			</tr>
		
		</table>
	</form>

</body>
</html>