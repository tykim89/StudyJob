<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="kr.ac.gachon.model.vo.*"%>
<%@page import="kr.ac.gachon.model.service.BookServiceImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function btndelete() {
		if (confirm("삭제하시겠습니까?") == true) {
			document.location.href = '${pageContext.request.contextPath }/controller/deleteBook.do?bookNo=${param.bookNo }'
		} else
			return;
	}
</script>
<title>게시판 내용조회</title>
</head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
	<div id="warp" align="center">
	<div id="content2"  >

<div id = "stitle">
<font size = 7>교재 내용 보기</font>
<hr>
</div>
		<form>
			<table width="600" border="1" cellspacing="0" cellpadding="5">
				<tr>
					<th>제목</th>
					<td>${bookContent.bookTitle }</td>
				</tr>
				<tr>
					<th width="100">판매/구매</th>
					<td>${bookContent.tradeCategory }</td>
				</tr>
				<tr>
					<th>종류</th>
					<td>${bookContent.bookCategory }</td>
				</tr>

				<tr>
					<th>글쓴이</th>
					<td>${bookContent.memberId }</td>
				</tr>
				<tr>
					<th>작성날짜</th>
					<td>${bookContent.bookContentDate }</td>
				</tr>
				<tr>
					<th height="200">내용</th>
					<td><textarea name="content" cols="78" rows="14"
							style="resize: none;" readonly="readonly">${bookContent.bookContent }</textarea>
					</td>
				</tr>
			</table>
		</form>

		<fieldset style="width: 500px">
			<div>
				<table border="1" cellspacing="0" cellpadding="5" style="margin: 10px">
					<c:forEach items="${bookCommentList }" var="bcl">
						<tr>
							<td width="80">${bcl.memberId }</td>
							<td width="350">${bcl.comm }</td>
							<td width="80">${bcl.commentDate }</td>
						</tr>
					</c:forEach>
				</table>

				<form
					action="${pageContext.request.contextPath }/controller/insertBookComment.do"
					method="post">
					<c:choose>
						<c:when test="${member_id != null }">
							<input type="hidden" name="bookNo" value="${param.bookNo }" /> 
							<input type="text" name="comm" size="65px"> 
							<input type="submit" id="btn3" value="확인">
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</form>
			</div>
		</fieldset>
		
		<div>
			<form style="margin: 10px">
				<input type="button" id="btn3" value="목록으로"
					onclick="document.location.href='${pageContext.request.contextPath}/controller/bookList.do?start=1&end=10&nowPage=1'">

				<c:choose>
					<c:when test="${member_id == bookContent.memberId || member_id == 'admin' }">
						<input type="button" id="btn3" value="수정"
							onclick="document.location.href='${pageContext.request.contextPath }/controller/bookEdit.do?bookNo=${param.bookNo}'">
						<input type="button" id="btn3" value="삭제" onclick="javascript:btndelete()">
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</div></div>
	<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
</body>
</html>
