/**
 * 
 */
package org.tomale.id.gis;

/**
 * @author ferd
 *
 */
public interface ILayer {

	public String getName();
	
	public boolean isVisible();
	
	public void setVisible(final boolean visible);
	
	public boolean isEnabled();
	
	public void setEnabled(final boolean enabled);
	
}
