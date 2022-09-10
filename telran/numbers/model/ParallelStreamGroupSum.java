package telran.numbers.model;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import telran.numbers.tasks.OneGroupSum;

public class ParallelStreamGroupSum extends NumberSum {

	public ParallelStreamGroupSum(int[][] numbersGroup) {
		super(numbersGroup);
	}

	@Override
	public int computeSum() {
		OneGroupSum[] tasks = new OneGroupSum[numbersGroup.length];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = new OneGroupSum(numbersGroup[i]);
		}

		int poolSize = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(poolSize);

		for (int i = 0; i < tasks.length; i++) {
			pool.execute(tasks[i]);
		}

		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int res = Arrays.stream(tasks).parallel()
						.mapToInt(OneGroupSum::getSum)
						.sum();
		return res;
	}

}
