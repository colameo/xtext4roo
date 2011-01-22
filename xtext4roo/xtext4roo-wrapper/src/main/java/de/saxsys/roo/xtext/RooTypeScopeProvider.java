package de.saxsys.roo.xtext;

import org.eclipse.xtext.common.types.access.ITypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;

import com.google.inject.Inject;

public class RooTypeScopeProvider extends AbstractTypeScopeProvider {
	
	@Inject
	private RooTypeProviderFactory typeProviderFactory;

	@Override
	public RooTypeScope createTypeScope(ITypeProvider typeProvider) {
		return new RooTypeScope((RooTypeProvider) typeProvider);
	}

	public void setTypeProviderFactory(RooTypeProviderFactory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}

	@Override
	public RooTypeProviderFactory getTypeProviderFactory() {
		return typeProviderFactory;
	}
	
}