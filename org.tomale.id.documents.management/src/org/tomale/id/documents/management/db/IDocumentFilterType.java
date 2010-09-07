/**
 * 
 */
package org.tomale.id.documents.management.db;

/**
 * @author ferd
 *
 */
public interface IDocumentFilterType {

	String getName();
	
	boolean validate(String filter);
}
