package com.dng.project.behaviour;

import java.util.ArrayList;
import java.util.List;

public class Observer {
	
	String name;
	
	public Observer(String name) {
		this.name = name;
	}
	
	public void handle(String data) {
		System.out.println(name + " receive " + data);
	}
	
	static class Observable {
		List<Observer> observers = new ArrayList<>();
		
		public void register(Observer observer) {
			observers.add(observer);
		}
		
		public void register(Observer... observer) {
			observers.addAll(List.of(observer));
		}
		
		public void notify(String data) {
			observers.forEach(observer -> observer.handle(data));
		}
	}
	
	public static void main(String[] args) {
		Observer observer1 = new Observer("observer1");
		Observer observer2 = new Observer("observer2");
		Observer observer3 = new Observer("observer3");
		
		Observable observable = new Observable();
		observable.register(observer1, observer2, observer3);
		
		observable.notify("Hey !");
	}
	
}
