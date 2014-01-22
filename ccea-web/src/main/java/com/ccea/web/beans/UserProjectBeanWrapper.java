package com.ccea.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;

import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;

/**
 * container for the user and user project info
 * @author abuayyub
 *
 */
public class UserProjectBeanWrapper implements Serializable {
	
	private List<SelectItem> projects;
	
	private User user;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7784090592087842578L;
	
	
	/**
	 * create the list of projects
	 * for UI
	 * @param myProjects
	 */
	public void createListItems(List<UserProject> myProjects) {
		List<SelectItem> s = new ArrayList<SelectItem>();
		for(UserProject p : myProjects) {
			SelectItem  item = new SelectItem();
			item.setValue(p.getId());
			item.setLabel(p.getProjectName());
			s.add(item);
		}
	}
	
	
	/**
	 * create the list of projects
	 * for UI
	 * @param myProjects
	 */
	public void createListItems(User myUser) {
		List<SelectItem> s = new ArrayList<SelectItem>();
		Set<UserProject> userProjects = myUser.getUserProjects();
		for(UserProject p : userProjects) {
			SelectItem  item = new SelectItem();
			item.setValue(p.getId());
			item.setLabel(p.getProjectName());
			s.add(item);
		}
	}
	

	public UserProjectBeanWrapper() {
		// TODO Auto-generated constructor stub
	}

}
