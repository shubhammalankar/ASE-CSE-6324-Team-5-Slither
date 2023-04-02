package sourceUnit;
import org.antlr.v4.runtime.Token;
import antlr.ExprBaseVisitor;
import antlr.ExprParser.NumberLiteralContext;
public class AntlrToNumber_Literal extends ExprBaseVisitor<Literal>{
	public String too_many_digit_warning;
	public AntlrToNumber_Literal(String too_many_digit_warning) {
		this.too_many_digit_warning=too_many_digit_warning;
	}
	public static boolean isHexAddress(String str) {
	    // Check if the input string starts with "0x"
	    if (!str.startsWith("0x")) {
	        return false;
	    }
	    // Check if the input string has exactly 40 hexadecimal digits after the "0x"
	    if (str.length() != 42) {
	        return false;
	    }
	    // Check if all characters after the "0x" are hexadecimal digits
	    for (int i = 2; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
	            return false;
	        }
	    }
	    // If all checks pass, the input string is a valid hex address
	    return true;
	}
	
	public static boolean isNumeric(String str) {
	    //Check if String is null or empty.
		if (str == null || str.isEmpty()) {
	        return false;
	    }
	    try {
	    	// Check if number is Long.
	        Long.parseLong(str);
	        return true;
	    } catch (NumberFormatException e) {}
	    try {
	    	//Check if number is integer.
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {}
	    try {
	    	//Check if number is double.
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException e) {}
	    try {
	    	//Check if number is float.
	        Float.parseFloat(str);
	        return true;
	    } catch (NumberFormatException e) {}
	    return false;
	}

	
	public static boolean hasFiveOrMoreConsecutiveZeros(String str) {
		//Check if String is null or empty.
		if (str == null || str.isEmpty()) {
	        return false;
	    }
	    int zeroCount = 0;
	    //Check for five or more consecutive zeros.
	    for (int i = 0; i < str.length(); i++) {
	        char currentChar = str.charAt(i);
	        if (currentChar == '0') {
	            zeroCount++;
	            if (zeroCount >= 5) {
	                return true;
	            }
	        } else {
	            zeroCount = 0;
	        }
	    }
	    return false;
	}

	public static boolean getAddressFlag(String str) {  
		if (str.matches("^0x0*$")) {
	        return true; // Zero address
	    }

	    // Otherwise, it's not a zero address
	    return false;
	}

	
	@Override
	public Literal visitNumberLiteral (NumberLiteralContext ctx) {
		
		Token sttoken = ctx.getStart();
		int line = sttoken.getLine();
		String digit=ctx.getChild(0).getText();
		if (hasFiveOrMoreConsecutiveZeros(digit) && getAddressFlag(digit)) {
				System.out.println("[Warning] Zero address initialization: "+line+".");
		}
		
		else if(hasFiveOrMoreConsecutiveZeros(digit)) 
		{
			System.out.println("[Code Issue] Variable uses too many literals: "+line+".");
		}
		
		if (isHexAddress(digit)) {
			new Number_Literal(digit);
		}
		else if(isNumeric(digit)) {
				new Number_Literal(digit);
			}
			
		else {System.out.println("[Error] Incorrect address initialization: "+line+".");}
		
		
		
		return new Number_Literal(digit);
	}
}
