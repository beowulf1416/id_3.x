/**
 * 
 */
package org.tomale.id.inventory.management.editors;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * @author ferd
 *
 */
public class ItemDetailsPage extends FormPage {

	public static final String PAGE_ID = "org.tomale.id.inventory.management.editors.item.details";
	public static final String PAGE_TITLE = "Details";

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
		
		FillLayout layoutBody = new FillLayout();
		body.setLayout(layoutBody);
		
		Section section = tk.createSection(body, 
				Section.DESCRIPTION | Section.TITLE_BAR | Section.EXPANDED);
		section.setText("Inventory Item details");
		section.setDescription("Inventory Item details");
		
		Composite compSection = tk.createComposite(section);
		tk.paintBordersFor(compSection);
		GridLayout layoutComp = new GridLayout(2,false);
		compSection.setLayout(layoutComp);
		
		
		
		// TODO Auto-generated method stub
		super.createFormContent(managedForm);
	}
	
}
