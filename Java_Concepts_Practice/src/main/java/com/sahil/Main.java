package com.sahil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Keys{
	public void run(Engine key) {
		key.start();
	}
}

public class Main {
	
	public static void main(String[] args) {
		
		//ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ConfigClass.class);
		
//		Engine eng = ac.getBean("eng",Engine.class);
//		Engine engine = new Bike(); //instead of creating obj give IOC to spring container & loosely coupled
//		new Keys().run(eng);
//		
//		Bike bk = ac.getBean("bike", Bike.class);
//		System.out.println(bk.getColour());
//		bk.start();


		int stage = 1;
		String season;
		switch (stage) {
			case 0:
				season = "Spring";
				break;
			case 1:
				season = "Summer";
				break;
			default:
				season = "Invalid";
		}
		// OR java 14 switch, default is mandatory in new switch syntax
		String season1 = switch(stage) {
			case 0 -> "Spring";
			case 1 -> "Summer";
			//default -> "Invalid";
			default -> {
				System.out.println("This is message that season is invalid");
				yield "Invalid";
			}
		};

		enum Season {
			Spring, Summer, Fall, Winter
		}
		Season season2 = Season.Fall;
		String weather = switch(season2) {
			case Spring, Summer -> "Spring";
			case Fall -> "Summer";
			//default -> "Invalid";
			default -> {
				System.out.println("This is message that season is invalid");
				yield "Invalid";
			}
		};

		String olsString = "Sahil";
		String newconcatString = olsString.concat(" ").concat("is good");
		String bigText = "dkdjbkjfekjfekjbkwjbkjbk. " + " kjbaskdbca s kjbdksajbksjbksjbdkasbkajbkjbj. " + "snlajfnjfijbsdfkjssd fkja skjkj askjcakdj. ";
		String[] sentences = bigText.split("\\. "); //we used \\ because we need . as char not as regular expression .
		String[] words =  bigText.split(" |-"); // word with space or dash -
		String abc = "a,b,c,,";
		System.out.println(abc.split(",").length);

		String literal1 = "abc";
		String literal2 = "abc";
		String obj1 = new String("abc");
		String obj2 = new String("abc");
		System.out.println(literal1==literal2); // == checks reference
		System.out.println(literal1==obj1);
		System.out.println(literal1==obj2);
		System.out.println(literal1.equals(literal2));
		System.out.println(literal1.equals(obj1));
		System.out.println(literal1.equals(obj2)); //.equals checks value not reference

		System.out.println("palindrome: " + palindromeCheckStream("Kanak"));
		findNumberofVowelsandConsonanysStreams("Sahil Agichani");


	}

	public static boolean palindromeCheckStream(String original) {
		String normalized = original.toLowerCase();
		return IntStream.range(0, normalized.length()/2).allMatch(i -> normalized.charAt(i)== normalized.charAt(normalized.length()-i-1));
	}

	public static void findNumberofVowelsandConsonanysStreams(String input) {
		String normalized = input.trim().toLowerCase();
		String vowels = "aieouy"; //? why y

		List<Integer> letters = normalized.chars().filter(Character::isAlphabetic).boxed().collect(Collectors.toList());
		long vowelsCount = letters.stream().filter(c -> vowels.indexOf(c)!=-1).count();
		long consonentCount = letters.stream().count() - vowelsCount;
		System.out.println("vowels: " + vowelsCount + " consonentCount: " + consonentCount);
	}

}
