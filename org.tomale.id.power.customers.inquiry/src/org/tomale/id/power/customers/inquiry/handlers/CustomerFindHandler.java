/**
 * 
 */
package org.tomale.id.power.customers.inquiry.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.tomale.id.power.customers.inquiry.views.CustomersBrowser;

/**
 * @author ftomale
 *
 */
public class CustomerFindHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if(part instanceof CustomersBrowser){
			CustomersBrowser browser = (CustomersBrowser) part;
			browser.doFind();
		}
		return null;
	}

}
