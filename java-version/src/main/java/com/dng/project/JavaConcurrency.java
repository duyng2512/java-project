package com.dng.project;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaConcurrency {
	
	static volatile int count = 0; // -> not safe code
	static AtomicInteger atomicCount = new AtomicInteger();
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread run1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				count++;
				atomicCount.incrementAndGet();
			}
		});
		
		Thread run2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				count++;
				atomicCount.incrementAndGet();
			}
		});
		
		run1.start();
		run2.start();;
		
		run1.join();
		run2.join();
		
		System.out.println("Count " + count);
		System.out.println("Atomic  Count " + atomicCount.get());
	}
}
