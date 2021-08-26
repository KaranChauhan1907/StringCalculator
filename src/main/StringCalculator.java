package main;

public class StringCalculator {

	public int Add(String numbers) {
		
		if (numbers.isEmpty()) {
			return 0;
		}
		else {
			String[] Splitted_array = numbers.split(",");
			int Sum=0;
			for(String num : Splitted_array)
				Sum = Sum + toInt(num);
			return Sum;
		}
	}
	
	private int toInt(String numbers) {
		return Integer.parseInt(numbers);
	}
	
}