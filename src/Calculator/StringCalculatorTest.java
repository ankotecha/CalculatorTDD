package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StringCalculatorTest {

StringCalculator calculator = new StringCalculator();
	
	@Test
	void testEmpty() {
		assertEquals(0, calculator.Add(""));
	}
	
	@Test
	void testNull() {
		assertEquals(0, calculator.Add(null));
	}
	
	
	@Test
	void testOne() {
		assertEquals(1, calculator.Add("1"));
	}
	
	@Test
	void testTwo() {
		assertEquals(3, calculator.Add("1,2"));
	}
	
	@Test
	void testFive() {
		assertEquals(15, calculator.Add("1,2,3,4,5"));
	}
	
	@Test
	void testNewLineDelimiter() {
		assertEquals(6, calculator.Add("1,2\n3"));
	}
	
	@Test	
	void testNewLineDelimiterMoreNumbers() {
		assertEquals(14, calculator.Add("2\n3,4\n5"));
	}
	
	@Test
	void testOtherDelimiter() {
		StringCalculator calc = Mockito.mock(StringCalculator.class);
		
		calc.Add("//;\\n1;66");
		verify(calc);

	}
	
	@Test
	void testNegativeNumber() {
		IllegalArgumentException ex = null;
		try
		{
			calculator.Add("//;\n1;-2");
		}
		catch (IllegalArgumentException e)
		{
			ex = e;
		}
		assertNotNull(ex);
		assertEquals(ex.getMessage(), "negatives not allowed -2");
	}

	@Test
	void testMultipleNegativeNumbers() {
		IllegalArgumentException ex = null;
		try
		{
			calculator.Add("-1,-2");
		}
		catch (IllegalArgumentException e)
		{
			ex= e;
		}
		assertNotNull(ex);
		assertEquals(ex.getMessage(), "negatives not allowed -1,-2");
	}
	
	@Test
	void testGetCalledCount() {
		StringCalculator calc = new StringCalculator();
		calc.Add("1,2");
		calc.Add("//;\n1;2");

		assertEquals(2,calc.GetCalledCount());
	}
	
	@Test
	void testNumberOverThousand() {		
		assertEquals(2,calculator.Add("1001,2"));
	}
	
	@Test
	void testDelimiterLengthTwo()
	{
		assertEquals(6, calculator.Add("//[;;]\n1;;2;;3"));
	}
	
	@Test
	void testDelimiterLengthOverTwo()
	{
		assertEquals(6, calculator.Add("//[***]\n1***2***3"));
	}
	
	@Test
	void testMultipleDelimiter() {
		assertEquals(6, calculator.Add("//[*][%]\n1*2%3"));
	}
	
	@Test
	void testMultipleDelimiterMultipleLength() {
		assertEquals(6, calculator.Add("//[**][%%]\n1**2%%3"));
	}
}
