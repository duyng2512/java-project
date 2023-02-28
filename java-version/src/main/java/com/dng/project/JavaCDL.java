package com.dng.project;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaCDL {
	
	public static class Counter implements Runnable {
		private final CountDownLatch latch;
		private final int value;
		private final AtomicInteger count;
		
		public Counter(CountDownLatch latch, int value, AtomicInteger count) {
			this.latch = latch;
			this.value = value;
			this.count = count;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			count.addAndGet(value);
			latch.countDown();
		}
	}
	
	public static void futureWork() {
		try {
			
			
			Path file = Paths.get("/Users/karianna/foobar.txt");
			var channel = AsynchronousFileChannel.open(file);
			var buffer = ByteBuffer.allocate(1_000_000);
			Future<Integer> result = channel.read(buffer, 0);
			
			// Leave IO thread do their work and do st else
			System.out.println("Do some thing else");
			
			var bytesRead = result.get();
			System.out.println("Bytes read [" + bytesRead + "]");
			
		} catch (IOException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		var latch = new CountDownLatch(5);
		var count = new AtomicInteger();
		
		new Thread(new Counter(latch, 1, count)).start();
		new Thread(new Counter(latch, 1, count)).start();
		new Thread(new Counter(latch, 1, count)).start();
		new Thread(new Counter(latch, 1, count)).start();
		new Thread(new Counter(latch, 1, count)).start();
		new Thread(new Counter(latch, 1, count)).start();
		latch.await();
	}
	
}
