/**
 * 
 */
package org.tomale.id.views;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.tomale.id.Activator;
import org.tomale.id.db.DatabaseConnectionConfiguration;

/**
 * @author ftomale
 *
 */
public class DatabaseConnectionsView extends ViewPart {

	public static final String VIEW_ID = "org.tomale.id.views.databaseconnections";
	
	TreeViewer _tree;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		FillLayout layout = new FillLayout();
		parent.setLayout(layout);
	
		_tree = new TreeViewer(parent);
		_tree.setContentProvider(new ContentProvider());
		_tree.setLabelProvider(new TreeLabelProvider());

		_tree.setInput(Activator.getDatabaseConnections());
		
		_tree.getTree().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		
		getSite().setSelectionProvider(_tree);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		_tree.getTree().setFocus();
	}

	public class ContentProvider implements ITreeContentProvider {

		ArrayList<DatabaseConnectionConfiguration> _connections;
		
//		public ContentProvider(ArrayList<DatabaseConnectionConfiguration> connections){
//			_connections = connections;
//		}
		
		@Override
		public Object[] getElements(Object inputElement) {
			return ((ArrayList<DatabaseConnectionConfiguration>) inputElement).toArray();
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			DatabaseConnectionConfiguration conf = (DatabaseConnectionConfiguration) parentElement;
			ArrayList<String> objs = new ArrayList<String>();
			objs.add(MessageFormat.format("Host: {0}", conf.getHost()));
			objs.add(MessageFormat.format("Port: {0}", Integer.toString(conf.getPort())));
			objs.add(MessageFormat.format("Database Name: {0}",conf.getDatabaseName()));
			objs.add(MessageFormat.format("Username: {0}", conf.getUsername()));
//			objs.add(conf.getPassword());
			
			return objs.toArray();
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return element instanceof DatabaseConnectionConfiguration;
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			_connections = (ArrayList<DatabaseConnectionConfiguration>) newInput;
		}
		
	}
	
	public class TreeLabelProvider extends LabelProvider {

		@Override
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		@Override
		public String getText(Object element) {
			if(element instanceof DatabaseConnectionConfiguration){
				return ((DatabaseConnectionConfiguration) element).getName();
			} else {
				return element.toString();
			}
			        
		}
		
	}
}
