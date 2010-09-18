/**
 * 
 */
package org.tomale.id.gis.internal;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/**
 * @author ftomale
 *
 */
public class MapView {

	Point _center = new Point(0, 0);
	float _aspect;
	
	int _width = 0;
	int _height = 0;
	
	public MapView(){
		
	}
	
	public Point getCenterPoint(){
		return _center;
	}
	
	public void setCenterPoint(final Point p){
		_center = p;
	}
	
	public float getAspectRatio(){
		return _aspect;
	}
	
	public void resize(final int width, final int height){
		_width = width;
		_height = height;
		
		_aspect = _width/_height;
	}
	
	public Rectangle getBoundingRectangle(){
		Point p = new Point(_center.x - (_width/2), _center.y - (_height/2));
		Rectangle rect = new Rectangle(p.x, p.y, _width, _height);
		return rect;
	}
}
