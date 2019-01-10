<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="idwindow" style="border: silver 3px solid"> ${loginid } 입력: </div>
<div id="result" style="border: silver 3px solid; background-color: light green"> </div> <!-- 채팅하면 늘어날 공간 -->
메시지입력: <input type=text id=inputMessage><br>
<input type=button value=서버전송 onclick="send()">
</body>

<script> 
// 클라이언트
// body태그 밖에다가 script를 사용할 경우, (document).ready(function(){})필요없음
						//http:localhost:9090/el_jstl/web_socket/websocket.html
var websocket= new WebSocket("ws://localhost:9090/08.el_jstl/broadcast"); //폴더나 패키지상관없이 프로젝트/broadcast


websocket.onopen=function(event){
	document.getElementById("result").innerHTML="<h3>웹소켓연결</h3>";
	websocket.send("클라이언트가 전달합니다"); //open되자마자 메세지하나 보내보도록
}
websocket.onmessage=function(event){ //귓속말 제어하는 함수
	document.getElementById("result").innerHTML+= event.data+"<br>"; //이전값을 누적하고, 새로운 값마다 개행처리
		//"<h3>웹소켓서버로부터 메시지전달</h3>"+event.data;
	
	//id-메시지 또는 id-/to 귓속말 id 귓속말 메시지
	var message = event.data.spilit("-");
	var sender = message[0];
	var content = message[1];
	var myid= document.getElementById("idwindow").innerHTML; 
	
	if(content != null && content.match("/to ")){//귓속말 출력.  //==>  /to가 있는지? // 안에 값이 있고 매치했을때 /to라는 조건문을 적어줘야지 파란글씨의 귓속말출력문이 나온다.
			
		if(content.match("/to "+ myid)){ //==> 있다면, 내 아이디와 일치하는지?   //내 아이디와 똑같을 경우에만 출력하라는 거니까 => 내 화면에만 출력하기
			//to id 귓속말 ==> xxx(귓속말):xxx출력
			var temp= content.replace("/to "+ myid, "(귓속말):"); // /to를 (귓속말): 형태로 바꾸게한다. 
			document.getElementById("result").innerHTML+="<p style=\"color:blue\">"+sender+temp+"</p>";
		}
	}
	else{ //귓속말이 아니어도 출력
		document.getElementById("result").innerHTML+="<p style=\"color:green\">"+event.data+"</p>"; //초록글씨
	}
}
websocket.onerror=function(event){
	document.getElementById("result").innerHTML="<h3>오류발생</h3>"; 
}

function send(){
	websocket.send(document.getElementById("idwindow").innerHTML)
	+ "-" +
	websocket.send(document.getElementById("inputMessage").value); //서버로 보내라. input값은 value로 출력한다.
}


</script>
</html>