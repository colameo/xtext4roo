/*
* generated by Xtext
*/
package de.saxsys.roo.xtext.example.somedsl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class SomeDslAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.tokens");
	}
}
