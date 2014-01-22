package com.ccea.persistence.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;


/**
 * user projects DAO for managing users 
 * to project data.
 * 
 * @author abuayyub
 * 
 */
@SuppressWarnings("unchecked")
@Repository("userProjectDAO")
public class UserProjectDAO extends AbstractHibernateDAO<UserProject> {

        /**
         * 
         */
        private static final long serialVersionUID = 7835694213038872722L;

        public UserProjectDAO() {
                super();
        }

        @Override
        public UserProject findById(Integer id) {

                Criteria c = getSessionFactory().getCurrentSession().createCriteria(
                                UserProject.class);
                c.add(Restrictions.eq("id", id));
                List<UserProject> userProjects = c.list();
                return userProjects.size() == 1 ? userProjects.get(0) : null;

        }

        public Set<UserProject> findByUser(User user) {
                Set<UserProject> col = new HashSet<UserProject>();                        
                Query c = getSessionFactory().getCurrentSession().createQuery(
                                UserProject.FIND_BY_USER_QUERY);                
                c.setInteger("user", user.getUserId());                
                Collection<UserProject> userProjects = c.list();                
                userProjects.addAll(col);                
                return col;
        }
        
        @Override
        public UserProject findByName(String field, String value) {
                // TODO Auto-generated method stub
                return null;
        }
}