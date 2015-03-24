<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/resources/css/common.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/resources/css/layout.css" rel="stylesheet" type="text/css" media="all" />

<script type="text/javascript" src="../../js/jquery-1.10.2.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<%-- <%=request.getAttribute("studyTitle") %><br/>
<%=request.getAttribute("getMoney") %><br/>
<%=request.getAttribute("getLate") %><br/>
<%=request.getAttribute("getAbsent") %><br/>
<%=request.getAttribute("getTotalMoney") %><br/>
 --%>
<title>회원 페이지</title>
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
  <iframe src="${pageContext.request.contextPath }/controller/calendarview.do?no=${studyTitle.study_no}" width="700" height="520" frameborder="0"></iframe> 
</div> 

<div id = "sstudyInfo">
<div id = "sstudyInfo1">
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

<div  id = "sstudyInfo2">
	<table border ="1">
		<tr style="background-color: #afeeee;">	
			<th style="width: 50px">지각</th>
			<th style="width: 50px">결석</th>
			<th style="width: 70px">벌금</th>
		</tr>
		<tr style="background-color: #ffffff;">
			<td style="text-align: center">${getLate}번</td>
			<td style="text-align: center">${getAbsent}번 </td>
			<td style="text-align: center">${getTotalMoney}원</td>
		</tr>
	</table>
</div>
</div>

<div id="sstudymember" align="right" style="margin-right: 160px">
	<div id = "sstudy_index">
	<a href="${pageContext.request.contextPath }/controller/getmystudylist.do"><button class="btn_join" id="btn2" type="button">목록보기
	</button></a>
	</div>
	<div id="sstudy_out">
	<form method="POST" action = "${pageContext.request.contextPath }/controller/studydeletemember.do">
	<input name="no"  type = "hidden" value = "${studyTitle.study_no}" />
	
	<input type="submit" id="btn2" value = "스터디 나가기"/>
	</form>
	</div>
</div>
</div>
</div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

</body>
</html>