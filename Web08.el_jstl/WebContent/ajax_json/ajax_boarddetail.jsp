<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
JSONArray jsonarray = new JSONArray();
for(int i = 1; i <= 5; i++){
	JSONObject jsonobj = new JSONObject();
	jsonobj.put("seq", i);
	jsonobj.put("title", "제목"+i);	
	jsonobj.put("contents", "내용"+i);	
	jsonobj.put("writer", "작성자"+i);	
	jsonobj.put("time", "2018-04-25");
	jsonobj.put("pw", "1234"+i);
	jsonobj.put("viewcount", i);	
	jsonarray.add(jsonobj);
}//for end
%>
<%
String seq = request.getParameter("seq");
for(int i = 0; i < jsonarray.size(); i++){
	JSONObject vo = 
			(JSONObject)jsonarray.get(i);
	
	if( ((Integer)vo.get("seq"))
		 ==
		(Integer.parseInt(seq))){
		out.println(vo.toJSONString());
	}
}
%>








