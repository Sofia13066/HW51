package telran.numbers.tests;

import telran.numbers.model.NumberSum;

public class GroupSumPerfomanceTest {
	String name;
	NumberSum numberSum;

	public GroupSumPerfomanceTest(String name, NumberSum numberSum) {
		this.name = name;
		this.numberSum = numberSum;
	}

	public void runTest(){
		long t1 = System.currentTimeMillis();
		int sum = numberSum.computeSum();
		long t2 = System.currentTimeMillis();
		System.out.println("Test name: " + name + ", time = " + (t2 - t1) + ", sum = " + sum);
	}

}