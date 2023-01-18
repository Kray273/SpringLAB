<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#ajaxbtn').on('click',function(){
			$.ajax({
				url: 'loginajax',
				type : 'post',
				data : {'id': $('#id').val(), 'pw': $('#pw').val()},
				dataType : 'json',
				success : function(data){
					$('#ajaxresult').html("<h3>"+data.process+"</h3>");
				}, //성공 시
				error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"
			        		+request.responseText+"\n"+"error:"+error);
			    } // 실패 시
			}); //ajax
		});// ajaxbtn _ on
		
		$('#ajaxbtn2').on('click',function(){
			$.ajax({
				url: 'myinformajax',
				type : 'post',
				data : {'id': $('#id').val(), 'pw': $('#pw').val()},
				dataType : 'json',
				success : function(data){
					$('#ajaxresult').html("회원아이디 : "+ data.id);
					$('#ajaxresult').append(", 암호 : "+ data.pw);
					$('#ajaxresult').append(", 번호 : "+ data.phone);
					$('#ajaxresult').append(", 가입일 : "+ data.indate);
				}, //성공 시
				error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"
			        		+request.responseText+"\n"+"error:"+error);
			    } // 실패 시
			}); //ajax
		});// ajaxbtn2 _ on
		
		$('#ajaxbtn3').on('click',function(){
			$.ajax({
				url: 'memeberlistajax',
				type : 'get',
				dataType : 'json',
				success : function(data){
					for(var i = 0; i < data.length; i++ ){
						$('#ajaxresult').append(
						data[i].id + " : " + data[i].name + " : " + data[i].address + "<br>");
					}
				}, //성공 시
				error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"
			        		+request.responseText+"\n"+"error:"+error);
			    } // 실패 시
			}); //ajax
		});// ajaxbtn3 _ on
		
		$('#ajaxbtn4').on('click',function(){
			$.ajax({
				url: 'pageinglistajax/'+$('#page').val(),
				type : 'get',
				dataType : 'json',
				success : function(data){
					for(var i = 0; i < data.length; i++ ){
						$('#ajaxresult').append(
						data[i].id + " : " + data[i].name + " : " + data[i].address + "<br>");
					}
				}, //성공 시
				error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"
			        		+request.responseText+"\n"+"error:"+error);
			    } // 실패 시
			}); //ajax
		});// ajaxbtn4 _ on
		
	});//ready
</script>
<style type="text/css">
	#ajaxresult{ background-color: gray;}
</style>
</head>
<body>
<h1>AJAX로그인</h1>
<form action="loginajax" method=post >
	아이디<input type=text name="id" id="id"><br>
	암호<input type=password name="pw" id="pw"><br>
	<input type="submit" value="로그인"><br>
</form>
<input type="button" id="ajaxbtn" value="ajax로그인"><br>
<input type="button" id="ajaxbtn2" value="내정보보기"><br>
<input type="button" id="ajaxbtn3" value="회원리스트보기"><br>

페이지 번호 입력 : <input type="number" id="page">
<input type="button" id="ajaxbtn4" value="페이징리스트보기"><br>

<div id="ajaxresult"></div>
</body>
</html>