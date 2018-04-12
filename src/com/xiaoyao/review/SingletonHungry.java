package com.xiaoyao.review;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-04-12
 */
public class SingletonHungry {
    private static SingletonHungry name = new SingletonHungry();
    private SingletonHungry(){}
    public static SingletonHungry getSingle(){
        return name;
    }
}
