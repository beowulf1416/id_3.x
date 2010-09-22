/**
 * 
 */
package org.tomale.id.inventory;

/**
 * @author ferd
 *
 */
public class Manufacturer {

	int _id;
	String _name;
	String _desc;
	
	public Manufacturer(final int id, final String name, 
			final String description){
		_id = id;
		_name = name;
		_desc = description;
	}
	
	public int getId(){
		return _id;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getDescription(){
		return _desc;
	}
}
