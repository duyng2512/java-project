package com.dng.project;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Java11 {
	
	public static void collectionFactory() {
		
		Map<String, String> map;
		try {
			map = Map.of("key", "value");
			map.put("new", "new Value"); // --> will throw Unsupport Operation
			
		} catch (UnsupportedOperationException e) {
			map = new HashMap<>(Map.of("key", "value"));
			map.put("new", "new Value");
			System.out.println(map);
		}
	}
	
	public static void httpSupport() {
		
		try {
			var client = HttpClient.newBuilder().build();
			var uri = new URI("https://google.com");
			var request = HttpRequest.newBuilder(uri).build();
			var response = client.send(
				request,
				HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));
			System.out.println(response.body());
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void httpSupportAsync() {
		try {
			var client = HttpClient.newBuilder().build();
			var uri = new URI("https://google.com");
			var req = HttpRequest.newBuilder(uri).build();
			var handler = HttpResponse.BodyHandlers.ofString();
			
			CompletableFuture.allOf(
				client.sendAsync(req, handler).thenAccept((resp) -> System.out.println( "1: " + resp.statusCode())),
				client.sendAsync(req, handler).thenAccept((resp) -> System.out.println( "2: " + resp.statusCode())),
				client.sendAsync(req, handler).thenAccept((resp) -> System.out.println( "3: " + resp.statusCode()))
			).join();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		// collectionFactory();
		httpSupportAsync();
	}
}
