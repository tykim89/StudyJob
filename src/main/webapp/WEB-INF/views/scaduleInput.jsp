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
	
	function closewinredirect(){
		var cForm = document.getElementById("createForm");
		cForm.submit();
		self.close();
	}
	

	function closewinredirect2(){
		var cForm = document.getElementById("deleteForm");
		cForm.submit();
		self.close();
	}
	
</script>



</head>
<body background="${pageContext.request.contextPath }/resources/images/post.png">

<div style="margin: 12px 0 0 10px">

<span style="font-weight:bold;"><font color="#8b008b"><%=indate%></font></span>
<hr>
<%-- <%=request.getAttribute("studyDate") %> --%>

<div>


<c:forEach items="${studyDate}" var="studydate">
<c:set var="date" value="<%=indate %>"/>
<c:if test="${studydate.my_study_date == date}">
<%
 studyOk =  true;
%>
</c:if>
</c:forEach>

<c:set var="studyOk" value="<%=studyOk%>"/>

<c:if test="${studyOk == true}">

<form method="POST" action = "${pageContext.request.contextPath }/controller/studyinfochage2.do">
		<input name="no" type = "hidden" value = "${studyTitle.study_no}" />
		<input name="date" type = "hidden" value = "${studyDateInfo.my_study_date}" />
<div>
	<span>내용</span>
	<input name="my_study_content" type="text" value="${studyDateInfo.my_study_content}">
</div>

<div>
	<span>시간</span>
	<input name= "my_study_time"  type="text" value="${studyDateInfo.my_study_time}">
</div>

<div>
	<span>장소</span>
	<input name = "my_study_place" type="text" value="${studyDateInfo.my_study_place}">
</div>

<div>
<input type="submit" value = "수정" onclick="javascript:closewin()"/>
<button type="button" onclick="javascript:closewin()">취소</button>
</form>
</div>
<div>
<form method="POST" id = "deleteForm" action = "${pageContext.request.contextPath }/controller/studyinfodelete.do" target="CalendarPage">
		<input name="no" type = "hidden" value = "${studyTitle.study_no}" />
		<input name="date" type = "hidden" value = "${studyDateInfo.my_study_date}" />
<input type="button" value = "삭제" onclick="closewinredirect2()"/>
</form>
</div>
</c:if>


<c:if test="${studyOk == false}">
<form method="POST" 
	id = "createForm"
	action = "${pageContext.request.contextPath }/controller/createstudydate.do"
	target="CalendarPage"
	>
<div>
	<span>내용</span>
	<input name="my_study_content" type="text" >
</div>

<div>
	<span>시간</span>
	<input name= "my_study_time" type="text" >
</div>

<div>
	<span>장소</span>
	<input name = "my_study_place" type="text" >
</div>

<div>
		<input name="no" type = "hidden" value = "${studyTitle.study_no}" />
		<input name="date" type = "hidden" value = "<%=indate%>" />
<!-- <input type="submit" value = "확인" onclick="javascript:closewinredirect()"/> -->
<input id="btn3" type="button" value = "확인" onclick="closewinredirect()"/>
</form>
<button id="btn3" type="button" onclick="javascript:closewin()">취소</button>
</div>
</c:if>


</div>
</div>
</body>
</html>