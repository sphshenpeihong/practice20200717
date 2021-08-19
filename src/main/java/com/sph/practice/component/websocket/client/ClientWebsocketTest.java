package com.sph.practice.component.websocket.client;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * Websocket客户端测试
 *
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
@Slf4j
public class ClientWebsocketTest {

    /**
     *
     */
    @Test
    public void test() throws URISyntaxException, InterruptedException {
        WebSocketClient webSocketClient = new WebSocketClient(new URI("ws://106.52.143.20:8080/grg-center-ma/socket.io/?EIO=3&transport=websocket"), new Draft_6455()) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                log.info("[websocket] 连接成功");
            }

            @Override
            public void onMessage(String message) {
                log.info("[websocket] 收到消息={}", message);

            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                log.info("[websocket] 退出连接");
            }

            @Override
            public void onError(Exception ex) {
                log.info("[websocket] 连接错误={}", ex.getMessage());
            }
        };
        webSocketClient.addHeader("token", "{\"appAccessToken\":\"88a2278f-3fa0-44ac-ab92-ee4f9a5e8471\",\"appId\":\"1425728806500564992\",\"userId\":1074,\"localSessionKey\":\"\"}");
        webSocketClient.connect();
        //
        TimeUnit.HOURS.sleep(1);
    }

}
