/**
 * 
 */
package org.tomale.id.gis.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.tomale.id.gis.preferences.MapSourceFactoryConfiguration;

/**
 * @author ferd
 *
 */
public class MapSourceWizard extends Wizard implements INewWizard {

	MapSourceSelectionPage _page;
	IWizardPage _mapSourceConfPage;
	
	@Override
	public boolean canFinish() {
		return _mapSourceConfPage == null ? _page.isPageComplete() : 
			_page.isPageComplete() & _mapSourceConfPage.isPageComplete();
	}

	@Override
	public void addPages() {
		
		_page = new MapSourceSelectionPage();
		addPage(_page);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		
		String name = _page.getName();
		MapSourceFactoryConfiguration conf = _page.getConfiguration();
		
		IWizardPage[] pages = getPages();
		for(IWizardPage page : pages){
			if(!page.equals(_page)){
				if(page instanceof IWizardPagePreference){
					IWizardPagePreference pref = (IWizardPagePreference) page;
					pref.savePreference();
				}
			}
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}
	
	public void setMapSourceConfigPage(IWizardPage page){
		if(_mapSourceConfPage != null){
			_mapSourceConfPage = null;
		}
		_mapSourceConfPage = page;
		addPage(_mapSourceConfPage);
	}
	
}
