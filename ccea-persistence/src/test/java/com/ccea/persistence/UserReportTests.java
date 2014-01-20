package com.ccea.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccea.persistence.model.ProjectDAO;
import com.ccea.persistence.model.UserDAO;
import com.ccea.persistence.model.UserProjectDAO;
import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/META-INF/ExampleConfigurationTests-context.xml" })
public class UserReportTests extends AbstractTransactionalJUnit4SpringContextTests {
	
	// needed to create the test data
	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	UserProjectDAO userProjectDAO;

	
	@Autowired
	private ReportServiceImpl reportService;
	
		
	@Before
	public void setupBefore() {
		CceaCrudTests.AbstractCcaaTestData data = new CceaCrudTests().new AbstractCcaaTestData();
		// needed to create the test data
		List<Project> ps = data.getProjects();
		for (Project p : ps) {
			projectDAO.create(p);
		}
		
		// create n userProject for all users
		for (User u : data.getUser()) {
			userDAO.create(u);				
		}
		
		List<User> users = userDAO.findAll();
		for(User u : users) {
			for (UserProject newup : data.getUserProjects(u, ps)) {
				System.out.println("USERPROJECT : "+newup);
				userProjectDAO.create(newup);
		}	
			
		}		
	}
		
		
		
	@Test
	public void testGetUesrReport() throws Exception {
		
		assertNotNull(reportService);
		List<User> l = (List<User>)reportService.getAllUserProjects();
		assertNotNull(l);
		assertTrue(l.get(0).getUserProjects().size() > 0);		
		logger.info(l.toString());					
	}
	
}
