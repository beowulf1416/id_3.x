/**
 * 
 */
package org.tomale.id.db;

import java.sql.Connection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.Status;
import org.tomale.id.Activator;

/**
 * @author ftomale
 *
 */
public class DatabaseConnectionManager {

	private static DatabaseConnectionManager _mgr;
	
	private HashMap<String, Connection> _cns;
	
	private DatabaseConnectionManager(){
		_cns = new HashMap<String, Connection>();
	}
	
	public static DatabaseConnectionManager getInstance(){
		if(_mgr == null){
			_mgr = new DatabaseConnectionManager();
		}
		return _mgr;
	}
	
	public Connection getConnection(final String name){
		if(!_cns.containsKey(name)){
			ArrayList<DatabaseConnectionConfiguration> elements = Activator.getDatabaseConnections();
			for(DatabaseConnectionConfiguration element : elements){
				if(element.getName().equals(name)){
					IConnectionFactory cf = Activator.getConnectionFactory(element.getFactoryId());
					if(cf != null){
						Connection cn = cf.create(element.getHost(), 
								element.getPort(), 
								element.getDatabaseName(), 
								element.getUsername(), 
								element.getPassword(), 
								element.getOptions());
						if(cn == null){
							Activator.getDefault().getLog().log(new Status(Status.ERROR, 
									Activator.PLUGIN_ID, MessageFormat.format("Unable to create an instance of connection '{0}'", name)));
							
							return null;
						} else {
							_cns.put("name", cn);
						}
					}
				}
			}
		}
		return _cns.get(name);
	}
	
	public ArrayList<DatabaseConnectionConfiguration> getConnections(){
		return Activator.getDatabaseConnections();
	}
	
}
