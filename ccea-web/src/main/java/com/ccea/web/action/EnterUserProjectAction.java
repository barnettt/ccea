package com.ccea.web.action;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.ccea.persistence.exceptions.DataStoreException;
import com.ccea.persistence.model.UserDAO;
import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;
import com.ccea.persistence.report.UIDataManager;


public class EnterUserProjectAction extends CceaAbstractEventAction {

	@Autowired
	UIDataManager uiDataManager;
	
		
	public EnterUserProjectAction() {
		super(EnterUserProjectAction.class);
	}
	
	/**
	 * add a user to the datastore
	 * @param context
	 * @return
	 */
	public Event addUser(RequestContext context) {
		User user = (User)context.getFlowScope().get("userBean");
		try {
		   uiDataManager.addUser(user);
		} catch (DataStoreException e) {
			if(e.getMessage().contains("User Already Registered")) {
				context.getFlowScope().put("userErrorMesage",e.getMessage());
			} else {
			   context.getFlowScope().put("newUserMessage","Error occurred during save operation, "
						+ "check data and try again or see system administrator. ");
			}
			return error;
		}
		return success;
		
	}
	
	/**
	 * add a user to the datastore
	 * @param context
	 * @return
	 */
	public Event getUserProjects(RequestContext context) {
		User user = (User)context.getFlowScope().get("userBean");
		try {
		   Set<UserProject> userProjects = uiDataManager.getUserProject(user);
		   if(userProjects == null) {
			   context.getFlowScope().put("userProjectMessage","no projects found for user, "
						);
			
		   }
		} catch (DataStoreException e) {
			
			   context.getFlowScope().put("newUserMessage","Error occurred during save operation, "
						+ "check data and try again or see system administrator. ");
			
			return error;
		}
		return success;
		
	}
	
	
	
	public Event addUserProject(RequestContext context) {
		UserProject userProject = (UserProject)context.getFlowScope().get("userProjectBean");
		UserProject user = (UserProject)context.getFlowScope().get("userBean");
		
		userProject.setUserId(user.getUserId());
		try {
			uiDataManager.addUserProject(userProject);
		} catch (DataStoreException e) {
			 context.getFlowScope().put("newUserProjectMessage","Error occurred during save operation, "
						+ "check data and try again or see system administrator. ");
			 return error;
		}
		
		return success;
	}
}
