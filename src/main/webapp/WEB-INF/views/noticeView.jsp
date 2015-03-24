
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<title>공지사항 내용보기</title>
<style>
body{
     font size :16pt;
     font-family: 맑은 고딕;
     } 

</style>
<script type="text/javascript">
	function bdelete(){
			if(confirm("삭제하시겠습니까?")==true){
				return true;
			}else
				return false;
	}
</script>
</head>
<body>
<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

<div id="warp" align="center">
<div id="content2" >
<div id = "stitle">
<font size = 7>공지사항</font>
<hr>
</div><br>
<form method="post"  action="${pageContext.request.contextPath }/controller/deleteNotice.do"
		onsubmit="return bdelete()">
    <fieldset>
        <table border="1">
            <tbody>
               
                 <tr>
                    <th scope="row"><label for="notice">카테고리</label></th>
                    <td>
                        <select id="study_select" title="카테고리" >
                        	   <option>${notice.noticeMainCategory }</option>
                       </select> 
                    </td>
                     
                 <tr>
				<th>날짜</th>
				<td style="width: 450px">${notice.noticeContentDate}</td>
				</tr>
                
                <tr>
                    <th>제목</th>
				    <td>${notice.noticeTitle }</td>
                <tr>
                    <th scope="row">내용</th>
                     <td>
                     <textarea cols="80" rows="15" style="resize: none;" readonly="readonly" >${notice.noticeContent }
                     </textarea></td>     
                </tr>            

				<tr>
				<td colspan="2" align="center">
				<c:choose>
        			<c:when test="${member_id == 'admin' }">
			     	 <input type="button" id="btn3" value="수정" 
			     	 	onclick="document.location.href='${pageContext.request.contextPath }/controller/noticeEdit.do?no=${param.no}'" >
					 <input type="submit" id="btn3" value="삭제" >
			     	</c:when>
				<c:otherwise></c:otherwise>
				</c:choose>
			      <input type="hidden" name=no value="${param.no}">
			    </td>
			    </tr>
			    </tbody>
</table>
    
</fieldset>

    
</form>

<form action="${pageContext.request.contextPath }/controller/noticeList.do" style="margin: 5px" method="get">
	<input type="hidden" name="start" value=1>
	<input type="hidden" name="end" value=10>
	<input type="hidden" name="nowPage" value=1>
	<input type="submit"  id="btn3" value="목록으로" >
</form>
</div>
</div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
</jsp:include>
</body>
</html>