package com.sahil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

	}

}
