package com.dng.project.behaviour;

import java.util.ArrayList;
import java.util.List;

public class Chain {
	
	public interface Handler {
		void handle(StringBuilder data);
	}
	
	public static class PreProcessHandler implements Handler {
		
		@Override
		public void handle(StringBuilder data) {
			data.append("_PreProcessHandler");
		}
	}
	
	public static class DataProcessHandler implements Handler {
		
		@Override
		public void handle(StringBuilder data) {
			data.append("_DataProcessHandler");
		}
	}
	
	public static class PostProcessHandler implements Handler {
		
		@Override
		public void handle(StringBuilder data) {
			data.append("_PostProcessHandler");
		}
	}
	
	public static void main(String[] args) {
		List<Handler> handlers = new ArrayList<>();
		handlers.add(new PreProcessHandler());
		handlers.add(new DataProcessHandler());
		handlers.add(new PostProcessHandler());
		final StringBuilder data = new StringBuilder();
		handlers.forEach( handler -> handler.handle(data) );
		System.out.println(data);
	}
	
}
