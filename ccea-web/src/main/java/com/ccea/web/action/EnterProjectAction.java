package com.ccea.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.action.MultiAction;

import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.ccea.persistence.exceptions.DataStoreException;

import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.report.UIDataManager;
import com.ccea.web.beans.ProjectBeanWrapper;

public class EnterProjectAction extends CeaAbstractEventAction {

	@Autowired
	UIDataManager uiDataManager;
	
	public EnterProjectAction() {
		 super(EnterProjectAction.class);
	}

	 
	
	/**
	 * add a ingle project to the data store
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public Event storeProjectBean(RequestContext context) throws Exception {
		
        Project p = (Project)context.getFlowScope().get("projectBean");
		try {
           uiDataManager.addProject(p);
		} catch (DataStoreException e) {
			context.getFlowScope().put("newProjectMessage","Error occurred during save operation, "
					+ "check data and try again or see system administrator. ");
			return error;
		}
	    return success;
	}
	/**
	 * add a blank project bean to the flow context
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public Event getProjectBean(RequestContext context) throws Exception {
		
		Project project = new Project();
		
        context.getFlowScope().put("projectBean", project);
		
	    return success;
	}
	
	/**
	 * wrap the list o projects in a bean and add to the flow context 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public Event getAllProjectBean(RequestContext context) throws Exception {
		
		ProjectBeanWrapper projects = new ProjectBeanWrapper();
		
		projects.createListItems(uiDataManager.getProjects());
        context.getFlowScope().put("projectBeanWrapper", projects);
		
	    return success;
	}

}
