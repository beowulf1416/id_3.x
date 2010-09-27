/**
 * 
 */
package org.tomale.id.inventory.management.editors;

import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

/**
 * @author ftomale
 *
 */
public class ItemPurchasingPage extends FormPage {

	public static final String PAGE_ID = "org.tomale.id.inventory.management.editors.item.purchasing";
	public static final String PAGE_TITLE = "Purchasing";

	public ItemPurchasingPage(FormEditor editor){
		super(editor,PAGE_ID,PAGE_TITLE);
	}
}
