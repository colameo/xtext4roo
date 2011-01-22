package de.saxsys.roo.xtext.example.somedsl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import de.saxsys.roo.xtext.example.somedsl.services.SomeDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSomeDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Hello'", "'!'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalSomeDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g"; }


     
     	private SomeDslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(SomeDslGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleModel
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:62:1: ( ruleModel EOF )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:63:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:70:1: ruleModel : ( ( rule__Model__GreetingsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:74:2: ( ( ( rule__Model__GreetingsAssignment )* ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:75:1: ( ( rule__Model__GreetingsAssignment )* )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:75:1: ( ( rule__Model__GreetingsAssignment )* )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:76:1: ( rule__Model__GreetingsAssignment )*
            {
             before(grammarAccess.getModelAccess().getGreetingsAssignment()); 
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:77:1: ( rule__Model__GreetingsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:77:2: rule__Model__GreetingsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Model__GreetingsAssignment_in_ruleModel94);
            	    rule__Model__GreetingsAssignment();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGreetingsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleGreeting
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:89:1: entryRuleGreeting : ruleGreeting EOF ;
    public final void entryRuleGreeting() throws RecognitionException {
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:90:1: ( ruleGreeting EOF )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:91:1: ruleGreeting EOF
            {
             before(grammarAccess.getGreetingRule()); 
            pushFollow(FOLLOW_ruleGreeting_in_entryRuleGreeting122);
            ruleGreeting();
            _fsp--;

             after(grammarAccess.getGreetingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGreeting129); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleGreeting


    // $ANTLR start ruleGreeting
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:98:1: ruleGreeting : ( ( rule__Greeting__Group__0 ) ) ;
    public final void ruleGreeting() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:102:2: ( ( ( rule__Greeting__Group__0 ) ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:103:1: ( ( rule__Greeting__Group__0 ) )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:103:1: ( ( rule__Greeting__Group__0 ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:104:1: ( rule__Greeting__Group__0 )
            {
             before(grammarAccess.getGreetingAccess().getGroup()); 
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:105:1: ( rule__Greeting__Group__0 )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:105:2: rule__Greeting__Group__0
            {
            pushFollow(FOLLOW_rule__Greeting__Group__0_in_ruleGreeting155);
            rule__Greeting__Group__0();
            _fsp--;


            }

             after(grammarAccess.getGreetingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleGreeting


    // $ANTLR start entryRuleFQN
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:117:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:118:1: ( ruleFQN EOF )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:119:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN182);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN189); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:126:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:130:2: ( ( ( rule__FQN__Group__0 ) ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:131:1: ( ( rule__FQN__Group__0 ) )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:131:1: ( ( rule__FQN__Group__0 ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:132:1: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:133:1: ( rule__FQN__Group__0 )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:133:2: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_rule__FQN__Group__0_in_ruleFQN215);
            rule__FQN__Group__0();
            _fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFQN


    // $ANTLR start rule__Greeting__Group__0
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:147:1: rule__Greeting__Group__0 : rule__Greeting__Group__0__Impl rule__Greeting__Group__1 ;
    public final void rule__Greeting__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:151:1: ( rule__Greeting__Group__0__Impl rule__Greeting__Group__1 )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:152:2: rule__Greeting__Group__0__Impl rule__Greeting__Group__1
            {
            pushFollow(FOLLOW_rule__Greeting__Group__0__Impl_in_rule__Greeting__Group__0249);
            rule__Greeting__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Greeting__Group__1_in_rule__Greeting__Group__0252);
            rule__Greeting__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__Group__0


    // $ANTLR start rule__Greeting__Group__0__Impl
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:159:1: rule__Greeting__Group__0__Impl : ( 'Hello' ) ;
    public final void rule__Greeting__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:163:1: ( ( 'Hello' ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:164:1: ( 'Hello' )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:164:1: ( 'Hello' )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:165:1: 'Hello'
            {
             before(grammarAccess.getGreetingAccess().getHelloKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Greeting__Group__0__Impl280); 
             after(grammarAccess.getGreetingAccess().getHelloKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__Group__0__Impl


    // $ANTLR start rule__Greeting__Group__1
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:178:1: rule__Greeting__Group__1 : rule__Greeting__Group__1__Impl rule__Greeting__Group__2 ;
    public final void rule__Greeting__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:182:1: ( rule__Greeting__Group__1__Impl rule__Greeting__Group__2 )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:183:2: rule__Greeting__Group__1__Impl rule__Greeting__Group__2
            {
            pushFollow(FOLLOW_rule__Greeting__Group__1__Impl_in_rule__Greeting__Group__1311);
            rule__Greeting__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Greeting__Group__2_in_rule__Greeting__Group__1314);
            rule__Greeting__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__Group__1


    // $ANTLR start rule__Greeting__Group__1__Impl
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:190:1: rule__Greeting__Group__1__Impl : ( ( rule__Greeting__NameAssignment_1 ) ) ;
    public final void rule__Greeting__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:194:1: ( ( ( rule__Greeting__NameAssignment_1 ) ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:195:1: ( ( rule__Greeting__NameAssignment_1 ) )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:195:1: ( ( rule__Greeting__NameAssignment_1 ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:196:1: ( rule__Greeting__NameAssignment_1 )
            {
             before(grammarAccess.getGreetingAccess().getNameAssignment_1()); 
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:197:1: ( rule__Greeting__NameAssignment_1 )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:197:2: rule__Greeting__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Greeting__NameAssignment_1_in_rule__Greeting__Group__1__Impl341);
            rule__Greeting__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGreetingAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__Group__1__Impl


    // $ANTLR start rule__Greeting__Group__2
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:207:1: rule__Greeting__Group__2 : rule__Greeting__Group__2__Impl rule__Greeting__Group__3 ;
    public final void rule__Greeting__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:211:1: ( rule__Greeting__Group__2__Impl rule__Greeting__Group__3 )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:212:2: rule__Greeting__Group__2__Impl rule__Greeting__Group__3
            {
            pushFollow(FOLLOW_rule__Greeting__Group__2__Impl_in_rule__Greeting__Group__2371);
            rule__Greeting__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Greeting__Group__3_in_rule__Greeting__Group__2374);
            rule__Greeting__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__Group__2


    // $ANTLR start rule__Greeting__Group__2__Impl
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:219:1: rule__Greeting__Group__2__Impl : ( '!' ) ;
    public final void rule__Greeting__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:223:1: ( ( '!' ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:224:1: ( '!' )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:224:1: ( '!' )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:225:1: '!'
            {
             before(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__Greeting__Group__2__Impl402); 
             after(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__Group__2__Impl


    // $ANTLR start rule__Greeting__Group__3
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:238:1: rule__Greeting__Group__3 : rule__Greeting__Group__3__Impl ;
    public final void rule__Greeting__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:242:1: ( rule__Greeting__Group__3__Impl )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:243:2: rule__Greeting__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Greeting__Group__3__Impl_in_rule__Greeting__Group__3433);
            rule__Greeting__Group__3__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__Group__3


    // $ANTLR start rule__Greeting__Group__3__Impl
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:249:1: rule__Greeting__Group__3__Impl : ( ( rule__Greeting__EntityAssignment_3 )? ) ;
    public final void rule__Greeting__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:253:1: ( ( ( rule__Greeting__EntityAssignment_3 )? ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:254:1: ( ( rule__Greeting__EntityAssignment_3 )? )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:254:1: ( ( rule__Greeting__EntityAssignment_3 )? )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:255:1: ( rule__Greeting__EntityAssignment_3 )?
            {
             before(grammarAccess.getGreetingAccess().getEntityAssignment_3()); 
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:256:1: ( rule__Greeting__EntityAssignment_3 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:256:2: rule__Greeting__EntityAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Greeting__EntityAssignment_3_in_rule__Greeting__Group__3__Impl460);
                    rule__Greeting__EntityAssignment_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGreetingAccess().getEntityAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__Group__3__Impl


    // $ANTLR start rule__FQN__Group__0
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:274:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:278:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:279:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0499);
            rule__FQN__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0502);
            rule__FQN__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group__0


    // $ANTLR start rule__FQN__Group__0__Impl
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:286:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:290:1: ( ( RULE_ID ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:291:1: ( RULE_ID )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:291:1: ( RULE_ID )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:292:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl529); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group__0__Impl


    // $ANTLR start rule__FQN__Group__1
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:303:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:307:1: ( rule__FQN__Group__1__Impl )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:308:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1558);
            rule__FQN__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group__1


    // $ANTLR start rule__FQN__Group__1__Impl
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:314:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:318:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:319:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:319:1: ( ( rule__FQN__Group_1__0 )* )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:320:1: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:321:1: ( rule__FQN__Group_1__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:321:2: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl585);
            	    rule__FQN__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group__1__Impl


    // $ANTLR start rule__FQN__Group_1__0
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:335:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:339:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:340:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0620);
            rule__FQN__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0623);
            rule__FQN__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group_1__0


    // $ANTLR start rule__FQN__Group_1__0__Impl
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:347:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:351:1: ( ( '.' ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:352:1: ( '.' )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:352:1: ( '.' )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:353:1: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,13,FOLLOW_13_in_rule__FQN__Group_1__0__Impl651); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group_1__0__Impl


    // $ANTLR start rule__FQN__Group_1__1
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:366:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:370:1: ( rule__FQN__Group_1__1__Impl )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:371:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1682);
            rule__FQN__Group_1__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group_1__1


    // $ANTLR start rule__FQN__Group_1__1__Impl
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:377:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:381:1: ( ( RULE_ID ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:382:1: ( RULE_ID )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:382:1: ( RULE_ID )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:383:1: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl709); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FQN__Group_1__1__Impl


    // $ANTLR start rule__Model__GreetingsAssignment
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:399:1: rule__Model__GreetingsAssignment : ( ruleGreeting ) ;
    public final void rule__Model__GreetingsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:403:1: ( ( ruleGreeting ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:404:1: ( ruleGreeting )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:404:1: ( ruleGreeting )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:405:1: ruleGreeting
            {
             before(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleGreeting_in_rule__Model__GreetingsAssignment747);
            ruleGreeting();
            _fsp--;

             after(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__GreetingsAssignment


    // $ANTLR start rule__Greeting__NameAssignment_1
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:414:1: rule__Greeting__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Greeting__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:418:1: ( ( RULE_ID ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:419:1: ( RULE_ID )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:419:1: ( RULE_ID )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:420:1: RULE_ID
            {
             before(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Greeting__NameAssignment_1778); 
             after(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__NameAssignment_1


    // $ANTLR start rule__Greeting__EntityAssignment_3
    // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:429:1: rule__Greeting__EntityAssignment_3 : ( ( ruleFQN ) ) ;
    public final void rule__Greeting__EntityAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:433:1: ( ( ( ruleFQN ) ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:434:1: ( ( ruleFQN ) )
            {
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:434:1: ( ( ruleFQN ) )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:435:1: ( ruleFQN )
            {
             before(grammarAccess.getGreetingAccess().getEntityJvmTypeCrossReference_3_0()); 
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:436:1: ( ruleFQN )
            // ../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g:437:1: ruleFQN
            {
             before(grammarAccess.getGreetingAccess().getEntityJvmTypeFQNParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleFQN_in_rule__Greeting__EntityAssignment_3813);
            ruleFQN();
            _fsp--;

             after(grammarAccess.getGreetingAccess().getEntityJvmTypeFQNParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getGreetingAccess().getEntityJvmTypeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Greeting__EntityAssignment_3


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__GreetingsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleGreeting_in_entryRuleGreeting122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGreeting129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__0_in_ruleGreeting155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0_in_ruleFQN215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__0__Impl_in_rule__Greeting__Group__0249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Greeting__Group__1_in_rule__Greeting__Group__0252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Greeting__Group__0__Impl280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__1__Impl_in_rule__Greeting__Group__1311 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Greeting__Group__2_in_rule__Greeting__Group__1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__NameAssignment_1_in_rule__Greeting__Group__1__Impl341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__2__Impl_in_rule__Greeting__Group__2371 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Greeting__Group__3_in_rule__Greeting__Group__2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Greeting__Group__2__Impl402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__Group__3__Impl_in_rule__Greeting__Group__3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Greeting__EntityAssignment_3_in_rule__Greeting__Group__3__Impl460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__0__Impl_in_rule__FQN__Group__0499 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1_in_rule__FQN__Group__0502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group__0__Impl529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group__1__Impl_in_rule__FQN__Group__1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0_in_rule__FQN__Group__1__Impl585 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__0__Impl_in_rule__FQN__Group_1__0620 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1_in_rule__FQN__Group_1__0623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__FQN__Group_1__0__Impl651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FQN__Group_1__1__Impl_in_rule__FQN__Group_1__1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FQN__Group_1__1__Impl709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_rule__Model__GreetingsAssignment747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Greeting__NameAssignment_1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_rule__Greeting__EntityAssignment_3813 = new BitSet(new long[]{0x0000000000000002L});

}