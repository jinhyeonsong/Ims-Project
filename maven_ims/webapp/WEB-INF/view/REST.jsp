<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PUT이나 DELETE연습</title>
</head>
<body>
	<h1>REST 웹서비스 구현 연습</h1>
	<%-- 
	
	REST에서 PUT과 DELETE는 브라우저가 지원을 안함
	그래서 PUT이나 DELETE의 경우 method를 POST로 넘기고
	그대신 _method 파라미터의 값을 put이나 delete로  
	
	 --%>
	<form action="/rest.ims" method="POST">
	<input type="hidden" name="_method" value="DELETE" />
	<button>보내기</button>
	</form>
</body>
</html>






