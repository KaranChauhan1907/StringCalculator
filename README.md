# StringCalculator
## Function Distribution(Explanation)
* [Add](#Add)
* [Splitter](#Splitter)
* [giveDifferentDelimiters](#giveDifferentDelimiters)
* [throwExceptionIfNegative](#throwExceptionIfNegative)
* [calculateSumOfNumbers](#calculateSumOfNumbers)

## Add
```java
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
```
In this method if string numbers will empty then it returns 0. Otherwise at first Splitter method will called and it will Split the string into elements. After that it will check for the negative values by throwExceptionIfNegative method. At last it will return the sum of the splitted elements.


## Splitter
```java
private String[] Splitter(String numbers) {
		
		String delimiter = ",";
		int start_index = numbers.indexOf("//");
		int end_index = numbers.indexOf("\n");
		
		if (start_index != -1){
				delimiter = numbers.substring(start_index+2,end_index);
				numbers = numbers.substring(end_index+1);
				String finalDelimiters = giveDifferentDelimiters(delimiter,numbers);
				return numbers.split("\n|" + finalDelimiters);
		}
		
		return numbers.split("\n|\\"+delimiter);
	}
```
#### Used For : split by regex
Basically in this method i will take the delimiter and string after "\n" and pass it into giveDifferentDelimiters method which will give regex for splitting multiple delimiters. 

## giveDifferentDelimiters
```java
private String giveDifferentDelimiters(String delimiter,String numbers) {
		String groupDelimiter = "";
		String differentDelimiter ="";
		Pattern pattern = Pattern.compile("[^\\[0-9\\]]+");
		Matcher matcher = pattern.matcher(delimiter);
		
		while (matcher.find()) {
			groupDelimiter = matcher.group();
			for(int i=0;i<groupDelimiter.length();i++) {
				differentDelimiter = differentDelimiter + "\\" + groupDelimiter.charAt(i);
			}
			differentDelimiter = differentDelimiter + "|";
		}
		
		return differentDelimiter.substring(0,differentDelimiter.length() -1);
	}
```
#### Used For : Creating the regex which can split the string by multiple delimiter
In this i will take all the substring from the string delimiter which pass the regex "[^\\[0-9\\]]+". After that i will create a regex by using this substrings and return the String to the Splitter method
```java
Example String : "//[*][%]\n1*2%3"
Returned String : "\*|\%"
```

## throwExceptionIfNegative
```java
	private void throwExceptionIfNegative(String []arrayOfNumbers) {
		ArrayList<String> negatives = new ArrayList<String>();
		
		for(String number : arrayOfNumbers) {
			if(toInt(number) < 0)
				negatives.add(number);
		}
		if(negatives.size()!=0)
				throw new IllegalArgumentException("negatives not allowed: "+ String.join(",", negatives));
	}
```
#### Used For : Throw the exception if negative numers are there
## calculateSumOfNumbers
```java
	private int calculateSumOfNumbers(String []arrayOfNumbers) {
		
		int Sum=0;
		for(String num : arrayOfNumbers )
			if(toInt(num)<=1000)
				Sum = Sum + toInt(num);
		
		return Sum;
	}
	
```
#### Used For : If the Number is Greater than 1000 than Ignored and For calculating Sum of splitted elements
