<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${group.name }의 상세 페이지</title>
<c:import url="/WEB-INF/view/template/link.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/view/template/header.jsp">
<c:param name="type" value="G"></c:param>
</c:import>

<h2>${group.name }</h2>
<dl>
<dt>번호</dt>
<dd>${group.groupId }</dd>
<dt>이름</dt>
<dt>${group.name }</dt>
<dt>데뷔일</dt>
<dd>
<fmt:formatDate value="${group.debutDate }" pattern="YYYY년 MM월 dd일"/>
</dd>
</dl>
<p>
<a href="/group/${group.groupId}/modify" class="btn">수정</a>
<button form="deleteForm" class="btn">삭제</button>
<form id="deleteForm" action="/group/${group.groupId}" method="post">
	<input type="hidden" name="_method" value="DELETE">
</form>
</p>
<h3>멤버 목록</h3>
<ul>
<c:forEach items="${idols }"  var="idol">
<li><a href="/idol.ims?idolId=${idol.idolId }">${idol.name }</a></li>

</c:forEach>
<c:if test="${idols.isEmpty() }">
<li>아이돌이 없습니다.</li>
</c:if>
</ul>

<p>
<a href="" class="btn">목록으로</a>
</p>
<c:import url="/WEB-INF/view/template/footer.jsp"/>
</body>
</html>