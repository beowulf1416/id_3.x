/**
 * 
 */
package org.tomale.id.inventory.management.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.tomale.id.inventory.management.Activator;

/**
 * @author ftomale
 *
 */
public class ItemEditor extends FormEditor {

	public final static String EDITOR_ID = "org.tomale.id.inventory.management.editor.item";
	public final static String EDITOR_NAME = "Item Editor";
	public final static String EDITOR_TIP = "Edit inventory items";
	
	ItemDetailsPage _details;
	ItemSubstitutesPage _substitutes;
	ItemPartsPage _parts;
	ItemPurchasingPage _purchasing;
	ItemCostingPage _costing;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		_details = new ItemDetailsPage(this);
		_substitutes = new ItemSubstitutesPage(this);
		_parts = new ItemPartsPage(this);
		_purchasing = new ItemPurchasingPage(this);
		_costing = new ItemCostingPage(this);
		
		try {
			addPage(_substitutes);
			addPage(_parts);
			addPage(_purchasing);
			addPage(_costing);
		} catch(PartInitException e){
			getActiveEditor().getEditorSite().getActionBars().getStatusLineManager().setErrorMessage("Unable to create Inventory Item Editor");
			Activator.getDefault().getLog().log(new Status(Status.ERROR, 
					Activator.PLUGIN_ID, 
					"Unable to create inventory item editor",e));
		}
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
