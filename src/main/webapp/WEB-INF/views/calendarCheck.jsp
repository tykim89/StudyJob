<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Calendar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

//칼렌더 객체 생성
Calendar cal = Calendar.getInstance();

//오늘 날짜 구하기
int nowYear=cal.get(Calendar.YEAR);
int nowMonth=cal.get(Calendar.MONTH)+1;

//월은 0부터 시작하므로 1월 표시를 위해 1을 더해 줍니다.
int nowDay=cal.get(Calendar.DAY_OF_MONTH);

//클라이언트가 선택하여 넘어온 날짜
String strYear=request.getParameter("year");
String strMonth=request.getParameter("month");

//표시할 달력의 년,월
int year=nowYear;
int month =nowMonth;

if(strYear!=null){// 값이 없으면
year=Integer.parseInt(strYear);//클라이언트가 선택한 값을 입력
}

if(strMonth!=null){// 값이 없으면
month=Integer.parseInt(strMonth);//클라이언트가 선택한 값을 입력
}

//전월 이동을 구하기
int preYear=year, preMonth=month-1;
if(preMonth<1){//1월 전월은 작년 12월 이니깐...
preYear=year-1;
preMonth=12; 
}

//다음달 구하기
int nextYear=year,nextMonth=month+1;
if(nextMonth>12){//12월 다음달은 내년 1월 이므로...
nextYear=year+1;
nextMonth=1;
}


//표시할 달력 세팅
cal.set(year,month-1,1);//년,월,일
int startDay=1;//달의 첫 날
int endDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);

//매년 해당월의 1일 구하기
int week =cal.get(Calendar.DAY_OF_WEEK);

%>



<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function overM(obj){
	if(obj.className!='today'){
		obj.style.backgroundColor = '#f4f4f4';
	}
}

function ou(obj){
	if(obj.className!='today'){
		obj.style.backgroundColor = '';
	}
}


  function pushDate(year,month, day){
	
	var date = parent.document.getElementById("studydate1");
	var date2 = parent.document.getElementById("studydate2");

		$(date).html(year+"/"+month+"/"+day);
		$(date2).val(year+"/"+month+"/"+day);
	} 
 
 
	
</script>

<style>

#wrap {width:100%;}

		#head {width:100%;height:62px;border-bottom:1px solid #fff;background:#f9f9f9;}

		#head a {font-family:arial,dotum;}

		#head .monthList a {font-size:8pt;font-family:tahoma;}

		.body {border-bottom:1px solid #717171;border-top:1px solid #d0d0d0;}

		.calTable {width:100%;table-layout:fixed;}

		.calTable thead td.sun{font-weight:bold;color:#dd3c10;}

		.calTable thead td.sat{font-weight:bold;color:#2067a4;border-right:0px;}

		/* .calTable thead td{font-weight:bold;background:url('/images/tHeadBG.gif');text-align:center;height:24px;border-right:1px solid #d0d0d0;} */

		.calTable tbody td{border-right:1px solid #e9e9e9;border-bottom:1px solid #e9e9e9;height:70px;vertical-align:top;background:white;font-family:arial,dotum;}

		.calTable tbody td .sun{color:#dd3c10;}

		.calTable tbody td .sat{color:#2067a4;border-right:0px;}

		.calTable tbody div {padding:4px 0px 0px 3px;}

		.calTable tbody .tdBox {display:block;padding:3px 0px 3px 5px;line-height:150%;font-family:dotum;font-size:8pt;}

		.calTable tbody td.today {background:#ecf6f9}

		.thisMonth {font-family:arial black;font-size:16pt;line-height:70%;}

		.calTable tbody td a {text-overflow:ellipsis;-o-text-overflow:ellipsis;width:100%;overflow:hidden;white-space:nowrap;display:block;}

		a { color:#888; text-decoration:none; }

		a:hover { color:#ff3c00; text-decoration:none;}

		html,body{overflow:hidden;}
</style>

</head>

<body>

<%-- <%=request.getAttribute("studyTitle") %> --%>
<form name= "date">
	<div id="wrap">
		<div id="head">
			<div style='padding: 4px 8px;'>
				<div style='position: relative;'>
					<table align="center" width="430" height="50" cellpadding="2" cellspacing="1">
						<tr>
						<td align="center">
							<a href="${pageContext.request.contextPath }/controller/calendarcheck.do?no=${studyTitle.study_no}&year=<%=preYear %>&month=<%=preMonth %>"><font size =5>◀</font></a>
							<b>&nbsp;<font size =5><%=year %>년</font>&nbsp;&nbsp;<font size =5><%=month %>월</font></b>
							<a href="${pageContext.request.contextPath }/controller/calendarcheck.do?no=${studyTitle.study_no}&year=<%=nextYear %>&month=<%=nextMonth %>"><font size =5>▶</font></a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		

		<div class="body">
			<table class="calTable">
				<thead>
					<tr>
						<td class='sun'>일</td>
						<td>월</td>
						<td>화</td>
						<td>수</td>
						<td>목</td>
						<td>금</td>
						<td class='sat'>토</td>
					</tr>
				</thead>
			</table>
		</div>

	<table class='calTable' id='calTable'>
	<tbody>


<%
//한주가 지나면 줄바꿈을 할 것이다.

int newLine=0;

out.print("<tr height='20'>");

for(int i=1;i<week;i++){

out.print("<td bgcolor='#ffffff'>&nbsp;</td>");

newLine++;

}


for(int i=startDay;i<=endDay;i++){//1일 부터 말일까지 반복

	 String fontColor=(newLine==0)?"red":(newLine==6)?"blue":"black";

	 String bgColor=(nowYear==year)&&(nowMonth==month)&&(nowDay==i)?"#e6e6e6":"#fff";//오늘날짜음영

	  
%>
					<c:set var="year" value="<%=year%>"/>
					<c:set var="month" value="<%=month %>"/>
					<c:set var="day" value="<%=i %>"/>
					<c:set var="studyday" value="${year}/${month}/${day}"/>
					<c:remove var="flag"/>
					
					<c:forEach items="${studyDate}" var="studydate">
						<c:if test="${studydate.my_study_date == studyday}">
							<c:set var="flag"  value="true"  />
						</c:if>
					</c:forEach>
					
	<c:choose>	
	<c:when test="${flag== true }">
	 <td style='line-height:120%; cursor:pointer' onmouseover='overM(this);' onmouseout='ou(this);' onclick="pushDate(${year},${month},${day});">
	</c:when>			
	<c:otherwise>
	 <td style='line-height:120%;'>
	</c:otherwise>
	</c:choose>		 
				<div class=nor ><span id='indate'><font color= <%=fontColor %>><%=i%></font></span>
					
		 		<c:if test="${flag== true}">
						<br/> 
						<img src="../resources/images/book.png" width="40%" height="40%">
						<span class='tdBox'><font color = "red">스터디!!</font></span>
				</c:if>		
					</div>
					
					
		</td>
	
<%
	  newLine++;

	  if(newLine==7&&i!=endDay){//7일째거나 말일이면 달력 줄바꿈이 일어난다.

	   out.print("</tr><tr height='20'>");

	   newLine=0;

	  }

	 }//3항 연산자로 for문으로 요일별 색상을 정한다. 

%>

</tbody>
</table>

	</div>
 </form>
</body>
</html> 
