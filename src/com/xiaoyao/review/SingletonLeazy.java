package com.xiaoyao.review;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-04-12
 */
public class SingletonLeazy {

    private  static SingletonLeazy name;

    private SingletonLeazy(){

    }
    public static SingletonLeazy getSingleton(){
        if (name == null) {
           synchronized (SingletonLeazy.class){
               if (name == null) {
                   name = new SingletonLeazy();
               }
           }
        }
        return name;
    }



}
