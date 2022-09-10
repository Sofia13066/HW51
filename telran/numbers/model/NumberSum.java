package telran.numbers.model;

public abstract class NumberSum {
	protected int[][] numbersGroup;

	public NumberSum(int[][] numbersGroup) {
		this.numbersGroup = numbersGroup;
	}
	
	public abstract int computeSum();
}