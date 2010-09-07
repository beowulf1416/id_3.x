/**
 * 
 */
package org.tomale.id.power.customers.inquiry.db;

/**
 * @author ferd
 *
 */
public interface ICustomerFilterType {

	String getFilterTypeName();
	
	boolean validate(String filter);
	
}
