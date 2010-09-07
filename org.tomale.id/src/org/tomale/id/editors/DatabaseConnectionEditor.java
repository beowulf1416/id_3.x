/**
 * 
 */
package org.tomale.id.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.tomale.id.Activator;

/**
 * @author ftomale
 *
 */
public class DatabaseConnectionEditor extends FormEditor {
	
	public static final String EDITOR_ID = "org.tomale.id.editors.databaseconnection";

	DatabaseConnectionEditorPage _page;
	
	@Override
	protected void addPages() {
		_page = new DatabaseConnectionEditorPage(this);
		try {
			addPage(_page);
		}catch(PartInitException e){
			Activator.getDefault().getLog().log(new Status(Status.ERROR, 
					Activator.PLUGIN_ID, "Unable to add DatabaseConnectionEditorPage",e));
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
