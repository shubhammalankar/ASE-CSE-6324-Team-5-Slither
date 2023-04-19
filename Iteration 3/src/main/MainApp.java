package main;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ExprLexer;
import antlr.ExprParser;
import sourceUnit.AntlrToNumber_Literal;
import sourceUnit.AntlrToPragmaDirective;
import sourceUnit.PragmaDirective;
import sourceUnit.AntlrToCondition;
import sourceUnit.AntlrToLoopBool;
import sourceUnit.AntlrToLoop;

public class MainApp {

	public static void main(String[] args) {
		if(args.length!=1)
			System.out.println("Usage : filename");
		else {
			String filename = args[0];
			ExprParser parser = getParser(filename);
			ParseTree antlrAST= parser.sourceUnit();
			AntlrToPragmaDirective pragmavisitor = new AntlrToPragmaDirective();
			pragmavisitor.visit(antlrAST);
			
			//PragmaDirective prag = pragmavisitor.visit(antlrAST);
			AntlrToNumber_Literal number_Literal= new AntlrToNumber_Literal("Warning");
			number_Literal.visit(antlrAST);
			AntlrToCondition condition = new AntlrToCondition("Warning");
			condition.visit(antlrAST);
			AntlrToLoop loop = new AntlrToLoop("Warning");
			loop.visit(antlrAST);
			AntlrToLoopBool bool_condition=new AntlrToLoopBool("Warning");
			bool_condition.visit(antlrAST);
		}
	}
	
	private static ExprParser getParser(String fileName) {
		ExprParser parser = null;
		
		try {
			CharStream input =  CharStreams.fromFileName(fileName);
			ExprLexer lexer = new ExprLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new ExprParser(tokens);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parser;
	}

}
