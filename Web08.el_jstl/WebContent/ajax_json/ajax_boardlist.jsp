<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONAware"%>
<%@page import="board.BoardVO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
//서버입니다.

//id:board이고 pw:board이면 정상사용자입니다.
// JSP태그 
//태그가 있으면 안된다. HTML태그는 다 제거.  //html주석은 서버로 전송되기때문에<!-->는 사용x  왠만하면 jsp//주석을 사용해야지 오류가 나지않는다.
JSONArray jsonarray = new JSONArray();
if(request.getParameter("id").equals("board") 
	&&
	request.getParameter("pw").equals("board")){

//게시물리스트 5개 생성 - jason전달
String da1= new SimpleDateFormat("yy년MM월dd일 HH시mm분ss초").format(new Date());
BoardVO vo1 = new BoardVO(1,"제목","내용","작성자",da1,"1234",0);

for(int i=0; i<=4; i++){
	JSONObject jsonobj = new JSONObject();
	jsonobj.put("seq", i);
	jsonobj.put("title", "제목"+i);
	jsonobj.put("contents", "내용"+i);
	jsonobj.put("writer", "작성자" + i);
	jsonobj.put("time", da1+ i);
	jsonobj.put("pw", "1234"+ i);
	jsonobj.put("view", i);
	jsonarray.add(jsonobj); //put과 add를 통해알수있듯이 map과 같다
	}//for //마무리하고 출력시 toString형태로.
}//if
%>

<%=jsonarray.toJSONString() %> 
