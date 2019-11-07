package com.algerfan.lecture.stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {

	public static void main(String[] args) {
		String str = "my name is AlgerFan";

		System.out.println("-------并行流parallel--------");
		// 使用并行流
		str.chars().parallel().forEach(i -> System.out.print((char) i));
		System.out.println();
		// 使用 forEachOrdered 保证顺序
		str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));
		System.out.println();

		System.out.println("-------collect收集到list--------");
		// 收集到list
		List<String> list = Stream.of(str.split(" "))
				.collect(Collectors.toList());
		System.out.println(list);

		System.out.println("-------使用 reduce 拼接字符串--------");
		// 使用 reduce 拼接字符串
		Optional<String> letters = Stream.of(str.split(" "))
				.reduce((s1, s2) -> s1 + "|" + s2);
		System.out.println(letters.orElse(""));

		System.out.println("-------带初始化值的reduce--------");
		// 带初始化值的reduce
		String reduce = Stream.of(str.split(" ")).reduce("",
				(s1, s2) -> s1 + "|" + s2);
		System.out.println(reduce);

		System.out.println("-------计算所有单词总长度--------");
		// 计算所有单词总长度
		Integer length = Stream.of(str.split(" ")).map(s -> s.length())
				.reduce(0, (s1, s2) -> s1 + s2);
		System.out.println(length);

		System.out.println("-------max 的使用--------");
		// max 的使用
		Optional<String> max = Stream.of(str.split(" "))
				.max((s1, s2) -> s1.length() - s2.length());
		System.out.println(max.get());

		System.out.println("-------使用 findFirst 短路操作--------");
		// 使用 findFirst 短路操作
		OptionalInt findFirst = new Random().ints().findFirst();
		System.out.println(findFirst.getAsInt());
	}

}
