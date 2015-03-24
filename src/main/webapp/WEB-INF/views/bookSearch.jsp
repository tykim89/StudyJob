<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="kr.ac.gachon.model.vo.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<link href="${pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/css/layout.css" rel="stylesheet" type="text/css" media="all" />

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
<div id="content2" style="min-height: 330px;" >
<br><br><br><br>
<br>	
	<table border="1" cellpadding="5" cellspacing="0" width="800" >
		<tr>
			<th>번호</th>
			<th>판매/구매</th>
			<th>종류</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
	
		<c:forEach items="${bookSearch }" var="bl">
		<tr>
			<td>${bl.bookNo }</td>
			<td>${bl.tradeCategory }</td>
			<td>${bl.bookCategory }</td>
			<td><a href="${pageContext.request.contextPath }/controller/bookContent.do?bookNo=${bl.bookNo}">${bl.bookTitle }</a></td>
			<td>${bl.memberId }</td>
			<td>${bl.bookContentDate }</td>
		</tr>	
		</c:forEach>
	</table>
	
	<div>
		<form name="frmPaging" method="post" action="${pageContext.request.contextPath }/controller/bookSearchTitle.do">
			<input type="hidden" name="searchVal" value="${param.searchVal }" />
			<input type="hidden" name="searchKey" value="${param.searchKey }" />
			<input type="hidden" name="start" value=""/>
			<input type="hidden" name="end" value=""/>
			<input type="hidden" name="nowPage" value=""/>

			<jsp:include page="boardPaging.jsp">
				<jsp:param value="" name="" />
			</jsp:include>
		</form>
	</div>
	
	<div>
		<form name="frmSearch" method="post" 
			action="${pageContext.request.contextPath }/controller/bookSearchTitle.do"
			onsubmit="return searchCheck()">	
	      	<input type="hidden" name="start" value="1"/>
		  	<input type="hidden" name="end" value="10"/>
		  	<input type="hidden" name="nowPage" value="1"/>
	      	<select name="searchKey"> 
	       		<option value="title"
	       		<c:if test="${param.searchKey == 'title' }">selected</c:if>
	       		>제목</option> 
				<option value="id"
				<c:if test="${param.searchKey == 'id' }">selected</c:if>
				>아이디</option> 
	      	</select>
	    		<input type="text" size="50" name="searchVal" value="${param.searchVal }"/> 
    			<input type="submit" id="btn3" value="검색"> 
    	</form>
    	<c:choose>
			<c:when test="${member_id != null }">
    			<form action="${pageContext.request.contextPath }/controller/write_form" method="post">
					<input type="submit" id="btn3" value="글쓰기" >
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