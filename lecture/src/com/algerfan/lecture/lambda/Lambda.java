package com.algerfan.lecture.lambda;

/**
 * @Auther algerfan
 * @Date 18-11-8 16:08
 * @Description
 **/
@FunctionalInterface
interface Print<T> {
    public void print(T x);
}

public class Lambda {

    public static void PrintString(String s, Print<String> print) {
        print.print(s);
    }

    /*private static void lambda$main$0(String s) {
    }*/

    public static void main(String[] args) {
        PrintString("test", System.out::println);
    }
}

