/**
 * 
 */
package org.tomale.id.gis.internal;

import java.util.ArrayList;

import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.glu.GLU;

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
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.opengl.GLCanvas;
import org.eclipse.swt.opengl.GLData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ScrollBar;
import org.tomale.id.gis.ILayer;
import org.tomale.id.gis.IMapElement;

/**
 * @author ferd
 *
 */
public class MapCanvas extends GLCanvas {

	private final GLContext _context;
	
	MapView _view = new MapView();
	
	ArrayList<ILayer> _layers = new ArrayList<ILayer>();
	float _aspect = 0;
	
	int _scale = 100;
	int _rotate = 0;
	
	int _defaultRotate = 5;
	int _defaultPanX = 5;
	int _defaultPanY = 5;
	int _defaultZoom = 5;
	
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
				
				boolean ctrl = (e.stateMask & SWT.CTRL) != 0;	// ctrl key pressed
				
				switch(e.keyCode){
					case SWT.ARROW_UP:{
						if(ctrl){
							rotate(_defaultRotate);
						} else {
							pan(0,_defaultPanY);
						}
						break;
					}
					case SWT.ARROW_DOWN:{
						if(ctrl){
							rotate(-_defaultRotate);
						} else {
							pan(0,-_defaultPanY);
						}
						break;
					}
					case SWT.ARROW_LEFT:{
						if(ctrl){
							rotate(_defaultRotate);
						} else {
							pan(_defaultPanX,0);
						}
						break;
					}
					case SWT.ARROW_RIGHT:{
						if(ctrl){
							rotate(-_defaultRotate);
						} else {
							pan(-_defaultPanX,0);
						}
						break;
					}
					case SWT.PAGE_UP:{
						zoomIn(_defaultZoom);
						break;
					}
					case SWT.PAGE_DOWN:{
						zoomOut(_defaultZoom);
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
		Rectangle rect = getClientArea();
		int width = rect.width;
		int height = rect.height;
		_aspect = width/height;
		
		_view.resize(width, height);
		
		this.setCurrent();
		_context.makeCurrent();
		GL gl = _context.getGL();
		
		// left, bottom, right, top
		gl.glViewport(0,0, width, height);
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		
		GLU glu = new GLU();
		// field of view angle in degrees in the y direction
		// aspect
		// distance of near clipping plane
		// distance of far clipping plane
		glu.gluPerspective(45.0f, _aspect, 0.5f, 400.0f);
		
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		_context.release();
	}
	
	private void paint(){
		
		
		
		this.setCurrent();
		_context.makeCurrent();
		GL gl = _context.getGL();
		
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		
		_context.release();
	}
	
	/**
	 * rotate view by number of degrees
	 * @param value
	 */
	private void rotate(int value){
		_rotate += value;
	}
	
	/**
	 * pan view
	 * @param dx
	 * @param dy
	 */
	private void pan(int dx, int dy){
		
	}
	
	private void zoomIn(int value){
		
	}
	
	private void zoomOut(int value){
		
	}
	
	private void getMapElements(){
		Rectangle rect = _view.getBoundingRectangle();
		for(ILayer layer : _layers){
			ArrayList<IMapElement> elements = layer.getMapElements(rect);
		}
	}
	
	private void getRenderers(){
		
	}
	
	public ArrayList<ILayer> Layers(){
		return _layers;
	}
	
	public float getAspectRatio(){
		return _aspect;
	}
}
