package com.example.foodordersystem.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@RestController
@ServerEndpoint("/webSocket")
@Component
public class WebSocketService {
    // 定义属性
    private Session session;
    // 创建一个set用来存储用户
    public static CopyOnWriteArraySet<WebSocketService> websockets = new CopyOnWriteArraySet<>();
    public static final Map<String, CopyOnWriteArraySet<WebSocketService>> sessionMap = new ConcurrentHashMap<>();

    /**
     * 当有用户创建连接时候调用该方法
     */
    @OnOpen
//    @RequestMapping("{password}")
    public void onOpen(Session session) {
        // 给当前的Session赋值
        this.session = session;
        // 将当前对象添加到CopyOnWriteArraySet 中
        websockets.add(this);
//        if (sessionMap.get(password) == null) {
//            sessionMap.put(password, new CopyOnWriteArraySet<>());
//            sessionMap.get(password).add(this);
//        } else sessionMap.get(password).add(this);

        // 可以获取该session，但是其实也是一个内存地址
        System.err.println("【建立连接】 用户为：" + this.session);
        // 获取总数，这个不难理解，实际上这个集合的总数，就是WebSocket连接的总数
        System.err.println("【建立连接】 总数为：" + websockets.size());
    }

    /**
     * 有用户连接断开时候触发该方法
     */
    @OnClose
    public void onClose() {
        websockets.remove(this); // 将当前的对象从集合中删除
        sessionMap.forEach((k, v) -> {
            for (WebSocketService service : v) {
                if (sessionMap.get(k).remove(service)) {
                    break;
                }
            }
        });
        System.err.println("【连接断开】 用户为：" + this.session);
        System.err.println("【连接断开】 总数为：" + websockets.size());
    }

    /**
     * 这个方法是客户端给服务端发送消息触发该方法
     *
     * @param message ： 消息内容
     */
    @OnMessage
    public void onMessage(String message) {
        if (sessionMap.get(message) == null) {
            sessionMap.put(message, new CopyOnWriteArraySet<>());
            sessionMap.get(message).add(this);
        } else sessionMap.get(message).add(this);
        System.err.println("【收到客户端发的消息】：" + message);
    }

    /**
     * 发送消息的方法，方便后期别的service调用
     *
     * @param message 消息内容
     */
    public void sendMessage(String message) {
        for (WebSocketService websocket : websockets) {
            // 遍历该Set集合
            try {
                websocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
