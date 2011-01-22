package de.saxsys.roo.xtext;

import org.springframework.roo.metadata.MetadataIdentificationUtils;
import org.springframework.roo.project.Path;
import org.springframework.roo.support.util.Assert;

public class XtextMetadataIdentifier {

	public static final String PROVIDES_TYPE_STRING = XtextMetadata.class
			.getName();
	public static final String PROVIDES_TYPE = MetadataIdentificationUtils
			.create(PROVIDES_TYPE_STRING);

	public static String getExtension(String metadataIdentifier) {
		String instance = getInstance(metadataIdentifier);
		int index = instance.indexOf('#');
		Assert.isTrue(
				index > 0,
				"Metadata identification string "
						+ metadataIdentifier
						+ "has no extension. Second '#' is missing or directly following the first '#'.");
		return instance.substring(0, index);
	}

	public static String getQualifiedName(String metadataIdentifier) {
		String instance = getInstance(metadataIdentifier);

		int index = instance.indexOf('?');
		Assert.isTrue(
				index > -1 && index < instance.length(),
				"Metadata identification string "
						+ metadataIdentifier
						+ "has no qualified name. '?' is missing or at the end.");
		return instance.substring(index + 1);
	}

	public static Path getPath(String metadataIdentifier) {
		String instance = getInstance(metadataIdentifier);

		int index = instance.indexOf('#');
		Assert.isTrue(index > -1, "Metadata identification string "
				+ metadataIdentifier + "has no path. Second '#' is missing");
		String afterExtension = instance.substring(index + 1);
		index = afterExtension.indexOf('?');
		Assert.isTrue(
				index > 0,
				"Metadata identification string "
						+ metadataIdentifier
						+ "has no path. '?' is missing or directly following second '#'");
		return new Path(afterExtension.substring(0, index));
	}

	private static String getInstance(String metadataIdentifier) {
		String instance = MetadataIdentificationUtils
				.getMetadataInstance(metadataIdentifier);
		Assert.notNull(instance, "Metadata identification string "
				+ metadataIdentifier + " does not identify an instance");
		return instance;
	}

	public static String createIdentifier(Path path, String qualifiedName,
			String extension) {
		return MetadataIdentificationUtils.create(PROVIDES_TYPE_STRING,
				extension + "#" + ((path == null) ? "" : path.getName()) + "?"
						+ qualifiedName);
	}

}
