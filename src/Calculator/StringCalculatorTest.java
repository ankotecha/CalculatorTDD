package Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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


}
