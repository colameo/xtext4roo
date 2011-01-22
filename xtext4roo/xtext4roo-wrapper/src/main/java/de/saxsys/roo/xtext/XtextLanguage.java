package de.saxsys.roo.xtext;

import com.google.inject.Module;

/**
 * this interface must be implemented for an XText language to be recognized
 * by the XtextMetadata provider.  The implementation must be registered
 * as OSGi service.
 * 
 * @author stefan.ocke
 *
 */
public interface XtextLanguage {
	/**
	 * 
	 * @return the Guice runtime module for the language, f.e. MyDslRuntimeModule.
	 */
	Module getRuntimeModule();
	
	/**
	 * 
	 * @return the filename extension for the language, f.e. "mydsl"
	 */
	String getExtension();
	
	
}
