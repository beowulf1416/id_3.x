/**
 * 
 */
package org.tomale.id.documents.management.db;

/**
 * @author ferd
 *
 */
public interface IDocumentFilter {

	IDocumentFilterType getFilterType();
	
	void setFilterType(IDocumentFilterType filterType);
	
	String getFilter();
	
	void setFilter(String filter);
}
