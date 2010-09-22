package org.tomale.id.gis;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.tomale.id.gis.preferences.MapSourceFactoryConfiguration;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.tomale.id.gis";

	// The shared instance
	private static Activator plugin;
	
	public static final String EXT_MAP_SOURCE_FACTORIES = "org.tomale.id.gis.mapsourcefactories";
	
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

	public static ArrayList<MapSourceFactoryConfiguration> getMapSourceFactories(){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXT_MAP_SOURCE_FACTORIES);
		ArrayList<MapSourceFactoryConfiguration> confs = new ArrayList<MapSourceFactoryConfiguration>();
		for(IConfigurationElement element : elements){
			confs.add(new MapSourceFactoryConfiguration(element.getAttribute("id"), 
					element.getAttribute("name"), element.getAttribute("class")));
		}
		return confs;
	}
	
	public static IMapSourceFactory getMapSourceFactory(final String id){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXT_MAP_SOURCE_FACTORIES);
		for(IConfigurationElement element : elements){
			if(id.equals(element.getAttribute("id"))){
				try {
					Object o = element.createExecutableExtension("class");
					IMapSourceFactory factory = (IMapSourceFactory) o;
					return factory;
				}catch(CoreException e){
					Activator.getDefault().getLog().log(new Status(Status.ERROR, 
							Activator.PLUGIN_ID, 
							MessageFormat.format("Unable to create an instance of IMapSourceFactory with id '{0}'", 
									id),
							e));
					return null;
				}
			}
		}
		
		Activator.getDefault().getLog().log(new Status(Status.ERROR,
				Activator.PLUGIN_ID,
				MessageFormat.format("Unable to locate IMapSourceFactory provider '{0}'", 
						id)));
		
		return null;
	}
	
	public void addMapSourceFactory(final String id){
		
	}
}
