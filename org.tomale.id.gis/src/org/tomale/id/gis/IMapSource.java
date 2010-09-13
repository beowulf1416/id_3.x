/**
 * 
 */
package org.tomale.id.gis;

import java.util.ArrayList;

/**
 * @author ferd
 *
 */
public interface IMapSource {

	public String getName();
	
	public void addLayer(final ILayer layer);
	
	public void removeLayer(final String layerName);
	
	public ArrayList<ILayer> getLayers();
	
}
