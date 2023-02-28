package com.dng.project.creational;

import java.util.Locale;


public class Factory {
	
	abstract static class Shape {
		public abstract void draw();
	}
	
	static class Circle extends Shape {
		@Override
		public void draw() {
			System.out.println("Draw circle");
		}
	}
	
	static class Square extends Shape {
		@Override
		public void draw() {
			System.out.println("Draw square");
		}
	}
	
	static Shape generate(String shapeType) {
		switch (shapeType.toLowerCase(Locale.ROOT)) {
			case "circle":
				return new Circle();
			case "square":
				return new Square();
			default:
				return null;
		}
	}
	
	public static void main(String[] args) {
		Shape square = Factory.generate("square");
		Shape circle = Factory.generate("circle");
		square.draw();
		circle.draw();
	}
}
