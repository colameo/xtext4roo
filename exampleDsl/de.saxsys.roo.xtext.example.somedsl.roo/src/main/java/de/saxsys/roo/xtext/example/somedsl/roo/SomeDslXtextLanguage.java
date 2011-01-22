package de.saxsys.roo.xtext.example.somedsl.roo;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.google.inject.Module;

import de.saxsys.roo.xtext.XtextLanguage;
import de.saxsys.roo.xtext.example.somedsl.SomeDslRuntimeModule;

@Component(immediate = true)
@Service
public class SomeDslXtextLanguage implements XtextLanguage {
	

	public static final String SOMEDSL = "somedsl";

	public Module getRuntimeModule() {
		return new SomeDslRuntimeModule();
	}

	public String getExtension() {
		return SOMEDSL;
	}

}
