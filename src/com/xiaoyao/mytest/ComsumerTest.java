package com.xiaoyao.mytest;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-03-28
 */
public class ComsumerTest {
    public static void main(String[] args) {
        Comsumer c = new Comsumer();
        ComsumerTest ct = new ComsumerTest();
        c.init();
        new Thread(ct.new sub(c,"MQ1"),"Commsumer 1").start();
        new Thread(ct.new sub(c,"MQ2"),"Commsumer 2").start();
        new Thread(ct.new sub(c,"MQ3"),"Commsumer 3").start();
        new Thread(ct.new sub(c,"MQ5"),"Commsumer 4").start();

    }

    private class sub implements  Runnable{
        private Comsumer c ;
        private String name;

        public sub(Comsumer c, String name) {
            this.c = c;
            this.name = name;
        }

        @Override
        public void run() {
            int t = 22;
            while (t>0){
                t--;
                try {
                    Thread.sleep(10000);
                    c.receiveMsg(this.name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
