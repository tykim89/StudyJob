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
<%
	String member_id = (String)session.getAttribute("member_id");
%>
<script type="text/javascript">
	function loginError(){
		alert("로그인이 필요합니다.");
	}
</script>
</head>
<body style="background: transparent;">
 <div id="warp">
	 <div id="header">
		<div class="headerInner">
			<h1 class="logo"><a href="<%=request.getContextPath() %>/">로고값</a></h1>
			<div id="login">	
				<div class="login_inner">
					<%if(member_id == null){ %>
					<iframe src="/gachon/login" height="300" frameborder="0" allowTransparency="true"></iframe>
					<%}else{ %>
					<iframe src="/gachon/result/login_success" height="300" frameborder="0" allowTransparency="true"></iframe><%} %>
				</div>
				
			</div>
		</div>
		<div id="menu">
			<ul>
				<li><a href="${pageContext.request.contextPath }/controller/noticeList.do?start=1&end=10&nowPage=1"> <span style="font-weight:bold;">공지사항</span></a></li>
				<li><a href="${pageContext.request.contextPath }/controller/freeboard.do?start=1&end=10&nowPage=1"> <span style="font-weight:bold;">자유게시판</span></a></li>
				<li><a href="${pageContext.request.contextPath }/controller/studyList.do?start=1&end=10&nowPage=1"> <span style="font-weight:bold;">스터디</span></a></li>
				<li><a href="${pageContext.request.contextPath }/controller/studyRoomList.do?studyRoomCategory=전체"><span style="font-weight:bold;">스터디룸</span></a></li>
				<li><a href="${pageContext.request.contextPath }/controller/bookList.do?start=1&end=10&nowPage=1"><span style="font-weight:bold;">교재관련</span></a></li>
				<c:choose>
					<c:when test="${member_id != null }">
				<li><a href="${pageContext.request.contextPath }/controller/getmystudylist.do"><span style="font-weight:bold;">마이스터디</span></a></li>
					</c:when>
					<c:otherwise>
				<li><a href="javascript:loginError()"><span style="font-weight:bold;">마이스터디</span></a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	 </div>
	 </div>
</body>
</html>