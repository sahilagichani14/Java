package com.sahil;

public class Car {
	
	Engine eng;
	
	public Car(Engine eng) {
		this.eng=eng;
	}
	
	public void start() {
		System.out.println("Car started");
	}

}
