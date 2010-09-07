package org.tomale.id.documents.management;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.tomale.id.documents.management.db.IDocumentStore;
import org.tomale.id.documents.management.preferences.PreferenceConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.tomale.id.documents.management";
	
	// The shared instance
	private static Activator plugin;
	
	private static final String EXT_DOCUMENT_STORE_TYPES = "org.tomale.id.documents.management.documentstores.providers";
	
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
	
	public static ArrayList<DocumentStoreConfigurationElement> getDocumentStoreTypes(){
		ArrayList<DocumentStoreConfigurationElement> ret = new ArrayList<DocumentStoreConfigurationElement>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXT_DOCUMENT_STORE_TYPES);
		for(IConfigurationElement element : elements){
			ret.add(new DocumentStoreConfigurationElement(element.getAttribute("id"), 
					element.getAttribute("name"), element.getAttribute("class")));
		}
		
		return ret;
	}
	
	public static IDocumentStore getDocumentStore(){
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String selectedStore = store.getString(PreferenceConstants.DOC_STORE_PROVIDER);
		
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] elements = registry.getConfigurationElementsFor(EXT_DOCUMENT_STORE_TYPES);
		for(IConfigurationElement element : elements){
			String id = element.getAttribute("id");
			if(selectedStore.equals(id)){
				try {
					Object o = element.createExecutableExtension("class");
					IDocumentStore docStore = (IDocumentStore) o;
					return docStore;
				}catch(CoreException e){
					Activator.getDefault().getLog().log(new Status(Status.ERROR, 
							Activator.PLUGIN_ID, 
							MessageFormat.format("Unable to create an instance of DocumentStore id '{0}'", id),e));
				}catch(Exception e){
					Activator.getDefault().getLog().log(new Status(Status.ERROR, 
							Activator.PLUGIN_ID, 
							MessageFormat.format("Unable to create an instance of DocumentStore id '{0}'", id),e));
				}
				break;
			}
		}

		Activator.getDefault().getLog().log(new Status(Status.ERROR, 
				Activator.PLUGIN_ID, MessageFormat.format("Unable to create an instance of Document Store '{0}'.", selectedStore)));
		
		return null;
	}

}
