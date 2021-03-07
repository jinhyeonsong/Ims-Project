<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<div id="header">
<h1 id="logo"><a href="/"><img src="/img/logo.png" height="80"/>Awesome Ims</a></h1>
<c:choose>
<c:when test="${loginMember==null }">
<a id="joinBtn" href="/join"><i class="fas fa-user-plus"></i> 회원가입</a>
</c:when>
<c:otherwise>
<c:if test="${pageContext.request.requestURI !='/WEB-INF/view/index.jsp'}">
<h2 class="screen_out">주요 서비스</h2>
<ul id="mainServiceList">
<li <c:if test="${param.type=='G' }">class="on"</c:if>><a href="/group/page/1"><i class="fas fa-user-friends"></i> 그룹 목록</a></li>
<li <c:if test="${param.type=='I' }">class="on"</c:if>><a href="/idol/page/1"><i class="fas fa-user-circle"></i> 아이돌 목록</a></li>
</ul>
</c:if>

<div id="profileBox">
<img src="/img/members/${loginMember.profileImage }"
title="${loginMember.nickname }" alt="${loginMember.nickname }"/>
<form action="/session" method="post" id="logoutForm">
<input type="hidden" name="_method" value="DELETE"> 
</form>
<button form="logoutForm" id="logoutBtn">
<i class="fas fa-sign-out-alt"></i> 
로그아웃
</button>
</div>
</c:otherwise>
</c:choose>
</div>
<%--header end --%>
<c:if test="${msg!=null }">
<div id="msgBox">${msg }</div>
<script>
setTimeout(function() {
	$("#msgBox").fadeOut();
}, 500);
</script>
</c:if>
<div id="content">