<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
function btndelete(){
	if(confirm("삭제하시겠습니까?")==true){
		document.location.href='${pageContext.request.contextPath }/controller/deleteStudy.do?no=${param.no }';
	}else
		return;
}
</script>
<title>스터디 개설 내용</title>
<style>
body {font size :16pt;
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
<div id = "stitle" align="center">
<font size = 7>스터디 게시판</font>
<hr>
</div><br>
	<form action="${pageContext.request.contextPath }/controller/study.do">
		<fieldset >
			<table border="1">

				<tbody>
					
					
					<tr>
						<th>작성자 : </th>
						<td>${study.member_id}
						<input id="member_id" type = "hidden" value="${study.member_id}"/></td>
					</tr>

					<tr>
						<th>스터디 과목</th>
						<td> 
						<select id="study_select" disabled="disabled" title="과목선택" >
								<option>${study.study_category }</option>
						</select></td>
					</tr>

					<tr>
						<th>스터디 지역</th>

						<td><select id="study_area" disabled="disabled" title="지역 선택">
								<option>${study.study_area }</option>
						</select></td>
					</tr>


					<tr>
						<th>스터디 도시</th>

						<td><select id="study_city" disabled="disabled" title="도시 선택">
								<option>${study.study_rigion }</option>
						</select></td>
					</tr>


					<tr>
						<th>스터디 요일</th>
						<td> ${study.study_week }
					    <%-- <input type="checkbox"  name="study_week" value="${study.study_week }"/>월요일
                        <input type="checkbox"  name="study_week" value="${study.study_week }"/>화요일
                        <input type="checkbox"  name="study_week" value="${study.study_week }"/>수요일
                        <input type="checkbox"  name="study_week" value="${study.study_week }"/>목요일
                        <input type="checkbox"  name="study_week" value="${study.study_week }"/>금요일
                        <input type="checkbox"  name="study_week" value="${study.study_week }"/>토요일
                        <input type="checkbox"  name="study_week" value="${study.study_week }"/>일요일 --%>
                         <input type = "hidden" style="width: 220px" name="study_time" readonly="readonly" value="${study.study_week }"/>
                        </td>
					</tr>

					<tr>
						<th>스터디 시간</th>
						<td> ${study.study_time }
						<%-- <input type="radio"  name="study_time" value="${study.study_time }" />오전(9시~12시)
                        <input type="radio"  name="study_time" value="${study.study_time }"/>오후(12시~18시)
                        <input type="radio"  name="study_time" value="${study.study_time }"/>저녁(18시~24시) --%>
                        <input  type = "hidden" style="width: 110px" name="study_time" readonly="readonly" value="${study.study_time }"/>
                        </td>
					</tr>


					<tr>
						<th>제목</th>
						<td>${study.study_title }<input type = "hidden" style="width: 250px" id="title" readonly="readonly" value="${study.study_title }"/></td>
					</tr>

					<tr>
						<th>스터디 인원</th>
						<td>${study.study_number_of_person }<input type = "hidden" id="member_num" readonly="readonly" value="${study.study_number_of_person }"/>명</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="title" cols="80" rows="15" readonly="readonly"style="resize:none;" >${study.study_content }</textarea></td>
					</tr>
					<tr>

						<th>모집기간</th>
						<td nowrap>시작날짜 : ${study.period_start } <input type = "hidden" id="from" name="from"
							readonly="readonly" size="30" value="${study.period_start }" /></td>
					</tr>
					<tr>
						<th></th>
						<td>끝 날짜&nbsp;&nbsp; : ${study.period_end } &nbsp;&nbsp; <input type = "hidden" id="to" name="to"
							readonly="readonly" size="30" value="${study.period_end }" /></td>
					</tr>

					<tr>
						<th> 현재 신청 인원</th>
						<td><input type = "hidden" size="1" id="member_num" readonly="readonly" value="${num}"/>&nbsp;${num}명</td>
					</tr>

				</tbody>
			</table>
			</fieldset>
			</form>
			
			<c:remove var="flag"/>
			<c:remove var="flag2"/>
			<c:set var ="flag" value="false"/>
			<c:set var ="flag2" value="false"/>
			<c:forEach items="${smemberId}" var="smember_id">
				<c:if test="${smember_id.member_id == 'sim' }">
					<c:set var ="flag" value="true"/>
				</c:if>
				<c:if test="${smember_id.study.study_no == study.study_no }">
					<c:set var ="flag2" value="true"/>
				</c:if>
			</c:forEach>
			<br>
			
			<form action="${pageContext.request.contextPath}/controller/participateStudy.do" method="post">
			<center>
			
			<c:choose>
			
			<c:when test="${num >= study.study_number_of_person}">
				
			</c:when>
			
			<c:when test="${(flag == true) and (flag2 == true) }">
			
			</c:when>
			<c:otherwise>
			    <input type="submit" id="btn3"  value="스터디 신청" />
				<input type="hidden" name=no value="${param.no}">
			</c:otherwise>
			</c:choose>
			</center>
			</form>
			
			<div>
			<fieldset>
			<table border="solid" cellpadding="5" cellspacing="0">
				<!-- <tr>
					<th width=100 height=10 scope="col">작성자</th>
					<th width=400 height=10 scope="col">댓글내용</th>
					<th width=100 height=10 scope="col">날짜</th>
				</tr> -->
				
				<c:forEach items="${studyCommList}" var="sc">
				<tr>
					<td>${sc.memberId}</td>
					<td width="350">${sc.comm }</td>
					<td >${sc.commentDate}</td>
				</tr>
				</c:forEach>
			</table>
			<br>
			<form action="${pageContext.request.contextPath}/controller/InsertStudyComm" method="post">
				<input type="text" size="65" name="comm">
				<input type="submit" id="btn3"  value="확인">
				<input type="hidden" name=studyNo value="${param.no}">
			</form>
			</fieldset>
			</div>
			
			<div align="right" style="margin-right: 120px" >
			
			<input id="btn3"  type="button" onclick="document.location.href='${pageContext.request.contextPath }/controller/studyList.do?start=1&end=10&nowPage=1'" value="목록으로">
			
			<input id="btn3"  type="button" onclick="document.location.href='${pageContext.request.contextPath }/controller/editStudy2.do?no=${param.no}'" value="수정">
				
			<input type="button" name="bdelete" onclick="javascript:btndelete()" id="btn3" value="삭제">
			</div>
			</div>
</div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
</jsp:include>


</body>
</html>