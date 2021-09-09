package com.sph.practice.component.websocket.service;

import com.alibaba.fastjson.JSON;
import com.sph.practice.component.exception.BaseException;
import com.sph.practice.component.websocket.pojo.bo.LiveCommentBO;
import com.sph.practice.component.websocket.pojo.vo.SessionVO;
import com.sph.practice.component.websocket.util.WebsocketUtil;
import com.sph.practice.mybatis.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 2021/08/19
 */
@Slf4j
@ServerEndpoint("/webSocket/cluster/{liveId}/{userId}")
@Component
public class WebsocketClusterServer {

    // concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static Map<String, CopyOnWriteArraySet<SessionVO>> clientMap = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    private final KafkaTemplate<String, String> kafkaTemplate = ApplicationContextUtil.getBean("kafkaTemplate", KafkaTemplate.class);

    /**
     * 下发广播通知
     *
     * @param liveId  直播ID
     * @param userId  用户ID （排除给该用户推送消息）
     * @param message 消息内容
     * @throws IOException 异常对象
     */
    public static void sendMessage(String liveId, String userId, String message) {
        // 获取当前直播的Session对象
        CopyOnWriteArraySet<SessionVO> sessionSet = clientMap.getOrDefault(liveId, new CopyOnWriteArraySet<>());
        try {
            for (SessionVO sessionVO : sessionSet) {
                // 若userId不为当前用户，则推送消息给前端
                if (userId.equals(sessionVO.getUserId())) {
                    continue;
                }
                sessionVO.getSession().getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            log.error("下发广播通知出现异常", e);
        }
    }

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
            // 直播若存在，则发布消息到kafka
            String message = userId + "，闪亮登场";
            LiveCommentBO commentBO = new LiveCommentBO();
            commentBO.setLiveId(liveId);
            commentBO.setUserId(userId);
            commentBO.setMessage(message);
            kafkaTemplate.send(WebsocketUtil.TOPIC_LIVE_COMMENT, JSON.toJSONString(commentBO));
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
        String comment = userId + "说：" + message;
        LiveCommentBO commentBO = new LiveCommentBO();
        commentBO.setLiveId(liveId);
        commentBO.setUserId(userId);
        commentBO.setMessage(comment);
        kafkaTemplate.send(WebsocketUtil.TOPIC_LIVE_COMMENT, JSON.toJSONString(commentBO));
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
        LiveCommentBO commentBO = new LiveCommentBO();
        commentBO.setLiveId(liveId);
        commentBO.setUserId(userId);
        commentBO.setMessage(message);
        kafkaTemplate.send(WebsocketUtil.TOPIC_LIVE_COMMENT, JSON.toJSONString(commentBO));
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


