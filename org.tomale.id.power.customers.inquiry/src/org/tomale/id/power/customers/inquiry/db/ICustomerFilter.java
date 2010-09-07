/**
 * 
 */
package org.tomale.id.power.customers.inquiry.db;

/**
 * @author ferd
 *
 */
public interface ICustomerFilter {

	ICustomerFilterType getFilterType();
	
	void setFilterType(ICustomerFilterType filterType);
	
	String getFilter();
	
	void setFilter(String filter);
}
