package com.ccea.persistence.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccea.persistence.exceptions.DataStoreException;
import com.ccea.persistence.model.ProjectDAO;
import com.ccea.persistence.model.UserDAO;
import com.ccea.persistence.model.UserProjectDAO;
import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;

@Service("userReportManager")
@Transactional
public class UserReportManager {
	
	protected static Logger logger = LoggerFactory
            .getLogger(UserReportManager.class);
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired	
	UserProjectDAO userProjectDAO;
	
	/**
	 * Return the users an their projects.
	 * NOTE: Hibernate seem to return an empty UserProject set,
	 *       even with lazy set to false or using the query criteria to
	 *       do the join or select. this is an alternative.  
	 * 
	 * @return
	 */
	public List<User> getAllUserProjects() throws DataStoreException {
		
		List<User> users = userDAO.findAll();
		List<UserProject> userProj = userProjectDAO.findAll();
		try {
			for(User u : users ) {
				for (UserProject p : userProj) {
					if(p.getUserId().equals(u.getUserId())) {
						u.getUserProjects().add(p);
					}
				}
			}
		}catch (Exception e) {
			logger.error(""+e);
		}
		return users;
		
	}
}
