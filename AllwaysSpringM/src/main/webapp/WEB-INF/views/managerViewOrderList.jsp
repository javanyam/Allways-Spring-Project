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
<hr/><h1>주문접수</h1><hr/>
<form name="orderList" method="post">
<table border="1" >
<thead>
		<tr>
			<th>주문번호</th>
			<th>주문상태</th>
			<th>구매자</th>
			<th>케이크번호</th>
			<th>케이크이름</th>
			<th>추가상품번호</th>
			<th>추가상품이름</th>
			<th>주문가격</th>
			<th>주문개수</th>
			<th>포인트가격</th>
			<th>제작선택</th>
			<th>주문취소</th>
		</tr>	
		</thead>
			<c:forEach items = "${orderList1}" var = "dto">
		<tr>
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
</form>

<hr/><h1>제작중</h1>
<table border="1" >
<thead>
		<tr>
			<th>주문번호</th>
			<th>주문상태</th>
			<th>구매자</th>
			<th>케이크번호</th>
			<th>케이크이름</th>
			<th>추가상품번호</th>
			<th>추가상품이름</th>
			<th>주문가격</th>
			<th>주문개수</th>
			<th>포인트가격</th>
			<th>제작선택</th>
			<th>주문취소</th>
		</tr>	
		</thead>
			<c:forEach items = "${orderList2}" var = "dto">
		<tr>
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
<hr/><h1>제작완료</h1>
<div class="tablediv">
<table border="1" >
<thead>
		<tr>
			<th>주문번호</th>
			<th>주문상태</th>
			<th>구매자</th>
			<th>케이크번호</th>
			<th>케이크이름</th>
			<th>추가상품번호</th>
			<th>추가상품이름</th>
			<th>주문가격</th>
			<th>주문개수</th>
			<th>포인트가격</th>
			<th>제작선택</th>
		</tr>	
		</thead>
			<c:forEach items = "${orderList3}" var = "dto"> <%-- begin="${(index-1)*rowcount }" end="${(index)*rowcount-1}" --%>
		<tr>
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
			<td><a href="Sold.do?ordersId=${dto.ordersId}"><input type="button" value="선택"></a></td>
		</tr>
			</c:forEach>
			<tr>
			</tr>
			
</table>
</div>
<%-- <c:if test="${Query==null }">
	<div class="tablediv" align="center">
		<a href="MorderStatus.do?index=1">처음으로</a>
		<c:if test="${index!=1 }">
			<a href="MorderStatus.do?index=${index-1 }">이전</a>
		</c:if>
		<c:forEach var="dto3" begin="${pagecount*pagepage+1}" end="${pagecount*(pagepage+1) }">
			<c:if test="${dto3<=Math.ceil(Size/rowcount) }">
				<c:if test="${dto3==index }">
					<span style="display:inline">
						<a href="MorderStatus.do?index=${dto3 }" style="font-size:1.3em">${dto3 }</a>
					</span>
				</c:if>
				<c:if test="${dto3!=index }">
					<a href="MorderStatus.do?index=${dto3 }" style="font-size:0.9em">${dto3 }</a>
				</c:if>
			</c:if>
		</c:forEach>
		<c:if test="${index<Math.ceil(Size/rowcount) }">
			<a href="MorderStatus.do?index=${index+1 }">다음</a>
		</c:if>
		<a href="MorderStatus.do?index=${Math.ceil(Size/rowcount) }">끝으로</a>
	</div>
	</c:if> --%>
</body>
</html>