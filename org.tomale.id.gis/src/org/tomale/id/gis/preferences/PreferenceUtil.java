/**
 * 
 */
package org.tomale.id.gis.preferences;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tomale.id.gis.Activator;
import org.tomale.id.gis.IMapSource;

/**
 * @author ferd
 *
 */
public class PreferenceUtil {

	public static ArrayList<MapSourceFactoryConfigurationElement> getMapSources(){
		ArrayList<MapSourceFactoryConfigurationElement> confs = new ArrayList<MapSourceFactoryConfigurationElement>();
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String sources = store.getString(PreferenceConstants.PREF_MAP_SOURCES);
		if(!sources.isEmpty()){
			try {
				JSONArray jarray = new JSONArray(sources);
				for(int i=0;i<jarray.length();i++){
					JSONObject jo = jarray.getJSONObject(i);
					
					String id = jo.has("id") ? jo.getString("id") : "";
					JSONArray joptions = jo.has("options") ? jo.getJSONArray("options") : new JSONArray();
					HashMap<String, Object> options = new HashMap<String, Object>();
					for(int j=0;j<joptions.length();j++){
						
					}
					
					confs.add(new MapSourceFactoryConfigurationElement(id, options));
				}
				
			}catch(JSONException e){
				Activator.getDefault().getLog().log(new Status(Status.ERROR, 
						Activator.PLUGIN_ID, "Unable to read map source configuration.", e));
			}
		}	
		
		return confs;
	}
	
	public static void addMapSource(){
		JSONArray jarray = new JSONArray();
		
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
	}
	
}
