package com.xiaoyao.mytest;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-03-28
 */
public class ProducterTest {
    public static void main(String[] args) {
        Producter p = new Producter();
        ProducterTest pt = new ProducterTest();
        p.initConnection();
        new Thread(pt.new RN(p,"MQ1"),"Thread 1").start();
        new Thread(pt.new RN(p,"MQ2"),"Thread 2").start();
        new Thread(pt.new RN(p,"MQ3"),"Thread 3").start();
        new Thread(pt.new RN(p,"MQ4"),"Thread 4").start();

    }

    class RN implements  Runnable{
        private Producter p;
        private String desName ;
        private int xx = 20;
        public RN(Producter p,String name) {
            this.p = p;
            this.desName = name;
        }

        @Override
        public void run() {
            while (xx >0){

                try {
                    xx--;
                    Thread.sleep(10000);
                    p.sendMessage(this.desName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
