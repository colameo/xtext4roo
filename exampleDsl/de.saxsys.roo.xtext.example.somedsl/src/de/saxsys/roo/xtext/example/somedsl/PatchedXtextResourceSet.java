package de.saxsys.roo.xtext.example.somedsl;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import java.util.Map;

public class PatchedXtextResourceSet extends SynchronizedXtextResourceSet {
	@Override
	public URIConverter getURIConverter() {
		if (uriConverter == null) {
			uriConverter = new ExtensibleURIConverterImpl() {
				@Override
				public InputStream createInputStream(URI uri,
						Map<?, ?> options) throws IOException {

					if (ClasspathUriUtil.isClasspathUri(uri)) {
						return PatchedXtextResourceSet.class.getResourceAsStream(uri.path());
					} else {
						return super
								.createInputStream(uri, options);
					}
				}
				public InputStream createInputStream(URI uri) throws IOException {
					if (ClasspathUriUtil.isClasspathUri(uri)) {
						return PatchedXtextResourceSet.class.getResourceAsStream(uri.path());
					} else {
						return super
								.createInputStream(uri);
					}
					
				};
			};
		}
		return uriConverter;
	}
}
