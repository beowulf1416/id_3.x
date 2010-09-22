/**
 * 
 */
package org.tomale.id.gis.preferences;

import java.util.HashMap;

/**
 * @author ferd
 *
 */
public class MapSourceFactoryConfigurationElement {

	String _id;
	HashMap<String, Object> _options;
	
	public MapSourceFactoryConfigurationElement(final String id,
			final HashMap<String, Object> options){
		_id = id;
		_options = options;
	}
	
	public String getId(){
		return _id;
	}
	
	public HashMap<String, Object> getOptions(){
		return _options;
	}
	
}
