<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" >
  
  	function ok(){
  		var title = document.writeform.title;
  		var content = document.writeform.content;
  		
  		if(title.value=="" || content.value==""){
  			alert("제목과 내용을 모두 입력하세요.");
			return false;
  		}
  		return true;
  	}
  	
  	function not_ok(){
  		location.href="${pageContext.request.contextPath}/controller/bookList.do?start=1&end=10&nowPage=1";
  	}
  	
  </script>
  <title>게시판 글쓰기</title>
  </head>
  <body>

<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

<div id="warp" align="center">	
<div id="content2"  >
<br><br><br><br>
  <form method="post" action="${pageContext.request.contextPath}/controller/bookInsert.do">
   <table width="550" border="1" cellspacing="0" cellpadding="5">
  	<tr>
  		<td style="text-align: center;"><b>분류</b></td>
      	<td> 
      	<select name="tradeCategory"> 
       	 <option value="판매" selected>판매</option> 
       	 <option value="구매">구매</option> 
      	</select> 
      </td>
  	</tr>
  	<tr>
  		<td style="text-align: center;"><b>교재 종류</b></td><td> 
      	<select name="bookCategory"> 
       	 <option value="전공" selected>전공</option> 
       	 <option value="자격증">자격증</option> 
       	 <option value="어학">어학</option> 
       	 <option value="교양">교양</option> 
       	 <option value="기타">기타</option> 
      	</select> 
      	</td>
    </tr>
  	<tr>
  		<td style="text-align: center;"><b>제목</b></td>
  		<td><input size="77" type="text" name="bookTitle" size="56"  maxlength="50">
  		</td>
  	</tr>
  	<tr>
  		<td style="text-align: center;"><b>내용</b></td>
  		<td><textarea name="bookContent" style="resize:none;" cols="75" rows="10"></textarea></td>
  	</tr>
  </table>

  	<input type="submit" id="btn3" value="등록" onclick="ok()">
  	<input type="reset" id="btn3" value="취소" onclick="not_ok()">
  </form>
</div></div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
</jsp:include>

  </body>
  </html>
