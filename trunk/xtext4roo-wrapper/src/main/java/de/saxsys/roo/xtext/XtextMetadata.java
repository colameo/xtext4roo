package de.saxsys.roo.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.springframework.roo.metadata.AbstractMetadataItem;

public class XtextMetadata extends AbstractMetadataItem {

	private Resource resource;

	public XtextMetadata(String id, Resource resource) {
		super(id);
		this.resource = resource;
	}

	public Resource getResource() {
		return resource;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return resource.getContents().toString();
	}
}
