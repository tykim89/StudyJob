<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
fieldset {
	width: 500px;
	margin: 50px auto;
}

fieldset #member_wrap {
	width: 500px;
	height: 250px;
	border-top: 3px solid #303030;
}

fieldset #member_wrap .lb {
	font-weight: bold;
}

div {
	text-align: center;
}
</style>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
function check(){
	 if($("#password").val().trim()=="" || $("#phone_number").val().trim()==""){
		 alert("비밀번호, 연락처는 반드시 입력해야 합니다.");
		 return false;
	 }else if($("#password").val() != $("#password2").val()){
			 alert("비밀번호가 다릅니다"); 
			 return false;
		 }else{
			 alert("수정되었습니다.");
			 window.close();
		 }
	}
	
function back(){
	$("#updateForm")[0].action = "${pageContext.request.contextPath}/controller/get_user_list.do";
	$("#updateForm")[0].target = "_self";
	$("#updateForm").submit(); 
}

</script>
</head>
<%
	String member_id = (String) session.getAttribute("member_id");
%>
<body>

	<h2>회원정보</h2>

	<form method="post" id="updateForm"
		action="<%=request.getContextPath()%>/controller/update.do"
		onsubmit="return check();">
		<fieldset>
			<table id="member_wrap">
				<tbody>

					<tr>
						<td class="lb">* 아이디 :</td>
						<td><INPUT type="hidden" value="${member.member_id }"
							id="member_id" name="member_id">${member.member_id }</td>
					</tr>

					<tr>
						<td class="lb">* 이름 :</td>
						<td><INPUT type="hidden"
							value="${requestScope.member.member_name }" id="member_name"
							name="member_name">${requestScope.member.member_name }</td>
					</tr>
					<%-- <h3> 주민등록번호 : <INPUT type="hidden" value="${requestScope.member.social_security_number }" id="social_security_number" name="social_security_number">${requestScope.member.social_security_number }</h3> --%>

					<INPUT type="hidden"
						value="${requestScope.member.social_security_number }"
						id="social_security_number" name="social_security_number">

					<tr>
						<td class="lb">* 비밀번호 :</td>
						<td><INPUT id="password" type="password" id="password"
							name="password" value="${requestScope.member.password }"></td>
					</tr>
					<tr>
						<td class="lb">* 비밀번호확인 :</td>
						<td><INPUT id="password2" type="password" id="password2"
							name="password2" value="${requestScope.member.password }"></td>
					</tr>
					<tr>
						<td class="lb">* 연락처 :</td>
						<td><INPUT id="phone_number" type="text" id="phone_number"
							name="phone_number" value="${requestScope.member.phone_number }"></td>
					</tr>

					<tr>
						<td class="lb">&nbsp;&nbsp;이메일 :</td>
						<td><INPUT type="text" id="email" name="email"
							value="${requestScope.member.email }"></td>
					</tr>

					<tr>
						<td class="lb">&nbsp;&nbsp;우편번호 :</td>
						<td><INPUT type="text" id="postal_number"
							name="postal_number"
							value="${requestScope.member.postal_number }"></td>
					</tr>

					<tr>
						<td class="lb">&nbsp;&nbsp;집주소 :</td>
						<td><INPUT type="text" id="address" name="address"
							value="${requestScope.member.address }"></td>
					</tr>

					<tr>
						<td class="lb">&nbsp;&nbsp;자기소개 :</td>
						<td><INPUT type="text" id="profile" name="profile"
							value="${requestScope.member.profile }"></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
		<div id="btn">

			<INPUT type="submit" value=" 정보수정 ">
			<%
				if (!(member_id.equals("admin"))) {
			%>
			<input type="button" value="회원탈퇴"
				onclick="javascript:location.href='<%=request.getContextPath()%>/delete'">
			<%
				}
			%>
			<input type="button" value=" 닫   기 " onclick="self.close();">
		</div>

	</form>

</body>
</html>