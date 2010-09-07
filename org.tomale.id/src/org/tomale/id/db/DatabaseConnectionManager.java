/**
 * 
 */
package org.tomale.id.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
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
			ArrayList<DatabaseConnectionConfiguration> connections = Activator.getDatabaseConnections();
			for(DatabaseConnectionConfiguration conf : connections){
				if(conf.getName().equalsIgnoreCase(name)){
					
					IExtensionRegistry registry = Platform.getExtensionRegistry();
					
					
					
					break;
				}
			}
		}
		return _cns.get(name);
	}
	
	public ArrayList<DatabaseConnectionConfiguration> getConnections(){
		return Activator.getDatabaseConnections();
	}
	
}
