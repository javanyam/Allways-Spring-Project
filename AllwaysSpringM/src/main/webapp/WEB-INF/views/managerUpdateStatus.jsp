<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="managerHeader.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" href="css/Table22.css">

<script>

	function Return(){
		var RET = document.ADDR;
		RET.action = "managerViewOrderList";
		RET.method = "post";
		RET.submit();
	}

	function Delete() {
		var DEL = document.ADDR;
		DEL.action = "orderDelete";
		DEL.method = "post";
		DEL.submit();
	}
	
	function Update(){
		var UPD = document.ADDR;
		UPD.action = "orderUpdate"
		UPD.method = "post";
		UPD.submit();
	}
</script>
</head>
<body>
<h1 align="center">주문 상태 변환</h1>
	<form method="post" action="ADDR" name = "ADDR">
	<div align="center">
	<table border="2">
<thead>
	<tr align="center">
		<th>주문 번호 :</th>
		<td><input type="text" name=ordersId value="${selectInfo.ordersId}" readonly/></td>
	</tr>
	
	<tr align="center">
		<th>주문 상태 :</th>
		<td align="left">
		<select name="ordersStatus">
		<option value="구매">구매</option>
		<option value="제작중">제작중</option>
		<option value="제작완료">제작완료</option>
		</select>
		</td>
	</tr>
	<tr align="center">
		<th>구매자 :
		</th>
		<td>
		<input type="text" name="o_customerId" value="${selectInfo.o_customerId}" readonly="readonly" >
		</td>
	</tr>
	
	<tr align="center">
		<th>케이크번호 :</th>
		<td>
		<input type="text" name="o_cakeId" value="${selectInfo.o_cakeId}" readonly="readonly">
		</td>
	</tr>
	<tr align="center">
		<th>케이크이름 :</th>
		<td>
		<input type="text" name="cakeName" value="${selectInfo.cakeName}" readonly="readonly">
		</td>
	</tr>
	
	<tr align="center">
		<th>추가상품번호:</th>
		<td>
		<input type="text" name="o_goodsId" value="${selectInfo.o_goodsId}" readonly="readonly">
		</td>
		
	</tr>
	<tr align="center">
		<th>추가상품이름:</th>
		<td>
		<input type="text" name="goodsName" value="${selectInfo.goodsName}" readonly="readonly">
		</td>
	</tr>
	
	<tr align="center">
		<th>주문가격 :</th>
		<td>
		<input type="text" name="ordersSalePrice" value="${selectInfo.ordersSalePrice}" readonly="readonly">
		</td>
	</tr>
	<tr align="center">
		<th>주문개수 :</th>
		<td>
		<input type="text" name="ordersQuantity" value="${selectInfo.ordersQuantity}" readonly="readonly">
		</td>
	</tr>
	<tr align="center">
		<th>포인트 :</th>
		<td>
		<input type="text" name="ordersPoint" value="${selectInfo.ordersPoint}" readonly="readonly">
		</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input type="button" value="돌아가기" onclick="Return()">
			<input type="button" value="수정" onclick="Update()">
			<input type="button" value="삭제" onclick="Delete()">
		</td>
	</tr>
	</table>
	</div>
		
	</form>
</body>
</html>