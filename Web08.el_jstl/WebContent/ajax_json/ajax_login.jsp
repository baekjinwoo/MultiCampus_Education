<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
//id:hr이고 pw:hr이면 정상사용자입니다.
// JSP태그 
//태그가 있으면 안된다. HTML태그는 다 제거.  //html주석은 서버로 전송되기때문에<!-->는 사용x  왠만하면 jsp//주석을 사용해야지 오류가 나지않는다.
String auth="";
if(request.getParameter("id").equalsIgnoreCase("hr") 
	&&
	request.getParameter("pw").equals("hr")){
	String time=new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date()); //현재시간을 해당형태로 저장
	auth="{\"auth\":true, \"logintime\":\""+time+ "\" }"; //논리값을 제외하고는 값도, 변수도 String처리 " "
}														//auth=true;와 같이 변수를 생성하는것과같다.
else{
	auth="{\"auth\":false}";
}
%>
<%=auth %>
