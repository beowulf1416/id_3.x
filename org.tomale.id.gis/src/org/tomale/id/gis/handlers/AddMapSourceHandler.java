package org.tomale.id.gis.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.tomale.id.gis.views.LayersView;

/**
 * 
 */

/**
 * @author ferd
 *
 */
public class AddMapSourceHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if(part instanceof LayersView){
			LayersView view = (LayersView) part;
			
			
			
		}
		
		return null;
	}

}
