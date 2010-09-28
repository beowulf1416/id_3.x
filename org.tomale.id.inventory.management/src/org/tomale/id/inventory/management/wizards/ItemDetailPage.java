/**
 * 
 */
package org.tomale.id.inventory.management.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

/**
 * @author ferd
 *
 */
public class ItemDetailPage extends WizardPage {

	public final static String PAGE_ID = "org.tomale.id.inventory.management.wizards.item.detail";
	
	protected ItemDetailPage() {
		super(PAGE_ID);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

	}

}
