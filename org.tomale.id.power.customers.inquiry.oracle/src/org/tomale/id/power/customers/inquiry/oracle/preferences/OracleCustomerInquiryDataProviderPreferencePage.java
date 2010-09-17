/**
 * 
 */
package org.tomale.id.power.customers.inquiry.oracle.preferences;

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
import org.tomale.id.power.customers.inquiry.oracle.Activator;

/**
 * @author ftomale
 *
 */
public class OracleCustomerInquiryDataProviderPreferencePage extends
		PreferencePage implements IWorkbenchPreferencePage {

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

	private void initDbConnections(){
		ArrayList<DatabaseConnectionConfiguration> connections = DatabaseConnectionManager.getInstance().getConnections();
		for(DatabaseConnectionConfiguration cn : connections){
			_cns.add(cn.getName());
		}
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String selectedConnection = store.getString(PreferenceConstants.DB_CONNECTION_NAME);

		if(!selectedConnection.isEmpty()){
			_cns.setText(selectedConnection);
		}
	}
	
	private void savePreferences(){
		
	}

}
