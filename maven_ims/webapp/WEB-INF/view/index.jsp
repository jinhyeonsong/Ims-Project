<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멋진 아이돌 관리 프로그램</title>
<c:import url="/WEB-INF/view/template/link.jsp"/>
<link rel="stylesheet" href="/css/index.css"/>
<style>

#content{
text-align:center;}
</style>
</head>
<body>
<c:import url="/WEB-INF/view/template/header.jsp"/>



<c:choose>
<c:when test="${loginMember==null }">
<div id="loginBox">
<h2><i class="fas fa-sign-in-alt"></i> 로그인</h2>
<form action="/session" method="post">
<div class="row">
<input name="id" placeholder="아이디"/>
</div>
<div class="row">
<input name="password" type="password"
placeholder="비밀번호"/>
</div>
<div class="row">
<button id="loginBtn" class="btn"><i class="fas fa-sign-in-alt"></i> 로그인</button>
</div>
</form>
</div>
</c:when>
<c:otherwise>
<h2>주요 서비스</h2>
<ul id="mainServiceBox">
<li class="item"><a href="/group/page/1"><i class="fas fa-user-friends"></i> 그룹 목록</a></li>
<li class="item"><a href="/idol/page/1"><i class="fas fa-user-circle"></i> 아이돌 목록</a></li>
</ul>
</c:otherwise>
</c:choose>


<c:import url="/WEB-INF/view/template/footer.jsp"/>
</body>
</html>
