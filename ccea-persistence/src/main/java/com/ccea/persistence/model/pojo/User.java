package com.ccea.persistence.model.pojo;

import java.util.HashSet;
import java.util.List;

import javax.persistence.JoinColumn;

/**
 * represents a user in the system.
 * 
 * @author abuayyub
 * 
 */

public class User implements Comparable<User>{
	private Integer userId;
	private String firstName;
	private String lastName;
	private String login;
	private String department;
	private String password;
	private UserType userType;
	@JoinColumn(name="userId", nullable=false)
	private java.util.Set<UserProject> userProjects = new HashSet<UserProject>();
	
	
	
	/**
	 * Constructor
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param department
	 * @param login
	 * @param password
	 * @param homeWorker
	 * @param arrayList
	 */
	public User(Integer id, String firstName, String lastName,
			String department, String login, String password,
			UserType homeWorker, List<UserProject> arrayList) {
		//
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.login = login;
		this.password = password;
		this.userType = homeWorker;
	}

	/**
	 * Constructor
	 */
	public User() {

	}

	/**
	 * @return the id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * @return the userProjects
	 */
	public java.util.Set<UserProject> getUserProjects() {
		return userProjects;
	}
	
	public  void setUserProjects(java.util.Set<UserProject> userProjects) {
		this.userProjects = userProjects;
	}

	@Override
	public int compareTo(User o) {
		
		if(o.getUserId() == null || this.userId == null) {
			return -1;
		}
		if(this.userId.equals(o.getUserId())) {
			return 0;
		}
		return -1;
	}
	
	/**
	 * private Integer id;
	private String firstName;
	private String lastName;
	private String login;
	private String department;
	private String password;
	 */
	
	public String toString() {
		StringBuilder buff = new StringBuilder("\n");

		buff.append(userId);
		buff.append(",");
		buff.append(firstName);
		buff.append(",");		
		buff.append(lastName);
		buff.append(",");
		buff.append(login);
		buff.append(",");
		buff.append(password);
		buff.append(",");
		buff.append(department);
		buff.append(",");
		buff.append(userProjects == null ? userProjects  : userProjects.toString());
		
		return buff.toString();
	}

}
