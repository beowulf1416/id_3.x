/**
 * 
 */
package org.tomale.id.projects;

import java.util.ArrayList;

/**
 * @author ftomale
 *
 */
public class PredefinedTask {

	int _id;
	
	int _duration;
	
	ArrayList<Task> _tasks = new ArrayList<Task>();
	ArrayList<Material> _materials = new ArrayList<Material>();
	ArrayList<Personnel> _personnel = new ArrayList<Personnel>();
	ArrayList<Vehicle> _vehicles = new ArrayList<Vehicle>();
	ArrayList<Tool> _tools = new ArrayList<Tool>();
	
}
