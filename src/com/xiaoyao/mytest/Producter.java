package com.xiaoyao.mytest;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-03-28
 */
public class Producter {

    private  final String URL = "tcp://192.168.31.128:61616";

    private  AtomicInteger num = new AtomicInteger();
    // 连接工厂
    ConnectionFactory factory;
    // 连接
    Connection connection;
    // session
    Session session;

    ThreadLocal<MessageProducer> tl = new ThreadLocal<>();

    public void initConnection(){
//        ==》 连接到mq 服务器
//          ==》 获取 connection
//              ==》 获取 session
        try {
            this.factory = new ActiveMQConnectionFactory(this.URL);
            this.connection = this.factory.createConnection();
            this.connection.start();
            this.session = this.connection.createSession(true,Session.SESSION_TRANSACTED);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param desname   Destination Name . 详间 Destination 接口
     */
    public void sendMessage(String desname){
        try {
            Queue queue = this.session.createQueue(desname);
            MessageProducer mp = tl.get();
            if (mp == null) {
                mp = session.createProducer(queue);
                tl.set(mp);
            }
            int yy = 3;
            while (yy > 0){
                    yy--;
                    Thread.sleep(1000);
                    int xx = num.getAndIncrement();
                    String msg = Thread.currentThread().getName() +": destination "+ desname +"产生消息："+ xx;
                    TextMessage textMessage = session.createTextMessage(msg);
                    System.out.println(msg);
                    mp.send(textMessage);
                    this.session.commit();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
