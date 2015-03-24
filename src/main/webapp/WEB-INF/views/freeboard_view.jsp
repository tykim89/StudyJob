<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/css/layout.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript">
function btndelete(){
	if(confirm("삭제하시겠습니까?")==true){
		document.location.href='${pageContext.request.contextPath }/controller/freeboardDelete.do?freeboardNo=${param.no }'
	}else
		return;
}
</script>

</head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

	<div id="warp" align="center">
	<div id="content2" >
<br><br><br><br>
		<h1>자유게시판</h1>
		<table border="solid">
			<tr>
				<th>제목</th>
				<td>${freeboard.freeboardTitle }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${freeboard.memberId }</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${freeboard.freeboardContentDate }</td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="10" cols="70" style="resize: none;" readonly="readonly">${freeboard.freeboardContent }
				</textarea></td>
			</tr>
		</table>
		<div>
			<table border="solid" style="margin: 10px">
				<c:forEach items="${fboardCommList }" var="fcl">
				<tr>
					<td>${fcl.memberId }</td>
					<td width="350">${fcl.comm }</td>
					<td>${fcl.commentDate }</td>
				</tr>
				</c:forEach>
			</table>
			<form action="${pageContext.request.contextPath }/controller/freeboardComm.do" method="post">
				<c:choose>
					<c:when test="${member_id != null }">
						<input type="text" size="65px" name="comm">
						<input type="submit" id="btn3" value="확인">
						<input type="hidden" name="freeboardNo" value="${param.no}"/>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</form>
		</div>
		<div>
			<form name="form1" action="" style="margin: 10px">
				<input type="button" id="btn3" onclick="document.location.href='${pageContext.request.contextPath }/controller/freeboard.do?start=1&end=10&nowPage=1'" value="목록으로">
				
			<c:choose>
				<c:when test="${ member_id  == freeboard.memberId || member_id == 'admin' }" >
					<input type="button" id="btn3" onclick="document.location.href='${pageContext.request.contextPath }/controller/freeboardEdit.do?no=${param.no}'" value="수정">
					<input type="button" id="btn3"name="bdelete" onclick="javascript:btndelete()" value="삭제">
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			</form>
		</div>
	</div>
	</div>
	
	<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
</body>
</html>