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
	#idolListContainer {
		overflow: hidden;
	}
	.item_idol {
		width:200px;
		height:230px;
		float:left;
		text-align: center;
		margin:10px;
		box-shadow:0 0 2px #999A9C;
		
	}
	.item_idol a {
		width:180px;
		height:210px;
		padding:10px;
		display:block;
		text-decoration: none;
		transition:.2s ease;
	}
	.item_idol a:hover {
		width:180px;
		height:210px;
		background: #F5DF4E;
		box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	.item_idol img {
		width:180px;
		height:180px;
		border-radius: 100%;
		transition:.2s ease;
	}
	.item_idol a:hover img {
		transform:scale(1.1);
	}
	.item_idol h3 {
		font-size:22px;
		font-weight:100;
		margin-top:5px;
	}
</style>
</head>
<body>
<c:import url="/WEB-INF/view/template/header.jsp">
<c:param name="type" value="I"></c:param>
</c:import>
<h2>아이돌 목록</h2>
<ul id="idolListContainer">
	<c:forEach items="${idols}" var="idol">
	<li class="item_idol">
	<a href="/idol/${idol.idolId }" >
	<img src="/img/idols/${idol.profileImage }" />
	<h3>${idol.name }</h3>
	</a>
	</li>
	</c:forEach>
</ul>
${paginate }

<a href="/idol/register" class="btn">아이돌 등록</a>

<c:import url="/WEB-INF/view/template/footer.jsp"/>
</body>
</html>





