package com.sph.practice.test.socketio;

import com.alibaba.fastjson.JSONObject;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2.0.0.2
 */
public class SocketClient {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        IO.Options options = new IO.Options();
        options.transports = new String[]{"websocket"};
        options.reconnectionAttempts = 2;
        options.reconnectionDelay = 1000;

        final Socket socket = IO.socket("http://localhost:9099/", options);

        socket.on("response", new Emitter.Listener() {
            @Override
            public void call(Object... arg0) {
                // JSONObject obj = (JSONObject)arg0[0];
                System.out.println(arg0[0].toString());
            }
        });

        socket.connect();
        JSONObject sendObj = new JSONObject();
        sendObj.put("stationName", "CantonTower");
        // sendObj.put("data", new JSONObject().fluentPut("stationName", "CantonTower"));
        socket.emit("web_init_event", sendObj.toJSONString());
        while (true) {
            Thread.sleep(1000);
        }
    }

}