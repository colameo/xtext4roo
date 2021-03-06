lexer grammar InternalSomeDsl;
@header {
package de.saxsys.roo.xtext.example.somedsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'Hello' ;
T12 : '!' ;
T13 : '.' ;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g" 237
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g" 239
RULE_INT : ('0'..'9')+;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g" 241
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g" 243
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g" 245
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g" 247
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.saxsys.roo.xtext.example.somedsl/src-gen/de/saxsys/roo/xtext/example/somedsl/parser/antlr/internal/InternalSomeDsl.g" 249
RULE_ANY_OTHER : .;


