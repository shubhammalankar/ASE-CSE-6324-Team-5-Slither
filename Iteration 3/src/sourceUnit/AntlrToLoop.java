package sourceUnit;
import org.antlr.v4.runtime.Token;
import antlr.ExprBaseVisitor;
import antlr.ExprParser.ForStatementContext;
import antlr.ExprParser.WhileStatementContext;
public class AntlrToLoop extends ExprBaseVisitor<Contract_Parts>{
	public String DOS_Warning;

	public AntlrToLoop(String DOS_Warning) {
		this.DOS_Warning = DOS_Warning;
	}
	
	@Override
	public Contract_Parts visitWhileStatement(WhileStatementContext ctx) {
		Token sttoken = ctx.getStart();
		int line = sttoken.getLine();
		//Get the part of code in smart contract which contains possible vulnerable code.
		String curr =  ctx.getChild(2).getText();
		for(int i = 0; i < curr.length(); ) {
			//Find period/ dot character to check function call and save its index.
			int dotIndex = curr.indexOf('.', i);
		    if (dotIndex == -1) {
		        break;
		    }
		    int parenIndex = curr.indexOf('(', dotIndex);
		    if (parenIndex != -1) {
		        System.out.println("[Security issue] at line " + line + ": Possibility of a DOS "
		        		+ "attack due to an external call inside 'while' loop. Please consider setting gas limit.");
		    }
		    i = dotIndex + 1;
		}
		
		return new Event_Definition("");
	}
	
	@Override
	public Contract_Parts visitForStatement(ForStatementContext ctx) {
		Token sttoken = ctx.getStart();
		int line = sttoken.getLine();
		//Get the part of code in smart contract which contains possible vulnerable code.
		String curr =  ctx.getChild(3).getText();
		for(int i = 0; i < curr.length(); ) {
			//Find period/ dot character to check function call and save its index.
		    int dotIndex = curr.indexOf('.', i);
		    if (dotIndex == -1) {
		        break;
		    }
		  //Find opening bracket character to check function call
		    int parenIndex = curr.indexOf('(', dotIndex);
		    if (parenIndex != -1) {
		        System.out.println("[Security issue] at line " + line + ": Possibility of a DOS "
		        		+ "attack due to an external call inside 'for' loop. Please consider setting gas limit.");
		    }
		    i = dotIndex + 1;
		}
		
		return new Event_Definition("");
	}

}
