/**
 * 
 */
package org.tomale.id.inventory.management.wizards;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author ferd
 *
 */
public class ItemClassDetailPage extends WizardPage {

	public static final String PAGE_ID = "org.tomale.id.inventory.management.wizards.item.class";
	
	Text _name;
	Text _description;
	
	ModifyListener _modify = new ModifyListener() {
		
		@Override
		public void modifyText(ModifyEvent e) {
			updatePageComplete();
		}
	};
	
	public ItemClassDetailPage(){
		super(PAGE_ID);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent,SWT.NONE);
		GridLayout layout = new GridLayout(2,false);
		comp.setLayout(layout);
		
		Label l;
		ControlDecoration decoration;
		
		l = new Label(comp,SWT.NONE);
		l.setText("Name");
		l.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		
		_name = new Text(comp,SWT.BORDER);
		decoration = new ControlDecoration(_name,SWT.LEFT);
		decoration.setDescriptionText("Please enter a name for this item class");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED).getImage());
		_name.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_name.addModifyListener(_modify);
		
		l = new Label(comp,SWT.NONE);
		l.setText("Description");
		l.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		
		_description = new Text(comp,SWT.BORDER);
		decoration = new ControlDecoration(_name,SWT.LEFT);
		decoration.setDescriptionText("Please enter a description for this item class");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED).getImage());
		_description.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_description.addModifyListener(_modify);
		
		setControl(comp);
	}
	
	private void updatePageComplete(){
		setPageComplete(isPageComplete());
	}

	@Override
	public boolean isPageComplete() {
		return !_name.getText().isEmpty() & !_description.getText().isEmpty();
	}

	public String getItemName(){
		return _name.getText();
	}
	
	public String getItemDescription(){
		return _description.getText();
	}
}
