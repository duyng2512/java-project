package com.dng.project.behaviour;

import java.util.ArrayList;
import java.util.List;

public class Command {
	
	abstract static class BaseCommand {
		String type;
		Integer data;
	}
	
	static class AddCommand extends BaseCommand {
		public AddCommand(int data) {
			this.type = "add";
			this.data = data;
		}
	}
	
	static class RemoveCommand extends BaseCommand {
		public RemoveCommand() {
			this.type = "remove";
		}
	}
	
	static class Receiver {
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		
		public void handle(BaseCommand command) {
			switch (command.type) {
				case "add":
					list.add(command.data);
					break;
				case "remove":
					list.remove(list.size() - 1);
					break;
				default:
					System.err.println("Un support command");
			}
		}
	}
	
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		receiver.handle(new AddCommand(100));
		receiver.handle(new RemoveCommand());
		receiver.handle(new AddCommand(6));
		
		System.out.println(receiver.list);
		// 1 2 3 4 5 6
	}
	
}
