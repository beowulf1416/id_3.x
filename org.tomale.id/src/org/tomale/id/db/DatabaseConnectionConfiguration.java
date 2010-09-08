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
	String _factoryId;
	String _host;
	int _port;
	String _dbname;
	String _user;
	String _pw;
	String _options;
	
	public DatabaseConnectionConfiguration(final String name, final String factoryId,
			final String host, final int port, final String dbname, 
			final String user, final String pw, final String options){
		
		_name = name;
		_factoryId = factoryId;
		_host = host;
		_port = port;
		_dbname = dbname;
		_user = user;
		_pw = pw;
		_options = options;
		
	}

	public String getName(){
		return _name;
	}
	
	public String getFactoryId(){
		return _factoryId;
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
	
	public String getOptions(){
		return _options;
	}
	
}
