/**
 * 
 */
package org.tomale.id.wizards;

import java.util.ArrayList;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.tomale.id.Activator;
import org.tomale.id.db.internal.DatabaseConnectionConfigurationElement;

/**
 * @author ferd
 *
 */
public class DatabaseConnectionWizardPage extends WizardPage {

	public static final String PAGE_TITLE = "New Database Connection";
	public static final String PAGE_TEXT = "Material Overview";
	public static final String PAGE_DESC = "Database connection properties";
	
	Text _name;
	Combo _type;
	Text _host;
	Text _port;
	Text _dbname;
	Text _user;
	Text _pw;
	Text _options;
	
	ModifyListener _modify = new ModifyListener() {
		
		@Override
		public void modifyText(ModifyEvent e) {
			updatePageComplete();
		}
	};
	
	public DatabaseConnectionWizardPage(){
		super(PAGE_TITLE,PAGE_TEXT,
				Activator.getImageDescriptor("icons/alt_about.gif"));
		setDescription(PAGE_DESC);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		comp.setLayout(layout);
		
		Label l;
		ControlDecoration decoration;
		
		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("Connection name");
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_name = new Text(comp, SWT.BORDER);
		_name.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_name.addModifyListener(_modify);
		decoration = new ControlDecoration(_name, SWT.LEFT);
		decoration.setDescriptionText("Please enter the name of this database connection");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
		
		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("Connection type");
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_type = new Combo(comp, SWT.READ_ONLY | SWT.DROP_DOWN);
		initDbConnectionProviders(_type);
		_type.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		decoration = new ControlDecoration(_name, SWT.LEFT);
		decoration.setDescriptionText("Please select a database connecion provider");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
		
		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("Host");
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_host= new Text(comp, SWT.BORDER);
		_host.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_host.addModifyListener(_modify);
		decoration = new ControlDecoration(_name, SWT.LEFT);
		decoration.setDescriptionText("Please enter the database host name");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
		
		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("Port");
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_port= new Text(comp, SWT.BORDER);
		_port.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_port.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				try {
					Integer.parseInt(_port.getText());
				}catch(NumberFormatException ex){
					
				}
				updatePageComplete();
			}
		});
		decoration = new ControlDecoration(_name, SWT.LEFT);
		decoration.setDescriptionText("Please enter the database port number");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
		
		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("Database name");
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_dbname = new Text(comp, SWT.BORDER);
		_dbname.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_dbname.addModifyListener(_modify);
		decoration = new ControlDecoration(_name, SWT.LEFT);
		decoration.setDescriptionText("Please enter the name of the database");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
		
		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("User name");
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_user = new Text(comp, SWT.BORDER);
		_user.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_user.addModifyListener(_modify);
		decoration = new ControlDecoration(_name, SWT.LEFT);
		decoration.setDescriptionText("Please enter the name of the database user");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
		
		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("Password");
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_pw = new Text(comp, SWT.BORDER | SWT.PASSWORD);
		_pw.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_pw.addModifyListener(_modify);
		decoration = new ControlDecoration(_name, SWT.LEFT);
		decoration.setDescriptionText("Please enter the name of the database password");
		decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());

		l = new Label(comp, SWT.NO_FOCUS);
		l.setText("Options");
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_options = new Text(comp, SWT.BORDER);
		_options.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false));
		_options.addModifyListener(_modify);
		
		setControl(comp);
	}

	@Override
	public boolean isPageComplete() {
		return !(_name.getText().isEmpty() && _host.getText().isEmpty() &&
			_type.getText().isEmpty() && 
			_port.getText().isEmpty() && // TODO test for numeric port entry 
			_dbname.getText().isEmpty() && _user.getText().isEmpty());
	}
	
	private void updatePageComplete(){
		setPageComplete(isPageComplete());
	}
	
	private void initDbConnectionProviders(Combo types){
		ArrayList<DatabaseConnectionConfigurationElement> providers = Activator.getDatabaseConnectionTypes();
		for(DatabaseConnectionConfigurationElement provider : providers){
			types.add(provider.getName());
			types.setData(provider.getName(), provider);
		}
	}
	
	public String getName(){
		return _name.getText();
	}
	
	public DatabaseConnectionConfigurationElement getDatabaseConnectionType(){
		DatabaseConnectionConfigurationElement selected = (DatabaseConnectionConfigurationElement) _type.getData(_type.getText());
		return selected;
	}
	
	public String getHost(){
		return _host.getText();
	}
	
	public int getPort(){
		return Integer.parseInt(_port.getText());
	}
	
	public String getDatabaseName(){
		return _dbname.getText();
	}
	
	public String getUsername(){
		return _user.getText();
	}
	
	public String getPassword(){
		return _pw.getText();
	}
	
	public String getOptions(){
		return _options.getText();
	}
	
}
