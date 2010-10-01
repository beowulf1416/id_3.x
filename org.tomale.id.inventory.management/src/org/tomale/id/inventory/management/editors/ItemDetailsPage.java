/**
 * 
 */
package org.tomale.id.inventory.management.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

/**
 * @author ferd
 *
 */
public class ItemDetailsPage extends FormPage {

	public static final String PAGE_ID = "org.tomale.id.inventory.management.editors.item.details";
	public static final String PAGE_TITLE = "Details";

	Text _name;
	
	public ItemDetailsPage(FormEditor editor){
		super(editor,PAGE_ID, PAGE_TITLE);
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		
		final ScrolledForm form = managedForm.getForm();
		FormToolkit tk = managedForm.getToolkit();
		Composite body = form.getBody();
		tk.paintBordersFor(body);
		form.setText(this.getTitle());
		
		TableWrapLayout layoutBody = new TableWrapLayout();
		layoutBody.numColumns = 2;
		body.setLayout(layoutBody);
		
		createDetailSection(body, tk);
	}
	
	private void createDetailSection(Composite parent, FormToolkit tk){
		Section section = tk.createSection(parent, 
				Section.DESCRIPTION | Section.TITLE_BAR | Section.EXPANDED);
		section.setText("Inventory Item details");
		section.setDescription("Inventory Item details");
		
		Composite comp = tk.createComposite(section);
		tk.paintBordersFor(comp);
		GridLayout layoutComp = new GridLayout(2,false);
		comp.setLayout(layoutComp);

		Label l;
		
		l = tk.createLabel(comp, "Name");
		l.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		
		_name = tk.createText(comp, "");
		_name.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		section.setClient(comp);
	}
}
