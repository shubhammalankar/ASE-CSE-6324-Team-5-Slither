package source_unit;

import java.util.*;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.PragmaDirectiveContext;

public class AntlrToPragmaDirective extends ExprBaseVisitor<PragmaDirective> {
	
	public String VersionError; //Accessed by main app prog.

	@Override
	public PragmaDirective visitPragmaDirective(PragmaDirectiveContext ctx) {
		PragmaDirective pragD = new PragmaDirective();
		VersionError = "";
		AntlrToAttribute attributevisitor = new AntlrToAttribute(VersionError);
		pragD.addAttribute(attributevisitor.visit(ctx.getChild(2).getChild(0).getChild(0)));
		VersionError = attributevisitor.VersionError;
		//System.out.println(VersionError);
		// TODO Auto-generated method stub
		return pragD;
	}
	
	
	

}
