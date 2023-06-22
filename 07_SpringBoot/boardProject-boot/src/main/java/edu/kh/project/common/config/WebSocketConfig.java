package edu.kh.project.common.config;

import java.net.http.WebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import edu.kh.project.chatting.model.websocket.ChattingWebsocketHandler;
import edu.kh.project.common.interceptor.ChattingHandshakeInterceptor;

@Configuration // config 파일이면 
@EnableWebSocket //grandle -> refresh 해야지 WebSoektConfigurer나옴
public class WebSocketConfig implements WebSocketConfigurer {
	
	@Autowired
	private ChattingWebsocketHandler ChattingWebsocketHandler;
	
	@Autowired
	private ChattingHandshakeInterceptor handshakeInterceptor;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		 registry.addHandler(ChattingWebsocketHandler, "/chattingSock")
         .addInterceptors(handshakeInterceptor)
         .setAllowedOriginPatterns("http://localhost/", "http://127.0.0.1")
         .withSockJS();
	}
}	
	
