/**
 * 
 */
package org.tomale.id.db;

/**
 * @author ferd
 *
 */
public class DatabaseConnectionConfiguration {

	String _name;
	String _type;
	String _host;
	int _port;
	String _dbname;
	String _user;
	String _pw;
	
	public DatabaseConnectionConfiguration(final String name, final String type,
			final String host, final int port, final String dbname, 
			final String user, final String pw){
		
		_name = name;
		_type = type;
		_host = host;
		_port = port;
		_dbname = dbname;
		_user = user;
		_pw = pw;
		
	}

	public String getName(){
		return _name;
	}
	
	public String getTypeName(){
		return _type;
	}
	
	public String getHost(){
		return _host;
	}
	
	public int getPort(){
		return _port;
	}
	
	public String getDatabaseName(){
		return _dbname;
	}
	
	public String getUsername(){
		return _user;
	}
	
	public String getPassword(){
		return _pw;
	}
	
}
