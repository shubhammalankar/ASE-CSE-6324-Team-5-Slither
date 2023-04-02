package sourceUnit;

import org.antlr.v4.runtime.Token;
import antlr.ExprBaseVisitor;
import antlr.ExprParser.VersionCheckContext;

public class AntlrToAttribute extends ExprBaseVisitor<Attributes> {
	
	public String VersionError;
	
	public AntlrToAttribute(String VersionError) {
		this.VersionError = VersionError;
	}
	
	

	@Override
	public Attributes visitVersionCheck(VersionCheckContext ctx) {
		String VersionLiteral=""; 
		//getting the first token.		
		Token sttoken = ctx.getStart();
		int line = sttoken.getLine();
		if(ctx.getChildCount()>1) {
			String VersionOperator = ctx.getChild(0).getText();
			if(!VersionOperator.equalsIgnoreCase("=")) 
			{
				System.out.println("[Code Issue] Compiler Version ambiguous or not correct at line:"+line+".");
			}
			
		}
		else
			VersionLiteral = ctx.getChild(0).getText();
		
		return new VersionConstraintCheck(VersionLiteral);
	}

	

	

	
	
	
	

}
