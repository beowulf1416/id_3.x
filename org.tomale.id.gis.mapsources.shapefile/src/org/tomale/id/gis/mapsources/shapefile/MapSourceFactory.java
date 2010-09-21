/**
 * 
 */
package org.tomale.id.gis.mapsources.shapefile;

import org.eclipse.jface.wizard.WizardPage;
import org.tomale.id.gis.IMapSource;
import org.tomale.id.gis.IMapSourceFactory;
import org.tomale.id.gis.mapsources.shapefile.wizards.ShapefileWizardPage;

/**
 * @author ferd
 *
 */
public class MapSourceFactory implements IMapSourceFactory {

	ShapefileWizardPage _page;
	
	/* (non-Javadoc)
	 * @see org.tomale.id.gis.IMapSourceFactory#create()
	 */
	@Override
	public IMapSource create() {
		
		MapSource source = new MapSource();
		
		return source;
	}

	@Override
	public WizardPage getWizardPage() {
		if(_page == null){
			_page = new ShapefileWizardPage();
		}
		return _page;
	}

}
