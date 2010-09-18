/**
 * 
 */
package org.tomale.id.power.customers.inquiry;

/**
 * @author ftomale
 *
 */
public class DataProviderConfigurationElement {

	String _id;
	String _name;
	String _class;
	
	public DataProviderConfigurationElement(final String id, final String name,
			final String className){
		_id = id;
		_name = name;
		_class = className;
	}
	
	public String getId(){
		return _id;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getClassName(){
		return _class;
	}
}
