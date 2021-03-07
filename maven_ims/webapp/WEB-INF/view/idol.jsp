<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${idol.name }의 상세 페이지</title>
<c:import url="/WEB-INF/view/template/link.jsp"/>
<style>
	#likeBtn .fas {
		display: none;
	}
	#likeBtn .far {
		display:inline; 
	}
	#likeBtn.like .fas {
		display: inline;
		color:red;
	}
	#likeBtn.like .far {
		display: none; 
	}
</style>
</head>
<body>
<c:import url="/WEB-INF/view/template/header.jsp">
<c:param name="type" value="I"/>
<%-- 헤더에 파라미터 넘기기 --%>
</c:import>
<h2>${idol.name } 

<button form="likeForm" class="btn 
<c:if test="${idol.myLikeCount == 1}">like</c:if>" id="likeBtn"> 
	<i class="fas fa-heart"></i>
	<i class="far fa-heart"></i>
	<strong>${idol.likeCount }</strong>
</button>
<form id="likeForm" 
action="/idol/like" method="post">
	<input type="hidden" name="typeNo" value="${idol.idolId}"/>
	<input type="hidden" name="_method" value="put"/>
	<input type="hidden" name="memberNo" value="${loginMember.no}"/>
</form>
</h2>
<dl>
<dt>사진</dt>
<dd>
<img src="/img/idols/${idol.profileImage }" width="200">
</dd>
<dt>번호</dt>
<dd>${idol.idolId }</dd>
<dt>이름</dt>
<dd>${idol.name }</dd>
<dt>키</dt>
<dd>${idol.height }cm</dd>
<dt>몸무게</dt>
<dd>${idol.weight }kg</dd>
<dt>생일</dt>
<dd><fmt:formatDate value="${idol.birthDate }" pattern="YYYY년 M월 d일"/></dd>
<dt>그룹</dt>
<dd><a href="/group.ims?groupId=${idol.groupId }">${idol.groupName }</a></dd>
</dl>
<p>
<a href="/idol/${idol.idolId }/modify" class="btn">수정</a>
<button form="deleteForm" class="btn">삭제</button>
<form id="deleteForm" action="/idol/${idol.idolId}" method="post">
	<input type="hidden" name="_method" value="DELETE"/>
</form>
</p>
<a class="btn" href="${header.referer }">목록으로</a>
<c:import url="/WEB-INF/view/template/footer.jsp"/>

</body>
</html>



