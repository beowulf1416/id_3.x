/**
 * 
 */
package org.tomale.id.inventory.management.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * @author ferd
 *
 */
public class ItemDetailPage extends WizardPage {

	public final static String PAGE_ID = "org.tomale.id.inventory.management.wizards.item.detail";
	
	Text _name;
	
	protected ItemDetailPage() {
		super(PAGE_ID);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2,false);
		comp.setLayout(layout);
		
		
		
		setControl(comp);
	}

}
