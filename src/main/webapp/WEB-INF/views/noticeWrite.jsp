<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		return true;
	}
	function bcancel(){
		if(confirm("취소하시겠습니까?")==true){
			document.location.href=location.href='${pageContext.request.contextPath }/controller/noticeList.do?start=1&end=10&nowPage=1'
		}else
			return;
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
<div id="content2">
<div id = "stitle">
<font size = 7>공지사항</font>
<hr>
</div>
	<br>
<form name="form1" action="${pageContext.request.contextPath }/controller/newNotice.do"
				method="post" onsubmit="return check()">
    <fieldset>
        <table>
           
            <tbody>
            
             	<tr>
                    <th scope="row">카테고리</th>
                    <td>                  
                       <select name="noticeMainCategory">
                            <option>전체</option>
                            <option>스터디</option>
                            <option>자유게시판</option>    
                            <option>교재관련</option>    
                        </select> 
                                           
                    </td>
         		</tr>
         		
                 <tr>
          
                    <th scope="row">제목 </th>
                    <td><input name="noticeTitle" type="text" size="82" title="제목을 입력하세요."></td>
        		</tr>
                           
              
               <tr>
                    <th scope="row">내용 </th>
                     <td><textarea name="noticeContent" cols="80" size="72" style="resize:none;" rows="15" title="내용을 입력하세요."></textarea></td>
                </tr>                   
</tbody>
        </table>
        </fieldset>
                
        <div><center>
        <input type="submit" id="btn3" value="작성">
        <input type="reset" onclick="javascript:bcancel()" id="btn3" value="취소"></center></div>
    
</form>
</div>
<br>
</div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
</jsp:include>
</body>
</html>