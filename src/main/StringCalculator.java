package main;

public class StringCalculator {

	public int Add(String numbers) {
		
		if (numbers.isEmpty()) {
			return 0;
		}
		else {
			String delimiter = ",";
			if (numbers.matches("/{2}\\W\n(.*)")) {
				delimiter = Character.toString(numbers.charAt(2));
				numbers = numbers.substring(4);
			}
			String[] Splitted_array = numbers.split("\n|"+delimiter);
			return calculateSumOfNumbers(Splitted_array);
		}
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