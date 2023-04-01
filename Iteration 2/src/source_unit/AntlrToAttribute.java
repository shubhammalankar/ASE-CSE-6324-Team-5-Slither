package source_unit;

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
		//getting the first character of.		
		Token sttoken = ctx.getStart();
		int line = sttoken.getLine();
		//int col = sttoken.getCharPositionInLine() +1;
		//Token idToken = ctx.I
		//String versionOp = ctx.getChild(0).getChild(0).getText();
		// TODO Auto-generated method stub
		//String VersionLiteral = ctx.getChild(0).getText();
		if(ctx.getChildCount()>1) {
			String VersionOperator = ctx.getChild(0).getText();
			if(!VersionOperator.equalsIgnoreCase("=")) 
			{
				System.out.println("[Code Issue] Compiler Version ambiguous or not correct at line:"+line+".");
				//VersionLiteral = ctx.getChild(1).getText();
			}
			
		}
		else
			VersionLiteral = ctx.getChild(0).getText();
		
		//System.out.println(VersionError);
		return new VersionConstraintCheck(VersionLiteral);
	}

	

	

	
	
	
	

}
