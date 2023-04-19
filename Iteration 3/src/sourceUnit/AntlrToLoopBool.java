package sourceUnit;
import org.antlr.v4.runtime.Token;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.ForStatementContext;
import antlr.ExprParser.WhileStatementContext;
import java.util.*;
import java.text.*;

public class AntlrToLoopBool extends ExprBaseVisitor<Contract_Parts> {
	public String Bool_Warning;
	
	public AntlrToLoopBool(String Bool_Warning) {
			this.Bool_Warning=Bool_Warning;
	}
	
	//Function to find all the words inside given string. 
	public static List<String> getWords(String text) {
	    List<String> words = new ArrayList<String>();
	    //Get an instance of BreakIterator for breaking words
	    BreakIterator breakIterator = BreakIterator.getWordInstance();
	    //Set the text to be analyzed
	    breakIterator.setText(text);
	    //Set the initial index to the start of the text
	    int lastIndex = breakIterator.first();
	    while (BreakIterator.DONE != lastIndex) {
	    	//Store the index of the first character of the word
	        int firstIndex = lastIndex;
	        //Get the index of the next word
	        lastIndex = breakIterator.next();
	        if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
	            words.add(text.substring(firstIndex, lastIndex));
	        }
	    }

	    return words;
	}
	
	@Override
	public Contract_Parts visitWhileStatement(WhileStatementContext ctx) {
		Token sttoken = ctx.getStart();
		int line = sttoken.getLine();
		//Get the part of code in smart contract which contains possible vulnerable code.
		String curr =  ctx.getChild(2).getText();
		List<String> words=getWords(curr);
		for(String word:words) {
			//If there is constant boolean inside loop condition raise warning
			if (word.equals("true") || word.equals("false")) {
				System.out.println("[Code issue] at line " + line + ": Boolean Value could result in infintie 'while' loop or unused block of code.");
			}

		}
				
		return new Event_Definition("");
	}
	
	@Override
	public Contract_Parts visitForStatement(ForStatementContext ctx) {
		Token sttoken = ctx.getStart();
		int line = sttoken.getLine();
		//Get the part of code in smart contract which contains possible vulnerable code.
		String curr =  ctx.getChild(3).getText();
		List<String> words=getWords(curr);

		for(String word:words) {
			//If there is constant boolean inside loop condition raise warning
			if (word.equals("true") || word.equals("false")) {
				System.out.println("[Code issue] at line " + line + ": Boolean Value could result in infintie 'for' loop or unused block of code.");
			}

		}
				
		return new Event_Definition("");
	}
	
}
