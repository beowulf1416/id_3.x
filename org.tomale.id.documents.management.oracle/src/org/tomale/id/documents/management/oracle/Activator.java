package org.tomale.id.documents.management.oracle;

import java.sql.Connection;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.tomale.id.db.DatabaseConnectionManager;
import org.tomale.id.documents.management.oracle.preferences.PreferenceConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin{

	// The plug-in ID
	public static final String PLUGIN_ID = "org.tomale.id.documents.management.oracle";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	
	public static Connection getConnection(){
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String selectedConnection = store.getString(PreferenceConstants.DB_CONNECTION_NAME);
		if(selectedConnection.isEmpty()){
			
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, "Oracle Document Store is not properly configured."));
			
			return null;
		} else {
			Connection cn = DatabaseConnectionManager.getInstance().getConnection(selectedConnection);
			return cn;
		}
	}

}
