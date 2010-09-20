/**
 * 
 */
package org.tomale.id.projects;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author ftomale
 *
 */
public class Task {

	int _id;
	
	Date _actualStart;
	Date _actualEnd;
	Date _projectedStart;
	Date _projectedEnd;
	
	ArrayList<Task> _tasks = new ArrayList<Task>();
	ArrayList<Material> _materials = new ArrayList<Material>();
	ArrayList<Personnel> _personnel = new ArrayList<Personnel>();
	ArrayList<Vehicle> _vehicles = new ArrayList<Vehicle>();
	ArrayList<Tool> _tools = new ArrayList<Tool>();
	
	public Date getActualStart(){
		return _actualStart;
	}
	
	public void setActualStart(final Date value){
		_actualStart = value;
	}
	
	public Date getActualEnd(){
		return _actualEnd;
	}
	
	public void setActualEnd(final Date value){
		_actualStart = value;
	}
	
	public Date getProjectedStart(){
		return _projectedStart;
	}
	
	public void setProjectedStart(final Date value){
		_projectedStart = value;
	}
	
	public Date getProjectedEnd(){
		return _projectedEnd;
	}
	
	public void setProjectedEnd(final Date value){
		_projectedEnd = value;
	}
	
	public ArrayList<Task> getTask(){
		return _tasks;
	}
	
	public ArrayList<Material> getMaterials(){
		return _materials;
	}
	
	public ArrayList<Personnel> getPersonnel(){
		return _personnel;
	}
	
	public ArrayList<Vehicle> getVehicles(){
		return _vehicles;
	}
	
	public ArrayList<Tool> getTools(){
		return _tools;
	}
}
