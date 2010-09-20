/**
 * 
 */
package org.tomale.id.gis.mapsources.shapefile;

import org.tomale.id.gis.IMapSource;
import org.tomale.id.gis.IMapSourceFactory;

/**
 * @author ferd
 *
 */
public class MapSourceFactory implements IMapSourceFactory {

	/* (non-Javadoc)
	 * @see org.tomale.id.gis.IMapSourceFactory#create()
	 */
	@Override
	public IMapSource create() {
		
		MapSource source = new MapSource();
		
		return source;
	}

}
