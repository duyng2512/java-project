package com.dng.project.behaviour;

public class Strategy {
	
	enum Type {
		GO_SLOW,
		GO_FAST
	}
	
	public void run(Type type) {
		switch (type) {
			case GO_FAST:
				System.out.println("LET FUCKING GO");
				break;
			case GO_SLOW:
				System.out.println("GO SLOW");
				break;
			default:
				System.out.println("STOP");
		}
	}
	
}
