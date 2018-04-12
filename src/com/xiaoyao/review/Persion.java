package com.xiaoyao.review;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-04-11
 */
public class Persion {
    private String name ;
    private int age;
    {
        System.out.println("代码块");
    }
    static {
        System.out.println("静态代码块");
    }
    public Persion() {
        System.out.println("无惨构造器");
    }

    public Persion(String name, int age) {
        System.out.println("有参构造器");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
