<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <script type="text/javascript" >
  	
  	function not_ok(){
  		location.href="${pageContext.request.contextPath }/controller/studyRoomList.do?studyRoomCategory=전체";
  	}
  	
</script>
  
<title>스터디룸 추가</title>
</head>
<body>
<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
<div id="warp" align="center">
<div id="content2" >
<br><br><br><br>


<form method="post" enctype="multipart/form-data"  action="${pageContext.request.contextPath }/controller/insertStudyRoom.do" >
 <table width="600" border="1" cellspacing="0" cellpadding="5">
	<tr>
  		<td><b>지역 선택</b></td>
  		<td>
	  		<input type="radio" name="areaCategory" value="강남">강남
	  		<input type="radio" name="areaCategory" value="신촌">신촌
	  		<input type="radio" name="areaCategory" value="대학로">대학로
	  		<input type="radio" name="areaCategory" value="종로">종로
	  		<input type="radio" name="areaCategory" value="건대입구">건대입구
	  		<input type="radio" name="areaCategory" value="기타">기타
  		</td>
  	</tr>
  	<tr>
  		<td><b>스터디룸 이름</b></td>
  		<td>
	  		<input type="text" size="56"  maxlength="50" name="name">
  		</td>
  	</tr>
  	<tr>
  		<td><b>스터디룸 정보</b></td>
  		<td>
  			<textarea cols="50" rows="10" name="info"></textarea>
  		</td>
  	</tr>
  	<tr>
  		<td><b>스터디룸 사진</b></td>
  		<td>
  			<input type="file" id="multipartFile" name="image" style="width: 100%">
  		</td>
  	</tr>

</table>

<br>
	<input type="submit" id="btn3" value="작성">
	<input type="reset" id="btn3" value="취소" onclick="not_ok()">
</form>
</div></div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
</jsp:include>
</body>
</html>