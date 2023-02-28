package com.dng.project.behaviour;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class State {
	
	AtomicInteger counter = new AtomicInteger();
	List<String> machineState = List.of("READY", "RUNNING", "SPEED UP", "STOP");
	
	public void run() {
		System.out.println("At state " + machineState.get(counter.getAndIncrement() % 4));
	}
	
	public static void main(String[] args) {
		State state = new State();
		state.run();
		state.run();
		state.run();
		state.run();
		state.run();
		
	}
}
