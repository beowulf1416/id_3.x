/**
 * 
 */
package org.tomale.id.gis;

import java.util.HashMap;

/**
 * @author ftomale
 *
 */
public interface IWizardPagePreference {

	HashMap<String, Object> getOptions();
	
	void savePreference();
	
}
