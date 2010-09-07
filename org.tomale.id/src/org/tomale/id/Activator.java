package org.tomale.id;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.BundleContext;
import org.tomale.id.db.DatabaseConnectionConfiguration;
import org.tomale.id.db.internal.DatabaseConnectionConfigurationElement;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.tomale.id";

	// The shared instance
	private static Activator plugin;
	
	private static final String EXT_DB_CONNECTION_PROVIDERS = "org.tomale.id.db.connection.providers";
	
	static final String KEY_DBCN = "org.tomale.id.database.connections";
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	public static ArrayList<DatabaseConnectionConfigurationElement> getDatabaseConnectionTypes(){
		ArrayList<DatabaseConnectionConfigurationElement> ret = new ArrayList<DatabaseConnectionConfigurationElement>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXT_DB_CONNECTION_PROVIDERS);
		for(IConfigurationElement element : elements){
			ret.add(new DatabaseConnectionConfigurationElement(element.getAttribute("id"), 
					element.getAttribute("name"), element.getAttribute("class")));
		}
		
		return ret;
	}
	
	public static ArrayList<DatabaseConnectionConfiguration> getDatabaseConnections(){
		ArrayList<DatabaseConnectionConfiguration> ret = new ArrayList<DatabaseConnectionConfiguration>();
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String connections = store.getString(KEY_DBCN);
		try {
				
				String name = "";
				String type = "";
				String host = "";
				int port = 0;
				String dbname = "";
				String user = "";
				String pw = "";
				
				JSONArray jarray = new JSONArray();
				if(!connections.isEmpty()){
					jarray = new JSONArray(connections);
					for(int i = 0;i<jarray.length();i++){
						
						JSONObject o = jarray.getJSONObject(i);
						
						name = o.has("name") ? o.getString("name") : "";
						type = o.has("type") ? o.getString("type") : "";
						host = o.has("host") ? o.getString("host") : "";
						port = o.has("port") ? o.getInt("port") : 0;
						dbname = o.has("dbname") ? o.getString("dbname") : "";
						user = o.has("user") ? o.getString("user") : "";
						pw = o.has("pw") ? o.getString("pw") : "";
						
						ret.add(new DatabaseConnectionConfiguration(name, type, host, 
								port, dbname, user, pw));
					}
				}
		} catch(JSONException e){
			Activator.getDefault().getLog().log(new Status(Status.ERROR, 
					Activator.PLUGIN_ID, "Unable to parse configuration.", e));
		}
		
		return ret;
	}
	
	public static void addDatabaseConnectionConfiguration(DatabaseConnectionConfiguration conf){
		try {
			ArrayList<DatabaseConnectionConfiguration> confs = getDatabaseConnections();
			confs.add(conf);
			
			JSONArray jarray = new JSONArray();
			for(DatabaseConnectionConfiguration c : confs){
				JSONObject o = new JSONObject();
				o.put("name", c.getName());
				o.put("type", c.getTypeName());
				o.put("host", c.getHost());
				o.put("port", c.getPort());
				o.put("user", c.getUsername());
				o.put("pw", c.getPassword());
				
				jarray.put(o);
			}
			String json = jarray.toString();
			
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			store.setValue(KEY_DBCN, json);
		}catch(JSONException e){
			Activator.getDefault().getLog().log(new Status(Status.ERROR, 
					Activator.PLUGIN_ID, "Unable to add database connection configuration.", e));
		}
	}
}
