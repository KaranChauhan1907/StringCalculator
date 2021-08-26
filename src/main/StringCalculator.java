package main;

public class StringCalculator {

	public int Add(String numbers) {
		
		if (numbers.isEmpty()) {
			return 0;
		}
		else {
			return toInt(numbers);
		}
	}
	
	private int toInt(String numbers) {
		return Integer.parseInt(numbers);
	}
	
}