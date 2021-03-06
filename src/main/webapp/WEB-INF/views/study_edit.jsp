<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script>

  $(function() {

    $( "#from" ).datepicker({

      defaultDate: "+1w",

      changeMonth: true,

      numberOfMonths: 2,

      onClose: function( selectedDate ) {

        $( "#to" ).datepicker( "option", "minDate", selectedDate );

      }

    });

    $( "#to" ).datepicker({

      defaultDate: "+1w",

      changeMonth: true,

      numberOfMonths: 2,

      onClose: function( selectedDate ) {

        $( "#from" ).datepicker( "option", "maxDate", selectedDate );

      }

    });

  });

  

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
<br><br><br><br>
	<form name="form1" action="${pageContext.request.contextPath }/controller/editStudy.do"
				method="post" onsubmit= "return check()">
				<input type="hidden" name=study_no value="${study.study_no}">
		<fieldset >
			<table >

				<tbody>

					<tr>
						<th>스터디 과목</th>
						<td>
						 <select name="study_category">
                            <option>${study.study_category}</option>
                            <option>토익</option>
                            <option>토스</option>
                            <option>오픽</option>
                            <option>중국어</option>
                            
                        </select> 
						</td>
					</tr>


					<tr>
						<th>스터디 지역</th>
						<td><select name="study_area" id="study_area" title="지역 선택">
								<option>${study.study_area}</option>
								<option value="서울">서울</option>
								<option value="경기">경기</option>
								<option value="인천">인천</option>
								<option value="부산">부산</option>
						</select></td>
					</tr>

					<tr>
						<th>스터디 도시</th>

						<td><span id="subList"> <select name="study_rigion"
								title="도시 선택">
							<option>${study.study_rigion}</option>
							</select>
						</span></td>
					</tr>


					<tr>
						<th>스터디 요일</th>
						<td>
					    <input type="checkbox"  name="study_week" value="월요일"
					    	<c:if test="${study.study_week == '월요일' }"> checked</c:if>/>월요일
                        <input type="checkbox"  name="study_week" value="화요일"
                        	<c:if test="${study.study_week == '화요일' }"> checked</c:if>/>화요일
                        <input type="checkbox"  name="study_week" value="수요일"
                        	<c:if test="${study.study_week == '수요일' }"> checked</c:if>/>수요일
                        <input type="checkbox"  name="study_week" value="목요일"
                        	<c:if test="${study.study_week == '목요일' }"> checked</c:if>/>목요일
                        <input type="checkbox"  name="study_week" value="금요일"
                        	<c:if test="${study.study_week == '금요일' }"> checked</c:if>/>금요일
                        <input type="checkbox"  name="study_week" value="토요일"
                        	<c:if test="${study.study_week == '토요일' }"> checked</c:if>/>토요일
                        <input type="checkbox"  name="study_week" value="일요일"
                        	<c:if test="${study.study_week == '일요일' }"> checked</c:if>/>일요일
                        </td>
					</tr>

					<tr>
						<th>스터디 시간</th>
						<td>
						<input type="radio"  name="study_time" value="오전(9시~12시)"
							<c:if test="${study.study_time == '오전(9시~12시)' }"> checked</c:if>/>오전(9시~12시)
                        <input type="radio"  name="study_time" value="오후(12시~18시)"
                        	<c:if test="${study.study_time == '오후(12시~18시)' }"> checked</c:if>/>오후(12시~18시)
                        <input type="radio"  name="study_time" value="저녁(18시~24시)"
                        	<c:if test="${study.study_time == '저녁(18시~24시)' }"> checked</c:if>/>저녁(18시~24시)
                        
                        </td>
					</tr>


					<tr>
						<th>제목</th>
						<td><input type="text" style="width: 450px" name="study_title"  value="${study.study_title }"/></td>
					</tr>

					<tr>
						<th>스터디 인원</th>
						<td><input size="5" type="text" name="study_number_of_person" value="${study.study_number_of_person }"/>명</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="study_content" cols="80" rows="15" style="resize:none;">${study.study_content }</textarea></td>
					</tr>
			

<tr>

<th label for="from">모집기간</label></th>
<td nowrap>시작<input type="text" id="from" name="period_start" value="${study.period_start }"/></td>
</tr>
<tr>
<th label for="to"></label></th>
<td>끝 <input type="text" id="to" name="period_end" value="${study.period_end }" /></td>
</tr>
				</tbody>
			</table>
			</fieldset>
			<input type="submit" id="btn3" value="작성">
			</form>
		
			<br><br>
			</div>
			</div>
<jsp:include page="footer.jsp">
	<jsp:param value="" name="" />
</jsp:include>
		

</body>
</html>