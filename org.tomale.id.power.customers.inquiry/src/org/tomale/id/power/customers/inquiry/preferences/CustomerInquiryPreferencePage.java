/**
 * 
 */
package org.tomale.id.power.customers.inquiry.preferences;

import java.util.ArrayList;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.tomale.id.power.customers.inquiry.Activator;
import org.tomale.id.power.customers.inquiry.DataProviderConfigurationElement;

/**
 * @author ftomale
 *
 */
public class CustomerInquiryPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	Combo _providers;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite comp = new Composite(parent,SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		comp.setLayout(layout);
		
		Label l;
		
		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("Customer Inquiry Data Provider");
		l.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		
		_providers = new Combo(comp,SWT.DROP_DOWN | SWT.READ_ONLY);
		_providers.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		initProviders();
		
		return comp;
	}
	
	private void initProviders(){
		ArrayList<DataProviderConfigurationElement> providers = Activator.getDataProviders();
		for(DataProviderConfigurationElement element : providers){
			_providers.add(element.getName());
			_providers.setData(element.getName(),element);
		}
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String selectedProvider = store.getString(PreferenceConstants.DATA_PROVIDER);
		if(!selectedProvider.isEmpty()){
			
			for(DataProviderConfigurationElement element : providers){
				if(selectedProvider.equals(element.getId())){
					_providers.setText(element.getName());
					break;
				}
			}
			
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean performOk() {
		
		savePreferences();
		
		return super.performOk();
	}

	private void savePreferences(){
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if(!_providers.getText().isEmpty()){
			store.setValue(PreferenceConstants.DATA_PROVIDER, ((DataProviderConfigurationElement) _providers.getData(_providers.getText())).getId());
		}
	}

}
