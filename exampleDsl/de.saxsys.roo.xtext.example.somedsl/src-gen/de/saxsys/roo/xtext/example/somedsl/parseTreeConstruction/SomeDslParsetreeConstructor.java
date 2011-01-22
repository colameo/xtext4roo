/*
* generated by Xtext
*/
package de.saxsys.roo.xtext.example.somedsl.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import de.saxsys.roo.xtext.example.somedsl.services.SomeDslGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class SomeDslParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private SomeDslGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Model_GreetingsAssignment(this, this, 0, inst);
			case 1: return new Greeting_Group(this, this, 1, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Model ****************
 *
 * Model:
 * 	greetings+=Greeting*;
 *
 **/

// greetings+=Greeting*
protected class Model_GreetingsAssignment extends AssignmentToken  {
	
	public Model_GreetingsAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getModelAccess().getGreetingsAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Greeting_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("greetings",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("greetings");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getGreetingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Model_GreetingsAssignment(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}

/************ end Rule Model ****************/


/************ begin Rule Greeting ****************
 *
 * Greeting:
 * 	"Hello" name=ID "!" entity=[types::JvmType|FQN]?;
 *
 **/

// "Hello" name=ID "!" entity=[types::JvmType|FQN]?
protected class Greeting_Group extends GroupToken {
	
	public Greeting_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getGreetingAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Greeting_EntityAssignment_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Greeting_ExclamationMarkKeyword_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getGreetingRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "Hello"
protected class Greeting_HelloKeyword_0 extends KeywordToken  {
	
	public Greeting_HelloKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getGreetingAccess().getHelloKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// name=ID
protected class Greeting_NameAssignment_1 extends AssignmentToken  {
	
	public Greeting_NameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getGreetingAccess().getNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Greeting_HelloKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// "!"
protected class Greeting_ExclamationMarkKeyword_2 extends KeywordToken  {
	
	public Greeting_ExclamationMarkKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getGreetingAccess().getExclamationMarkKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Greeting_NameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// entity=[types::JvmType|FQN]?
protected class Greeting_EntityAssignment_3 extends AssignmentToken  {
	
	public Greeting_EntityAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getGreetingAccess().getEntityAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Greeting_ExclamationMarkKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("entity",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("entity");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getGreetingAccess().getEntityJvmTypeCrossReference_3_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getGreetingAccess().getEntityJvmTypeCrossReference_3_0(); 
				return obj;
			}
		}
		return null;
	}

}


/************ end Rule Greeting ****************/


}
