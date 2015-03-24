<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>회원가입</TITLE>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	function check() {
		if ($("#member_id").val().trim() == ""
				|| $("#member_name").val().trim() == ""
				|| $("#social_security_number").val().trim() == ""
				|| $("#password").val().trim() == ""
				|| $("#phone_number").val().trim() == "") {
			alert("아이디, 이름, 주민번호, 비밀번호, 연락처는 반드시 입력해야 합니다.");
			return false;
		} else if ($("#password").val() != ($("#password2").val())) {
			alert("비밀번호가 다릅니다");
			return false;
		} else {
			alert("회원가입을 축하합니다.");
			window.close();
		}
	}
	function id_check() {
		alert("체크");
	}
</script>
<style type="text/css">
fieldset {
	width: 400px;
	margin: 50px auto;
}

fieldset #member_wrap {
	width: 400px;
	height: 200px;
	border-top: 3px solid #303030;
}

fieldset #member_wrap .lb {
	font-weight: bold;
}

div {
	text-align: center;
}
</style>
</HEAD>
<BODY>
	<h3>회원가입</h3>

	<form id="myForm" method="post"
		action="${pageContext.request.contextPath}/controller/insert.do"
		onsubmit="return check();">
	<fieldset>
		<table id="member_wrap"> 
		<tbody>
		<tr>
			<td class="lb">* 아이디</td><td> 
			<INPUT type="text" id="member_id" name="member_id" value="${param.member_id }" maxlength="10">
			</td>
			<td>
			<input type="button" value="중복검사" onclick="id_check();">
			</td>
			</tr>
		<tr>			
		<td class="lb">* 이름 </td><td><INPUT type="text" id="member_name" name="member_name"
			value="${param.member_name }" maxlength="4"></td></tr>
<tr>			 
		<td class="lb">* 주민등록번호 </td><td><INPUT type="text" id="social_security_number"
			name="social_security_number" value="${param.social_security_number }" maxlength="20"></td></tr> 
<tr>			
		<td class="lb">* 비밀번호 </td><td><INPUT type="password" id="password" name="password"
			maxlength="15"></td></tr>
<tr>			
		<td class="lb">* 비밀번호확인 </td><td><INPUT type="password"
			id="password2" name="password2" maxlength="15"> </td></tr>
<tr>		
		<td class="lb">* 연락처 </td><td><INPUT type="text" id="phone_number"
			name="phone_number" value="${param.phone_number }" maxlength="15"></td></tr>
<tr>			
		<td class="lb">&nbsp;&nbsp;이메일 </td><td><INPUT type="text" id="email" name="email"
			value="${param.email }" maxlength="30"></td></tr> 
<tr>			
		<td class="lb">&nbsp;&nbsp;우편번호 </td><td><INPUT type="text" id="postal_number"
			name="postal_number" value="${param.postal_number }" maxlength="5"></td></tr>
<tr>			
		<td class="lb">&nbsp;&nbsp;주소 </td><td> <INPUT type="text" id="address" name="address"
			value="${param.address }" maxlength="50"></td></tr>
<tr>			
		<td class="lb">&nbsp;&nbsp;자기소개 </td><td><INPUT type="text" id="profile" name="profile" value="${param.profile }"
			maxlength="100"></td></tr>
			
			</tbody>
			</table>
			</fieldset>
			<div id="btn"> 
			<INPUT type="submit" value=" 가   입 " onclick="javascript:close();">
			<input type="button" value=" 취   소 " onclick="self.close();">
			</div>
	</FORM>
</BODY>
</HTML>