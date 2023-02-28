package com.dng.project.creational;

public class Builder {
	
	private String data;
	private Integer id;
	
	public Builder(String data, Integer id) {
		this.data = data;
		this.id = id;
	}
	
	static class builder {
		
		private String data;
		private Integer id;
		
		public builder() {
		}
		
		public builder data(String data) {
			this.data = data;
			return this;
		}
		
		public builder id(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder build() {
			return new Builder(this.data, this.id);
		}
	}
	
	public static void main(String[] args) {
		Builder builder = new Builder.builder()
			                  .data("data")
			                  .id(100)
			                  .build();
	}
	
}
