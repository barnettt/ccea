package com.ccea.persistence.report;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccea.persistence.exceptions.DataStoreException;
import com.ccea.persistence.exceptions.InvalidLoginException;
import com.ccea.persistence.model.ProjectDAO;
import com.ccea.persistence.model.UserDAO;
import com.ccea.persistence.model.UserProjectDAO;
import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;

@Service("uiServiceManager")
@Transactional
public class UIDataManager {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired	
	UserProjectDAO userProjectDAO;
	
	private static String LOGIN_FIELD = "login";
	protected static Logger logger = LoggerFactory
            .getLogger(UIDataManager.class);
	
	
	/**
	 * Check the users login credentials 
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws InvalidLoginException
	 */
    public boolean checkLoginDetails(String userName,String password) throws InvalidLoginException {
    	 User u = null;
    	 try {
    		 u = userDAO.findByName(LOGIN_FIELD ,userName);
    	 } catch (Exception e) {
    		 
    		 logger.error("",e);
    	 }
    	 if(u != null && u.getPassword().equals(password)) {
    		 return true;
    	 }
    	 return false;
    	 
    }
    
    /**
     * Adds a new project to the data store for a user.
     * 
     * @param user
     * @param userProject
     * @return
     * @throws DataStoreException
     */
    public boolean addUserProject(UserProject userProject) throws DataStoreException {
    	try {    		  
    	      userProjectDAO.create(userProject);
    	} catch (Exception e) {
    		logger.error(""+e);
    		throw new DataStoreException(e.getMessage());
    	}
    	
		return true;
    }
    
    /**
     * return all the projects.
     * @return
     * @throws DataStoreException
     */
    public List<Project> getProjects() throws DataStoreException {
    	List<Project> projects = null;
    	try {
    		  projects = projectDAO.findAll();
    	}catch (Exception e) {
    		logger.error(""+e);
    		throw new DataStoreException (e.getMessage());
    	}
    	return projects;
    }
    
    /**
     * return all the projects.
     * @return
     * @throws DataStoreException
     */
    public boolean addProject(Project project) throws DataStoreException {
    	if(project.getCode() != null) {
    		throw new DataStoreException("Project Already exists : " + project.getName());
    	}
    	try {
    		   projectDAO.create(project);
    	}catch (Exception e) {
    		logger.error(""+e);    		
    		throw new DataStoreException (e.getMessage());
    	}
    	return true;
    }
    
    /**
     * return all the projects.
     * @return
     * @throws DataStoreException
     */
    public Set<UserProject> getUserProject(User user) throws DataStoreException {
    	if(user.getUserId() != null) {
    		throw new DataStoreException("User not Registered : " + user.getLogin());
    	}
    	try {
    		  return  userProjectDAO.findByUser(user);
    	}catch (Exception e) {
    		logger.error(""+e);    		
    		throw new DataStoreException (e.getMessage());
    	}
    	
    }
    
    public User addUser(User user) throws DataStoreException {
    	
    	if(user.getUserId() != null) {
    		throw new DataStoreException("User Already Registered : " + user.getLogin());
    	}
    	try {
	    	userDAO.create(user);
	    	user = userDAO.findByName("login", user.getLogin());
    	} catch(Exception e) {
    		logger.error(""+e);    		
    		throw new DataStoreException (e.getMessage());
    	}
    	return user;
    }
}
