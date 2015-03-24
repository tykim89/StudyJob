<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="kr.ac.gachon.model.vo.StudyRoom"%>
<%@page import="kr.ac.gachon.model.service.BookServiceImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- <link rel="stylesheet" href="/resources/demos/style.css" /> -->
<title>스터디룸 정보</title>
<script type="text/javascript">
	$(function() {
		$( "#accordion" ).accordion({
			collapsible: true
		});
	 });

	$(function() {
		 $( "#tabs" ).tabs(); 
	});
	
    function btndelete(studyRoomNo){
		if(confirm("삭제하시겠습니까?")==true){
			document.location.href='${pageContext.request.contextPath }/controller/deleteStudyRoom.do?studyRoomNo='+studyRoomNo;
		}else
			return;
	}
</script>
</head>

<body>
<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
<div align="center">

<center>
<div id="tabs" style="width: 1000px;">
  <ul>
  	<li><a href="#전체"><b>전체</b></a></li>
    <li><a href="${pageContext.request.contextPath }/controller/studyRoomList.do?studyRoomCategory=강남"><b>강남</b></a></li>
    <li><a href="${pageContext.request.contextPath }/controller/studyRoomList.do?studyRoomCategory=신촌"><b>신촌</b></a></li>
    <li><a href="${pageContext.request.contextPath }/controller/studyRoomList.do?studyRoomCategory=대학로"><b>대학로</b></a></li>
    <li><a href="${pageContext.request.contextPath }/controller/studyRoomList.do?studyRoomCategory=종로"><b>종로</b></a></li>
    <li><a href="${pageContext.request.contextPath }/controller/studyRoomList.do?studyRoomCategory=건대입구"><b>건대입구</b></a></li>
    <li><a href="${pageContext.request.contextPath }/controller/studyRoomList.do?studyRoomCategory=기타"><b>기타</b></a></li>
  	<div align="right" style="margin: 7px">
		<form action="${pageContext.request.contextPath }/controller/write_room">
 		<c:choose>
			<c:when test="${member_id == 'admin' }">
 				<input type="submit" id="btn3" value="정보추가" >
 			</c:when>
  			<c:otherwise></c:otherwise>
  		</c:choose>
 		</form>
	</div>
  </ul>
  

<div id="전체">
	<div id="accordion">
		<c:forEach items="${allStudyRoomList }" var="asrl">
		  <div id="roomTitle">	
			<h3><b>${asrl.studyRoomTitle }</b></h3>
				<input type="hidden" name="roomNo" value="${StudyRoom.studyRoomNo }">
		  </div>
		<div>
  			<img src="<c:url value="/resources/images/${asrl.studyRoomImage}"/>" align="left" height="250" width="400"></img>
			<textarea rows="10" cols="20" style="margin: 2px; width: 400px; height: 241px; resize:none;" readonly>${asrl.studyRoomContent }</textarea>
  			<c:choose>
				<c:when test="${member_id == 'admin' }">	
  					<input type="button" id="btn3" value="삭제" onclick="javascript:btndelete(${asrl.studyRoomNo})">
  				</c:when>
  				<c:otherwise></c:otherwise>
  			</c:choose>
  			
		</div>
		</c:forEach>
	</div>
  </div>
</div>



<br></br>




<!-- 
<div align="center">
 <select name="keyfield"> 
        <option value="subject" selected>이름</option> 
        <option value="subjectContent">제목+내용</option> 
 </select> 
		<input type="text" style="margin: 2px; width: 300px; ;" maxlength="100" name="key"> 
    	<input type="submit" value="검색"> 
</div>
 -->
 </center>
</div>

	<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
     	
</body>
</html>