<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>
<c:choose>
		<c:when test="${idol!=null}">
		${idol.name } 수정폼
		</c:when>
		<c:otherwise>
		아이돌 등록폼
		</c:otherwise>
	</c:choose>
</title>
<c:import url="/WEB-INF/view/template/link.jsp"/>
<style>
	.group {
		display: none;
	}
	.group+label {
		border-radius:10px;
		padding:6px 12px;
		margin:2px;
		display: inline-block;
		border:1px solid #999A9C;
		cursor: pointer;
	}
	.group:checked+label{
		background:#F5DF4E;
		box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
</style>
</head>
<body>
<c:import url="/WEB-INF/view/template/header.jsp">
	<c:param name="type" value="I"></c:param>
</c:import>
	<h2>
	<c:choose>
		<c:when test="${idol!=null}">
		${idol.name } 수정
		</c:when>
		<c:otherwise>
		아이돌 등록
		</c:otherwise>
	</c:choose>
	 </h2>
	<c:choose>
	<c:when test="${idol==null}">
		<form action="/idol" method="post" enctype="multipart/form-data">
	</c:when>
	<c:otherwise>
		<form method="post" action="/idol" >
		<input type="hidden" name="_method" value="PUT">
		<input type="hidden" name="idolId" value="${idol.idolId }" />
	</c:otherwise>
	</c:choose>
		<fieldset>
			<legend class="screen_out">아이돌 ${idol==null?'등록':'수정'}폼</legend>
			<p>
			<c:choose>
			<c:when test="${idol==null}">
			<label>프로필 사진
				<input type="file" name="profile" />
			</label>
			</c:when>
			<c:otherwise>
			<img src="/img/idols/${idol.profileImage}" width="200" />
			</c:otherwise>
			</c:choose>
			</p>
			<p>
			<input name="name" placeholder="이름" value="${idol.name }"/>
			</p>
			<p>
			<input name="height" placeholder="키" 
			value="${idol.height }"/>
			</p>
			<p>
			<input name="weight" placeholder="몸무게" 
			value="${idol.weight }"/>
			</p>
			<p><label> 생년월일
			<input name="birthDate" 
			placeholder="생년월일(YYYY-M-D)"
			value="${idol.birthDate }"/>
			</label>
			</p>
			<p>성별
			
				<select name="gender">
					<option
					 
					<c:if test="${idol.gender=='F' }">selected</c:if>
							
					 value="F">여자</option>
					<option 
					
					<c:if test="${idol.gender=='M' }">selected</c:if>
					
					 value="M">남자</option>
				</select>
			</p>
			<p>
			<c:forEach items="${groups}" var="group"> 
				<input class="group" id="group${group.groupId }"
				
				<c:if test="${idol.groupId==group.groupId}">checked</c:if>
				
				 type="radio" 
				name="groupId" value="${group.groupId }"/>
				<label for="group${group.groupId }">${group.name }</label>
			</c:forEach>	
			</p>
			<button class="btn" type="submit">아이돌 ${idol==null?'등록':'수정'}</button>
		</fieldset>
	</form>
<c:import url="/WEB-INF/view/template/footer.jsp"/>	
</body>
</html>


