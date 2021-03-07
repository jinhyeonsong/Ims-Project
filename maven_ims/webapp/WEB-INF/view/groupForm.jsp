<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 
prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멋진 아이돌 관리 프로그램</title>
<c:import url="/WEB-INF/view/template/link.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/view/template/header.jsp">
<c:param name="type" value="G"/>
</c:import>
<h2>그룹 ${group!=null?'수정':'등록'}</h2>
<form action="/group" method="post">
<c:if test="${group!=null}">
	<input type="hidden" name="_method" value="PUT">
	<input type="hidden" name="groupId" value="${group.groupId }" />
</c:if>
	<fieldset>
		<legend>그룹 ${group!=null?'수정':'등록'}폼</legend>
		<p>
		<input name="name" 
		placeholder="그룹명" value="${group.name }">
		</p>
		<p>
		<input name="debutDate" value="${group.debutDate }"
		placeholder="데뷔일(예 : 2020-1-2)">
		</p>
		<button class="btn">${group!=null?'수정':'등록'}</button>
	</fieldset>
</form>
<c:import url="/WEB-INF/view/template/footer.jsp"/>
</body>
</html>





