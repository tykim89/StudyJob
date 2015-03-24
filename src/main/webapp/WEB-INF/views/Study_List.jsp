<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="kr.ac.gachon.model.vo.Study"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>스터디모집글</title>

<script type="text/javascript">
$(document).ready(function(){
	$("#study_area").change(function(){ displayVals(); });
});

function displayVals() {
  var singleValues = $("#study_area").val();
  
  $.ajax({
      type: 'post'
      , async: true
      , url: '${pageContext.request.contextPath}/controller/getSubList.do'
      , data: {singleValues:singleValues}
      , success: function(data) {
    	  $("#subList").html(data);
      }
  });
}

$("select").change(displayVals);
displayVals();

function searchCheck(pageNum){
	var searchForm = document.frmSearch;
/* 	 if(!searchForm.searchVal.value){
		alert("검색어를 입력하세요!");
		document.searchForm.focus();
		return;
	}  */
	searchForm.submit();
}
</script>
</head>

<style>
body {font size :16pt;
	font-family: 맑은 고딕;
}
</style>

<body>
<jsp:include page="header.jsp">
		<jsp:param value="" name="" />
</jsp:include>
<div id="warp">
<div id="content2" style="min-height: 500px;" >
<div id = "stitle" align="center">
<font size = 7>스터디 게시판</font>
<hr>
</div>

<div align="center">
	<form method="post" action="${pageContext.request.contextPath }/controller/studyAreaSearch.do">
		<table border=1 cellpadding="5" cellspacing="0">
			<tr>
				<th>스터디 지역</th>
				<td>
				<select name="study_area" id="study_area" title="지역 선택">
						<option>선택</option>
						<option value="서울">서울</option>
						<option value="경기">경기</option>
						<option value="인천">인천</option>
						<option value="부산">부산</option>
				</select></td>
			</tr>

			<tr>
				<th>스터디 도시</th>

				<td>
				<span id="subList">
				<select name="study_city" title="도시 선택">
						<option>선택</option>
				</select>
				</span>						
				</td>
			</tr>
		</table>
		<input type="hidden" name="start" value="1"/>
		<input type="hidden" name="end" value="10"/>
		<input type="hidden" name="nowPage" value="1"/>
		<input type="submit" id="btn3" value="검색"/>
	</form>
</div>

<div style="margin-left: 50px">
<form>
	<ul>
	 	<li style="display: inline;"><a href="${pageContext.request.contextPath }/controller/studyCategory.do?start=1&end=10&nowPage=1&study_category=토익"><b>|토익|</b></a></li>
	 	<li style="display: inline;"><a href="${pageContext.request.contextPath }/controller/studyCategory.do?start=1&end=10&nowPage=1&study_category=토스"><b>토스|</b></a></li>
	 	<li style="display: inline;"><a href="${pageContext.request.contextPath }/controller/studyCategory.do?start=1&end=10&nowPage=1&study_category=오픽"><b>오픽|</b></a></li>
	 	<li style="display: inline;"><a href="${pageContext.request.contextPath }/controller/studyCategory.do?start=1&end=10&nowPage=1&study_category=중국어"><b>중국어|</b></a></li>
	 </ul>
	<table border=1 cellpadding="5" cellspacing="0">
		<tr>
			<th  height=30 scope="col">번호</th>
			<th width=50 height=30 scope="col">과목</th>
			<th width=50 height=30 scope="col">지역</th>
			<th width=50 height=30 scope="col">도시</th>
			<th height=30 scope="col">요일</th>
			<th width=100 height=30 scope="col">시간</th>
			<th width=300 height=30 scope="col">제목</th>
			<th width=90 height=30 scope="col">작성자</th>
			<th width=65 height=30 scope="col">날짜</th>
		</tr>

		<c:forEach items="${noticeList}" var="n">
			<tr>
				<td><center>공지사항</center></td>
				<td>${n.noticeMainCategory }</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a
					href="${pageContext.request.contextPath }/controller/notice.do?no=${n.noticeNo }">${n.noticeTitle }</a></td>
				<td>관리자</td>
				<td>${n.noticeContentDate }</td>
			</tr>
		</c:forEach>

		<c:forEach items="${studyList}" var="s">
			<tr>
				<td>${s.study_no }</td>
				<td>${s.study_category}</td>
				<td>${s.study_area}</td>
				<td>${s.study_rigion}</td>
				<td>${s.study_week}</td>
				<td>${s.study_time}</td>
				<td><a
					href="${pageContext.request.contextPath }/controller/study.do?no=${s.study_no }">${s.study_title }</a></td>
				<td>${s.member_id }</td>
				<td>${s.study_content_date }</td>
			</tr>
		</c:forEach>

	</table>
	</form></div>
	<br>

	<div align="center">
		<form name="frmPaging" method="get" action="${pageContext.request.contextPath }/controller/studyList.do">
			<input type="hidden" name="start" value=""/>
			<input type="hidden" name="end" value=""/>
			<input type="hidden" name="nowPage" value=""/>
		<jsp:include page="boardPaging.jsp">
			<jsp:param value="" name="" />
		</jsp:include>
		</form>
	</div>

	<div align="center">
		<form name="frmSearch" method="post" action="${pageContext.request.contextPath }/controller/studyTitleSearch.do">
			<input type="hidden" name="start" value="1"/>
			<input type="hidden" name="end" value="10"/>
			<input type="hidden" name="nowPage" value="1"/>
		      <select name="searchKey"> 
		        <option value="title">제목</option> 
		        <option value="id">아이디</option> 
		      </select>
	    	<input type="text" size="50" name="searchVal" value="${param.searchVal }"/> 
    		<input type="submit" id="btn3" value="검색"> 
	    </form>
    </div>
		
	<div align="center">
		<form action="${pageContext.request.contextPath }/controller/writeForm" method="post" >
			<input type="submit" id="btn3" value="게시글작성" align="right">
			<input type="button" id="btn3" onclick="document.location.href='${pageContext.request.contextPath }/controller/studyList.do?start=1&end=10&nowPage=1'" value="전체목록">
		</form>
	</div>
	</br>
	</div>
	</div>
	<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>

</body>
</html>