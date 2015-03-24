<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/resources/css/common.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/resources/css/layout.css" rel="stylesheet" type="text/css" media="all" />
<title>메인페이지</title>
</head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
	<div id="warp">
		<div id="content">
			<div class="main_img" align="center">
				<img src="resources/images/main2.png" width="63%" height="63%" />
			</div>
			<div class="main_text">
				<span>메인페이지 입니다 . 카테고리와 서치가 들어갑니다.</span> 
				<input type="text" class="serch" /> 
				<input type="submit" class="btn_serch" value="찾기" />
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
</body>
</html>