/*
* generated by Xtext
*/
package de.saxsys.roo.xtext.example.somedsl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.saxsys.roo.xtext.example.somedsl.services.SomeDslGrammarAccess;

public class SomeDslParser extends AbstractContentAssistParser {
	
	@Inject
	private SomeDslGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.saxsys.roo.xtext.example.somedsl.ui.contentassist.antlr.internal.InternalSomeDslParser createParser() {
		de.saxsys.roo.xtext.example.somedsl.ui.contentassist.antlr.internal.InternalSomeDslParser result = new de.saxsys.roo.xtext.example.somedsl.ui.contentassist.antlr.internal.InternalSomeDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getGreetingAccess().getGroup(), "rule__Greeting__Group__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getModelAccess().getGreetingsAssignment(), "rule__Model__GreetingsAssignment");
					put(grammarAccess.getGreetingAccess().getNameAssignment_1(), "rule__Greeting__NameAssignment_1");
					put(grammarAccess.getGreetingAccess().getEntityAssignment_3(), "rule__Greeting__EntityAssignment_3");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.saxsys.roo.xtext.example.somedsl.ui.contentassist.antlr.internal.InternalSomeDslParser typedParser = (de.saxsys.roo.xtext.example.somedsl.ui.contentassist.antlr.internal.InternalSomeDslParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public SomeDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SomeDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
