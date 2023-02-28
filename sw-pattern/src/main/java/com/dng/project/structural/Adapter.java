package com.dng.project.structural;

public class Adapter {
	static class LegacyAdapter {
		private String data;
		
		public LegacyAdapter(String data) {
			this.data = data;
		}
	}
	
	// We want to add new set Capability
	LegacyAdapter adapter;
	
	public Adapter(LegacyAdapter adapter) {
		this.adapter = adapter;
	}
	
	public void setData(String data){
		this.adapter.data = data;
	}
	
	public static void main(String[] args) {
		LegacyAdapter legacyAdapter = new LegacyAdapter("old data");
		Adapter newAdapter = new Adapter(legacyAdapter);
		newAdapter.setData("new data");
		System.out.println(newAdapter);
	}
	
	@Override
	public String toString() {
		return "Adapter{" +
			       "adapter.data=" + adapter.data +
			       '}';
	}
}
