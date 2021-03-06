package com.ccea.persistence;

import java.util.Map;
import java.util.List;
import java.util.Date;

import com.ccea.persistence.exceptions.DataStoreException;
import com.ccea.persistence.model.pojo.Project;
import com.ccea.persistence.model.pojo.User;

/**
 * Report service facade. Provide access to report data to the 
 * web tier.
 * 
 * @author abuayyub
 *
 * @param <I>
 * @param <T>
 */
public interface ReportService<I, T>  {

	/**
	 * Get all projects. The 'Project' have extra information about specific projects.
	 * 
	 * 
	 * @return
	 */
	public Map<I, List<T>> getAllProjectReport()throws DataStoreException;
	/**
	 * get all the user related information for the given 'Project'.
	 * 
	 * @param project
	 * @return
	 */
	public Map<I, List<T>> getProjectReport(Project project) throws DataStoreException;
	/**
	 *  get the information for projects within a given time period
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Map<I, List<T>> getReportAllProjectBetweenDates(Date startDate,Date endDate)throws DataStoreException;
	/**
	 * get all the project information entered for all users. 
	 * @return
	 * @throws DataStoreException 
	 */
	public List<User> getAllUserProjects() throws DataStoreException;

}
