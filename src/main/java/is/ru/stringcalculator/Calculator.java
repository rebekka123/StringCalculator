package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if((text.contains("\n")) || (text.contains(","))){
			if(text.contains("\n")){
				text = text.replace("\n", ",");
			}
			return sum(splitNumbers(text));
		}
		else{
			int numb = toInt(text);
			if(numb > 1000){
				numb = 0;
			}
			else if(numb < 0){
				throw new RuntimeException("Negatives not allowed: " + numb);
			}
			return numb;
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	
	private static String[] splitNumbers(String numbers){
		String delem = ",";
		if(numbers.startsWith("//")){
			delem = numbers.substring(2, 3);
			numbers = numbers.substring(4);
		}
	    return numbers.split(delem);
	}
	
	private static int sum(String[] numbers){
 	    int total = 0;
 	    StringBuilder negativeNumString = new StringBuilder();
        for(String number : numbers){
        	int num = toInt(number);
        	if(num > 1000){
        		num = 0;
        	}
        	if(num < 0){
        		if(!negativeNumString.toString().isEmpty()){
        			negativeNumString.append(",");
        		}
        		negativeNumString.append(num);
        	}
		    total += num;
		}
		if(!negativeNumString.toString().isEmpty()){
				throw new RuntimeException("Negatives not allowed: " + negativeNumString.toString());
			}
		return total;
	}
}
