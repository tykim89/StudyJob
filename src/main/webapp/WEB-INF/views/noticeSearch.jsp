<%@ page import="java.util.*,kr.ac.gachon.model.vo.Notice" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항목록</title>

<script type="text/javascript">
function searchCheck(){
	if(searchform.searchVal.value == ""){
		alert("검색어를 입력하시기 바랍니다.");
		return false;
	}
}
</script>
</head>
<style>
body{
     font size :16pt;
     font-family: 맑은 고딕;
     } 
</style>

<body>

<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
<div id="warp" align="center" >
	<div id="content2" style="min-height: 385px;">
	<br>
	<br>
	<br>

<table border=1 cellpadding="5" cellspacing="0" >
	<tr>
		<th width=40 height=30 scope="col">번호</th>
		<th width=100 height=30 scope="col">카테고리</th>
		<th width=400 height=30 scope="col">제목</th>	
		<th width=100 height=30 scope="col">날짜</th>
	</tr>
	
	<c:forEach items="${nsearch}" var="n">	
		<tr>	
	    	<td><center>${n.noticeNo}</center></td>
	    	<td>${n.noticeMainCategory }</td>
	    	<td><a href= "${pageContext.request.contextPath }/controller/notice.do?no=${n.noticeNo }">${n.noticeTitle }</a></td> 
	    	<td>${n.noticeContentDate }</td> 
		</tr>
	</c:forEach>
	</table>
	
	<br>
	<div align="center">
		<form name="frmPaging" method="post" action="${pageContext.request.contextPath }/controller/noticeSearch.do">
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

	<div style="display:inline" >
       <form name="searchform" method="post" 
       		action=""
       		onsubmit="return searchCheck()">
			<input type="hidden" name="start" value="1"/>
			<input type="hidden" name="end" value="10"/>
			<input type="hidden" name="nowPage" value="1"/>
				<select name="searchKey">
            		<option value="title"
            		<c:if test="${param.searchKey == 'title' }">selected</c:if>
            		>제목</option>
                    <option value="content"
                    <c:if test="${param.searchKey == 'content' }">selected</c:if>
                    >내용</option>
				</select>
			<input type="text" size="70" name="searchVal" value="${param.searchVal }"/>
			<input type="submit" id="btn3" value="검색" />
        </form>
        
        <form action="${pageContext.request.contextPath }/controller/noticeWrite.do" style="margin: 5px" >
	        <c:choose>
    	    	<c:when test="${member_id == 'admin' }">
				<input type="submit" id="btn3" value="게시글작성">
				</c:when>
			<c:otherwise></c:otherwise>
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