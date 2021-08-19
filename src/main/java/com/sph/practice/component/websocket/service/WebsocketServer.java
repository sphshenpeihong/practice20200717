package com.sph.practice.component.websocket.service;

import com.sph.practice.component.exception.BaseException;
import com.sph.practice.component.websocket.pojo.vo.SessionVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/*
    此次功能是模仿直播弹幕，所以消息应该是以一场直播为维度，进入直播、下发消息、离开直播，理论上归属该场直播的其他人都应该收到信息
    onOpen：ws连接通道建立完毕后，将入参的session、liveId、userId存储到静态Map，存储完毕后，向该场直播的其他人发送消息，说这个人进入直播了
    onMessage：收到客户端传过来的消息，传给该场直播的其他人
    onError：出现一场就要打印在控制台（这个等会再看啥情况下会出现一场）
    onClose：当断开WS连接(可能是关闭浏览器时，会清空websocket全局变量，就会断开连接)，需要通知当场直播的其他人
*/

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2021/5/7
 */
/*
    websocket对象监听的地址（{sid}是变量，也即是由变量的不同，可能创建多个连接，也即是会创建多个websocketServer实例对象）
    建立websocket连接的时候，此两个参数就固定了，在onOpen、onMessage、onClose、onError方法的形参中，都可以拿到这两个参数了
 */
@ServerEndpoint("/webSocket/{liveId}/{userId}")
@Component
public class WebsocketServer {

    // concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static Map<String, CopyOnWriteArraySet<SessionVO>> clientMap = new ConcurrentHashMap<>();

    /**
     * ws连接通道建立完毕后，将入参的session、liveId、userId存储到静态Map，存储完毕后，向该场直播的其他人发送消息，说这个人进入直播了
     *
     * @param session 当前websocket连接的session信息
     * @param liveId  直播ID
     * @param userId  用户ID
     * @throws BaseException 异常对象
     * @throws IOException   异常对象
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "liveId") String liveId, @PathParam(value = "userId") String userId) throws BaseException, IOException {
        this.checkParam(session, liveId, userId);
        SessionVO sessionVO = new SessionVO();
        sessionVO.setUserId(userId);
        sessionVO.setSession(session);
        System.out.println("userId：" + userId + "，当前ws连接指向的服务器端口为：" + getServerPort());
        // 当直播存在时
        if (clientMap.containsKey(liveId)) {
            clientMap.get(liveId).add(sessionVO);
            // 直播若存在，则需要给这场直播的其他人下发消息
            String message = userId + "，闪亮登场";
            sendMessage(clientMap.get(liveId), userId, message);
        } else {
            // 当前直播不存在时
            CopyOnWriteArraySet<SessionVO> sessionSet = new CopyOnWriteArraySet<>();
            sessionSet.add(sessionVO);
            clientMap.put(liveId, sessionSet);
        }
    }

    /**
     * 用户发送消息
     *
     * @param session 用户session对象
     * @param message 消息内容
     * @throws IOException   异常对象
     * @throws BaseException 异常对象
     */
    @OnMessage
    public void onMessage(Session session, String message, @PathParam("liveId") String liveId, @PathParam("userId") String userId) throws IOException, BaseException {
        this.checkParam(session, liveId, userId);
        // 接收到用户的消息，需要推送给当前直播的其他人看到
        sendMessage(clientMap.get(liveId), userId, userId + "说：" + message);
    }

    /**
     * websocket连接关闭
     *
     * @param session 用户session对象
     * @param liveId  直播ID
     * @param userId  用户ID
     * @throws BaseException 异常对象
     * @throws IOException   异常对象
     */
    @OnClose
    public void onClose(Session session, @PathParam(value = "liveId") String liveId, @PathParam(value = "userId") String userId) throws BaseException, IOException {
        checkParam(session, liveId, userId);
        String message = userId + "已离开了直播间";
        this.sendMessage(clientMap.get(liveId), userId, message);
        clientMap.get(liveId).removeIf(sessionVO -> session.getId().equals(sessionVO.getSession().getId()));
    }

    /**
     * websocket连接出现错误
     *
     * @param throwable 错误
     */
    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    /**
     * 下发广播通知
     *
     * @param sessionSet 用户信息列表
     * @param userId     用户ID （排除给该用户推送消息）
     */
    private void sendMessage(Set<SessionVO> sessionSet, String userId, String message) throws IOException {
        // 循环，判断userId不一致，则推送消息
        for (SessionVO sessionVO : sessionSet) {
            if (userId.equals(sessionVO.getUserId())) {
                continue;
            }
            sessionVO.getSession().getBasicRemote().sendText(message);
        }
    }

    /**
     * 校验参数的合法性
     *
     * @param session 当前websocket连接的session信息
     * @param liveId  直播ID
     * @param userId  用户ID
     * @throws BaseException 异常对象
     */
    private void checkParam(Session session, String liveId, String userId) throws BaseException {
        if (Objects.isNull(session) || StringUtils.isAnyEmpty(liveId, userId)) {
            throw new BaseException(-1, "非法参数");
        }
    }

    /**
     * 获取到配置项的值
     *
     * @return 当前端口号
     * @throws IOException 异常对象
     */
    private String getServerPort() throws IOException {
        Properties properties = new Properties();
        // 获取指向classes目录
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("application-local.yml");
        properties.load(is);//指向输入流地址
        // yml文件的话，有点坑，不是server.port，而是port
        return properties.getProperty("port");
    }

}


