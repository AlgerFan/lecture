package com.algerfan.lecture.lambda;

import java.util.stream.IntStream;

/**
 * @Auther algerfan
 * @Date 18-11-8 17:02
 * @Description
 **/
public class MinDemo {
    public static void main(String[] args) {
        int[] arr = {15,24,12,451,156};
        int min = Integer.MAX_VALUE;
        for (int a :
                arr) {
            if (a < min) {
                min = a;
            }
        }
        System.out.println(min);

        //jdk8 lambda
        int min2 = IntStream.of(arr).parallel().min().getAsInt();
        System.out.println(min2);

    }
}
