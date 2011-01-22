package de.saxsys.roo.xtext;

import org.springframework.roo.metadata.MetadataProvider;

public interface XtextMetadataProvider extends MetadataProvider {
	
	/**
	 * Tries to find an Xtext DSL file with a certain qualified name and extension
	 * and returns the according Metadata ID.
	 * For example, given a qualified name "pages.Homepage" and an extension "webdsl",
	 * this method would search all source paths of the application for a file
	 * "./pages/Homepage.webdsl"
	 * 
	 * @param qualifiedName
	 * @param dslExtension
	 * @return the Metadata ID or null
	 */
	public String findIdentifier(String qualifiedName, String dslExtension);
}
