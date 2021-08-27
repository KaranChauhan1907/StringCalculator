package test;
import main.StringCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
public class TestStringCalculator {

	private StringCalculator stringcalculator;
	
	@Before
	public void init() {
		stringcalculator = new StringCalculator();
	}
	
	@Test
	public void ReturnZeroOnEmptyString() {
		Assert.assertEquals(stringcalculator.Add(""), 0);
	}
	
	@Test
	public void ReturnValueOnSingleNumber() {
		Assert.assertEquals(stringcalculator.Add("1"),1);
	}
	
	@Test
	public void ReturnSumOnTwoNumbers() {
		Assert.assertEquals(stringcalculator.Add("1,2"), 3);
	}
	
	@Test
	public void ReturnSumOnMoreNumbers() {
		Assert.assertEquals(stringcalculator.Add("1,2,3,4"), 10);
	}
	
	@Test
	public void AllowNewLineAsDelimiter () {
		Assert.assertEquals(stringcalculator.Add("1\n2,3"), 6);
	}
	
	@Test
	public void AllowDifferentDelimiters() {
		Assert.assertEquals(stringcalculator.Add("//;\n1;2"), 3);
	}
	
	@Test
	public void TestNegativeValues() {
		try {
			stringcalculator.Add("1,2,-3");
		}
		catch(IllegalArgumentException e){
			Assert.assertEquals(e.getMessage(), "negatives not allowed: -3");
		}
	}
	
	
	
}
