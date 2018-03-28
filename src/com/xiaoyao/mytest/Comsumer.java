package com.xiaoyao.mytest;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-03-28
 */
public class Comsumer {

    private String URL = "tcp://192.168.31.128:61616";
    ConnectionFactory cf ;
    Connection connection;
    Session session;
    ThreadLocal<MessageConsumer> tl = new ThreadLocal<>();
    AtomicInteger num = new AtomicInteger();
    public void init(){
        try {
            cf = new ActiveMQConnectionFactory(this.URL);
            connection = cf.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param desname 目的地名
     */
    public void receiveMsg(String desname){
        MessageConsumer mc = tl.get();
        try {
            Queue queue = session.createQueue(desname);
            if (mc == null) {
                mc = session.createConsumer(queue);
                tl.set(mc);
            }
            int yy = 3;
            while (yy >0){
                yy--;
                Thread.sleep(1000);
                int xx = num.getAndIncrement();
                TextMessage receive =(TextMessage) mc.receive();
                if(receive!=null) {
                    receive.acknowledge();
                    System.out.println(Thread.currentThread().getName() + " : destination: "+ desname + "消费消息" + receive.getText());
                }else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
