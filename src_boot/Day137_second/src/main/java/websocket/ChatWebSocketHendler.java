package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.server.WebSession;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ChatWebSocketHendler implements WebSocketHandler{
	// 여러개 웹소캣 클라이언트가 공유시 static 
	public static List<WebSocketSession> list = new ArrayList();
	
	@Override //클라이언트 요청시 즉각 호출
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
	}

	@Override// 클라이언트 수신시 즉각 호출
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		//session - 웹소캣 클라이언트 객체 1개
		//message - 웹소캣 클라이언트가 보낸 문자열 데이터 _ nickname:XXXX
		String msg = (String)message.getPayload();
		for(WebSocketSession s : list) {
			//s.sendMessage(WebSocketMessage타입);
			WebSocketMessage<String> sendmsg = new TextMessage(msg);
			s.sendMessage(sendmsg);
		}
		
	}

	@Override // 통신간 에러발생시 즉각 호출	
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {}

	@Override // 클라이언트 연결 해제시 즉각 호출
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		list.remove(session);
	}

	@Override //메시지를 수정할 때
	public boolean supportsPartialMessages() {return false;	}
}
