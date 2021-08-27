package main;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String newDelimiter= "";
		if(numbers.matches("/{2}[^0-9]\n(.*)")) {
			delimiter = Character.toString(numbers.charAt(2));
			numbers = numbers.substring(4);
		}

		 int start_index = numbers.indexOf("//[");
			int end_index = numbers.indexOf("\n");
			if (start_index != -1){
					delimiter = numbers.substring(start_index+3,end_index-1);
					numbers = numbers.substring(end_index+1);
					Pattern pattern = Pattern.compile("[^0-9]+");
					Matcher matcher = pattern.matcher(delimiter);
					if(matcher.find()){
					    	return numbers.split(pattern.quote(matcher.group()));
					}
			}
		return numbers.split("\n|\\"+delimiter);
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