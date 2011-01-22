package de.saxsys.roo.xtext.example.somedsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SomeDslStandaloneSetup extends SomeDslStandaloneSetupGenerated{

	public static void doSetup() {
		new SomeDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

