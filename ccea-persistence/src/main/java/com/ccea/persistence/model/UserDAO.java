package com.ccea.persistence.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl.CriterionEntry;
import org.hibernate.mapping.Join;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;

/**
 * user DAO for managing the user within the system
 * 
 * @author abuayyub
 * 
 */
@SuppressWarnings("unchecked")
@Repository("userDAO")
public class UserDAO extends AbstractHibernateDAO<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2490985543626828270L;
  
	public UserDAO() {
		super();
	}

	/**
	 * find a user by the user id
	 * @param  id
	 * @return user
	 */
	public User findById(Integer id) {
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(
				User.class,"user");			
		c.createAlias("user.userProjects", "proj");		
		c.add(Restrictions.eq("proj.userId", id));
		c.add(Restrictions.eq("user.userId", id));
		c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);		
		List<User> userList = c.list();
		if(userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}

	@Override
	public User findByName(String field, String value) {
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(User.class,"user");
		c.add(Restrictions.eq("user."+field,value));
		List<User> l = c.list();
		return l.get(0);
	}
	
	/**
	 * returns users and their projects
	 * 
	 * @return
	 */
	public List<User> findAllUserProjects() {

		Criteria c = getSessionFactory().getCurrentSession().createCriteria(User.class,"user");
		c.createCriteria("userProjects").setFetchMode("user.userProjects",FetchMode.SELECT);		
		List<User> l =  c.list();
					
		return l;
	}

}
