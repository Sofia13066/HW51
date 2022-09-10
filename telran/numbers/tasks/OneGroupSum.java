package telran.numbers.tasks;

import java.util.Arrays;

public class OneGroupSum implements Runnable {
	int[] group;
	int sum;

	public OneGroupSum(int[] group) {
		this.group = group;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
		sum = Arrays.stream(group).sum();

	}

}
