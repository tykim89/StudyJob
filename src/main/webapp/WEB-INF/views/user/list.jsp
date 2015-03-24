<%@page import="kr.ac.gachon.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	function move(flag, memberId) {
		var url = "${pageContext.request.contextPath}/controller/get_user.do";

		if (flag == 'delete') {

			url = "${pageContext.request.contextPath}/controller/delete.do";
			alert("탈퇴되었습니다.");
		}
		$("#myForm")[0].action = url
		$("#memberId").val(memberId);
		$("#myForm")[0].target = "_self";
		$("#myForm").submit();
	}
</script>
</head>
<body>
	<h3 align="center">회원 목록</h3>
	
	<table border="5" width="580">
		<TR>
			<TH>아이디</TH>
			<TH>이름</TH>
			<TH>연락처</TH>
		</TR>
		<c:forEach items="${member}" var="member">

			<tr>

				<td>${member.member_id}</td>

				<td>${member.member_name}</td>

				<td>${member.phone_number}</td>

				<td align="center"><INPUT type="button" value="상세정보 "
					onclick="move('register','${member.member_id}');"></td>
				<td align="center"><INPUT type="button" value="강제탈퇴 "
					onclick="move('delete','${member.member_id}');"></td>

			</tr>
			<br>
		</c:forEach>
	</table>
	<form id="myForm" method="post">
		<input type="hidden" name="id" value="" id="memberId" />	
	</form>

</body>
</html>