package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {
//	 private static List<String> _defaultDelimiters = new List<String>{ ",", "\n" };
	 private static int StartIndexOfNumbersWithCustomDelimiter = 3;
	 private static int StartIndexOfCustomDelimiter = 2;
//	public static void main(String[] args) {
//		SpringApplication.run(CalculatorApplication.class, args);
//	}
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			String delimiter = ",";
			if(text.matches("//(.*)\n(.*)")){
				delimiter = Character.toString(text.charAt(2));
				text = text.substring(4);
			}
			
			String numList[] = splitNumbers(text, delimiter + "|\n");
			return sum(numList);
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String divider){
	    return numbers.split(divider);
	}

	private static int sum(String[] numbers){
 	    int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInt(number) <= 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += (","+number);
        	}
        	if(toInt(number) <1000)
		    	total += toInt(number);
		}

		if(!negString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}
		

		return total;
    }
	
	

}
