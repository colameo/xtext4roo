lexer grammar InternalSomeDsl;
@header {
package de.saxsys.roo.xtext.example.somedsl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'Hello' ;
T12 : '!' ;
T13 : '.' ;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g" 449
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g" 451
RULE_INT : ('0'..'9')+;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g" 453
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g" 455
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g" 457
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g" 459
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl.ui/src-gen/de/saxsys/roo/xtext/example/somedsl/ui/contentassist/antlr/internal/InternalSomeDsl.g" 461
RULE_ANY_OTHER : .;


