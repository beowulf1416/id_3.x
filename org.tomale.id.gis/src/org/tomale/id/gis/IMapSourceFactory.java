/**
 * 
 */
package org.tomale.id.gis;

import org.eclipse.jface.wizard.WizardPage;

/**
 * @author ferd
 *
 */
public interface IMapSourceFactory {

	public IMapSource create();
	
	public WizardPage getWizardPage();
	
}
