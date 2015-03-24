<%@ page import="java.util.*,kr.ac.gachon.model.vo.FreeBoard" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/resources/css/common.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/resources/css/layout.css" rel="stylesheet" type="text/css" media="all" />

<script type="text/javascript">
function searchCheck(){
	if(frmSearch.searchVal.value == ""){
		alert("검색어를 입력하시기 바랍니다.");
		return false;
	}
}
</script>
</head>
<body>

	<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

	<div id="warp" align="center">
	<div id="content2" style="min-height: 450px;" >
<div id = "stitle">
<font size = 7>자유게시판</font>
<hr>
</div>
	
	<br>
		<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th width=60 height=30 scope="col">번호</th>
			<th width=400 height=30 scope="col">제목</th>
			<th width=100 height=30 scope="col">작성자</th>
			<th width=100 height=30 scope="col">날짜</th>
		</tr>
		<c:forEach items="${noticeList }" var="nlist">
			<tr>
				<td>공지사항</td>
				<td><a href= "${pageContext.request.contextPath }/controller/notice.do?no=${nlist.noticeNo }">${nlist.noticeTitle }</a></td>
				<td>관리자</td>
				<td>${nlist.noticeContentDate }</td>
			</tr>
		</c:forEach>
		<c:forEach items="${freeboardList }" var="fb">
			<tr>
				<td>${fb.freeboardNo }</td>
				<td><a href="${pageContext.request.contextPath }/controller/freeboardView.do?no=${fb.freeboardNo }">${fb.freeboardTitle }</a></td>
				<td>${fb.memberId }</td>
				<td>${fb.freeboardContentDate }</td>
			</tr>
		</c:forEach>
		</table>
	<div align="center">
		<form name="frmPaging" method="get" action="${pageContext.request.contextPath }/controller/freeboard.do">
			<input type="hidden" name="start" value=""/>
			<input type="hidden" name="end" value=""/>
			<input type="hidden" name="nowPage" value=""/>
		<jsp:include page="boardPaging.jsp">
			<jsp:param value="" name="" />
		</jsp:include>
		</form>
	</div>
	
	<%
		//String searchKey = request.getParameter("searchKey");
	%>
	<div>
		<form name="frmSearch" method="post"
			action="${pageContext.request.contextPath }/controller/freeboardSearchTitle.do"
			onsubmit="return searchCheck()">
			<input type="hidden" name="start" value="1"/>
			<input type="hidden" name="end" value="10"/>
			<input type="hidden" name="nowPage" value="1"/>
			<select name="searchKey">
				<option value="title">제목</option>
				<option value="memberId">아이디</option>
			</select>
			<input type="text" name="searchVal" value=""/>
			<input type="submit" id="btn3" value="검색"/>
		</form>
	</div>
	<div>
		<c:choose>
			<c:when test="${member_id != null }">
				<form action="${pageContext.request.contextPath }/controller/freeboardwrite.do" style="margin: 5px">
					<input type="submit" id="btn3" value="게시글작성">
				</form>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</div>
</div>
</div>

<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
</jsp:include>
	
</body>
</html>