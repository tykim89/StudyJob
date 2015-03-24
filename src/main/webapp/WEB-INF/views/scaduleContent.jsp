<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세 일정 입력</title>
<%
String indate = request.getParameter("date");
boolean studyOk = false;

String year = indate.split("/")[0];
String month = indate.split("/")[1];
String day = indate.split("/")[2];

%>


<script language="javascript">
	function closewin(){
		self.close();
	}
	
</script>



</head>
<body background="${pageContext.request.contextPath }/resources/images/post.png">

<div style="margin: 12px 0 0 10px">
<span style="font-weight:bold;"><font color="#8b008b"><%=indate%></font></span>
<hr>
<div>


<div>
	<span>내용 : </span>
	<c:choose>
	<c:when test="${studyDateInfo.my_study_content != null}">
	<span>${studyDateInfo.my_study_content}</span>
	</c:when>
	<c:otherwise>
	미정
	</c:otherwise>
	</c:choose>
</div>

<div>
	<span>시간 : </span>
	<c:choose>
	<c:when test="${studyDateInfo.my_study_time != null}">
	<span>${studyDateInfo.my_study_time}</span>
	</c:when>
	<c:otherwise>
	미정
	</c:otherwise>
	</c:choose>
</div>

<div>
	<span>장소 : </span>
	<c:choose>
	<c:when test="${studyDateInfo.my_study_place != null}">
	<span>${studyDateInfo.my_study_place}</span>
	</c:when>
	<c:otherwise>
	미정
	</c:otherwise>
	</c:choose>
</div>

<div>
<button type="button" onclick="javascript:closewin()">취소</button>
</div>
<div>
</div>


</div>
</div>
</body>
</html>