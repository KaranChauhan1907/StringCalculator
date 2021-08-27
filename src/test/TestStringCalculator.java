package test;
import main.StringCalculator;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestStringCalculator {

	private StringCalculator stringcalculator;
	private int count = 0;
	
	@Before
	public void init() {
		stringcalculator = new StringCalculator();
	}

	
	@Test
	public void _1_ReturnZeroOnEmptyString() {
		Assert.assertEquals(stringcalculator.Add(""), 0);
	}
	
	@Test
	public void _2_ReturnValueOnSingleNumber() {
		Assert.assertEquals(stringcalculator.Add("1"),1);
	}
	
	@Test
	public void _3_ReturnSumOnTwoNumbers() {
		Assert.assertEquals(stringcalculator.Add("1,2"), 3);
	}
	
	@Test
	public void _4_ReturnSumOnMoreNumbers() {
		Assert.assertEquals(stringcalculator.Add("1,2,3,4"), 10);
	}
	
	@Test
	public void _5_AllowNewLineAsDelimiter () {
		Assert.assertEquals(stringcalculator.Add("1\n2,3"), 6);
	}
	
	@Test
	public void _6_AllowDifferentDelimiters() {
		Assert.assertEquals(stringcalculator.Add("//;\n1;2"), 3);
	}
	
	@Test
	public void _7_TestNegativeValues() {
		try {
			stringcalculator.Add("1,2,-3");
		}
		catch(IllegalArgumentException e){
			Assert.assertEquals(e.getMessage(), "negatives not allowed: -3");
		}
	}
	
	@Test
	public void _8_TestMultipleNegativeValues() {
		try {
			stringcalculator.Add("-1,2,-3,4,-5");
		}
		catch(IllegalArgumentException e){
			Assert.assertEquals(e.getMessage(), "negatives not allowed: -1,-3,-5");
		}
	}
	
	@Test
	public void _9_TestGetCalledCount() {
		Assert.assertEquals(stringcalculator.getCalledCount(),8);
	}
	

	
}
