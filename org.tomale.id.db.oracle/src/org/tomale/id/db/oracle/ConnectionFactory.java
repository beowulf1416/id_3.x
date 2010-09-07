/**
 * 
 */
package org.tomale.id.db.oracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

import oracle.jdbc.pool.OracleDataSource;

import org.eclipse.core.runtime.Status;
import org.tomale.id.db.IConnectionFactory;

/**
 * @author ferd
 *
 */
public class ConnectionFactory implements IConnectionFactory {

	/* (non-Javadoc)
	 * @see org.tomale.id.db.IConnectionFactory#create(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Connection create(String host, int port, String name, String user,
			String pw, String options) {
		// TODO Auto-generated method stub
		
		try{
			Locale.setDefault(Locale.ENGLISH);
			
			OracleDataSource ds = new OracleDataSource();
			
			ds.setDatabaseName(name);
			ds.setPortNumber(port);
			ds.setUser(user);
			ds.setPassword(pw);
			
			Connection cn = ds.getConnection();
			cn.setAutoCommit(false);
			
			return cn;
		}catch(SQLException e){
			Activator.getDefault().getLog().log(new Status(Status.ERROR, 
					Activator.PLUGIN_ID, "Unable to create Oracle database connection.",e));
		}
		
		return null;
	}

}
