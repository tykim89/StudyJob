<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${pageContext.request.contextPath }/resources/css/common.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/resources/css/layout.css" rel="stylesheet" type="text/css" media="all" />

<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.2.min.js"></script> --%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

 
<%--  <%=request.getAttribute("getMemberNamePhone") %> --%>


<title>팀장 페이지 - 일정관리</title>
</head>
<body>



<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

<div id="warp">
<div id="content2">
<div style="margin-top: 50px; margin-left: 15px">
<font size = 5>MyStudy : ${studyTitle.study_title}</font>
<hr>
</div>



<div id = "calenderInPage" style="include-source:url('${pageContext.request.contextPath }/calendar')" align="center">
  <iframe src="${pageContext.request.contextPath }/controller/calendarcheck.do?no=${studyTitle.study_no}" width="700" height="520" frameborder="0"></iframe> 
</div> 

<div id="studycheck_back">


<div id =pmoneyInfo2>
<div class = "penaltytable">

<span style="font-weight:bold;" ><font color="#b22222">-회원 정보-</font></span>
<div>
<table border ="1" id = "penaltytableinside">
	
	<tr style="background-color: #afeeee;">	
		<th style="width: 50px" style=" padding: 3px">팀원</th>
		<th style=" padding: 3px" >연락처</th>
	</tr>
	<c:forEach items="${getMemberNamePhone}" var="getMemberNamePhone">
	<tr style="background-color: #ffffff;">
		<td style="text-align: center">${getMemberNamePhone.member_name}</td>
		<td>${getMemberNamePhone.phone_number}</td>
	</tr>
	</c:forEach>
	</table>
	
	
	<table border ="1" id = "penaltytableinside">
	<tr style="background-color: #afeeee;" style=" padding: 3px">
		<th style="width: 30px; padding: 3px">지각</th>
	</tr>
	<c:forEach items="${getLate}" var="late">
	<tr style="background-color: #ffffff;">
		<td style="text-align: center">${late}번</td>
	</tr>
	</c:forEach>
	</table>
	
	
	<table border ="1" id = "penaltytableinside">
	<tr style="background-color: #afeeee;">
		<th style="width: 30px; padding: 3px">결석</th>
	</tr>
	<c:forEach items="${getAbsent}" var="absent">
	<tr style="background-color: #ffffff;">
		<td style="text-align: center">${absent}번</td>
	</tr>
	</c:forEach>
	</table>
	
	<table border ="1" id = "penaltytableinside">
	<tr style="background-color: #afeeee;">
		<th style="width: 80px; padding: 3px">벌금총액</th>
	</tr>
	<c:forEach items="${getTotalMoney}" var="totalmoney">
	<tr style="background-color: #ffffff;">
		<td style="text-align: center">${totalmoney}원</td>
	</tr>
	</c:forEach>
	</table>
	
	</div>
</div>



<div class="change">

<table border ="1">
<span style="font-weight:bold;"><font color="#b22222">-회원 출석 체크-</font></span>
	<tr style="background-color: #afeeee;">	
		<th style=" padding: 3px">팀원</th>
		<th id = studydate1 style=" padding: 3px" >날짜를 선택하세요</th>
	</tr>
	<tr style="background-color: #ffffff;">
		<form method="POST" action = "${pageContext.request.contextPath }/controller/studychecksubmit.do">
			<input id="studydate2" name = "studydate2" type = "hidden" value =""/>
			<input name = "no" type = "hidden" value ="${studyTitle.study_no}"/>
		<c:forEach items="${getMemberNamePhone}" var="getMemberNamePhone">
		<td style="background-color: #ffffff;">${getMemberNamePhone.member_name}</td>
			<input name ="memId" type = "hidden" value="${getMemberNamePhone.member_id}" />
		<td style="background-color: #ffffff; text-align: center; width: 115px"  >
			<select name = "attendance_information" >
    			<option value="0" >출석</option>
    			<option value="1" >지각</option>
    			<option value="2" >결석</option>
			</select>
		</td>
	</tr>
	</c:forEach>
	<tr>
	<input type="submit" value = "확인" style="margin-left: 20px" id="btn3"/>
	</tr>
	</form>
	</table>
</div>


</div>



<div id = "pmoneyInfo">

<div id = "moneyInfo1">
<span style="font-weight:bold;"><font color="#b22222">-현재 벌금-</font></span>
<table border ="1">
	<tr style="background-color: #afeeee;">	
		<th style="width: 90px">지각비</th>
		<th style="width: 90px">결석비</th>
	</tr>
	<tr style="background-color: #ffffff;">
		<td style="text-align: center">${getMoney.lateness_money}원</td>
		<td style="text-align: center">${getMoney.absant_money}원</td>
	</tr>
	</table>
</div>

<div id = "moneyInfo2">
<span style="font-weight:bold;"><font color="#b22222">-벌금 수정-</font></span>
<table border ="1">
	<tr style="background-color: #afeeee;">	
		<th>지각비</th>
		<th>결석비</th>
	</tr>
	<form method="POST" action = "${pageContext.request.contextPath }/controller/penaltychage.do">
	<tr style="background-color: #ffffff;">
		<input name="stdno" type = "hidden" value = "${studyTitle.study_no}" />
		<td><input name="lateness_money" type="text" value=${getMoney.lateness_money} /></td>
		<td><input name="absant_money" type="text" value=${getMoney.absant_money} /></td>
	</tr>
	<tr>
	<input type="submit" value = "확인" style="margin-left: 150px" id="btn3"/>
	</tr>
	</form>
</table>
</div>


</div>

</div>

<div align="right" style="margin-right: 160px">
<a href="${pageContext.request.contextPath }/controller/getmystudylist.do"><button id="btn2" type="button">목록보기
	</button></a>
	
<a href="${pageContext.request.contextPath }/controller/studymanagerdate.do?no=${studyTitle.study_no}"><button id="btn2" type="button">뒤로가기
	</button></a>
</div>

</div>
</div>


<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>



</body>
</html>