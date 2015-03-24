<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
<link
	href="${pageContext.request.contextPath }/resources/css/common.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="${pageContext.request.contextPath }/resources/css/layout.css"
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

	var win;
	function create() {
		win = open('', 'w', 'width=500,height=500');
		$("#myForm")[0].action = "${pageContext.request.contextPath}/insert";
		$("#myForm")[0].target = "w";
		$("#myForm").submit();
	}

	function login() {

		if ($("#member_id").val().trim() == "") {
			alert("아이디를 입력하세요.");
			return false;
		} else if ($("#password").val().trim() == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		} else {
			$("#myForm")[0].action = "${pageContext.request.contextPath}/controller/login.do";
	//		$("#myForm")[0].target = "_parent";
			$("#myForm").submit();
		}

	}
</script>
</head>
<body>
	<form method="post" id="myForm" style="margin-top: 40px; margin-left: 15px">
		<div class="input_id" style="margin-right: 0px;">
			<span> 아이디 </span> <br> <input type="text" class="id"
				id="member_id" name="member_id" value="${param.member_id }" /> <br>
			<span> 비밀번호 </span><br> <input type="password" class="password"
				id="password" name="password" />

		</div>
		<input type="button" id="btn4" class="btn_login" value=" 로 그 인 "
			onclick="return login();"> <INPUT type="button"
			class="btn_join" id="btn4" value=" 회원가입 " onclick="create();">

		<div class="input_button"></div>
	</form>

	<c:if test="${ failMessage == '1' }">
		<script type="text/javascript">
			alert("아이디가 맞지 않습니다.");
//			parent.location.href="${pageContext.request.contextPath}/";
		</script>
	</c:if>

	<c:if test="${ failMessage == '2' }">
		<script type="text/javascript">
			alert("비밀번호가 맞지 않습니다.");
	//		parent.location.href="${pageContext.request.contextPath}/";
		</script>
	</c:if>

</body>
</html>