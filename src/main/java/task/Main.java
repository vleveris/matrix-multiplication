package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many threads do you want to run?");
		String threadInput = reader.readLine();
		int threadCount = Integer.parseInt(threadInput);
		Thread[] threads = new Thread[threadCount];
		for (int i = 0; i < threadCount; i++) {
			System.out.print(i + 1 + ". Size: ");
			String sizeStr = reader.readLine();
			int size = Integer.parseInt(sizeStr);
			threads[i] = new Thread(new CalculationThread(size));
			System.out.println();
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < threadCount; i++) {
			threads[i].start();
		}

	}
}