package main;

public class StringCalculator {

	public int Add(String numbers) {
		
		if (numbers.isEmpty()) {
			return 0;
		}
		else {
			String[] Splitted_Array = Splitter(numbers);
			throwExceptionIfNegative(Splitted_Array);
			return calculateSumOfNumbers(Splitted_Array);
		}
	}
	
	private void throwExceptionIfNegative(String []arrayOfNumbers) {
		for(String number : arrayOfNumbers) {
			if (toInt(number) < 0)
					throw new IllegalArgumentException("negatives not allowed: "+ toInt(number));
		}
	}
	
	private String[] Splitter(String numbers) {
		String delimiter = ",";
		if (numbers.matches("/{2}(\\D)\n(.*)")) {
			delimiter = Character.toString(numbers.charAt(2));
			numbers = numbers.substring(4);
		}
		return numbers.split("\n|"+delimiter);
	}
	
	private int calculateSumOfNumbers(String []arrayOfNumbers) {
		int Sum=0;
		for(String num : arrayOfNumbers )
			Sum = Sum + toInt(num);
		return Sum;
	}
	
	private int toInt(String numbers) {
		return Integer.parseInt(numbers);
	}
	
}