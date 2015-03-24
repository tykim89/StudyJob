<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function check(){
		if(form1.freeboardTitle.value == "" ||form1.freeboardContent.value == ""){
			alert("제목과 내용을 모두 입력하시기 바랍니다.");
			return false;
		}
	}
	function bcancel(){
		if(confirm("취소하시겠습니까?")==true){
			document.location.href='${pageContext.request.contextPath }/controller/freeboardView.do?no=${param.no}';
		}else
			return;
	}

</script>
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

	<div id="warp"align="center">
	<div id="content2" style="min-height: 300px;" >
<br><br><br><br>
		<h1>자유게시판</h1>
		<div>
			<form name="form1" action="${pageContext.request.contextPath }/controller/editfreeboard.do"
				method="post" onsubmit= "return check()">
				<input type="hidden" name=freeboardNo value="${freeboard.freeboardNo }">
				<table border="solid">
					<tr>
						<th>제목</th>
						<td><input name="freeboardTitle" type="text" size="72" value="${freeboard.freeboardTitle }"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="freeboardContent" rows="10" size="72" cols="70" style="resize:none;">${freeboard.freeboardContent }</textarea></td>
					</tr>
				</table>
				<input type="submit" id="btn3" value="작성">
				<input type="button" id="btn3" name="cancel" onclick="javascript:bcancel()" value="취소">
			</form>
		</div>
	</div>
	</div>
	<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
</body>
</html>