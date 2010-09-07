/**
 * 
 */
package org.tomale.id.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author ftomale
 *
 */
public class CompanyInfoPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		comp.setLayout(layout);
		
		Label l;
		
		l = new Label(comp,SWT.NO_FOCUS);
		l.setText("Company Name");
		l.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		
		Text txtCompanyName = new Text(comp,SWT.BORDER);
		txtCompanyName.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		return comp;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

}
