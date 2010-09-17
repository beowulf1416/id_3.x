/**
 * 
 */
package org.tomale.id.power.customers.inquiry.views;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

/**
 * @author ferd
 *
 */
public class CustomersBrowser extends ViewPart {

	public static final String VIEW_ID = "org.tomale.id.power.customers.inquiry.views.customersbrowser";

	Composite _comp;
	ArrayList<Combo> _filterTypes = new ArrayList<Combo>();
	ArrayList<Text> _txtFind = new ArrayList<Text>();
	ArrayList<Button> _btnRem = new ArrayList<Button>();
	
	Button _btnFind;
	Button _btnAdd;
	
	TableViewer _view;

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
	
		_comp = new Composite(parent,SWT.NO_FOCUS);
		GridLayout layoutFilters = new GridLayout();
		layoutFilters.numColumns = 3;
		_comp.setLayout(layoutFilters);
		_comp.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		addFilter();
		
		Composite compAdd = new Composite(parent, SWT.NO_FOCUS);
		GridLayout layoutAdd = new GridLayout();
		layoutAdd.numColumns = 2;
		compAdd.setLayout(layoutAdd);
		compAdd.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		
		_btnFind = new Button(compAdd,SWT.PUSH);
		_btnFind.setText("Find");
		_btnFind.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,false));
		_btnFind.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				doFind();
			}
			
		});
		
		_btnAdd = new Button(compAdd,SWT.PUSH);
		_btnAdd.setText("+");
		_btnAdd.setLayoutData(new GridData(SWT.RIGHT,SWT.FILL,false,false));
		_btnAdd.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				addFilter();
			}
			
		});
		
		_view = new TableViewer(parent);
		_view.setContentProvider(new ContentProvider());
		_view.setLabelProvider(new ViewLabelProvider());
		Table tbl = _view.getTable();
		initTableColumns(tbl);
		tbl.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		
		getSite().setSelectionProvider(_view);
	}
	
	private void initTableColumns(Table table){
		table.setHeaderVisible(true);
	}
	
	private void addFilter(){

		Combo cbo = new Combo(_comp,SWT.DROP_DOWN | SWT.READ_ONLY);
		initFilterTypes(cbo);
		cbo.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
		_filterTypes.add(cbo);
		
		Text txt = new Text(_comp,SWT.BORDER | SWT.SEARCH);
		if(_txtFind.size() > 0){
			txt.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		} else {
			txt.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,2,1));
		}
		_txtFind.add(txt);
		
		if(_txtFind.size() > 1){
			Button remove = new Button(_comp,SWT.PUSH);
			remove.setText("-");
			remove.setLayoutData(new GridData(SWT.FILL,SWT.FILL,false,false));
			remove.addSelectionListener(_removeSelectionListener);
			_btnRem.add(remove);
		}
		
		_comp.layout();
		_comp.getParent().layout();
	}
	
	private void initFilterTypes(Combo filterType){
		
	}
	
	private void removeFilter(Button b){
		int index = _btnRem.indexOf(b);
		
		_filterTypes.get(index+1).dispose();
		_txtFind.get(index+1).dispose();
		_btnRem.get(index).dispose();
		
		_comp.layout();
		_comp.getParent().layout();
	}
	
	public void doFind(){
		boolean find = false;
		for(Text t : _txtFind){
			if(!t.getText().isEmpty()){
				find = true;
			}
		}
		
		if(find){
			
			// http://www.eclipse.org/articles/Article-Concurrency/jobs-api.html
			Job job = new Job("// TODO replace with proper name") {
				
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					
					Display.getDefault().asyncExec(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
						}
					});
					
					return Status.OK_STATUS;
				}
			};
			job.addJobChangeListener(new JobChangeAdapter(){

				@Override
				public void done(IJobChangeEvent event) {
					IStatus status = event.getResult();
					if(status.isOK()){
						// TODO update table
						
					} else {
						getViewSite().getActionBars().getStatusLineManager().setErrorMessage(status.getMessage());
					}
				}
				
			});
			job.setPriority(Job.LONG);
			job.schedule();
			
		} else {
			getViewSite().getActionBars().getStatusLineManager().setErrorMessage("Please enter customer search criteria");
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		if(_txtFind.size()>0){
			_txtFind.get(0).setFocus();
		} else {
			_view.getTable().setFocus();
		}
	}
	
	public class ContentProvider implements IStructuredContentProvider {

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
