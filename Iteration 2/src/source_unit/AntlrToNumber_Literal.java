package source_unit;

import org.antlr.v4.runtime.Token;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import antlr.ExprBaseVisitor;
import antlr.ExprParser.NumberLiteralContext;

public class AntlrToNumber_Literal extends ExprBaseVisitor<Literal>{

	public String too_many_digit_warning;
	
	public AntlrToNumber_Literal(String too_many_digit_warning) {
		this.too_many_digit_warning=too_many_digit_warning;
	}
	
	public static boolean isHexAddress(String str) {
	    // Regular expression to match a hex address
	    String regex = "^0x[0-9a-fA-F]{40}$";

	    // Create a Pattern object from the regex
	    Pattern pattern = Pattern.compile(regex);

	    // Use the Pattern object to create a Matcher object
	    Matcher matcher = pattern.matcher(str);

	    // Return true if the Matcher object finds a match, false otherwise
	    return matcher.matches();
	}

	
	public static boolean hasFiveOrMoreConsecutiveZeros(String str) {
	    if (str == null || str.isEmpty()) {
	        return false;
	    }
	    int zeroCount = 0;
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
		//System.out.println(getAddressFlag(digit));
		if (hasFiveOrMoreConsecutiveZeros(digit) && getAddressFlag(digit)) {
				System.out.println("[Warning] Zero address initialization: "+line+".");
		}
		
		else if(hasFiveOrMoreConsecutiveZeros(digit)) 
		{
			System.out.println("[Code Issue] Variable uses too many literals: "+line+".");
		}
		else if (!isHexAddress(digit)) {
			System.out.println("[Error] Incorrect address initialization: "+line+".");
		}
		
		return new Number_Literal(digit);
	}
}
