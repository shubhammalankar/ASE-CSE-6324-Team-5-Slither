package sourceUnit;

import java.util.*;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.PragmaDirectiveContext;

public class AntlrToPragmaDirective extends ExprBaseVisitor<PragmaDirective> {
	
	public String VersionError;

	@Override
	public PragmaDirective visitPragmaDirective(PragmaDirectiveContext ctx) {
		PragmaDirective pragD = new PragmaDirective();
		VersionError = "";
		AntlrToAttribute attributevisitor = new AntlrToAttribute(VersionError);
		pragD.addAttribute(attributevisitor.visit(ctx.getChild(2).getChild(0).getChild(0)));
		VersionError = attributevisitor.VersionError;
		return pragD;
	}

}
