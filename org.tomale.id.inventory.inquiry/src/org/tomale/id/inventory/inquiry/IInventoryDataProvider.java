/**
 * 
 */
package org.tomale.id.inventory.inquiry;

import java.util.ArrayList;

import org.tomale.id.inventory.Unit;
import org.tomale.id.inventory.UnitType;

/**
 * @author ferd
 *
 */
public interface IInventoryDataProvider {

	ArrayList<UnitType> getUnitTypes();
	
	ArrayList<Unit> getUnits();
	
}
