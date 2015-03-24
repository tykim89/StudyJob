<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	var flag = '${loginFlag}';
	if(flag=='true'){
		parent.location.href='${pageContext.request.contextPath}/';
	}
	
	var win;
	function create() {
		win = open('', 'w', 'width=600,height=650');
		$("#myForm")[0].action = "${pageContext.request.contextPath}/controller/get_user.do";
		$("#myForm")[0].target = "w";
		$("#myForm").submit();
	}

	function create2() {
		win = open('', 'w', 'width=600,height=600');
		$("#myForm")[0].action = "${pageContext.request.contextPath}/controller/get_user_list.do";
		$("#myForm")[0].target = "w";
		$("#myForm").submit();
	}

	function logout() {
		$("#myForm")[0].action = "${pageContext.request.contextPath}/controller/logout.do";
		$("#myForm")[0].target = "_parent";
		$("#myForm").submit();
	}
</script>
<style type="text/css">
#btn3{background: #d2b48c;
	padding:5px 8px 5px 8px;
	font-size:7px;
	color:#000000;
	text-align:center;
	
	border:solid 1px #d2b48c;
	
	background: -moz-linear-gradient(0%, 100%, 90deg, #75BC00, #ffffff);
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#ffffff), to(#d2b48c));

	border-radius:5px;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;

	border-bottom-color:#d2b48c;
	text-shadow:0 -1px 0 #d2b48c;}

</style>

</head>
<%
	String member_id = (String) session.getAttribute("member_id");
%>
<body>
	<div style="margin-top: 60px">
	<form method="post" id="myForm">
		<h5>
			<%=member_id%>님, 환영합니다.
		</h5>



		<%
			if (!(member_id.equals("admin"))) {
		%><input type="button" id="btn3"
			value="회원정보" onclick="create();">
		<%
			}
		%>
		<%
			if (member_id.equals("admin")) {
		%><input type="button" value="회원목록" id="btn3"
			onclick="create2();">
		<%
			}
		%>
		<input type="button" value="로그아웃" id="btn3" onclick="logout();">

	</form>
	</div>
</body>
</html>






