/**
 * 
 */
package org.tomale.id.documents.management.preferences;

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
import org.tomale.id.documents.management.Activator;
import org.tomale.id.documents.management.DocumentStoreConfigurationElement;

/**
 * @author ferd
 *
 */
public class DocumentManagementPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	Combo _stores;
	
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
		l.setText("Document Store Provider");
		l.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		
		_stores = new Combo(comp,SWT.DROP_DOWN | SWT.READ_ONLY);
		_stores.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		initDocumentStoreTypes();
		
		return comp;
	}
	
	private void initDocumentStoreTypes(){
		ArrayList<DocumentStoreConfigurationElement> elements = Activator.getDocumentStoreTypes();
		for(DocumentStoreConfigurationElement element : elements){
			_stores.add(element.getName());
			_stores.setData(element.getName(), element);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if(!store.getString(PreferenceConstants.DOC_STORE_PROVIDER).isEmpty()){
			_stores.setText(store.getString(PreferenceConstants.DOC_STORE_PROVIDER));
		}
	}

	@Override
	protected void performApply() {
		
		savePreferences();
		
		super.performApply();
	}
	
	private void savePreferences(){
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if(!_stores.getText().isEmpty()){
			store.setDefault(PreferenceConstants.DOC_STORE_PROVIDER, _stores.getText());
		}
	}

	
}
