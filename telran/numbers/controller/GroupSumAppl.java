package telran.numbers.controller;

import java.util.Random;

import telran.numbers.model.ExecutorGroupSum;
import telran.numbers.model.NumberSum;
import telran.numbers.model.ParallelStreamGroupSum;
import telran.numbers.model.ThreadGroupSum;
import telran.numbers.tests.GroupSumPerfomanceTest;

public class GroupSumAppl {
	static final int N_GROUPS = 10_000;
	static final int NUMBER_PER_GROUP = 10_000;
	static int[][] arr = new int[N_GROUPS][NUMBER_PER_GROUP];
	static Random random = new Random();

	public static void main(String[] args) {
		fillArray();
		NumberSum executorsSum = new ExecutorGroupSum(arr);
		NumberSum threadSum = new ThreadGroupSum(arr);
		NumberSum streamSum = new ParallelStreamGroupSum(arr);
		new GroupSumPerfomanceTest("ExecutorGroupSum", executorsSum).runTest();
		new GroupSumPerfomanceTest("ParallelStreamGroupSum", streamSum).runTest();
		new GroupSumPerfomanceTest("ThreadGroupSum", threadSum).runTest();

	}

	private static void fillArray() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = random.nextInt();
			}
		}

	}

}
