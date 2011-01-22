package de.saxsys.roo.xtext.example.somedsl.roo;

import org.springframework.roo.metadata.MetadataIdentificationUtils;
import org.springframework.roo.metadata.MetadataItem;


public class SomeDslExampleMetadata implements MetadataItem {

	public static String PROVIDES_TYPE_STRING = SomeDslExampleMetadata.class
			.getName();
	public static String PROVIDES_TYPE = MetadataIdentificationUtils
			.create(PROVIDES_TYPE_STRING);

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
