<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 파일읽어오기 (log_read)</title>
</head>
<body>

<% 
//파일을 읽는다, 로그Read
	FileReader fr= new FileReader("c:/log.txt");
	Scanner sc= new Scanner(fr);
	while(sc.hasNextLine()==true){ //다음라인에 읽을게 없을때까지 반복
	String line = sc.nextLine(); //한줄 읽기위해
	out.println(line +"<br>"); //브라우저에 한 줄씩 출력

	//로그출력예시지만, 책에서는 입력값이 DB로 저장되는게 아니라, 파일로 저장되는 예제.
	}
%>
</body>
</html>