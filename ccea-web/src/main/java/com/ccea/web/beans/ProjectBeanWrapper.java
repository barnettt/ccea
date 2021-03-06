package com.ccea.web.beans;

import java.util.ArrayList;
import java.util.List;

import com.ccea.persistence.model.pojo.Project;

import javax.faces.model.SelectItem;

public class ProjectBeanWrapper {

	
	private List<SelectItem> projects;
	
	private String currentProject;
	
	
	public ProjectBeanWrapper() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the projects
	 */
	public List<SelectItem> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<SelectItem> projects) {
		this.projects = projects;
	}
	
	/**
	 * @return the currentProjects
	 */
	public String getCurrentProject() {
		return currentProject;
	}

	/**
	 * @param currentProjects the currentProjects to set
	 */
	public void setCurrentProject(String currentProjects) {
		this.currentProject = currentProjects;
	}

	/**
	 * create the list of projects
	 * for UI
	 * @param myProjects
	 */
	public void createListItems(List<Project> myProjects) {
		List<SelectItem> s = new ArrayList<SelectItem>();
		for(Project p : myProjects) {
			SelectItem  item = new SelectItem();
			item.setValue(p.getCode());
			item.setLabel(p.getName());
			s.add(item);
		}
	}
}
