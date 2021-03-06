/**
 * 
 */
package org.tomale.id.documents.management.oracle;

import java.sql.Connection;
import java.util.ArrayList;

import org.tomale.id.documents.Document;
import org.tomale.id.documents.management.db.DocumentStoreException;
import org.tomale.id.documents.management.db.IDocumentFilter;
import org.tomale.id.documents.management.db.IDocumentFilterType;
import org.tomale.id.documents.management.db.IDocumentStore;

/**
 * @author ferd
 *
 */
public class OracleDocumentStore implements IDocumentStore {
	
	Connection _cn;

	public OracleDocumentStore() throws DocumentStoreException {
		_cn = Activator.getConnection();
		if(_cn == null){
			throw new DocumentStoreException("Unable to obtain a connection");
		}
	}
	
	/* (non-Javadoc)
	 * @see org.tomale.id.documents.management.db.IDocumentStore#getDocumentFilterTypes()
	 */
	@Override
	public ArrayList<IDocumentFilterType> getDocumentFilterTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.tomale.id.documents.management.db.IDocumentStore#getDocuments(java.util.ArrayList)
	 */
	@Override
	public ArrayList<Document> getDocuments(ArrayList<IDocumentFilter> filters) {
		// TODO Auto-generated method stub
		return null;
	}

}
