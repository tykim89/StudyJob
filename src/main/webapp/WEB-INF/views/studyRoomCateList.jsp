<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	$(function(){
		$( "#accordion-${param.studyRoomCategory }" ).accordion({
			collapsible: true
		});
	});
	
	function btndelete(studyRoomNo){
		if(confirm("삭제하시겠습니까?")==true){
			document.location.href='${pageContext.request.contextPath }/controller/deleteStudyRoom.do?studyRoomNo='+studyRoomNo;
	
		}else
			return;
	}
</script>

<div id="accordion-${param.studyRoomCategory }">
	<c:forEach items="${categoryStudyRoomList }" var="csrl">
		<h3><b>${csrl.studyRoomTitle }</b></h3>

		<div>
  			<img src="<c:url value="/resources/images/${csrl.studyRoomImage }"/>" align="left" height="250" width="400"></img>
			<textarea rows="10" cols="20" style="margin: 2px; width: 400px; height: 241px; resize:none;" readonly>${csrl.studyRoomContent }</textarea>
  				<c:choose>
				<c:when test="${member_id == 'admin' }">	
  					<input type="button" id="btn3" value="삭제" onclick="javascript:btndelete(${csrl.studyRoomNo})">
  				</c:when>
  				<c:otherwise></c:otherwise>
  			</c:choose>
  			
		</div>
	</c:forEach>
</div>
