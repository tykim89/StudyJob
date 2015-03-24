<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${pageContext.request.contextPath }/resources/css/common.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/resources/css/layout.css" rel="stylesheet" type="text/css" media="all" />

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<%-- <%=request.getAttribute("studyInfo") %> --%>

<%

String indate = request.getParameter("date");
String year = null;
String month = null;
String day = null;
if(request.getParameter("date") != null){
year = indate.split("/")[0];
month = indate.split("/")[1];
day = indate.split("/")[2];
}
%>

<%-- <%= month --%> 
<c:set var="isdate" value="<%=indate%>"/>
 

<script>
window.name = "CalendarPage";

function createInput(updateTitle) {
    
    var element = document.getElementById(updateTitle);
    if(element.style.visibility == "hidden") {
    	element.style.visibility = "visible";
    } else {
    	element.style.visibility = "hidden";
    }

}

function attendendceCheck(){
	var check = <%=indate%>
	if(check == null){
		alert("스터디일정을 등록해주세요");
	}else{
		document.location.href='${pageContext.request.contextPath }/controller/studymanagerattendendce.do?no=${studyTitle.study_no}';
	}
}

</script>




<title>팀장 페이지 - 일정관리</title>
</head>
<body>


<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

<div id="warp">
<div id="content2">

<div style="margin-top: 50px; margin-left: 15px">
<font size = 7>MyStudy : ${studyTitle.study_title}</font>
<input class="titlechage" id="btn2" type="button" value = "제목 수정" onclick = "javascript:createInput('updateTitle');" />
<div id= "updateTitle" style = visibility:hidden>
<form method="POST" action = "${pageContext.request.contextPath }/controller/titlechage.do">
<input name="stdno" type = "hidden" value = "${studyTitle.study_no}" />
<input name="study_title" type="text" value = "제목수정"/>
<input type="submit" value = "확인" />
</form>
</div>
<hr>
</div>


<c:if test="${isdate ==null}">
<div id = "calenderInPage" style="include-source:url('${pageContext.request.contextPath }/calendar')" align="center">
  <iframe id="calenderFrame" src="${pageContext.request.contextPath }/controller/calendar.do?no=${studyTitle.study_no}" width="700" height="520" frameborder="0"></iframe> 
<br/><br/>
</div> 
</c:if>
<c:if test="${isdate !=null}">
<div id = "calenderInPage" style="include-source:url('${pageContext.request.contextPath }/calendar')" align="center">
  <iframe id="calenderFrame" src="${pageContext.request.contextPath }/controller/calendar.do?no=${studyTitle.study_no}&year=<%=year%>&month=<%=month%>" width="700" height="520" frameborder="0"></iframe> 
<br/><br/>
</div> 
</c:if>

<%-- <div>
<table border ="1">
	<tr>	
		<th>날짜</th>
		<th>내용</th>
		<th>시간</th>
		<th>장소</th>
		<th>수정</th>
	</tr>
	
	<c:forEach items="${studyDate}" var="studydate">
	<tr>
	
	<form method="POST" action = "${pageContext.request.contextPath }/controller/studyinfochage.do">
		<input name="stdno" type = "hidden" value = "${studyTitle.study_no}" />
		<input name="stddate" type = "hidden" value = "${studydate.my_study_date}" />
		<td>${studydate.my_study_date}</td>
		<td><input name="my_study_content" type="text" value="${studydate.my_study_content}" /></td>
		<td><input name= "my_study_time" type="text" value="${studydate.my_study_time}" /></td>
		<td><input name = "my_study_place" type="text" value="${studydate.my_study_place}" /></td>
		<td><input type="submit" value = "수정"/></td>
	</form>
	
	</tr>
	</c:forEach>
	</table>
</div> --%>


<div align="right" style="margin-right: 160px">
	<button id="btn2" class="btn_join" type="button">스터디 마감
	</button>
	<a href="${pageContext.request.contextPath }/controller/getmystudylist.do"><button id="btn2" class="btn_join" type="button">목록보기
	</button></a>
	<a onclick="attendendceCheck()"><button id="btn2" class="btn_join" type="button">출석체크
	</button></a>
</div>

</div>
</div>

<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

</body>
</html>