package com.ccea.persistence.model.pojo;

import java.util.Date;

import javax.persistence.Id;

/**
 * represents the users time on a project in the system
 * 
 * @author abuayyub
 * 
 */

public class UserProject {
	// find all query
	public static final String FIND_BY_ID_QUERY = "FROM UserProject p where p.code=:id and p.useId=:user and group by p.user, p.code order by p.date desc  ";
	public static final String FIND_BY_USER_QUERY = "FROM UserProject p where p.userId=:user group by p.userId, p.code order by p.date desc  ";

	@Id
	private Integer id;
	private String projectName;
	private Integer code;
	private Integer hours;
	private Integer minutes;
	private String startTime;
	private String endTime;
	private User user;
	
	private Date date;
	private Integer userId;

	
	public UserProject() {
		super();
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the user
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	

	/**
	 * @return the hours
	 */
	public Integer getHours() {
		return hours;
	}

	/**
	 * @param hours
	 *            the hours to set
	 */
	public void setHours(Integer hours) {
		this.hours = hours;
	}

	/**
	 * @return the minutes
	 */
	public Integer getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes
	 *            the minutes to set
	 */
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String toString() {
		StringBuilder buff = new StringBuilder("\n");

		buff.append(id);		
		buff.append(",");
		buff.append(projectName);		
		buff.append(",");
		buff.append(date);
		buff.append(",");
		buff.append(userId);
		buff.append(",");
		buff.append(code);		
		buff.append(",");
		buff.append(hours);
		buff.append(",");
		buff.append(minutes);
		buff.append(",");
		buff.append(startTime);
		buff.append(",");
		buff.append(endTime);
		buff.append("\n");

		return buff.toString();
	}
	@Override
	public int hashCode() {
		int seed = 17;
		int result = id.hashCode() * seed;
		result = (result * seed) + date.hashCode();
		result = (result * seed) + userId.hashCode();
		result = result >>> 17;		
		return result;
	}

	@Override
	public boolean equals(Object o) {

		UserProject up = null;
		if (o instanceof UserProject) {
			up = (UserProject) o;
		} else {
			return false;
		}
		if (this.id.equals(up.getId()) && this.date.equals(up.getDate())
				&& this.userId.equals(up.getUserId())) {
			return true;
		}
		return false;
	}

}
