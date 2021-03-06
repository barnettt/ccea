package com.ccea.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ccea.persistence.ReportServiceImpl;
import com.ccea.persistence.model.ProjectDAO;
import com.ccea.persistence.model.UserDAO;
import com.ccea.persistence.model.UserProjectDAO;
import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;
import com.ccea.persistence.model.pojo.UserProjectPK;
import com.ccea.persistence.model.pojo.UserType;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/META-INF/ExampleConfigurationTests-context.xml" })
public class CceaCrudTests extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	UserProjectDAO userProjectDAO;

	@Before
	public void setUp() {

	}

	
	/**
	 * used just one test to do the insert and delete, find
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCRUDOperations() throws Exception {

//		CceaCrudTests.AbstractCcaaTestData data = new CceaCrudTests().new AbstractCcaaTestData();
//		// Start project test
//
//		for (Project p : data.getProjects()) {
//			projectDAO.create(p);
//		}
//		// check that these are in the database
//		List<Project> ps = projectDAO.findAll();
//		Assert.assertTrue(ps.size() == 4);
//
//		// check the delete operation
//
//		Project p1 = ps.get(0);
//		Integer id = p1.getCode();
//
//		p1 = projectDAO.findById(id);
//		Assert.assertTrue(p1.getCode().equals(id));
//
//		projectDAO.delete(p1);
//
//		ps = projectDAO.findAll();
//		Assert.assertTrue(ps.size() == 3);
//
//		// End project test
//
//		// Start User test
//
//		for (User u : data.getUser()) {
//
//			userDAO.create(u);
//
//		}
//		List<User> users = userDAO.findAll();
//
//		Assert.assertTrue(users.size() == 4);
//		System.out.println(users.toString());
//		User u1 = users.get(0);
//		System.out.println("USER ID : "+u1);
//		id = u1.getUserId();
//
//		userDAO.findById(id);
//		Assert.assertTrue(u1.getUserId().equals(id));
//
//		userDAO.delete(u1);
//
//		users = userDAO.findAll();
//		Assert.assertTrue(ps.size() == 3);
//		// End User test

	}

	@Test
	public void testUserProjectCrud() {

//		CceaCrudTests.AbstractCcaaTestData data = new CceaCrudTests().new AbstractCcaaTestData();
//		for (Project p : data.getProjects()) {
//			projectDAO.create(p);
//		}
//
//		for (User u : data.getUser()) {
//			userDAO.create(u);
//		}
//
//		List<Project> ps = projectDAO.findAll();
//		
//		List<User> users = userDAO.findAll();
//		// Setup 2 user projects
//		System.out.println(ps.toString());
//		
//		List<UserProject> up = data.getUserProjects(users.get(0), ps);
//
//		for (UserProject newup : up) {
//			userProjectDAO.create(newup);
//		}
//		
//		up.clear();
//		up = userProjectDAO.findAll();
//		Assert.assertTrue(up.size() == 4);
//
//		UserProject userproj = up.get(0);
//		UserProjectPK pk = new UserProjectPK();
//		
//		UserProject userproj2 = userProjectDAO.findById(userproj.getId());
//		System.out.println(userproj.getId());
//		System.out.println(userproj2.getId());
//
//		Assert.assertTrue(userproj2.getId().equals(userproj.getId()));
//
//		userProjectDAO.delete(userproj);
//
//		userproj2 = userProjectDAO.findById(userproj.getId());
//		Assert.assertNull(userproj2);
//
//		up = userProjectDAO.findAll();
//		Assert.assertTrue(up.size() == 3);

	}

	class AbstractCcaaTestData {

		public List<User> getUser() {
			List<User> users = new ArrayList<User>();
			User user = new User(null, "Tod", "Barnett", "tbarn", "tbarn",
					"IT", UserType.HOMEWORKER, new ArrayList<UserProject>());
			User user1 = new User(null, "John", "Doe", "jdoe", "jdoe", "HR",
					UserType.HOMEWORKER, new ArrayList<UserProject>());
			User user2 = new User(null, "Peter", "Parker", "ppark", "ppark",
					"HR", UserType.FINANCECLERK, new ArrayList<UserProject>());
			User user3 = new User(null, "Marry", "Jane", "mjane", "mjane",
					"HR", UserType.HOMEWORKER, new ArrayList<UserProject>());

			users.add(user);
			users.add(user1);
			users.add(user2);
			users.add(user3);

			return users;
		}

		public List<UserProject> getUserProjects(User user, List<Project> ps) {
			System.out.println(ps);
			Calendar cal = Calendar.getInstance();
			List<UserProject> upl = new ArrayList<UserProject>();
			for (Project p : ps) {
				UserProject up = new UserProject();
				up.setDate(cal.getTime());
				up.setUserId(user.getUserId());
				up.setCode(p.getCode());				
				up.setProjectName(p.getName());
				up.setEndTime("18:30");
				up.setStartTime("09:00");
				up.setHours(9);
				up.setMinutes(30);				
				upl.add(up);
			}
			System.out.println(upl);
			return upl;
		}

		/*
		 * private Integer code; private String name; private String owner;
		 * private Date dateStarted; private Double estimatedDuration; private
		 * Double actualDuration;
		 */
		public List<Project> getProjects() {
			Calendar cal = Calendar.getInstance();
			List<Project> projects = new ArrayList<Project>();
			cal.set(Calendar.MONTH, 6);
			Project project = new Project(null, "AS400 Migration",
					"Duncan Smith", cal.getTime(), Double.valueOf(180.00),
					Double.valueOf(0.00));
			Project project2 = new Project(null, "User Gateway Service",
					"ES Houdini", cal.getTime(), Double.valueOf(60.00),
					Double.valueOf(0.00));
			Project project3 = new Project(null, "NHS Patient Records",
					"Cap Gemini", cal.getTime(), Double.valueOf(360.00),
					Double.valueOf(0.00));
			Project project4 = new Project(null, "User Gateway Service",
					"Zenica Services", cal.getTime(), Double.valueOf(60.00),
					Double.valueOf(0.00));

			projects.add(project);
			projects.add(project2);
			projects.add(project3);
			projects.add(project4);

			return projects;
		}
	}

}
