package telran.numbers.model;

import java.util.Arrays;

import telran.numbers.tasks.OneGroupSum;

public class ThreadGroupSum extends NumberSum {

	public ThreadGroupSum(int[][] numbersGroup) {
		super(numbersGroup);
	}

	@Override
	public int computeSum() {
		OneGroupSum[] tasks = new OneGroupSum[numbersGroup.length];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = new OneGroupSum(numbersGroup[i]);
		}


		Thread[] threads = new Thread[numbersGroup.length];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(tasks[i]);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int res = Arrays.stream(tasks)
							.mapToInt(OneGroupSum::getSum)
							.sum();
		// System.out.println("Result = " + res);
        return res;
	}

}
