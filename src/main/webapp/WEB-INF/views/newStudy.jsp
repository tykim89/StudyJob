<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<!-- <script type="text/javascript">
	function check(){
		if(form1.title.value == "" ||form1.content.value == ""){
			alert("제목과 내용을 모두 입력하시기 바랍니다.");
			return false;
		}
		return true;
	}
</script> -->


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
    	  $("#study_rigion").html(data);
      }
  });
}

$("select").change(displayVals);
displayVals();
jQuery.noConflict();
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

})(jQuery);

 function bcancel(){
		if(confirm("취소하시겠습니까?")==true){
			document.location.href='${pageContext.request.contextPath }/controller/studyList.do?start=1&end=10&nowPage=1'
		}else
			return;
	}
  
  </script>


<title>스터디 개설하기</title>
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
<div id="warp">
<div id="content2" >
<div id = "stitle" align="center">
<font size = 7>스터디 게시판</font>
<hr>
</div><br>
<div style="margin-left: 15px" align="center">
<form name="form1" action="${pageContext.request.contextPath }/controller/newStudy.do"
		method="post" onsubmit="check()">
    <fieldset>
        <table border="1">
            <tbody>
                 <tr>
                    <th>스터디 과목</th>
                    <td>
                        <select name="study_category">
                            <option>선택</option>
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
								<option>선택</option>
								<option value="서울">서울</option>
								<option value="경기">경기</option>
								<option value="인천">인천</option>
								<option value="부산">부산</option>
						</select></td>
					</tr>

					<tr>
						<th>스터디 도시</th>

						<td><span id="study_rigion"> <select name="study_rigion"
								title="도시 선택">
									<option>선택</option>
							</select>
						</span></td>
					</tr>

					<tr>
                    <th>스터디 요일 </th>
                    <td>
                        <input type="checkbox"  name="study_week" value="월요일"/>월요일
                        <input type="checkbox"  name="study_week" value="화요일"/>화요일
                        <input type="checkbox"  name="study_week" value="수요일"/>수요일
                        <input type="checkbox"  name="study_week" value="목요일"/>목요일
                        <input type="checkbox"  name="study_week" value="금요일"/>금요일
                        <input type="checkbox"  name="study_week" value="토요일"/>토요일
                        <input type="checkbox"  name="study_week" value="일요일"/>일요일
                      </td>
                </tr>
                
                <tr>
                  <th>스터디 시간</th>
                    <td>
                        <input type="radio"  name="study_time" value="오전(9시~12시)"  />오전(9시~12시)
                        <input type="radio"  name="study_time" value="오후(12시~18시)"/>오후(12시~18시)
                        <input type="radio"  name="study_time" value="저녁(18시~24시)"/>저녁(18시~24시)
                      </td> 
                </tr>
                
                
                <tr>
                    <th>제목</th>
                   <td><input type="text" name="study_title"  style="width : 450px" id="study_title" title="내용 입력"/></td>
                </tr>
                
                    <tr>
                    <th>스터디 인원</th>
                    <td><input size="5" type="text" name="study_number_of_person" title="스터디인원설정" />명</td>
                </tr>
                <tr>
                    <th>내용</th>
                     <td><textarea name="study_content" cols="80" rows="15" style="resize:none;"></textarea></td>
                </tr>  
                              
				<tr>
					<!-- <th label for="from">모집기간</label></th> -->
					<th><label for="from">모집기간</label></th>
					<td>시작<input type="text" id="from" name="period_start"/></td>
				</tr>
				<tr>
					<th><label for="to"></label></th>
					<td>끝&nbsp;&nbsp; <input type="text" id="to" name="period_end" /></td>
				</tr>
		</tbody>
        </table>
        <br>
        <div><center>
        <input type="submit" id="btn3"  value="작성">
        <input type="button" id="btn3" name="cancel" onclick="javascript:bcancel()" value="취소">
        </center>
        </div>
        <br>
    </fieldset>
</form>
</div>
</div>
</div>
<jsp:include page="footer.jsp">
		<jsp:param value="" name="" />
	</jsp:include>
</body>
</html>