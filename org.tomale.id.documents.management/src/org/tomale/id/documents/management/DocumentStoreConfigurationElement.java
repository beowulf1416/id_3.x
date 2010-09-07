/**
 * 
 */
package org.tomale.id.documents.management;

/**
 * @author ftomale
 *
 */
public class DocumentStoreConfigurationElement {

	String _id;
	String _name;
	String _className;
	
	public DocumentStoreConfigurationElement(final String id, 
			final String name, final String className){
		
		_id = id;
		_name = name;
		_className = className;
		
	}
	
	public String getId(){
		return _id;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getClassName(){
		return _className;
	}
}
