/**
 * 
 */
package org.tomale.id.inventory;

/**
 * @author ferd
 *
 */
public class Unit {

	int _id;
	UnitType _type;
	String _symbol;
	String _name;
	
	public Unit(final int id, final UnitType type, final String name, 
			final String symbol){
		_id = id;
		_type = type;
		_name = name;
		_symbol = symbol;
	}
	
	public int getId(){
		return _id;
	}
	
	public UnitType getUnitType(){
		return _type;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getSymbol(){
		return _symbol;
	}
}
