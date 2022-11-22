<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">

function writeComment() {
	var form = document.myform;

	if(form.writeContent.value.length==0){
		form.writeContent.focus();
		return;
	}else {
			form.action = "customerWriteComment";
			form.submit();
	}
		
	
}

function next(commentId, writeId, result) {
	
	 if(confirm("삭제를 원하시면 예를 누르시고 원하지 않으시면 아니오를 눌러주세요!")) {
		 if(result == 'comment') {
			location.href="customerBoardDetailCommentDelete?commentId=" + commentId + "&writeId=" + writeId + "&result=commentId";
		 } else if(result == 'recomment') {
			location.href="customerBoardDetailCommentDelete?commentId=" + commentId + "&writeId=" + writeId + "&result=recommentId";
				
			}
	 }else {
		 
	 }
}

</script>

<title>Insert title here</title>
<style>

#title {
	text-align: left;
}

</style>
</head>
<body>


	<%@include file="customerHeader.jsp" %>

	<br>
	
	<table align="center">
		<tr>
			<th></th>
			<th><h6>No.${boardDetail.writeId}&nbsp;&nbsp;&nbsp;</h6></th>
			<th><h6>작성자: ${boardDetail.customerName}&nbsp;&nbsp;&nbsp;</h6></th>
			<th><h6>제목: ${boardDetail.writeTitle}&nbsp;&nbsp;&nbsp;</h6></th>
			<th><h6>작성일자: ${boardDetail.writeInitdate}</h6></th>
		</tr>
	</table>
	
	<br>
	
	<div align="center">
		<textarea rows="10" cols="70" readonly="true" style = "resize: none;">${boardDetail.writeContent}</textarea>

		<table>
		
			<c:choose>
			
				<c:when test="${boardlength == 0 }">
					<h5>작성한 답글이 없습니다.</h5>
				</c:when>
				
				<c:otherwise>
					<c:forEach var = "dto" items="${boardComment }">
					<input type = "hidden" value ="${dto.writeId }">
						<c:choose>
							<c:when test="${dto.writeDeletedate == null }">
							
								<c:choose>
									<c:when test="${dto.distinguish == 2 }">
										<tbody>
											<tr>
												<td width="300">&nbsp;&nbsp;↳ ${dto.writeContent }</td>
												<td width="110">${dto.customerName }</td>
												<td width="120">${dto.writeInitdate }</td>
												<c:if test="${CUSTOMERID == dto.w_customerId }">
													<td><a href = "" onclick = "next(${dto.recommentId}, ${boardDetail.writeId }, 'recomment')" data-bs-toggle="modal" data-bs-target="#exampleModal">X</a></td>
												</c:if>
											</tr>
										</tbody>
											
									</c:when>
									
									<c:otherwise>
										
										<tbody>
									        <tr>
									          <td width="300">${dto.writeContent }</td>
									          <td width="110">${dto.customerName }</td>
									          <td width="120">${dto.writeInitdate }</td>
												<c:if test="${CUSTOMERID == dto.w_customerId }">
									       		   <td><a href = "" onclick = "next(${dto.writeId}, ${boardDetail.writeId }, 'comment')" data-bs-toggle="modal" data-bs-target="#exampleModal">X</a></td>
												</c:if>
									        </tr>
										</tbody>
											
									</c:otherwise>
									
								</c:choose>
							</c:when>
								
							<c:otherwise>
							
									
								<tbody>
							        <tr>
									<c:choose>
										<c:when test="${dto.distinguish == 2 }">
							      		    <td width="300">&nbsp;&nbsp;↳ 삭제된 글 입니다.</td>
										</c:when>
										
										<c:otherwise>
											 <td width="300">삭제된 글 입니다.</td>
										</c:otherwise>
										
									</c:choose>
							          <td width="110">${dto.customerName }</td>
							          <td width="120">${dto.writeInitdate }</td>
							        </tr>
					    	  </tbody>
											
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		
		<br>
		
		<form name = "myform" method = "post">
			<input type = "hidden" name = "writeId" value = "${boardDetail.writeId}">
			<input type = "text" name = "writeContent" size = "65" placeholder="답글 작성란">
			<c:if test="${CUSTOMERID == null }">
				<button type = "button" onclick = "alert('로그인 후 이용 가능합니다.')">OK</button>
			</c:if>
			<c:if test="${CUSTOMERID != null }">
				<button type = "button" onclick = "writeComment()">OK</button>
			</c:if>
		</form>
		
	</div>
</body>
</html>