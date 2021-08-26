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
	
}
