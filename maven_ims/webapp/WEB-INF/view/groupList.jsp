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
<style>
	
	#groupListContainer::after {
		content: "";
		display: block;
		clear: both;
	}
	
	.item_group {
		width:200px;
		height:100px;
		float:left;
		margin:10px;
	}
	.item_group a {
		width:200px;
		height:100px;
		display: block;
		background:#F5DF4E;
		text-align: center;
		line-height:100px;
		font-size:28px;
		font-weight:900;
		text-decoration: none;
		transition:.1s ease;
		position: relative;
		color:#455931;
	}
	.item_group a:hover {
		 box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	#groupListContainer .label {
		position: absolute;
		left:5px;
		top:-5px;
		line-height:30px;
		font-size:16px;
		font-weight:100;
		width:30px;
		height:30px;
		background:#455931;
		color:#F2E1C2;
	}
	
	#groupListContainer .label::before {
		content:"";
		border-top:10px solid #455931;
		border-right:15px solid transparent;
		position: absolute;
		left:0;
		bottom:-10px;
	}
	
	#groupListContainer .label::after {
		content:"";
		border-bottom:10px solid transparent;
		border-right:15px solid #455931;
		position: absolute;
		right:0;
		bottom:-10px;
	}
	
	#groupListContainer .item_group strong {
		color:#999A9C;
		font-size:16px;
		font-weight:normal;
		position: absolute;
		bottom:10px;
		right:10px;
		line-height:1em;
	}
	
	#groupListContainer .like_count {
		font-size:12px;
		font-weight:100;
	}
	
	
</style>
</head>
<body>
<c:import url="/WEB-INF/view/template/header.jsp">
<c:param name="type" value="G"></c:param>
</c:import>
<h2>그룹 목록</h2>
<ul id="groupListContainer">
	<c:forEach var="group" items="${groupList}">
	<li class="item_group">
	<a href="/group/${group.groupId }">
	<span class="label">${group.groupId }</span>
	${group.name }
	<strong>
	<i class="fa${group.ownLike==1?'s':'r'} fa-heart"></i>
	<span class="like_count">${group.likeCount }</span>
	</strong>
	</a></li>
	</c:forEach>
</ul>
${paginate }
<a href="/group/register" class="btn">그룹 등록</a>
<c:import url="/WEB-INF/view/template/footer.jsp"/>
</body>
</html>



