package de.saxsys.roo.xtext.example.somedsl.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import de.saxsys.roo.xtext.example.somedsl.services.SomeDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSomeDslParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g"; }



     	private SomeDslGrammarAccess grammarAccess;
     	
        public InternalSomeDslParser(TokenStream input, IAstFactory factory, SomeDslGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected SomeDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:86:1: ruleModel returns [EObject current=null] : ( (lv_greetings_0_0= ruleGreeting ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_greetings_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:91:6: ( ( (lv_greetings_0_0= ruleGreeting ) )* )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:92:1: ( (lv_greetings_0_0= ruleGreeting ) )*
            {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:92:1: ( (lv_greetings_0_0= ruleGreeting ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:93:1: (lv_greetings_0_0= ruleGreeting )
            	    {
            	    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:93:1: (lv_greetings_0_0= ruleGreeting )
            	    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:94:3: lv_greetings_0_0= ruleGreeting
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getGreetingsGreetingParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGreeting_in_ruleModel130);
            	    lv_greetings_0_0=ruleGreeting();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"greetings",
            	    	        		lv_greetings_0_0, 
            	    	        		"Greeting", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleGreeting
    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:124:1: entryRuleGreeting returns [EObject current=null] : iv_ruleGreeting= ruleGreeting EOF ;
    public final EObject entryRuleGreeting() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreeting = null;


        try {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:125:2: (iv_ruleGreeting= ruleGreeting EOF )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:126:2: iv_ruleGreeting= ruleGreeting EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGreetingRule(), currentNode); 
            pushFollow(FOLLOW_ruleGreeting_in_entryRuleGreeting166);
            iv_ruleGreeting=ruleGreeting();
            _fsp--;

             current =iv_ruleGreeting; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGreeting176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGreeting


    // $ANTLR start ruleGreeting
    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:133:1: ruleGreeting returns [EObject current=null] : ( 'Hello' ( (lv_name_1_0= RULE_ID ) ) '!' ( ( ruleFQN ) )? ) ;
    public final EObject ruleGreeting() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:138:6: ( ( 'Hello' ( (lv_name_1_0= RULE_ID ) ) '!' ( ( ruleFQN ) )? ) )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:139:1: ( 'Hello' ( (lv_name_1_0= RULE_ID ) ) '!' ( ( ruleFQN ) )? )
            {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:139:1: ( 'Hello' ( (lv_name_1_0= RULE_ID ) ) '!' ( ( ruleFQN ) )? )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:139:3: 'Hello' ( (lv_name_1_0= RULE_ID ) ) '!' ( ( ruleFQN ) )?
            {
            match(input,11,FOLLOW_11_in_ruleGreeting211); 

                    createLeafNode(grammarAccess.getGreetingAccess().getHelloKeyword_0(), null); 
                
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:143:1: ( (lv_name_1_0= RULE_ID ) )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:144:1: (lv_name_1_0= RULE_ID )
            {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:144:1: (lv_name_1_0= RULE_ID )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:145:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGreeting228); 

            			createLeafNode(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGreetingRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleGreeting243); 

                    createLeafNode(grammarAccess.getGreetingAccess().getExclamationMarkKeyword_2(), null); 
                
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:171:1: ( ( ruleFQN ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:172:1: ( ruleFQN )
                    {
                    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:172:1: ( ruleFQN )
                    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:173:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getGreetingRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGreetingAccess().getEntityJvmTypeCrossReference_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleGreeting266);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGreeting


    // $ANTLR start entryRuleFQN
    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:195:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:196:2: (iv_ruleFQN= ruleFQN EOF )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:197:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN304);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN315); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:204:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:209:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:210:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:210:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:210:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN355); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:217:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g:218:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,13,FOLLOW_13_in_ruleFQN374); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN389); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFQN


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreeting_in_ruleModel130 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleGreeting_in_entryRuleGreeting166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGreeting176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGreeting211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGreeting228 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleGreeting243 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleGreeting266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN355 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleFQN374 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN389 = new BitSet(new long[]{0x0000000000002002L});

}