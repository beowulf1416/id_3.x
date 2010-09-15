/**
 * 
 */
package org.tomale.id.gis.internal;

import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
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
		this.setCurrent();
		_context.makeCurrent();
		
		GL gl = _context.getGL();
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		gl.glColor3f(0.0f, 0.0f, 0.0f);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		
		_context.release();
	}
	
	private void addEventListeners(){
		addControlListener(new ControlListener() {
			
			@Override
			public void controlResized(ControlEvent e) {
				resize();
			}
			
			@Override
			public void controlMoved(ControlEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				paint();
			}
		});
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.keyCode){
					case SWT.ARROW_UP:{
					
						break;
					}
					case SWT.ARROW_DOWN:{
						
						break;
					}
					case SWT.ARROW_LEFT:{
						
						break;
					}
					case SWT.ARROW_RIGHT:{
						
						break;
					}
					case SWT.PAGE_UP:{
						
						break;
					}
					case SWT.PAGE_DOWN:{
						
						break;
					}
					case SWT.HOME:{
						
						break;
					}
				}
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
