<%@ page import="java.util.*,kr.ac.gachon.model.vo.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link href="${pageContext.request.contextPath }/resources/css/common.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/resources/css/layout.css" rel="stylesheet" type="text/css" media="all" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">


function overM(obj){
	if(obj.className!='today'){
		obj.style.backgroundColor = '#f4f4f4';
	}
}

function ou(obj){
	if(obj.className!='today'){
		obj.style.backgroundColor = '';
	}
}


function popupOpen(member_id){
	  var popUrl = "${pageContext.request.contextPath }/controller/getmanagerinfo.do?id="+member_id;	//!!!!!회원정보 페이지랑 연결하기!!!!!
	  var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
		window.open(popUrl,"pop",popOption);
	}  






</script>








<title>마이 스터디</title>
</head>
<body >


<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

<div id="warp">
<div id="content3">
<div id = "stitle">
<font size = 7>MyStudy 목록 조회</font>
<hr>
</div>
<div align="center">
<table class="myStudyTable" border="solid" style="margin: 35px;">
	<tr>	
		<th style= "width: 100px;">분류</th>
		<th style= "width: 200px;">제목</th>
		<th style= "width: 80px;">작성자</th>
	</tr>
	<c:forEach items="${myStudyList}" var="msl">
	<tr>
			<td style= "text-align: center">${msl.study_category}</td>
		<c:choose>
			<c:when test="${msl.member_id == member_id }">
			<td style= "text-align: center" 'cursor:pointer' onmouseover='overM(this);' onmouseout='ou(this);' ><a href="${pageContext.request.contextPath }/controller/studymanagerdate.do?no=${msl.study_no}">${msl.study_title}</a></td>
			</c:when>
			<c:otherwise>
			<%-- <td><a href="${pageContext.request.contextPath }/controller/studymemberpage.do?no=${msl.study_no}">${msl.study_title}</a></td> --%>
			<td style= "text-align: center" 'cursor:pointer' onmouseover='overM(this);' onmouseout='ou(this);'><a href="${pageContext.request.contextPath }/controller/studymemberpage.do?no=${msl.study_no}">${msl.study_title}</a></td>			
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${msl.member_id == member_id }">
			<td style= "text-align: center" >${msl.member_id }</td>
			</c:when>
			<c:otherwise>
			<td style= "text-align: center" 'cursor:pointer' onmouseover='overM(this);' onmouseout='ou(this);' onclick="popupOpen(${msl.member_id });">${msl.member_id }</td>
			</c:otherwise>
		</c:choose>
	
	</tr>
	</c:forEach>
</table>
</div>


</div>
</div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>


</body>
</html>

