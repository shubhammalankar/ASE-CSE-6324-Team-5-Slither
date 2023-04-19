package sourceUnit;

import java.util.*;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.PragmaDirectiveContext;

public class AntlrToPragmaDirective extends ExprBaseVisitor<PragmaDirective> {
	
	public String VersionError;

	@Override
	public PragmaDirective visitPragmaDirective(PragmaDirectiveContext ctx) {
		//Create object for PragmaDirective to invoke pragD() to append version literals.
		PragmaDirective pragD = new PragmaDirective();
		VersionError = "";
		//Create object for AntlrToAttribute to find version errors. 
		AntlrToAttribute attributevisitor = new AntlrToAttribute(VersionError);
		//Append all version literals in arrayList.
		pragD.addAttribute(attributevisitor.visit(ctx.getChild(2).getChild(0).getChild(0)));
		VersionError = attributevisitor.VersionError;
		return pragD;
	}

}
