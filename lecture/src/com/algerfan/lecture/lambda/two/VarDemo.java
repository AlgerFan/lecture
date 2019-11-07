package com.algerfan.lecture.lambda.two;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 变量引用
 */
public class VarDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("打发的所发生的");
		String string = "123";
		Consumer<String> consumer = s -> System.out.println(s + list);
		consumer.accept("1211");
	}

	public void oldRunable() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("The old runable now is using!");
			}
		}).start();
	}

	public void runable() {
		new Thread(() -> System.out.println("It's a lambda function!")).start();
	}

}
