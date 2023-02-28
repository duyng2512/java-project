package com.dng.project.structural;

public class Bridge {
	
	/**
	 * The Bridge pattern decouples an abstraction from its implementation,
	 * so that the two can vary independently.
	 *
	 * Adapter map one behaviour to other one.
	 *
	 * Bridge is designed up-front to let the abstraction and the implementation vary independently.
	 * Adapter is retrofitted to make unrelated classes work together.
	 */
	
	// Abstraction
	public abstract static class Shape {
		protected DrawingAPI drawingAPI;
		
		protected Shape(DrawingAPI drawingAPI) {
			this.drawingAPI = drawingAPI;
		}
		
		public abstract void draw();
	}
	
	// Concrete Abstraction
	public static class Circle extends Shape {
		private int x, y, radius;
		
		public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
			super(drawingAPI);
			this.x = x;
			this.y = y;
			this.radius = radius;
		}
		
		public void draw() {
			drawingAPI.drawCircle(x, y, radius);
		}
	}
	
	// Concrete Implementation
	public interface DrawingAPI {
		public void drawCircle(int x, int y, int radius);
	}
	
	// Concrete Implementation
	public static class OpenGLDrawingAPI implements DrawingAPI {
		public void drawCircle(int x, int y, int radius) {
			// OpenGL drawing code for a circle
		}
	}
	
	// Concrete Implementation
	public static class DirectXDrawingAPI implements DrawingAPI {
		public void drawCircle(int x, int y, int radius) {
			// DirectX drawing code for a circle
		}
	}
	
}
