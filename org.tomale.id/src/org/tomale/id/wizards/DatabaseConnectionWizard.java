/**
 * 
 */
package org.tomale.id.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.tomale.id.Activator;
import org.tomale.id.db.DatabaseConnectionConfiguration;

/**
 * @author ferd
 *
 */
public class DatabaseConnectionWizard extends Wizard implements INewWizard {

	final String KEY_DBCN = "org.tomale.id.database.connections";
	
	boolean _canFinish = false;
	DatabaseConnectionWizardPage _page;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {

		try {
			String name = _page.getName();
			String type = _page.getDatabaseConnectionType().getId();
			String host = _page.getHost();
			int port = _page.getPort();
			String dbname = _page.getDatabaseName();
			String user = _page.getUsername();
			String pw = _page.getPassword();
			String options = _page.getOptions();
			
			Activator.addDatabaseConnectionConfiguration(new DatabaseConnectionConfiguration(name, type, 
					host, port, dbname, user, pw, options));
			
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPages() {
		_page = new DatabaseConnectionWizardPage();
		addPage(_page);
	}

	@Override
	public boolean canFinish() {
		return _page.isPageComplete();
	}
	
}
