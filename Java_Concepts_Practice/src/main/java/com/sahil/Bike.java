package com.sahil;

import org.springframework.stereotype.Component;

@Component("bk")
//by default bike as id
public class Bike {
	Engine eng;
	String colour;
	
	public Bike(){
		System.out.println("default constructor");
	}
	
	public Bike(Engine eng, String colour){
		this.eng=eng;
		this.colour=colour;
		System.out.println("parameterized constructor");
	}

	public void start() {
		System.out.println("Bike started");
		eng.start();
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
