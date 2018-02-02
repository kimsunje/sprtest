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
<title>ȸ������</title>

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
	// alert("blur ȣ��");
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
			//if�� jstl�� ó���ϱ�
			//chkemail = "${duplicatecheck}";
			/* alert("duplicatecheck"+"${duplicatecheck}") */
			
			//chkemail =test();
			//alert(chkemail);
			var chkemail = parseInt('${duplicatecheck}');
			alert("chkemail Ÿ��"+typeof(chkemail));
			alert("duplicate Ÿ��"+typeof('${duplicatecheck}'));
			alert("duplicatecheck"+'${duplicatecheck}');
			alert(chkemail);
			if(inputemail==null || inputemail=="") {
				//alert("�̸����� �Է����ּ���.");
				$(".form-group:first p").empty();
				$(".form-group:first").append("<p>email�� �Է��� �ּ��� <p>");
			}else if(chkemail==1){
				//alert("chkemail: "+chkemail);
				//alert("�ߺ�");
				$(".form-group:first p").empty();
				$(".form-group:first").append("<p>append test �Ұ�<p>");
			}else if(chkemail==0){
				//alert("chkemail: "+chkemail);
				//$("#InputEmail").innerHtml("�ߺ�");
				$(".form-group:first p").empty();
				$(".form-group:first").append("<p>append test ��밡��<p>");
				//alert("����� �� �ִ� �̸���");
			}
			/* if(duplicateCheck2==true){
			var email2=email; */
			//alert("success");
			/* setTimeout(function() {
				console.log("������");
				alert("redirect üũ");
				}, 2000); */
			/* console.log("������");
			alert("redirect üũ"); */
			/* } */
			
		}, fail:function(){
			alert("����");
			location.attr("/index.do");
		} 
		
	})

	
}

function checkPassword(){
	var password1=$("#InputPassword1").val();
	var password2=$("#InputPassword2").val();
	alert("password1"+password1);
	alert("password2"+password2);
	var tag1='<p class="help-block">��й�ȣ ��ġ/p>';
	var tag2='<p class="help-block">��й�ȣ ����ġ/p>';
	if(password1==password2){
		alert("�Ȱ���");
		
	} else{
		alert("�ٸ�");
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
				ȸ������ <small>Ajax-GET</small>
			</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form role="form">
				<div class="form-group">
					<label for="InputEmail">�̸��� �ּ�</label> <input type="email"
						class="form-control" id="InputEmail" placeholder="�̸��� �ּ�" onblur="checkEmail()">
				</div>
				<div class="form-group">
					<label for="InputPassword1">��й�ȣ</label> <input type="password"
						class="form-control" id="InputPassword1" placeholder="��й�ȣ">
				</div>
				<div class="form-group">
					<label for="InputPassword2">��й�ȣ Ȯ��</label> <input type="password"
						class="form-control" id="InputPassword2" placeholder="��й�ȣ Ȯ��" onblur="checkPassword()">
					<p class="help-block">��й�ȣ Ȯ���� ���� �ٽ��ѹ� �Է� �� �ּ���</p>
				</div>
				
				<div class="form-group text-center">
					<button type="submit" class="btn btn-info">
						ȸ������<i class="fa fa-check spaceLeft"></i>
					</button>
					<button type="submit" class="btn btn-warning">
						�������<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>
			</form>
		</div>

		<div class="col-md-12">
			<div class="page-header">
				<h1>
					ȸ������ <small>Ajax-POST</small>
				</h1>
			</div>
			<form class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">�̸���</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputEmail" type="email"
							placeholder="�̸���">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">��й�ȣ</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPassword" type="password"
							placeholder="��й�ȣ">
						<p class="help-block">����, Ư������ ���� 8�� �̻�</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPasswordCheck">��й�ȣ
						Ȯ��</label>
					<div class="col-sm-6">
						<input class="form-control" id="inputPasswordCheck"
							type="password" placeholder="��й�ȣ Ȯ��">
						<p class="help-block">��й�ȣ�� �ѹ� �� �Է����ּ���.</p>
					</div>
				</div>



				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputAgree">�������</label>
					<div class="col-sm-6" data-toggle="buttons">
						<label class="btn btn-warning active"> <input id="agree"
							type="checkbox" autocomplete="off" chacked> <span
							class="fa fa-check"></span>
						</label> <a href="#">�̿���</a> �� ���� �մϴ�.
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button class="btn btn-primary" type="submit">
							ȸ������<i class="fa fa-check spaceLeft"></i>
						</button>
						<button class="btn btn-danger" type="submit">
							�������<i class="fa fa-times spaceLeft"></i>
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
