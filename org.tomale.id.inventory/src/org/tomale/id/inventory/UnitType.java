/**
 * 
 */
package org.tomale.id.inventory;

/**
 * @author ferd
 *
 */
public class UnitType {

	int _id;
	String _name;
	
	public UnitType(final int id, final String name){
		_id = id;
		_name = name;
	}
	
	public int getId(){
		return _id;
	}
	
	public String getName(){
		return _name;
	}
	
}
