/**
 * 
 */
package org.tomale.id.power.customers.inquiry.oracle;

import java.util.ArrayList;

import org.tomale.id.power.customers.Customer;
import org.tomale.id.power.customers.inquiry.db.ICustomerFilter;
import org.tomale.id.power.customers.inquiry.db.ICustomerFilterType;
import org.tomale.id.power.customers.inquiry.db.ICustomerInquiryData;

/**
 * @author ftomale
 *
 */
public class OracleCustomerInquiryDataProvider implements ICustomerInquiryData {

	/* (non-Javadoc)
	 * @see org.tomale.id.power.customers.inquiry.db.ICustomerInquiryData#getCustomerFilterTypes()
	 */
	@Override
	public ArrayList<ICustomerFilterType> getCustomerFilterTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.tomale.id.power.customers.inquiry.db.ICustomerInquiryData#getCustomers(java.util.ArrayList)
	 */
	@Override
	public ArrayList<Customer> getCustomers(ArrayList<ICustomerFilter> filters) {
		// TODO Auto-generated method stub
		return null;
	}

}
