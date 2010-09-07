/**
 * 
 */
package org.tomale.id.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.tomale.id.Activator;

/**
 * @author ferd
 *
 */
public class DatabaseConnectionEditorInput implements IEditorInput {

	String _name;
	String _host;
	int _port;
	String _dbname;
	String _user;
	String _pw;
	String _opt;
	
	public DatabaseConnectionEditorInput(){
		
	}
	
	public DatabaseConnectionEditorInput(final String name, final String host,
			final int port, final String dbname, 
			final String user, final String pw, final String options){
		
		_name = name;
		_host = host;
		_port = port;
		_dbname = dbname;
		_user = user;
		_pw = pw;
		_opt = options;
		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		return Activator.getImageDescriptor("icons/alt_about.gif");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		return "Database Connection Editor";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	@Override
	public String getToolTipText() {
		return "Database Connection Editor";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}
	
	public String getHost(){
		return _host;
	}
	
	public String getConnectionName(){
		return _name;
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
		return _opt;
	}

}
