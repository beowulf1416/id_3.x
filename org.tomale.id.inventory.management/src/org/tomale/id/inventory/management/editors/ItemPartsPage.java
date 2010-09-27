package org.tomale.id.inventory.management.editors;

import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

public class ItemPartsPage extends FormPage {

	public static final String PAGE_ID = "org.tomale.id.inventory.management.editors.item.parts";
	public static final String PAGE_TITLE = "Parts";

	public ItemPartsPage(FormEditor editor){
		super(editor,PAGE_ID,PAGE_TITLE);
	}
}
