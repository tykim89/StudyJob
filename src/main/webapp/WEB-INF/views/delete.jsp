<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원탈퇴</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-1.10.2.min.js">

</script>


<script type="text/javascript">
function move(){
	
	 if($("#password").val().trim()==""){
		 alert("비밀번호를 입력하세요.");
		 return false;
	 }else if($("#password").val() != $("#password2").val()){
			 alert("비밀번호가 다릅니다"); 
			 return false;
		 }else{
			 	$("#myForm")[0].action = "${pageContext.request.contextPath}/controller/delete.do";
				$("#myForm")[0].target = "_self";
				$("#myForm").submit(); 
		 }
}
</script>
<style type="text/css"> 
            fieldset{ 
                width: 500px; 
                margin: 50px auto; 
            } 
            fieldset #member_wrap{ 
                width: 500px; 
                height: 100px; 
                border-top: 3px solid #303030; 
            } 
            fieldset #member_wrap .lb{ 
                font-weight: bold; 
            } 
            div{ 
                text-align: center; 
            } 
       </style> 
</head>
<body>
<h3>회원탈퇴</h3>
<font color="red" size="3">※탈퇴하시면 모든 개인정보가 지워지며, 사이트 이용에 제한이 생깁니다.</font><BR>
<form method="post" id="myForm">
<fieldset> 
	 <table id="member_wrap">
	 <tbody>
	 <tr>
	 <td class="lb">
	 * 비밀번호</td><td>    <INPUT type="password" id="password" name="password"         maxlength="15"></td></tr>
	 <tr>
	 <td class="lb">
	 * 비밀번호확인  </td><td> <INPUT type="password" id="password2" name="password2"         maxlength="15"></td></tr>
	</tbody>
	</table>
	</fieldset>
	<div id="btn">
<INPUT type="button" value=" 탈   퇴 " onclick="move();" ><input type="button" value=" 닫   기 " onclick="self.close();">
</div>
</form>
	<c:if test="${ failMessage == '3' }" >
	<script type="text/javascript">alert("회원탈퇴 되었습니다");
	opener.location.replace('<%=request.getContextPath()%>/login');
	window.close();
	</script>
	</c:if>

	<c:if test="${ failMessage == '4' }">
	<script type="text/javascript">alert("비밀번호가 맞지 않습니다.");</script>
	</c:if>
</body>
</html>