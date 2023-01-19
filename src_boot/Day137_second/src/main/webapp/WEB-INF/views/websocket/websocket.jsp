<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
<style type="text/css">
#chatarea{ background-color: yellow; border: 2px solid black;}
</style>
</head>
<body>
별명 : <input type="text" id="nickname" value="${param.id}">
<input type="button" id="enterbtn" value="입장"><br>
<h2>채팅영역</h2>
<div id="chatarea">채팅내용 표시<br></div>
전송할 메시지 : <input type="text" id="message">
<input type="button" id="sendbtn" value="메시지전송">

<script src="js/jquery-3.6.1.min.js"></script>
<script>
$(function(){
	var webSocket;
	
	$("#enterbtn").on('click',function(){ 
		webSocket = new WebSocket("ws://localhost:8085/ws");
		webSocket.onopen = open;
		webSocket.onclose = close;
		webSocket.onmessage = message; //서버가 응답한 내용 수신	
	});// on enterbtn
	
	$("#sendbtn").on('click',function(){ 
		//서버로 보내는 이벤트 발생
		var nickname =  $('#nickname').val();
		var sendmessage = $('#message').val();
		webSocket.send(nickname + " : " + sendmessage);
	});// on sendbtn
}); //바로 실행한다는 의미 

function open(){alert("웹소켓연결성공");}
function close(){alert("웹소켓해제성공");}
function message(event){
	console.log("서버로부터 메시지 수신");
	$('#chatarea').append(event.data + "<br>");
}
</script>


</body>
</html>