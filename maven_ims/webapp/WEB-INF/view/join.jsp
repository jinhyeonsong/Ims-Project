<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
	<c:import url="/WEB-INF/view/template/link.jsp"/>
    <link rel="stylesheet" href="/css/join.css" />
</head>
<body>
<div id="header">
    <h1 id="logo"><a href="/"><img src="/img/logo.png" height="80"/>Awesome IMS</a></h1>
</div>
<div id="content">
  
        <h2 class="title"><i class="fas fa-hat-wizard"></i> 회원가입</h2>
        <div id="joinBox">

            <form
              method="post" action="/join.bmj">
                <input type="hidden" id="profileName" name="profile" />
                <fieldset>
                    <legend class="screen_out">회원가입폼</legend>
                    <div class="row">
                        <label class="label" for="id">아이디</label>
                        <input id="id" name="id"
                               autocomplete="off"
                               placeholder="영어,숫자로 4~20자 입력"
                               title="영어,숫자로 4~20자 입력"/>
                        <div class="msg id"></div>
                    </div><!--//row-->
                    <div class="row">
                        <label class="label" for="nickname">별 명</label>
                        <input id="nickname"
                               autocomplete="off"
                               placeholder="5자 내로 한글,숫자 입력"
                               title="5자 내로 한글,숫자 입력"
                               name="nickname"/>
                        <div class="msg nickname"></div>
                    </div><!--//row-->
                    <div class="row">
                        <label class="label" for="pwd">비밀번호</label>
                        <input type="password" id="pwd"
                               placeholder="4~32자로 입력"
                               title="4~32자로 입력"
                               name="pwd"/>
                        <div class="msg pwd"></div>
                    </div><!--//row-->
                    <div class="row">
                        <label class="label" for="confirm">비밀번호 확인</label>
                        <input type="password" id="confirm"
                               placeholder="위와 동일하게 입력"
                               title="위와 동일하게 입력"/>
                        <div class="msg confirm"></div>
                    </div><!--//row-->
                    <div class="row">
                        <span class="label">생년월일</span>
                        <p id="birthDate">
                            <label>
                                <input type="text" id="year" 
                                name="year"
                                       maxlength="4"
                                       autocomplete="off"
                                       title="태어난 년도를 입력"
                                       placeholder="년(4자리)"/></label>
                            <label>
                                <input type="text" id="month" 
                                name="month"
                                       maxlength="2"
                                       autocomplete="off"
                                       title="태어난 월을 입력"
                                       placeholder="월"/>
                            </label>
                            <label>
                                <input type="text" id="date"
                                       name="date"
                                       autocomplete="off"
                                       title="태어난 일을 입력"
                                       maxlength="2"
                                       placeholder="일"/>
                            </label>
                        </p>
                        <div class="msg birth"></div>
                    </div><!--//row-->
                    <div class="row" id="profileRow">
                        <span class="label">프로필사진</span>
                        <div id="profileImageBox" class="fas fa-user-circle no_image">
                            <img src="" width="140" height="140" id="profileImg"/>
                            <label class="fas fa-camera">
                                <input type="file" id="profile" />
                            </label>
                            <button type="button" class="delete fas fa-times"><span class="screen_out">삭제</span></button>
                        </div><!-- //profileBox -->
                        <div class="msg profile"></div>
                    </div><!--//profileRow -->
                    <div class="box_btn">
                        <button class="btn submit" type="submit"><i class="fas fa-sign-in-alt"></i> 회원가입</button>
                        <a class="btn" href="/"><i class="far fa-list-alt"></i> index으로</a>
                    </div><!--//box_btn -->
                </fieldset>
            </form>
        </div><!--// joinBox -->

<c:import url="/WEB-INF/view/template/footer.jsp"/>
<script type="text/javascript">

	//id 입력필드
	const $id = $("#id");
	//nickname 입력필드
	const $nickname = $("#nickname");
	//profile(파일) input요소
	const $profile = $("#profile");
	
	//프로필 박스
	const $profileBox = $("#profileImageBox");
	//프로필 이미지
	const $profileImage = $("#profileImg");
	//프로필이름 input hidden
	const $profileName = $("#profileName");
	
	//이미지 삭제 버튼
	const $deleteBtn = $(".delete");
	
	
	//id에 대한 메세지
	const $idMsg = $(".msg.id");
	//nickname에 대한 메세지
	const $nicknameMsg = $(".msg.nickname");
	//profile의 메세지
	const $profileMsg = $(".msg.profile");
	
	
	//id의 정규표현식
	const idRegExp = 
		/^[a-z|A-Z]{1}[\w]{3,19}$/;
		
	//nickname의 정규표현식
	const nicknameRegExp = 
		/^[가-힣|0-9]{2,8}$/;
		
	//이미지 삭제 버튼을 클릭했을때
	$deleteBtn.on("click",function(){
		
		//alert("dafdfsfsdf");
		//no_image클래스 add함
		$profileBox.addClass("no_image");
		//$profile의 값을 비워야 함
		$profile.val("");
		
	});//click end
	
	//파일이 변경되었을때
	$profile.on("change",function(){
		
		//File API 순수자바스크립트
		//input type=file요소에는
		//files라는 배열이 존재함
		
		//console.log(this.files);
		
		const file = this.files[0];
		
		//1) 파일의 크기가 0이상
		
		if(file.size==0) {
			$profileMsg.text("제대로 된 파일을 선택하시오. -_-;");
			return;
		}//if end
		
		//alert("여기까지왔으면?");
		
		//2) 파일의 종류가 image
		if(!file.type.includes("image/")) {
			//파일이 image가 아닐때
			$profileMsg.text("이미지를 선택해주시오. -_-;");
			return;
		}//if end

		
		$profileMsg.text("파일 업로드중...");
		
		//3) FormData객체 생성
		const formData = new FormData();
		
		//4) formdata에 파라미터를 추가
		
		//?type=P 파라미터
		formData.append("type","P");
		
		//파일을 append
		formData.append("profile",file,file.name);
		
		//$.ajax의 enctype의 기본값은
		//application/x-www-form-urlencoded
		//enctype : 
		//multipart/form-data로 넘겨야함
		//1) post방식
		//2) processData : false
		//3) contentType : false 
		$.ajax({
			url:"/ajax/profile",
			type:"post",
			processData:false,
			contentType:false,
			data:formData,
			dataType:"json",
			error:function(){
				alert("서버 점검중!")
			},
			success:function(json){
				
				//img요소의 src속성을 넘어온 이미지로 변경 
				$profileImage.attr("src","/img/members/"+json.profileName);
				
				//profileBox의 no_image 클래스 제거
				$profileBox.removeClass("no_image");
				
				//메세지 제거
				$profileMsg.text("");
				
				//input hidden에 이름을 value로 
				$profileName.val(json.profileName);
				
				
			}
		});//ajax() end
		
	});//change() end
		
	
	//nickname에 글자를 쓸때	
	$nickname.on("keyup",function() {
		
		//우선 검사중으로
		$nicknameMsg.removeClass("ok")
		      .text("검사중...");
		
		//유저가 입력한 id값을 얻어옴
		const nickname = $nickname.val();
		
		//우선 정규표현식으로 test
		if(nicknameRegExp.test(nickname)) {
			
			//이때 ajax를 이용하여 데이터베이스에
			//이 아이디가 존재하는 지 확인!!
			$.ajax({
				url:"/ajax/check/nickname",//주소
				type:"get",//방식
				data:{"nickname":nickname},//파라미터
				dataType:"json",//응답의 자료형
				error:function(xhr,error){
					alert("서버 점검중!");
					console.log(error);
				},
				success:function(json){
					
					//alert("성공!!");
					//console.log(json);
					
					if(json.result) {
						$nicknameMsg.removeClass("ok")
						.text("이미 사용중인 닉네임입니다.");
						
					}else {
						$nicknameMsg.addClass("ok")
						      .text("아주 좋은 닉네임이군요!");
						
					}//if~else end
					
				}
			});//ajax end
			
		}else {
			//틀렸을때
			$nicknameMsg.removeClass("ok")
			      .text("한글, 숫자로 5글자 이상 입력해주세요. ㅠ-ㅠ");
			
		}//if~else end
		
	});//keyup() end	
		
		//아이디 입력필드에 글자를 썼을때
		$id.on("keyup",function(){
			
			//우선 검사중으로
			$idMsg.removeClass("ok")
			      .text("검사중...");
			
			//유저가 입력한 id값을 얻어옴
			const id = $id.val();
			
			//우선 정규표현식으로 test
			if(idRegExp.test(id)) {
				
				//이때 ajax를 이용하여 데이터베이스에
				//이 아이디가 존재하는 지 확인!!
				$.ajax({
					url:"/ajax/check/id",//주소
					type:"get",//방식
					data:{"id":id},//파라미터
					dataType:"json",//응답의 자료형
					error:function(xhr,error){
						alert("서버 점검중!");
						console.log(error);
					},
					success:function(json){
						
						//alert("성공!!");
						//console.log(json);
						
						if(json.result) {
							$idMsg.removeClass("ok")
							.text("이미 사용중이거나 탈퇴한 아이디입니다.");
							
						}else {
							$idMsg.addClass("ok")
							      .text("아주 좋은 아이디군요!");
							
						}//if~else end
						
					}
				});//ajax end
				
				
			}else {
				//틀렸을때
				$idMsg.removeClass("ok")
				      .text("첫글자를 영어, 4~20자 영어 및 숫자로 입력해주세용~ ㅠ-ㅠ");
				
			}//if~else end
			
			
		});//keyup end
	

</script>
</body>
</html>








