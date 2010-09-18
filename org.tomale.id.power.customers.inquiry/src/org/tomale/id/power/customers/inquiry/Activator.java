package org.tomale.id.power.customers.inquiry;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.tomale.id.power.customers.inquiry";

	// The shared instance
	private static Activator plugin;

	private static final String EXT_DATA_PROVIDER = "org.tomale.id.power.customers.inquiry.provider";
	
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
	
	public static ArrayList<DataProviderConfigurationElement> getDataProviders(){
		ArrayList<DataProviderConfigurationElement> providers = new ArrayList<DataProviderConfigurationElement>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXT_DATA_PROVIDER);
		for(IConfigurationElement element : elements){
			providers.add(new DataProviderConfigurationElement(element.getAttribute("id"), 
					element.getAttribute("name"), element.getAttribute("class")));
		}
		return providers;
	}

}
