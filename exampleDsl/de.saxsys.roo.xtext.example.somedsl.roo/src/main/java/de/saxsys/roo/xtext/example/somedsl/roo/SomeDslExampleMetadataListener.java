package de.saxsys.roo.xtext.example.somedsl.roo;

import java.util.logging.Logger;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.eclipse.emf.common.util.EList;
import org.osgi.service.component.ComponentContext;
import org.springframework.roo.metadata.MetadataDependencyRegistry;
import org.springframework.roo.metadata.MetadataIdentificationUtils;
import org.springframework.roo.metadata.MetadataItem;
import org.springframework.roo.metadata.MetadataNotificationListener;
import org.springframework.roo.metadata.MetadataProvider;
import org.springframework.roo.metadata.MetadataService;

import de.saxsys.roo.xtext.XtextMetadata;
import de.saxsys.roo.xtext.XtextMetadataIdentifier;
import de.saxsys.roo.xtext.example.somedsl.someDsl.Greeting;
import de.saxsys.roo.xtext.example.somedsl.someDsl.Model;

@Component(immediate = true)
@Service
public class SomeDslExampleMetadataListener implements
		MetadataNotificationListener, MetadataProvider {

	private static Logger logger = Logger
			.getLogger(SomeDslExampleMetadataListener.class.getName());

	@Reference
	protected MetadataService metadataService;

	@Reference
	private MetadataDependencyRegistry metadataDependencyRegistry;

	protected void activate(ComponentContext context) {
		metadataDependencyRegistry.registerDependency(
				XtextMetadataIdentifier.PROVIDES_TYPE,
				SomeDslExampleMetadata.PROVIDES_TYPE);
	}

	public void notify(String upstreamDependency, String downstreamDependency) {
		if (XtextMetadataIdentifier.PROVIDES_TYPE_STRING
				.equals(MetadataIdentificationUtils
						.getMetadataClass(upstreamDependency))) {
			String extension = XtextMetadataIdentifier
					.getExtension(upstreamDependency);
			if (SomeDslXtextLanguage.SOMEDSL.equals(extension)) {

				logger.warning("Notify: " + upstreamDependency + " "
						+ downstreamDependency);

				// Only for testing. Real code should go into
				// get(metadataIdentificationString) method
				XtextMetadata xm = (XtextMetadata) metadataService
						.get(upstreamDependency);
				Model m = (Model) xm.getResource().getContents().get(0);
				EList<Greeting> greetings = m.getGreetings();
				for (Greeting greeting : greetings) {
					logger.warning(greeting.getName()+" "+greeting.getEntity().getCanonicalName());
				}
			}
		}

	}

	public String getProvidesType() {
		// TODO Auto-generated method stub
		return SomeDslExampleMetadata.PROVIDES_TYPE;
	}

	public MetadataItem get(String metadataIdentificationString) {
		// TODO Auto-generated method stub
		return null;
	}

}
