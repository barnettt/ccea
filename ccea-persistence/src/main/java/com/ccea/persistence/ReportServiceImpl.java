package com.ccea.persistence;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ccea.persistence.exceptions.DataStoreException;
import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.model.pojo.UserProject;
import com.ccea.persistence.report.UserReportManager;

/**
 * {@link ReportService} 
 * 
 * @param <UserProject>
 */
@Component("reportService")
public class ReportServiceImpl implements ReportService<Project, UserProject> {

	@Autowired
	UserReportManager userReportManager;
	
	
	@Override
	public Map<Project, List<UserProject>> getAllProjectReport() throws DataStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Project, List<UserProject>> getProjectReport(Project project) throws DataStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Project, List<UserProject>> getReportAllProjectBetweenDates(
			Date startDate, Date endDate) throws DataStoreException {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUserProjects() throws DataStoreException {
		
		return userReportManager.getAllUserProjects();
	}
	
}
