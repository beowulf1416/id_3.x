/**
 * 
 */
package org.tomale.id.gis.internal;

import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.opengl.GLData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ScrollBar;

/**
 * @author ferd
 *
 */
public class MapCanvas extends GLCanvas {

	private final GLContext _context;
	
	public MapCanvas(Composite parent, int style, GLData data){
		super(parent,style | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.NO_BACKGROUND,
				data);
		
		addEventListeners();
		
		this.setCurrent();
		_context = GLDrawableFactory.getFactory().createExternalGLContext();
		
		init();
	}
	
	private void init(){
		
	}
	
	private void addEventListeners(){
		// scrollbars
		ScrollBar horizontal = getHorizontalBar();
		horizontal.setEnabled(true);
		horizontal.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				horizontalScroll((ScrollBar) e.widget);
			}
			
		});
		
		ScrollBar vertical = getVerticalBar();
		vertical.setEnabled(true);
		vertical.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				verticalScroll((ScrollBar) e.widget);
			}
			
		});
		
		// mouse

		
		// keyboard
	}
	
	private void horizontalScroll(ScrollBar horizontal){
		
	}
	
	private void verticalScroll(ScrollBar vertical){
		
	}
	
	private void resize(){
		
	}
	
	private void paint(){
		
	}
}
