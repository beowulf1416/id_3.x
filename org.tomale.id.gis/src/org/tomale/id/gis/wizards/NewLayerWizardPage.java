/**
 * 
 */
package org.tomale.id.gis.wizards;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.tomale.id.gis.Activator;

/**
 * @author ferd
 *
 */
public class NewLayerWizardPage extends WizardPage {

	public static final String PAGE_TITLE = "New Map Layer";
	public static final String PAGE_TEXT = "Map Layer";
	public static final String PAGE_DESC = "Define a new map layer";
	
	Text _name;
	Combo _src;
	
	ModifyListener _modify = new ModifyListener() {
		
		@Override
		public void modifyText(ModifyEvent e) {
			updatePageComplete();
		}
	};
	
	public NewLayerWizardPage(){
		super(PAGE_TITLE,PAGE_TEXT,Activator.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/alt_window_16.gif"));
		setDescription(PAGE_DESC);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		comp.setLayout(layout);
		
		Label l;
		ControlDecoration decoration;
		
		l = new Label(comp, SWT.NONE);
		l.setText("Name");
		l.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,false,false));
		
		_name = new Text(comp,SWT.BORDER);
		decoration = new ControlDecoration(_name, SWT.LEFT);
		decoration.setDescriptionText("Please enter the name of this layer");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
		_name.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_name.addModifyListener(_modify);
	}

	@Override
	public boolean isPageComplete() {
		return !_name.getText().isEmpty();
	}
	
	private void updatePageComplete(){
		setPageComplete(isPageComplete());
	}

	public String getName(){
		return _name.getText();
	}
	
}
