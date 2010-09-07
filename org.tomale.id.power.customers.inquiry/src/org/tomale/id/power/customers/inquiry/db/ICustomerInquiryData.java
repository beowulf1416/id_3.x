/**
 * 
 */
package org.tomale.id.power.customers.inquiry.db;

import java.util.ArrayList;

import org.tomale.id.power.customers.Customer;

/**
 * @author ftomale
 *
 */
public interface ICustomerInquiryData {

	ArrayList<ICustomerFilterType> getCustomerFilterTypes();
	
	ArrayList<Customer> getCustomers(ArrayList<ICustomerFilter> filters);
	
}
