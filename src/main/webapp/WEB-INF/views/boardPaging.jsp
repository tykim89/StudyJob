<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%
	int nowPage = 0;
	if(request.getParameter("nowPage")!=null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}else{
		nowPage = 1;
	}
	int countPerPage = 10; //���������� ������ �Խù���
	int countPerBlock = 3; //[1][2][3] [����] ��� ����, ���������� [4][5][6]�� ����
	int totalRecode = (Integer)request.getAttribute("totalCount"); //�� �Խù���
	int totalPage = (int)((totalRecode-1)/countPerPage)+1; //�� �������� ��
	
	if (totalPage == 0){
		totalPage = 1;}
	int totalBlock = (int) totalPage / countPerBlock; //�Ѻ��Ǽ�, [1]�� ��
	if (totalBlock != 0){
		totalBlock++; }
	int nowBlock = (int) ((nowPage - 1) / countPerBlock);

	int firstPage = 1;
	int prevPage = 0;
	int nextPage = 0;
	int lastPage = 0;

	if (nowBlock > 0) {
		firstPage = 1;
	}
	
	if (nowPage > 1) {
		prevPage = nowPage - 1;
	}

	int startPage = nowBlock * countPerBlock + 1;
	int endPage = countPerBlock * (nowBlock + 1);

	if (endPage > totalPage)
		endPage = totalPage;

	if (nowPage < totalPage) {
		nextPage = nowPage + 1;
	}
	if (nowBlock <= totalBlock) {
		lastPage = totalPage;
	}
%>
<script type="text/javascript">
function gotoPage(pageNum) {
	var objForm = document.frmPaging;
	var start = ((pageNum -1) * <%=countPerPage%>)+1;
	var end = (pageNum *  <%=countPerPage%>);
	objForm.start.value = start;
	objForm.end.value = end;
	objForm.nowPage.value = pageNum;	
	objForm.submit();
}
</script>
</head>
<body>
		<table>
			<tr>
				<td align="left">
				<%-- <%if (firstPage > 0) { %> --%>
				<a href="javascript:gotoPage('<%=firstPage%>');">ó��</a>
				<%-- <%} %> --%>
				<%if (prevPage > 0) { %>
				<a href="javascript:gotoPage('<%=prevPage%>');">����</a>
				<%} %>
				<%for (int indexI = startPage; indexI <= endPage; indexI++) { %>
					<%if (indexI == nowPage) { %>
					<%=indexI %>
					<%} else { %>
					<a href="javascript:gotoPage('<%=indexI%>');">[<%=indexI %>]</a> 
					<%} %>
				<%} %>
				<%if (nextPage > 0) { %>
				<a href="javascript:gotoPage('<%=nextPage%>');">����</a>
				<%} %>
				<%-- <%if (lastPage > 0) { %> --%>
				<a href="javascript:gotoPage('<%=lastPage%>');">������</a>
				<%-- <%} %> --%>
			</td>
			</tr>
		</table>
		
</body>
</html>