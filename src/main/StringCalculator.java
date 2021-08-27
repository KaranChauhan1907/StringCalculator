package main;
import java.util.ArrayList;

public class StringCalculator {

	private static int count=0;
	
	public int getCalledCount() {
		return count;
	}
	
	public int Add(String numbers) {
		
		count = count + 1;
		if(numbers.isEmpty()) {
			return 0;
		}
		else {
			String[] Splitted_Array = Splitter(numbers);
			throwExceptionIfNegative(Splitted_Array);
			return calculateSumOfNumbers(Splitted_Array);
		}
	}
	
	private void throwExceptionIfNegative(String []arrayOfNumbers) {
		
		ArrayList<String> negatives = new ArrayList<String>();
		
		for(String number : arrayOfNumbers) {
			if(toInt(number) < 0)
				negatives.add(number);
		}
		if(negatives.size()!=0)
			throw new IllegalArgumentException("negatives not allowed: "+ String.join(",", negatives));
	}
	
	private String[] Splitter(String numbers) {
		String delimiter = ",";
		
		if(numbers.matches("/{2}(\\D)\n(.*)")) {
			delimiter = Character.toString(numbers.charAt(2));
			numbers = numbers.substring(4);
		}
		
		return numbers.split("\n|"+delimiter);
	}
	
	private int calculateSumOfNumbers(String []arrayOfNumbers) {
		int Sum=0;
		
		for(String num : arrayOfNumbers )
			if(toInt(num)<=1000)
				Sum = Sum + toInt(num);
		
		return Sum;
	}
	
	private int toInt(String numbers) {
		return Integer.parseInt(numbers);
	}
	
}