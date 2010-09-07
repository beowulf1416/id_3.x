/**
 * 
 */
package org.tomale.id.documents.management.oracle.preferences;

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
import org.tomale.id.db.DatabaseConnectionConfiguration;
import org.tomale.id.db.DatabaseConnectionManager;
import org.tomale.id.documents.management.oracle.Activator;

/**
 * @author ftomale
 *
 */
public class OracleDocumentStorePreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	String _selectedConnection = "";
	Combo _cns;
	
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
		
		l = new Label(comp,SWT.NO_FOCUS);
		l.setText("Database Connection Providers");
		l.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));

		_cns = new Combo(comp,SWT.DROP_DOWN | SWT.READ_ONLY);
		_cns.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		initDbConnections();
		
		return comp;
	}
	
	private void initDbConnections(){
		ArrayList<DatabaseConnectionConfiguration> connections = DatabaseConnectionManager.getInstance().getConnections();
		for(DatabaseConnectionConfiguration cn : connections){
			_cns.add(cn.getName());
		}
		if(!_selectedConnection.isEmpty()){
			_cns.setText(_selectedConnection);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		_selectedConnection = store.getString(PreferenceConstants.DB_CONNECTION_NAME);
	}

	@Override
	protected void performApply() {
		
		savePreferences();
		
		super.performApply();
	}
	
	private void savePreferences(){
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if(!_cns.getText().isEmpty()){
			store.setValue(PreferenceConstants.DB_CONNECTION_NAME, _cns.getText());
		}
	}

}
