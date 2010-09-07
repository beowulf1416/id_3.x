/**
 * 
 */
package org.tomale.id.documents.management.db;

import java.sql.Connection;
import java.util.ArrayList;

import org.tomale.id.documents.Document;

/**
 * @author ferd
 *
 */
public interface IDocumentStore {
	
	void setConnection(Connection connection);

	ArrayList<IDocumentFilterType> getDocumentFilterTypes();
	
	ArrayList<Document> getDocuments(ArrayList<IDocumentFilter> filters);
	
}
