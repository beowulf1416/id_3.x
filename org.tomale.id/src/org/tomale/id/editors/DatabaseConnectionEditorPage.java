/**
 * 
 */
package org.tomale.id.editors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * @author ftomale
 *
 */
public class DatabaseConnectionEditorPage extends FormPage {

	public static final String PAGE_ID = "org.tomale.id.editors.databaseconnection.page";
	public static final String PAGE_TITLE = "Connection";
	
	Text _name;
	Combo _factories;
	Text _host;
	Text _port;
	Text _dbname;
	Text _user;
	Text _pw;
	Text _opt;
	
	public DatabaseConnectionEditorPage(FormEditor editor){
		super(editor,PAGE_ID,PAGE_TITLE);
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		
		DatabaseConnectionEditorInput input = (DatabaseConnectionEditorInput) managedForm.getInput();
		
		final ScrolledForm form = managedForm.getForm();
		FormToolkit tk = managedForm.getToolkit();
		Composite body = form.getBody();
		tk.paintBordersFor(body);
		form.setText(this.getTitle());
		
		FillLayout layoutBody = new FillLayout();
		body.setLayout(layoutBody);
		
		Section section = tk.createSection(body, 
				Section.DESCRIPTION | Section.EXPANDED | Section.TITLE_BAR);
		section.setText("Database connection properties");
		section.setDescription("This describes the properties of the database connection");
		
		Composite comp = tk.createComposite(section);
		tk.paintBordersFor(comp);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		comp.setLayout(gridLayout);
	
		Color red = tk.getColors().createColor("red", 255, 0, 0);
		
		FormText l = tk.createFormText(comp, false);
		l.setColor("red", red);
		l.setText("Name<span color=\"red\">*</span>", true, false);
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));		
		
		_name = tk.createText(comp, input.getConnectionName());
		_name.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,true,true));
		
		l.setColor("red", red);
		l.setText("Host<span color=\"red\">*</span>", true, false);
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_host = tk.createText(comp, input.getHost());
		_host.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,true,true));
		
		l = tk.createFormText(comp, false);
		l.setColor("red", red);
		l.setText("Port<span color=\"red\">*</span>", true, false);
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_port = tk.createText(comp, Integer.toString(input.getPort()));
		_port.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,true,true));
		
		l = tk.createFormText(comp, false);
		l.setColor("red", red);
		l.setText("Database Name<span color=\"red\">*</span>", true, false);
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_dbname = tk.createText(comp, input.getDatabaseName());
		_dbname.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,true,true));
		
		l = tk.createFormText(comp, false);
		l.setColor("red", red);
		l.setText("Username<span color=\"red\">*</span>", true, false);
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_user = tk.createText(comp, input.getUsername());
		_user.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,true,true));
		
		l = tk.createFormText(comp, false);
		l.setColor("red", red);
		l.setText("Password<span color=\"red\">*</span>", true, false);
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));
		
		_pw = tk.createText(comp, input.getPassword());
		_pw.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,true,true));
		
		l = tk.createFormText(comp, false);
		l.setText("Options", true, false);
		l.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,false,false));

		_opt = tk.createText(comp, input.getOptions());
		_opt.setLayoutData(new GridData(SWT.BEGINNING,SWT.CENTER,true,true));
		
	}
	
	
}
