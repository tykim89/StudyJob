<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="kr.ac.gachon.model.vo.*"%>
<%@page import="kr.ac.gachon.model.service.BookServiceImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function check(){
		if(form1.bookTitle.value == "" ||form1.bookContent.value == ""){
			alert("제목과 내용을 모두 입력하시기 바랍니다.");
			return false;
		}
	}
	function bcancel(){
		if(confirm("취소하시겠습니까?")==true){
			document.location.href='${pageContext.request.contextPath }/controller/bookContent.do?bookNo=${param.bookNo}';
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

	<div id="warp" align="center">
	<div id="content2"  >
<br><br><br><br>
		<h1>자유게시판</h1>
		<div>
			<form name="form1" action="${pageContext.request.contextPath }/controller/bookUpdate.do"
				method="post" onsubmit= "return check()">
				<input type="hidden" name="bookNo" value="${bookContent.bookNo }">
				<table border="solid">
					<tr>
				  		<th width="100">분류</th>
				  			<td>
						  		<select name="tradeCategory"> 
						  			<option>${bookContent.tradeCategory }</option>
						       	 	<option value="판매">판매</option> 
						       	    <option value="구매">구매</option> 
						      	</select> 
					      	</td>
				  	</tr>
				  	<tr>
				  		<th>교재 종류</th>
				  			<td>
						      	<select name="bookCategory"> 
						      		<option>${bookContent.bookCategory }</option>
						       	 	<option value="전공">전공</option> 
						       	 	<option value="자격증">자격증</option> 
						       	 	<option value="어학">어학</option> 
						       	 	<option value="교양">교양</option> 
						       	 	<option value="기타">기타</option> 
						      	</select>
					      	</td> 
				    </tr>
				  	<tr>
				  		<th>제목</th>
				  		<td><input type="text" name="bookTitle" size="56"  value="${bookContent.bookTitle }"></td>
				  	</tr>
				  	<tr>
				  		<th>글쓴이</th>
				  		<td> 
				      	${bookContent.memberId }
				      	</td>
				    </tr>
				  	<tr>
				  		<th>작성날짜</th>
				  		<td>
				  		${bookContent.bookContentDate }
				  	</td>
				  	</tr>
				  	<tr>
				  		<th height="200">내용</th>
				  			<td><textarea name="bookContent" style="resize:none;" cols="50" rows="10">${bookContent.bookContent }</textarea></td>
				  	</tr>
				</table>
				<input type="submit" id="btn3" value="작성">
				<input type="button" id="btn3" name="cancel" onclick="javascript:bcancel()" value="취소">
			</form>
		</div>
	</div></div>
	<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
</body>
</html>
