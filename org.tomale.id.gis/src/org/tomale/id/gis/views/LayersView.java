/**
 * 
 */
package org.tomale.id.gis.views;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

/**
 * @author ferd
 *
 */
public class LayersView extends ViewPart {

	public static final String VIEW_ID = "org.tomale.id.gis.views.layers";
	
	TableViewer _view;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		_view = new TableViewer(parent);
		_view.setContentProvider(new ViewContentProvider());
		_view.setLabelProvider(new ViewLabelProvider());
		initTable();
		
		getSite().setSelectionProvider(_view);
	}
	
	private void initTable(){
		Table tbl = _view.getTable();
		tbl.setHeaderVisible(true);
		tbl.setLinesVisible(true);
		
		TableColumn col;
		
		col = new TableColumn(tbl, SWT.NONE);
		col.setText("Name");
		col.setResizable(true);
		col.setMoveable(true);
		
		col = new TableColumn(tbl, SWT.CHECK);
		col.setText("Visible");
		col.setToolTipText("Visible");
		col.setWidth(20);
		col.setResizable(false);
		col.setMoveable(false);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		_view.getTable().setFocus();
	}
	
	public class ViewContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object[] getElements(Object inputElement) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
