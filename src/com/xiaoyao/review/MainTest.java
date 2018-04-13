package com.xiaoyao.review;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-04-12
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            MainTest.testReflect();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 类加载顺序
     */
    public static void testClassSequ(){
        System.out.println("main start");
        Persion p = new SubPersion();
    }

    /**
     * 反射
     */
    public static void testReflect() throws IllegalAccessException, InstantiationException {
       Class cz = Persion.class;
        System.out.println(cz.getName());
        Persion o = (Persion)cz.newInstance();
    }
}
