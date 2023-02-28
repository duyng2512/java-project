package com.dng.project.structural;

public class Decorator {
	
	/**
	 * Decorator enhance Object capability at run time
	 * <p>
	 * Wrapping a gift, putting it in a box, and wrapping the box.
	 */
	
	static class A {
		public void doIt() {
			System.out.print('A');
		}
	}
	
	static class AwithX extends A {
		public void doIt() {
			super.doIt();
			doX();
		}
		
		private void doX() {
			System.out.print('X');
		}
	}
	
	static class AWithY extends A {
		public void doIt() {
			super.doIt();
			doY();
		}
		
		public void doY() {
			System.out.print('Y');
		}
	}
	
	static class AWithZ extends A {
		public void doIt() {
			super.doIt();
			doZ();
		}
		
		public void doZ() {
			System.out.print('Z');
		}
	}
	
	
	public static void main(String[] args) {
		A[] array = new A[]{new AwithX(), new AWithY(), new AWithZ()};
		for (A a : array) {
			a.doIt();
			System.out.print("  ");
		}
	}
	
	
}
