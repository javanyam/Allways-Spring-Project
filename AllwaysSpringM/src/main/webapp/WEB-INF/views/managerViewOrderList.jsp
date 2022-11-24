<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>주문현황</title>
<%@include file="managerHeader.jsp"%>
<link rel="stylesheet" href="css/Table22.css">
</head>
<body>
<script type="text/javascript">
	function Final(){
			RET.action = "managerViewOrderList";
			RET.method = "post";
			RET.submit();
			
			}
		
</script>
<hr/><h1 align="center">주문접수</h1><hr/>
<form name="orderList" method="post">
<div align="center">
<table border="1" >
<thead>
		<tr align="center">
			<th width="80px;">주문번호</th>
			<th width="80px;">주문상태</th>
			<th width="100px;">구매자</th>
			<th width="80px;">케이크번호</th>
			<th width="150px;">케이크이름</th>
			<th width="100px;">추가상품번호</th>
			<th width="100px;">추가상품이름</th>
			<th width="80px;">주문가격</th>
			<th width="80px;">주문개수</th>
			<th width="80px;">포인트</th>
			<th width="80px;">제작선택</th>
			<th width="80px;">주문취소</th>
		</tr>	
		</thead>
			<c:forEach items = "${orderList1}" var = "dto" begin="${(index - 1) * rowcount }" end="${(index) * rowcount - 1}">
		<tr align="center">
			<td>${dto.ordersId}</td>
			<td>${dto.ordersStatus}</td>
			<td>${dto.o_customerId}</td>
			<td>${dto.o_cakeId}</td>
			<td>${dto.cakeName}</td>
			<td>${dto.o_goodsId}</td>
			<td>${dto.goodsName}</td>
			<td>${dto.ordersSalePrice}</td>
			<td>${dto.ordersQuantity}</td>
			<td>${dto.ordersPoint}</td>
			<td><a href="orderSelect?ordersId=${dto.ordersId}"><input type="button" value="선택"></a></td>
			<td><a href="orderDelete?ordersId=${dto.ordersId}"><input type="button" value="취소"></a></td>
		</tr>
			</c:forEach>
			
</table>
</div>
</form>

 	<div align="center">

			<table>
				<tr align="center" height="20">
					<td>
					
						<c:if test="${index <= 1}">
							[이전] &nbsp;
						</c:if>
					
						<c:if test="${index != 1 }">

							<a href="managerViewOrderList?index=${index-1 }">이전</a>&nbsp;

						</c:if> 
				
						<c:forEach var="cnt" begin="${pagecount * pagepage + 1}" end="${pagecount * (pagepage + 1)}">
							<c:if test="${cnt <= Math.ceil(arrsize / rowcount)}">
							
								<c:if test="${cnt == index }">

									<a href="managerViewOrderList?index=${cnt }" style="font-size:1.3em">[${cnt }]</a>
								</c:if>
						
								<c:if test = "${cnt != index }">
									<a href="managerViewOrderList?index=${cnt }" style="font-size:0.9em">[${cnt }]</a>&nbsp;

								</c:if>
								
							</c:if>
						</c:forEach>
				
						<c:if test="${index >= maxpage }">
							[다음]
						</c:if>
						
						<c:if test="${index < Math.ceil(arrsize / rowcount)}">
							<a href="managerViewOrderList?index=${index+1 }">다음</a>&nbsp;
						</c:if>
						
					</td>
				</tr>
			</table>
		</div>

<hr/><h1 align="center">제작중</h1>
<div align="center">
<table border="1">
<thead>
		<tr align="center">
			<th width="80px;">주문번호</th>
			<th width="80px;">주문상태</th>
			<th width="100px;">구매자</th>
			<th width="80px;">케이크번호</th>
			<th width="150px;">케이크이름</th>
			<th width="100px;">추가상품번호</th>
			<th width="100px;">추가상품이름</th>
			<th width="80px;">주문가격</th>
			<th width="80px;">주문개수</th>
			<th width="80px;">제작선택</th>
			<th width="80px;">주문취소</th>
		</tr>	
		</thead>
			<c:forEach items = "${orderList2}" var = "dto">
		<tr align="center">
			<td>${dto.ordersId}</td>
			<td>${dto.ordersStatus}</td>
			<td>${dto.o_customerId}</td>
			<td>${dto.o_cakeId}</td>
			<td>${dto.cakeName}</td>
			<td>${dto.o_goodsId}</td>
			<td>${dto.goodsName}</td>
			<td>${dto.ordersSalePrice}</td>
			<td>${dto.ordersQuantity}</td>
			<td><a href="orderSelect?ordersId=${dto.ordersId}"><input type="button" value="선택"></a></td>
			<td><a href="orderDelete?ordersId=${dto.ordersId}"><input type="button" value="취소"></a></td>
		</tr>
			</c:forEach>
			
</table>
</div>



</body>
</html>