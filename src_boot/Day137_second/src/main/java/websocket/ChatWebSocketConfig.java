package websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class ChatWebSocketConfig implements WebSocketConfigurer {
	// '/ws' 요청시 ChatWevbSocketHandler 매핑
	private final WebSocketHandler handler; //ChatWebSocketConfig에서만 사용
	public ChatWebSocketConfig(WebSocketHandler handler) {
		super();
		this.handler = handler;
	}
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler, "/ws").setAllowedOrigins("*");
	}
	
	
	
}
