package com.prac.gw;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GwApplication {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a2","b1","a1","b2");
		List<String> list2 = new ArrayList(Arrays.asList("a2","b1","a1","b2"));
		list2.stream().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		list.stream().map(s->s.length()).forEach(s->System.out.println(s));
		System.out.println("--------------------------------------");

		list.stream().map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));

		System.out.println("--------------------------------------");
	
		list.stream().map(String::toUpperCase).forEach(System.out::println);

		System.out.println("--------------------------------------");

		list.stream().map(String::toUpperCase).sorted().forEach(System.out::println);

		SpringApplication.run(GwApplication.class, args);
	}

}
