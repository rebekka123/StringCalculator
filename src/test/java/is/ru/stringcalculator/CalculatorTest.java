package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
	public void testAnotherNumber() {
		assertEquals(2, Calculator.add("2"));
	}
	
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testAgainTwoNumbers() {
		assertEquals(0, Calculator.add("0,0"));
	}
	
	@Test
	public void testManyNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	
	@Test
	public void testHandleNewLines() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
	@Test
	public void testHandleOnlyNewLines() {
		assertEquals(6, Calculator.add("1\n2\n3"));
	}
	
	@Test
	public void testBigNumbers() {
		assertEquals(1, Calculator.add("1005\n1"));
	}
	
	@Test
	public void testOneBigNum() {
		assertEquals(0, Calculator.add("1005"));
	}
	
	@Test
	public void testTwoBigNum() {
		assertEquals(0, Calculator.add("1005,1001"));
	}
	
	@Test
	public void testDelimeters() {
		assertEquals(3, Calculator.add("//#\n1#2"));
	}
	
	@Test
	public void testBDelimeters() {
		assertEquals(6, Calculator.add("//;\n1;2;3"));
	}
	
	@Test
	public void testATwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testADelimeters() {
		assertEquals(3, Calculator.add("//&\n1&1&1"));
	}
	
	
}