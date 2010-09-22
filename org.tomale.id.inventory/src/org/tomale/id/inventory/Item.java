/**
 * 
 */
package org.tomale.id.inventory;

import java.util.ArrayList;

/**
 * @author ftomale
 *
 */
public class Item {

	int _id;
	String _sku;
	ItemState _state;
	
	String _name;
	
	ArrayList<Integer> _classIds = new ArrayList<Integer>();
	ArrayList<Integer> _storageLocationIds = new ArrayList<Integer>();
	ArrayList<Integer> _manufacturerIds = new ArrayList<Integer>();
	
	public String getName(){
		return _name;
	}
	
	public void setName(final String name){
		_name = name;
	}
	
	public ItemState getState(){
		return _state;
	}
	
	public void setState(final ItemState state){
		_state = state;
	}
	
	public ArrayList<Integer> getItemClassIds(){
		return _classIds;
	}
	
	public ArrayList<ItemClass> getItemClasses(){
		// TODO getItemClasses
		return null;
	}
	
	public ArrayList<Integer> getStorageLocationIds(){
		return _storageLocationIds;
	}
	
	public ArrayList<StorageLocation> getStorageLocations(){
		// TODO getStorageLocations
		return null;
	}
	
	public ArrayList<Integer> getManufacturerIds(){
		return _manufacturerIds;
	}
	
	public ArrayList<Manufacturer> getManufacturers(){
		// TODO getManufacturers
		return null;
	}
}
