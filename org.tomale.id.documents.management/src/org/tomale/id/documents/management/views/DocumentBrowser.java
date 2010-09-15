/**
 * 
 */
package org.tomale.id.documents.management.views;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.ViewPart;
import org.tomale.id.documents.management.Activator;
import org.tomale.id.documents.management.db.IDocumentFilterType;
import org.tomale.id.documents.management.db.IDocumentStore;

/**
 * @author ftomale
 *
 */
public class DocumentBrowser extends ViewPart {

	ArrayList<IDocumentFilterType> _docFilterTypes;
	
	TreeViewer _view;
	
	Composite _compFilters;
	
	ArrayList<Combo> _filterTypes = new ArrayList<Combo>();
	ArrayList<Text> _filterSz = new ArrayList<Text>();
//	ArrayList<Button> _btnFind = new ArrayList<Button>();
	ArrayList<Button> _btnRemove = new ArrayList<Button>();
	
	Button _find;
	Button _add;
	
	SelectionAdapter _removeSelectionListener = new SelectionAdapter() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			removeFilter((Button) e.widget);
		}
		
	};
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		parent.setLayout(layout);
		
		_compFilters = new Composite(parent, SWT.NO_FOCUS);
		GridLayout layoutComp = new GridLayout();
		layoutComp.numColumns = 3;
		_compFilters.setLayout(layoutComp);
		_compFilters.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		addFilter();
		
		Composite compAdd = new Composite(parent, SWT.NO_FOCUS);
		GridLayout layoutAdd = new GridLayout();
		layoutAdd.numColumns = 2;
		compAdd.setLayout(layoutAdd);
		compAdd.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		_find = new Button(compAdd,SWT.PUSH);
		_find.setText("Find");
		_find.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,true,false));
		
		_add = new Button(compAdd,SWT.PUSH);
		_add.setText("+");
		_add.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,false));
		_add.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				addFilter();
			}
			
		});
		
		_view = new TreeViewer(parent);
		_view.setContentProvider(new ViewContentProvider());
		_view.setLabelProvider(new ViewLabelProvider());
		Tree tree = _view.getTree();
		tree.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
	}
	
	private void initCboFilters(Combo cbo){
		IDocumentStore store = Activator.getDocumentStore();
		if(store == null){
			getViewSite().getActionBars().getStatusLineManager().setErrorMessage("Unable to retrieve document filter types");
		} else {
			if(_docFilterTypes == null){
				_docFilterTypes = store.getDocumentFilterTypes();
			}
			
			for(IDocumentFilterType filterType : _docFilterTypes){
				cbo.add(filterType.getName());
				cbo.setData(filterType.getName(),filterType);
			}
		}
	}
	
	private void addFilter(){
		Combo cbo = new Combo(_compFilters, SWT.DROP_DOWN | SWT.READ_ONLY);
		initCboFilters(cbo);
		cbo.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		_filterTypes.add(cbo);
		
		Text txt = new Text(_compFilters, SWT.BORDER | SWT.SEARCH);
		if(_filterSz.size() > 0){
			txt.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		} else {
			txt.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,2,1));
		}
		_filterSz.add(txt);

		if(_filterSz.size() > 1){
			Button remove = new Button(_compFilters, SWT.PUSH);
			remove.setText("-");
			remove.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
			remove.addSelectionListener(_removeSelectionListener);
			_btnRemove.add(remove);
		}
		
		_compFilters.layout();
		_compFilters.getParent().layout();
	}
	
	private void removeFilter(Button b){
		int index = _btnRemove.indexOf(b);
		
		_btnRemove.get(index).dispose();
		_filterSz.get(index+1).dispose();
		_filterTypes.get(index+1).dispose();
		
		_compFilters.layout();
		_compFilters.getParent().layout();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		_view.getTree().setFocus();
	}
	
	private void doFind(){
		
	}
	
	public class ViewContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getChildren(Object parentElement) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class ViewLabelProvider extends LabelProvider {

		@Override
		public Image getImage(Object element) {
			// TODO Auto-generated method stub
			return super.getImage(element);
		}

		@Override
		public String getText(Object element) {
			// TODO Auto-generated method stub
			return super.getText(element);
		}
		
	}

}
