<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>회원가입</title>

<!-- Bootstrap -->
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet" href="/resources/css/font-awesome.min.css"
	media="screen" title="no title" charset="utf-8">
<!-- Custom style -->
<link rel="stylesheet" href="/resources/css/style.css" media="screen"
	title="no title" charset="utf-8">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<script type="text/javascript">
//var inputemail=$("#InputEmail").val();
 $(document).ready(function(){
	// alert("blur 호출");
	$("#InputEmail").focus(); 
 });
function checkEmail(){
	
 	var pawdcheck=0;
 	
	var inputemail=$("#InputEmail").val(); 
	//var email=$("#InputEmail").val();
	//alert(inputemail);
	//alert("before duplicateCheck2");
	//values=duplicateCheck2;
	//alert(duplicateCheck2);
	$.ajax({
		 data: {
			email:inputemail
		},
		
		
		url:"/signup.do",
		type:"GET",
		datatype:"text",
		
		success:function(data){
			//if문 jstl로 처리하기
			//chkemail = "${duplicatecheck}";
			/* alert("duplicatecheck"+"${duplicatecheck}") */
			
			//chkemail =test();
			//alert(chkemail);
			var chkemail = parseInt('${duplicatecheck}');
			alert("chkemail 타입"+typeof(chkemail));
			alert("duplicate 타입"+typeof('${duplicatecheck}'));
			alert("duplicatecheck"+'${duplicatecheck}');
			alert(chkemail);
			if(inputemail==null || inputemail=="") {
				//alert("이메일을 입력해주세요.");
				$(".form-group:first p").empty();
				$(".form-group:first").append("<p>email을 입력해 주세요 <p>");
			}else if(chkemail==1){
				//alert("chkemail: "+chkemail);
				//alert("중복");
				$(".form-group:first p").empty();
				$(".form-group:first").append("<p>append test 불가<p>");
			}else if(chkemail==0){
				//alert("chkemail: "+chkemail);
				//$("#InputEmail").innerHtml("중복");
				$(".form-group:first p").empty();
				$(".form-group:first").append("<p>append test 사용가능<p>");
				//alert("사용할 수 있는 이메일");
			}
			/* if(duplicateCheck2==true){
			var email2=email; */
			//alert("success");
			/* setTimeout(function() {
				console.log("찍혀라");
				alert("redirect 체크");
				}, 2000); */
			/* console.log("찍혀라");
			alert("redirect 체크"); */
			/* } */
			
		}, fail:function(){
			alert("실패");
			location.attr("/index.do");
		} 
		
	})

	
}

function checkPassword(){
	var password1=$("#InputPassword1").val();
	var password2=$("#InputPassword2").val();
	alert("password1"+password1);
	alert("password2"+password2);
	var tag1='<p class="help-block">비밀번호 일치/p>';
	var tag2='<p class="help-block">비밀번호 불일치/p>';
	if(password1==password2){
		alert("똑같음");
		
	} else{
		alert("다름");
	}
	
	
}

<%-- function test(){
	var querycheck=<%request.getparameter("duplicatecheck")%>
	return querycheck;
} --%>
</script>


</head>
<body>


	<article class="container">
		<div class="page-header">
			<h1>
				회원가입 <small>Ajax-GET</small>
			</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form role="form">
				<div class="form-group">
					<label for="InputEmail">이메일 주소</label> <input type="email"
						class="form-control" id="InputEmail" placeholder="이메일 주소" onblur="checkEmail()">
				</div>
				<div class="form-group">
					<label for="InputPassword1">비밀번호</label> <input type="password"
						class="form-control" id="InputPassword1" placeholder="비밀번호">
				</div>
				<div class="form-group">
					<label for="InputPassword2">비밀번호 확인</label> <input type="password"
						class="form-control" id="InputPassword2" placeholder="비밀번호 확인" onblur="checkPassword()">
					<p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
				</div>
				
				<div class="form-group text-center">
					<button type="submit" class="btn btn-info">
						회원가입<i class="fa fa-check spaceLeft"></i>
					</button>
					<button type="submit" class="btn btn-warning">
						가입취소<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>
			</form>
		</div>

		<div class="col-md-12">
			<div class="page-header">
				<h1>
					회원가입 <small>Ajax-POST</small>
				</h1>
			</div>
			<form class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">이메일</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="이메일">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="비밀번호">
						<p class="help-block">숫자, 특수문자 포함 8자 이상</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPasswordCheck">비밀번호
						확인</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPasswordCheck"
							type="password" placeholder="비밀번호 확인">
						<p class="help-block">비밀번호를 한번 더 입력해주세요.</p>
					</div>
				</div>



				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputAgree">약관동의</label>
					<div class="col-sm-6" data-toggle="buttons">
						<label class="btn btn-warning active"> <input id="agree"
							type="checkbox" autocomplete="off" chacked> <span
							class="fa fa-check"></span>
						</label> <a href="#">이용약관</a> 에 동의 합니다.
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button class="btn btn-primary" type="submit">
							회원가입<i class="fa fa-check spaceLeft"></i>
						</button>
						<button class="btn btn-danger" type="submit">
							가입취소<i class="fa fa-times spaceLeft"></i>
						</button>
					</div>
				</div>
			</form>
			<hr>
		</div>
	</article>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
