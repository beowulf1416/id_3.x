/**
 * 
 */
package org.tomale.id.power.customers;

/**
 * @author ferd
 *
 */
public class Customer {

	int _id;
	String _acct;
	String _meter;
	
	String _last;
	String _first;
	String _middle;
	
	String _address;
	
	CustomerState _state;

	public int getId(){
		return _id;
	}
	
	public void setId(final int id){
		_id = id;
	}
	
	public CustomerState getState(){
		return _state;
	}
	
	public void setState(final CustomerState state){
		_state = state;
	}
}
