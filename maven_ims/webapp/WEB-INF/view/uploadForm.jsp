<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 공부</title>
</head>
<body>
	<h1>파일 업로드 공부</h1>
	<%-- 
	파일업로드시에는 무조건 enctype을
	multipart/form-data로 해야 함!!
	방식은 무조건 post
	 --%>
	<form method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>파일업로드폼</legend>
			<p>
			<input name="zzz" type="file" >
			</p>
			<p>
			<input name="name" placeholder="이름"/>
			</p>
			<p>
			<input name="height" placeholder="키"/>
			</p>
			<p>
			<input name="weight" placeholder="몸무게"/>
			</p>
			<button type="submit">아이돌 등록</button>
			<%-- 
			name이 있어야 파라미터로 넘어갑니다.
			그리고 컨트롤러에서 인자로 받는 VO의 멤버필드명과
			파라미터이름과 동일할 경우 스프링이 알아서
			멤버필드의 값을 세팅해줍니다.
			 --%>
		</fieldset>
	</form>
</body>
</html>









