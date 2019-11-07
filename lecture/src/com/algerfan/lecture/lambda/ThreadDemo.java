package com.algerfan.lecture.lambda;

/**
 * @Auther algerfan
 * @Date 18-11-8 20:51
 * @Description
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("jdk8以前");
            }
        }).start();

        Runnable runnable = () -> System.out.println("jdk8以后");
        new Thread(runnable).start();

        new Thread(() -> System.out.println("jdk8以后")).start();
    }
}
