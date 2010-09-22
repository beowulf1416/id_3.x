/**
 * 
 */
package org.tomale.id.gis;

/**
 * @author ferd
 *
 */
public interface IMapSourceFactoryConfiguration {

	int getId();
	
	String getName();
	
	String getJSON();
	
	void setJSON(final String json);
	
}
