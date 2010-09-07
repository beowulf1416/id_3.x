/**
 * 
 */
package org.tomale.id.documents.management.db;

import java.util.ArrayList;

import org.tomale.id.documents.Document;

/**
 * @author ferd
 *
 */
public interface IDocumentStore {
	
	ArrayList<IDocumentFilterType> getDocumentFilterTypes();
	
	ArrayList<Document> getDocuments(ArrayList<IDocumentFilter> filters);
	
}
