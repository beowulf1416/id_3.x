/**
 * 
 */
package org.tomale.id.inventory.management.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * @author ferd
 *
 */
public class ItemEditorInput implements IEditorInput {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		return ItemEditor.EDITOR_NAME;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	@Override
	public String getToolTipText() {
		return ItemEditor.EDITOR_TIP;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}
