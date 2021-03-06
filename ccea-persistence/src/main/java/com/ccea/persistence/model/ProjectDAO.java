package com.ccea.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ccea.persistence.model.pojo.Project;

@SuppressWarnings("unchecked")
@Repository("projectDAO")
public class ProjectDAO extends AbstractHibernateDAO<Project> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6192708177923328891L;

	public ProjectDAO() {
		super();
	}
	
	/**
	 * add anew project to the datastore
	 * @param project
	 */
	public void save(Project project) {
		create(project);
	}
	
	@Override
	public Project findById(Integer id) {
		Project p = new Project();
		p.setCode(id);
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(
				Project.class);
		c.add(Restrictions.eq("code", id));

		List<Project> projects = c.list();
		return projects.size() == 1 ? projects.get(0) : null;
	}

	@Override
	public Project findByName(String field, String Value) {
		// TODO Auto-generated method stub
		return null;
	}
}
