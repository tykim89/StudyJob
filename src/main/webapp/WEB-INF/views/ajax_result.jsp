<%
List<String> lst = (List<String>)request.getAttribute("result");

int sizeOfList = lst.size();

out.print("<select id='study_city' name='study_rigion' >");
out.print("	<option value='전체'> 전체 </option>");

for(int i=0; i<sizeOfList; i++){
	out.print("	<option value='"+lst.get(i)+"'> "+lst.get(i)+" </option>");	
}


out.print("</select>");
%><%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.*"%>