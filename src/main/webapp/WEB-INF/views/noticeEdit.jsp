<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function check(){
		if(form1.noticeTitle.value == "" ||form1.noticeContent.value == ""){
			alert("제목과 내용을 모두 입력하시기 바랍니다.");
			return false;
		}
	}
</script>

<title>공지사항</title>
<style>
body{
     font size :16pt;
     font-family: 맑은 고딕;
     } 

</style>

</head>
<body>
<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
<div id="warp" align="center">
<div id="content2" >
<br><br><br><br>
<form name="form1" action="${pageContext.request.contextPath }/controller/updateNotice.do"
				method="post" onsubmit="return check()">
				<input type="hidden" name=noticeNo value="${notice.noticeNo }">
    <fieldset>
        <table>
            <tbody>
             	<tr>
                    <th scope="row">카테고리</th>
                    <td>                  
                       <select name="noticeMainCategory">
                    	   <option>${notice.noticeMainCategory}</option>
                         	<option>전체</option>
                            <option>스터디</option>
                            <option>자유게시판</option>    
                            <option>교재관련</option>
                        </select> 
                    </td>
         		</tr>
                 <tr>
                    <th scope="row">제목 </th>
                    <td><input name="noticeTitle" type="text" size="82" title="제목을 입력하세요."
                    		value="${notice.noticeTitle }"></td>
        		</tr>
               <tr>
                    <th scope="row">내용 </th>
                     <td><textarea name="noticeContent" cols="80" rows="15" size="72" style="resize:none;"
                     title="내용을 입력하세요." >${notice.noticeContent }</textarea></td>
                </tr>                   
			</tbody>
        </table>
        </fieldset>
        <div><center>
        <input type="submit" id="btn3" value="작성">
        <input type="reset" id="btn3" onclick="location.href='${pageContext.request.contextPath }/controller/notice.do?no=${param.no }'" value="취소"></center></div>
</form>
</div>
</div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
</jsp:include>
</body>
</html>