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
		$("#ajaxbtn").on('click',function(){
			var form = $("#uploadform")[0];
			var formdata = new FormData(form);
			
			$.ajax({ //
				url: 'uploadajax'
				,type:'post'
				,data:formdata
				,encType:"multipart/form-data"
				,processData: false
				,contentType: false
				,dataType:'json'
				,success : function(data){
					$("#ajaxresult").html("<h1>"+data.result+"</h1>");
				},error:function(request,status,error){
			        alert("code:"+request.status+"\n"
			        		+"message:"+request.responseText+"\n"
			        		+"error:"+error);
			       }
			});
		});//on5
		
	});//ready
</script>
<style type="text/css">
	#ajaxresult{ background-color: gray;}
</style>
</head>
<body>
<h1>AJAX파일업로드</h1>
===============================================================
<form id="uploadform">
업로드 파일 : <input type="file" name="uploadfile" ><br>
<input type="button" id="ajaxbtn" value="파일 업로드var.Ajax"><br>
</form>

<div id="ajaxresult"></div>
</body>
</html>