package com.example.demo;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.CalculatorApplication;

@SpringBootTest
class CalculatorApplicationTests {

	
//	public static void main(String args[]) {
//	      org.junit.runner.JUnitCore.main("org.springframework.boot.SpringApplication");
//	    }

		@Test
		public void testEmptyString() {
			assertEquals(0, CalculatorApplication.add(""));
		}

		@Test
		public void testOneNumber() {
			assertEquals(1, CalculatorApplication.add("1"));
		}

		@Test
		public void testTwoNumbers(){
			assertEquals(3, CalculatorApplication.add("1,2"));
		}

		@Test
	    public void testThreeNumbers(){
	    	assertEquals(6, CalculatorApplication.add("1,2,3"));
	    }

	    @Test
	    public void testNewLine(){
	    	assertEquals(6, CalculatorApplication.add("1\n2,3"));
	    }

	    @Test
	    public void testNegativeNumver(){
	    	try {
				CalculatorApplication.add("-1,2");
			}
			catch (IllegalArgumentException e){
				assertEquals(e.getMessage(), "Negatives not allowed: -1");
			}

			try {
				CalculatorApplication.add("2,-4,3,-5");
			}
			catch (IllegalArgumentException e){
				assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
			}
	    }

	    @Test
	    public void testOverThousand(){
	    	assertEquals(2, CalculatorApplication.add("1000,2"));
	    }

	    @Test
	    public void testOtherDelimiter(){
	    	assertEquals(3, CalculatorApplication.add("//;\n1;2"));
	    }
	    
}
